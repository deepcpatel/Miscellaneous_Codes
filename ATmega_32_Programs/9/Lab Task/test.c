#include<stdio.h>

int main()
{
	unsigned int o=0x0000;
	unsigned int take1=0b11100001;
	unsigned int take2=0b00110010;
    float t;
    
    take2=0x03&take2;
    
    o=o|take2;
    o=o<<8;
    o=o|take1;
	 
	t=(float)(o*5)/1024; 
	printf("Value is %i",o);
	printf("\nValue is %f",t);
	o=t*100;
	printf("\nValue is %i",o);
	
	return 0;
}