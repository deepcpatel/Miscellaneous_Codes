#include<stdio.h>
#include<sys/types.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>

int main()
{
    pid_t pid;
    int pi,status;
    char buf[100];
    
	bzero(buf,strlen(buf));
	
    pid=fork();
    
    pi=wait(&status);
    
    
    if(pid<0)
    {
        printf("\n Error ");
        exit(1);
    }
    else if(pid==0)
    {
    	sprintf(buf, "\n\nHello I am the child process ");
     	write(1, buf, strlen(buf));
        
        pi=getpid();
        
        bzero(buf,strlen(buf));
        
        sprintf(buf, "\nMy pid is: %d\n", pi);
     	write(1, buf, strlen(buf));
     	
        exit(0);
    }
    else
    {
     	
        sprintf(buf, "\n\nHello I am the parent process ");
     	write(1, buf, strlen(buf));
        
        pi=getpid();
        
        bzero(buf,strlen(buf));
        
        sprintf(buf, "\nMy pid is: %d\n", pi);
     	write(1, buf, strlen(buf));
     	
        exit(0);
    }
	//getpid() to retrieve the process ID assigned to this process;
	return 0;
}
