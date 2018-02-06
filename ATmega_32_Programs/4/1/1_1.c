void delay()
{
     TCNT1H = 0X00;
     TCNT1L = 0X00;
     
     TCCR1A = 0X00;
     TCCR1B = 0X01;
     
     while((TIFR&(0x04))==0);
     TCCR1B = 0;
     TIFR = 0x1<<TOV1;
}
void main()         //Practical Valur:-16 mS
{                   //Theoretical Value:-65535*(1/8) uS*2=16.383 mS
     DDRB= 0xFF;
     while(1)
     {
             PORTB.B0 ^=0x01;
             delay();
     }
}