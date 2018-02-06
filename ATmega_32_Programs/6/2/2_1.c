unsigned char p;

void usart_initialize()
{
	UCSRB=((1<<TXEN)|(1<<RXEN));	//Enabling Transmission and Receiving
	UCSRC=0x86; // Data Size : 8-bit, Stop Bit:1,No parity
	UBRRL=0x33;	//Baud Rate=9600
}

void main()
{
	DDRA=0xFF;	//Declaring Port A as Output
	PORTA=0x00;	//Initially Sending 0
	
	usart_initialize();	//Initializing the USART Settings
	
	while (1)
	{
        while(!(UCSRA & (1<<RXC)));	//Getting Input from User
        p = UDR;
        while(!(UCSRA & (1<<UDRE)));//Sending that input to Hyperterminal
        UDR = p;
	}
}