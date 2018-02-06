unsigned char m=0;

void interrupt() org 0x04
{
    m++;
    PORTB=m;
}

void main()
{
    DDRB = 0XFF;

    DDRD = 0<<3;

    PORTD = 1<<3;

    SREG.B7=1;

    MCUCR = 0X08;

    GICR = (1<<INT1);

    while(1)
    {

    }
}