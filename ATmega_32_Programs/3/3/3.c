void TODELAY()
{

        TCCR0=0X0A;
        OCR0 = 50;
        while((TIFR&0X02)==0);

        TCCR0=0;
        TIFR=0X02;
}

void main()
{
    unsigned int i,j;
    DDRA=0xFF;
    DDRB=0xFF;

    while(1)
    {

        for (j=0;j<100;j++)
        {
            for(i=0;i<10;i++)
            {
               TODELAY();
            }
            PORTA^=0X01;//1KHz
        }
        PORTB^=0X01;//1Hz
    }

}