
#include<arpa/inet.h>
#include<netinet/in.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>

#define BUF_LEN 10000
#define PORT 11000

void err(char *s)
{
	perror(s);
	exit(1);
}

int main(int argc, char *argv[])
{
	struct sockaddr_in my_addr, cli_addr; // structure to specify the socket address(IP address + port + family)
	
	int sockfd;						// socket desciptor
	int slen = sizeof(cli_addr);	// length of the address structure

	char buffer[BUF_LEN];
							// buffer to store data
							// create a socket and store its descriptor for using later
	
	if((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) == -1)
		err("socket");

	else
		printf("\n Server : Socket creation successful");	// assign 0 to the address structure to flush it

	
	bzero(&my_addr, sizeof(my_addr));
	my_addr.sin_family = AF_INET; 					//assign family
	my_addr.sin_port = htons(PORT); 				//assign port number
	my_addr.sin_addr.s_addr = htonl(INADDR_ANY);			// accept data from any address

	// bind the socket to that ip address, so that clients can send data to the ipaddress and it gets delivered to the socket

	if(bind(sockfd, (struct sockaddr*) &my_addr, sizeof(my_addr)) == -1)
		err("bind");
	
	else
		printf("\n Server : bind successful");

	
	while(1)
	{
		// receive data from the client on the specified socket(IP Address + port number)
		char mess[1000];
		int i;
		if(recvfrom(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr,&slen) == -1)
			err("receiving error");				// open the file specified
		

		for(i = 0;i<strlen(buffer); i++)
		{
 			 *(buffer+i) = tolower(*(buffer+i));
		}
		if(strcmp(buffer,"ready")==0)
		{
				int fp = open("quiz.txt", O_RDONLY);

				bzero(buffer, sizeof(buffer));			// read the first BUF_LEN bytes of the file
				read(fp, buffer, sizeof(buffer));
				// send the file data to the client address obtained in recvfrom
				if(sendto(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
					err("Client : sending of file data failed");
		}
		else if(strcmp(buffer,"ab")==0) 
		{
				bzero(buffer, sizeof(buffer));			// read the first BUF_LEN bytes of the file
				strcpy(mess,"You got full marks both the answers are correct");
				strcpy(buffer,mess);
				if(sendto(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
					err("Client : sending of file data failed");

		}
		else if(buffer[0]=='a' & buffer[1]!='b')
		{
				bzero(buffer, sizeof(buffer));			// read the first BUF_LEN bytes of the file
				strcpy(mess,"Your second answer is wrong");
				strcpy(buffer,mess);
				if(sendto(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
					err("Client : sending of file data failed");
		}	
		else if(buffer[0]!='a' & buffer[1]=='b')
		{		
				bzero(buffer, sizeof(buffer));			// read the first BUF_LEN bytes of the file
				strcpy(mess,"Your first answer is wrong");
				strcpy(buffer,mess);
				if(sendto(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
					err("Client : sending of file data failed");
		}
		else
		{
			//printf("\n%s",buffer);
			bzero(buffer, sizeof(buffer));			// read the first BUF_LEN bytes of the file
			strcpy(mess,"Your both answers are wrong or may be you are not following the protocol");
			strcpy(buffer,mess);
			if(sendto(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
					err("Client : sending of file data failed");

		} 
	}
	close(sockfd);
	return 0;
}
