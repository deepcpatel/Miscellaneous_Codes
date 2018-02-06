#include<arpa/inet.h>
#include<netinet/in.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<time.h>

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
	
	time_t rawtime;
  	struct tm * timeinfo;
	
	int sockfd;						// socket desciptor
	int slen = sizeof(cli_addr);	// length of the address structure

	char buffer[BUF_LEN];
							// buffer to store data
							// create a socket and store its descriptor for using later
	
	if((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) == -1)
		err("socket");

	else
		write(1,"\n Server : Socket creation successful",37);	// assign 0 to the address structure to flush it

	
	bzero(&my_addr, sizeof(my_addr));
	my_addr.sin_family = AF_INET; 					//assign family
	my_addr.sin_port = htons(PORT); 				//assign port number
	my_addr.sin_addr.s_addr = htonl(INADDR_ANY);			// accept data from any address

	// bind the socket to that ip address, so that clients can send data to the ipaddress and it gets delivered to the socket

	if(bind(sockfd, (struct sockaddr*) &my_addr, sizeof(my_addr)) == -1)
		err("bind");
	
	else
		write(1,"\n Client : bind successful",26);
		
	while(1)
	{
		// receive data from the client on the specified socket(IP Address + port number)

		if(recvfrom(sockfd, buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr,&slen) == -1)
			err("receiving error");				// open the file specified
			
		bzero(buffer,sizeof(buffer));
			
		//time (&rawtime);
  		//timeinfo = localtime(&rawtime);
  		
  		//strftime(buffer, sizeof(buffer), "%H:%M:%S", timeinfo);
		//puts(buffer);
		
		tick=time(NULL);
		snprintf(buffer,sizeof(buffer),"%s",ctime(&tick));

		if(sendto(sockfd,buffer, BUF_LEN, 0, (struct sockaddr*)&cli_addr, slen) ==-1)
		{
			
			err("Client : sending of message failed"); 
		}
		
		break;
	}
	
	close(sockfd);
	return 0;
}
