
void TIMER0_COMP() org 0x026
{
	PORTA^=0x01; // Toggle PORTA.0 every time this subroutine is called
	TCNT0=0X00;
}


void main() //T=4.7*0.2 mS=0.95 mS=>Practical Value
{           //T=64*0.125 uS*63*2=1.008mS=>Theoretical Value

	DDRA=0x01; 
	PORTA=0X01;

	TCCR0=0x03;
	OCR0=63;
	TCNT0=0X00;
	
	TIMSK.B1=1;  
	SREG.B7=1;   

	while(1)
	{
		//do nothing
	}
}