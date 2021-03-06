unsigned char ov_counter;
unsigned int starting_edge, ending_edge;
unsigned int clocks;

void timer1_ovf_isr(void) org 0x010
{
     ++ov_counter;
}

void timer1_capt(void) org 0x0A
{

    char low,high;
    
    low=ICR1L;
    high=ICR1H;
    
    ending_edge = 256*high + low;
    
    clocks =(unsigned long)ending_edge + ((unsigned long)ov_counter * 65536) - (unsigned long)starting_edge;
    
    PORTA = (char) (clocks / 1000);
    
    ov_counter = 0;

    starting_edge = ending_edge;
}


void main(void)
{
    DDRD.B6=0;
    DDRA=0xFF;

    PORTD.B6=1;

    TCCR1A = 0; /*disable all waveform functions*/
    TCCR1B = 0xC2;/*Timer 1 input to clock/8, enable input capture*/
    
    TIMSK = 0x24; /*unmask timer 1 overflow and capture interrupts*/
    
    SREG.B7=1; /*enable global interrupt bit*/
    
    while (1)
    {
     /*do nothing here*/
    }
}
