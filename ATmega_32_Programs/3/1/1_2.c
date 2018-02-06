void TIMER0_COMP() org 0x026
{
	PORTA^=0x01; // Toggle PORTA.0 every time this subroutine is called
	TCNT0=0X00;
}

void main() //T=3.9*50 uS=195 uS=>Practical Value
{			//T=8*0.125 uS*100*2=200 uS=>Theoretical Value

	DDRA=0x01; 
	PORTA=0X01;

	TCCR0=0x0A;
	OCR0=0x64;
	TCNT0=0X00;
  
	TIMSK.B1=1;  //OCIE0 Enable
	SREG.B7=1;   // Global interrupt enable

	while(1)
	{
		//do nothing
	}
}