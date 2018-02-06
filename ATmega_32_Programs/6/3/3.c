////////////////////////////////////////////////////////////////////////////////
void usart_initialize()
{
	UCSRB=((1<<TXEN)|(1<<RXEN)); //Tx Enable, and Rx Enable
	UCSRC=0x86; // Data Size : 8-bit, Stop Bit:1,No parity
	UBRRL=0x33;
}
////////////////////////////////////////////////////////////////////////////////

void usart_send(unsigned char ch)
{
	while(UCSRA.B5==0); // Wait till UDR is empty
	UDR=ch; //Write the value to be Tx
}
////////////////////////////////////////////////////////////////////////////////

void send_data(int m)
{
	int i=0;
	int size;

	char message1[]="Welcome to ESD Lab!";	//Declaring the Messages
	char message2[]="Invalid Passcode";
	char message3[]="Enter Password:";
	char message4[]="System Hang..!!!";

	char *message;

	if(m==0)
	{
		message=message1;	//Assigning the Messages
		size=19;
	}
	else if(m==1)
	{
		message=message2;
		size=16;
	}
	else if(m==2)
	{
		message=message3;
		size=15;
	}
	else
	{
		message=message4;
		size=16;
	}

	while(i<size)	//Sending the message to the Hyperterminal
	{
		usart_send(message[i]);  //Send data
		i++;
	}
}
////////////////////////////////////////////////////////////////////////////////

int check_pass()
{
	int chk=1;
	int i=0;

	char password[]={'P','a','s','s','w','o','r','d','\r'};

	while(i<sizeof(password))
	{
		while(UCSRA.B7==0); // Wait till Data is received

		if(password[i]==UDR)
		{
			chk=1;
		}
		else
		{
			chk=0;			//Return 0 if any character does not match
			return chk;
		}

		i++;
	}

	return chk;
}
////////////////////////////////////////////////////////////////////////////////

void main()
{
	int counter=0;
	int rec;
	int e=0;

	usart_initialize();	 //Initialize the USART

	while(counter<=3)	//Allow the User to Enter the password 3 Times
	{					//If Fourth time the password is correct then Show the message System Hang!
		counter++;
		send_data(2);
		rec=check_pass();	//Checking the password

		if(rec)				//Sending the Relevant Message
		{
			send_data(0);
			e=1;
			break;
		}
		else
		{
			send_data(1);	 
		}
	}

	if(e==0)
	{
		send_data(3);
	}

}
