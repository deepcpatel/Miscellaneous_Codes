void TODELAY()
{
        TCCR0=0X0A;
        OCR0 =250;
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
     PORTA=0X01;
     PORTB=0X00;
     TODELAY();
     
     PORTA=0X01;
     PORTB=0X01;
     TODELAY();
     
     PORTA=0X00;
     PORTB=0X01;
     TODELAY();
     
     PORTA=0X00;
     PORTB=0X00;
     TODELAY();
    }

}