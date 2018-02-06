// Code Reference
// Barnett, Coax, o'Cull

unsigned char ov_counter; /*counter for timer 1 overflow*/
unsigned int starting_edge, ending_edge; /*storage for times*/
unsigned int clocks; /*storage for actual clock counts in the pulse*/
/*Timer 1 overflow ISR*/
void timer1_ovf_isr(void) org 0x010
{
++ov_counter; /*increment counter when overflow occurs*/
}


/*Timer 1 input capture ISR*/
void timer1_capt(void)  org 0x0A
{
/*combine the two 8-bit capture registers into the 16-bit count*/
char low,high;
low=ICR1L;
high=ICR1H;
ending_edge = 256*high + low; /*get end time for period*/
clocks = (unsigned long)ending_edge
+ ((unsigned long)ov_counter * 65536)
- (unsigned long)starting_edge;
PORTA = (char) (clocks / 1000); /*output milliseconds to Port C*/
/*clear overflow counter for this measurement*/
ov_counter = 0;
/*save end time to use as starting edge*/
starting_edge = ending_edge;
}


void main(void)
{
DDRD.B6=0;
DDRA=0xFF; /*set Port A for output*/

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
