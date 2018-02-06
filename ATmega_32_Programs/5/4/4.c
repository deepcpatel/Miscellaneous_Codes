void interrupt() org 0x04
{
    PORTB ^=0x01;
}

void main()
{
    DDRB = 0XFF;

    DDRD = 0xFF;

    SREG.B7=1;

    MCUCR = 0X08;

    GICR = (1<<INT1);

    while(1)
    {
       PORTD = 0x08;
       Delay_ms(1000);
       PORTD = 0x00;
       Delay_ms(1000);
    }
}