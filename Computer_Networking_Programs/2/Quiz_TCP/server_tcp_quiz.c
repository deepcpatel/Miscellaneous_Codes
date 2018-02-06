/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
   
#include <stdio.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

void answerVerify(char*, char*);

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
		n = read(newsockfd,buffer,255);
	    
	    //printf("\nN=%d",n);
	    
	 	if (n < 0) 
	 		error("ERROR reading from socket");
	 		
	 	if(n>0)
	 	{
	 		//printf("Here is the message: %s\n",buffer);
	 		
			answerVerify(buffer, message);	
			
			bzero(buffer,256);
			
			strcpy(buffer,message);
			
			n = write(newsockfd,buffer,strlen(buffer));	

	 		if (n < 0) 
	 			error("ERROR writing to socket");
	 			
	 		bzero(buffer,256);
	 	}	
	 	
	}
    
    return 0; 
}

void answerVerify(char* ans, char* message)
{

	if(!strcmp(ans,"ready\n"))
	{
		strcpy(message,"\nQuestion Paper:\n-----------------\n1.Find the next number in the series\n1,1,2,3,5,-\nA.8");
		strcat(message,"\nB.13");
		strcat(message,"\nC.1");
		strcat(message,"\nD.10");
		strcat(message,"\n---------------------------------------");
		strcat(message,"\n2.Find the value of sqrt(144)");

		strcat(message,"\nA.11");
		strcat(message,"\nB.12");
		strcat(message,"\nC.9");
		strcat(message,"\nD.7");
		strcat(message,"\n---------------------------------------");
		//printf("%s",ans);
	}
	else if(!strcmp(ans,"AB\n"))
	{
		strcpy(message,"Congrats, You passed the quiz");
		//printf("%s",ans);
	}
	else
	{
		strcpy(message,"Either your answer is incorrect, or you didn't followed protocol, try again...");
	}
		
}
