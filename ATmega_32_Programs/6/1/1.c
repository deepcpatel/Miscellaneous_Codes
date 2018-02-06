//First Program Of Lab 6
void USART_INIT()
{
    UCSRB = (1<<TXEN); // Enable transmition
    UCSRC = (1<<UCSZ1) | (1<<UCSZ0) | (1<<URSEL);   // 8 bit transmition
    UBRRL = 0X33;   // Baud rate 9600   2400 - CF hex =  57600 - 8 hex
}

void USART_SEND(unsigned char ch)
{
    while(!(UCSRA & (1<<UDRE)));	//Waiting for buffer to be empty
    UDR = ch;						//Sending the Character
}

int main()
{
    unsigned char i = 0;

    unsigned char str[] = "Hello world!";

    USART_INIT();
    while(1)
    {
        i++;
        USART_SEND(str[i]);	//Calling the function to send all character of Hello World
        if(i>=12)
        {
            i=0;
        }
    }
    
	return 0;
}