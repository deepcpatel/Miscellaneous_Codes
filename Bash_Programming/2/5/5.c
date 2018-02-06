//ps -e -o pid,ppid,stat,cmd

#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main()
{

  pid_t pid;
  
  char buf[50];
  bzero(buf,strlen(buf));

  pid = fork ();
  
  if (pid != 0) 
  {
  
  	pid=getpid();
    
    sprintf(buf, "\nParent pid is: %d\n", pid);
 	write(1, buf, strlen(buf));
 	
    pause();	//Pausing the parent
  }
  else 
  {
    sprintf(buf, "\nChild pid is: %d\n", pid);
 	write(1, buf, strlen(buf));
 	
 	sleep(2);	//Letting child live for 2 seconds before becoming Zombie
 	
    exit (0);
  }
  
  return 0;
}
