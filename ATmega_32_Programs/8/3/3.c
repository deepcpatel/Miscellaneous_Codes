
int SevenSegment_Cathod[]={0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};  //Number from 0 to F

unsigned short int number;
unsigned int m=0;
unsigned int n=0;
unsigned int o=0;
unsigned int p=0;
unsigned int secondold=0;
unsigned int number_i = 0;
unsigned int cio=0;
unsigned int previous=1;
unsigned short int store[4];// Store hex values in an array
unsigned short int shift=1;
unsigned short int count_i=0;
unsigned int temp;

void TIMER0_COMP() org 0x014
{
	PORTA=0x00; // PORTA cleared

	PORTA=shift; // select data selection line
	PORTC=store[count_i];//Assign data to PORTC i.e. seven segment

	shift=shift<<1; // left shift 'shift' till it reahes 0x10

	if(shift==0x10)
	{
		shift=1; // Initialize once 0x10 is reached
	}

	count_i++; // increment count till it reaches 4

	if (count_i==4)
	{
		count_i=0; // Initialize once it reaches 4
	}


}


void main(void)
{
	DDRC=0xFF;        // Configure data line port C as output
	DDRA=0x0F;        // Configure selection lines of lower nibble of PORTA
					  //   as OUTPUT
	PORTA=0x01;       // Since display is required only at 1st SevenSegment

	TCCR0=0x0B;
	OCR0=0xF9;

	SREG.B7=1;           //Enable Global Interrupt


	TIMSK.B1=1; // Enable Timer 0 Comp interrupt OCEI0




	while(1)
	{
	
	    if(number_i<6756)	//Checking for Reinitialize the Counter 
	    {
			m:
			if(cio<1)
			{
				number_i = secondold+previous;
				cio++;
			}
			else
			{
				number_i = secondold+previous;
				secondold = previous;
				previous = number_i;
			}
	    }
	    else
	    {
		   number_i=0;
		   previous = 1;
		   secondold=0;
		   cio=0;
		   goto m;
	    }
	    
		temp=number_i%10u; // Calculate unit digit of number
	    store[0]=SevenSegment_Cathod[temp]; // Convert it to SevenSegment Common cathode

	    temp=(number_i/10u)%10u;// // Calculate tens digit
	    store[1]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

	    temp=(number_i/100u)%10u; // Calculate hundreds digit
	    store[2]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

	    temp=number_i/1000u; // Calculate thousands digit
	    store[3]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

	    delay_ms(500);

	}

}