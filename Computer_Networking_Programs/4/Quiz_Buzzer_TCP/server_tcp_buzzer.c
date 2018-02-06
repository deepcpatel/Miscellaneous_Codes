/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
   
#include <stdio.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

void reg(int);

void error(char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[])
{
	int sockfd, newsockfd, portno, clilen, take=-2;
	char buffer[256];

	char message[1000];

	struct sockaddr_in serv_addr, cli_addr;

	int n;

	if (argc < 2) 
	{
		fprintf(stderr,"ERROR, no port provided\n");
		exit(1);
	}

	sockfd = socket(AF_INET, SOCK_STREAM, 0);

	if (sockfd < 0) 
	error("ERROR opening socket");

	bzero((char *) &serv_addr, sizeof(serv_addr));
	portno = atoi(argv[1]);
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = INADDR_ANY;
	serv_addr.sin_port = htons(portno);

	if (bind(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
		error("ERROR on binding");


	listen(sockfd,5);
	clilen = sizeof(cli_addr);
	newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
	 
	if (newsockfd < 0) 
		error("ERROR on accept");

	bzero(buffer,256);
	 
	printf("\nQuiz Server Started");
			  
	while(1)
	{		
		newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
	 
		if(newsockfd < 0) 
			error("ERROR on accept");
		 
		pid = fork();
	 
		if(pid < 0)
			error("ERROR on fork");
		 
		if(pid == 0)  
		{
			close(sockfd);
			reg(newsockfd);
			exit(0);
		}
		else 
			close(newsockfd);
		
	}
    
    return 0; 
}

void reg(int sock)
{

	int n;
	char buffer[50];
	char roll[50];
	char name[50];
	  
	bzero(buffer,50);
	n = read(sock,buffer,49);

	n = write(sock,"Enter Roll:",11);

	if (n < 0) 
		error("ERROR writing to socket");

	bzero(buffer,50);
	n = read(sock,buffer,49);

	if (n < 0) 
		error("ERROR reading from socket");

	strcpy(roll,buffer);

	n = write(sock,"Enter Name:",11);

	if (n < 0) 
		error("ERROR writing to socket");

	bzero(buffer,50);
	n = read(sock,buffer,49);

	if (n < 0) 
		error("ERROR reading from socket");

	strcpy(name,buffer);

	n = write(sock,"registered",10);

	if (n < 0) 
		error("ERROR writing to socket");

}
