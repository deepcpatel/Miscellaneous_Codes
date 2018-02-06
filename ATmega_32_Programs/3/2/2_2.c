
void TODELAY()	//Theoretical Calculations:-100 us =2*(256-206)*8* 1uS *(1/8)
{
	TCNT0=206;
	TCCR0=0X02;
  
	while((TIFR&0X1)==0);
  
	TCCR0=0;
	TIFR=0X1;
}

void main()//Generating 100 uS and repeat it 10000 times to Generate 1 S
{
	unsigned int i;
    DDRA=0xFF;

    while(1)
    {    
		for(i=0;i<10000;i++)
        {
            TODELAY();
        }
           
        PORTA^=0X01;
    }

}