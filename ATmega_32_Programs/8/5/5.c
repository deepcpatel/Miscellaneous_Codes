
int SevenSegment_Cathod[]={0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};  //Number from 0 to F

unsigned short int number;
unsigned int m=0;
unsigned int n=0;
unsigned int numb=25;
unsigned int mumb=0;
unsigned int o=25%10;
unsigned int p=25/10;

unsigned short int store[4];// Store hex values in an array
unsigned short int shift=1;
unsigned short int count_i=0;

void TIMER0_COMP() org 0x014
{
	PORTA=0x00; // PORTA cleared

	PORTA=shift; // select data selection line
	PORTC=store[count_i];//Assign data to PORTC i.e. seven segment

	shift=shift<<1; // left shift 'shift' till it reahes 0x80

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


void interrupt() org 0x04 //Interrupt Function
{
    
    if(mumb!=25)
    {
		mumb++;
		numb--;
    }
    else
    {
        mumb=0;
        numb=25;
    }

    m=mumb%10;
    n=mumb/10;
    o=numb%10;
    p=numb/10;
}



void main(void)
{
	DDRC=0xFF;        // Configure data line port C as output
	DDRA=0x0F;        // Configure selection lines of lower nibble of PORTA
					  //   as OUTPUT
	PORTA=0x01;       // Since display is required only at 1st SevenSegment

	DDRD=(1<<6)|(0<<3);  // Enable and Interrupt
	PORTD = 1<<3;

	TCCR0=0x0B;
	OCR0=0xF9;

	SREG.B7=1;           //Enable Global Interrupt


	TIMSK.B1=1; // Enable Timer 0 Comp interrupt OCEI0

	MCUCR = 0X08;

	GICR = (1<<INT1);  //Use INT1

	while(1)
	{
	   store[0]=SevenSegment_Cathod[m]; // Convert it to SevenSegment Common cathode

	   store[1]=SevenSegment_Cathod[n];// Convert it to SevenSegment Common cathode

	   store[2]=SevenSegment_Cathod[o];// Convert it to SevenSegment Common cathode

	   store[3]=SevenSegment_Cathod[p];// Convert it to SevenSegment Common cathode

	}

}