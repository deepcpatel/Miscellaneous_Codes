void TIMER0_OVF() org 0x012
{
	PORTA^=0x01; // Toggle PORTA.0 every time this subroutine is called
	TCNT0=0x00;
}


void main() 
{   			//T=3.1*20 uS=62 uS=>Practical Analysis Using CRO
                //T=256*0.125 uS*2=64 uS=>Theoretical Analysis Using Formula
	DDRA=0x01;
	PORTA=0X01;

	TCCR0=0x01;
	TCNT0=0x00;

	TIMSK.B0=1;  //TOIE0 Enable
	SREG.B7=1;   // Global interrupt enable

	while(1)
	{
		//do nothing
	}
}