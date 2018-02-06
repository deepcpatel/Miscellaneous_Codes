void delay()
{
     TCNT1H = 0X00;
     TCNT1L = 0X00;

     TCCR1A = 0X00;
     TCCR1B = 0X09;
     OCR1AH = 0X00;
     OCR1AL = 0XFF;

     while((TIFR&(0X10))==0);
     
     TCNT1L = 0X00;
     TIFR = 0x1<<OCF1A;
}
void main()         //Practical Valur:-64 mS
{                   //Theoretical Value:-256*(1/8) uS*2=64 uS
     DDRB= 0xFF;
     while(1)
     {
             PORTB.B0 ^=0x1;
             delay();
     }
}
