unsigned char p;
unsigned char e[]="ERROR!";
unsigned int i;

void usart_initialize()
{
	UCSRB=((1<<TXEN)|(1<<RXEN));	//Enabling Transmission and Receiving
	UCSRC=0x86;	//Normal mode, 8-Bit Character, 1 stop bit
	UBRRL=0x33;	//9600 Baud Rate
}

void USART_SEND(unsigned char ch)	//Function to Send the Data
{
    while(!(UCSRA & (1<<UDRE)));
    UDR = ch;
}

void main()
{
	DDRA=0xFF;
	PORTA=0x00;
	usart_initialize();

	while (1)
	{
        while(UCSRA.B7==0); // Wait till Data is received

		p = UDR;
        
		if(p>=(int)65 && p<=(int)90)	//Checking for Capital Alphabets
        {
            p=p+32;						//Converting them to Small Alphabets
            while(!(UCSRA & (1<<UDRE)));//Sending
            UDR = p;
        }
        else if(p>=(int)97 && p<=(int)122)	//Checking for Small Alphabets
        {
            p=p-32;							//Converting them to Capital Alphabets
            while(!(UCSRA & (1<<UDRE)));	//Sending
            UDR = p;
        }
        else								//Sending error message for characters except Alphabets
        {
            for(i=0;i<6;i++)
            {
                USART_SEND(e[i]);
            }
        }
	}
}