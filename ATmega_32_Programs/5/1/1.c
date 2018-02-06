void TODELAY2();

void interrupt() org 0x04	//Interrupt Function
{
	unsigned int i;

	PORTA=(1<<3);
	
	for(i=0;i<10000;i++)
	{
		TODELAY2();
	}
	 
	PORTA=(0<<3);
	 
	for(i=0;i<10000;i++)
	{
		TODELAY2();
	}

	PORTA=(1<<3);
	
	for(i=0;i<10000;i++)
	{
		TODELAY2();
	}

	PORTA=(0<<3);
}

void TODELAY2()	//Timer to generate 1Hz
{
	TCNT2=206;
	TCCR2=0X02;

	while((TIFR&(1<<TOV2))==0);

	TCCR2=0;
	TIFR=(1<<TOV2);
}

void TODELAY0()	//Timer to generate 1Hz
{
	TCNT0=206;
	TCCR0=0X02;

	while((TIFR&0X01)==0);

	TCCR0=0;
	TIFR=0X1;
}

void main()
{
	unsigned int i;

    DDRA=1<<3;
	 
    PORTA=(0<<3);
     
    DDRD=0<<3;
    PORTD=1<<3;
     
    DDRB=0XFF;
     
    MCUCR=0X08;
     
    GICR=(1<<INT1);
     
    SREG.B7=1;
     
    while(1)
    {
        for(i=0;i<10000;i++)
        {
            TODELAY0();
        }
        
        for(i=0;i<10000;i++)
        {
            TODELAY0();
        }
        
        PORTB^=0X01;
    }
}