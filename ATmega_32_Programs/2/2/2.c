void main()
{
     DDRB=0X55;
     while(1)
	 {
              PORTB=0X55;
              Delay_ms(1000);
              PORTB=0X00;
              Delay_ms(1000);
     }

}