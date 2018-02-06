int m=0x01;

int counter=0x00;

/*void TODELAY2()
{
	TCNT2=206;
	TCCR2=0X02;

        while((TIFR&(1<<TOV2))==0);

	TCCR2=0;
	TIFR=(1<<TOV2);
} */


void interrupt() org 0x04
{
 /*
     while(1)
     {
       PORTB=m;
       if(m==0X01)
       {
            m=0X80;
        }
        else
        {
            m=m >>0X01;
        }
        Delay_ms(500);
     }
 */
 counter=1;
}

/*void Todelay()
{
     TCNT1L = 0XBE;
     TCNT1H = 0XF0;
     TCCR1A = 0X00;
     TCCR1B = 0X05;

     while((TIFR&(1<<TOV1))==0);

     TCCR1B = 0X00;
     TIFR =1<<TOV1;

} */

void interrupt1() org 0x02
{
     counter=0;
}

void main()
{
    DDRB = 0XFF;

    DDRD=0X00;

    MCUCR=0X00;

    GICR=((1<<INT1) | (1<<INT0));

    SREG.B7=1;
     
    while(1)
    {      
		if(counter==0)
        {
            PORTB=m;
            
			if(m==0X80)
            {
               m = 0X01;
            }
            
			else
            {
                m=m<<1;
            }
              
			Delay_ms(500);
        }
        
		else
        {
			
			PORTB=m;
			
			if(m==0X01)
			{
				m=0X80;
			}
			
			else
			{
				m=m >>0X01;
			}
			
			Delay_ms(500);

        }
    }
}


