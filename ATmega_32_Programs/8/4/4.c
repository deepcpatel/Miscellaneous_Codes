
int SevenSegment_Cathod[]={0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};  //Number from 0 to F

unsigned short int number;   //Initializing the Required Variables
unsigned int m=0; //Seconds
unsigned int n=0; //Minutes
unsigned int o=0;
unsigned int p=0; //Hour
unsigned int q=0;
unsigned int thresh=9;

unsigned short int store[4];// Store hex values in an array
unsigned short int shift=1;
unsigned short int count_i=0;

void T1DELAY() //Running Timer 1
{
	TCNT1H=0x7F;      //Initializing and Running Timer 1 for 0.5 Second
	TCNT1L=0xFF;
	
	TCCR1A=0x00;     //Normal Mode, 1024 Prescalar
	TCCR1B=0x05;

	while((TIFR&(0x1<<TOV1))==0);  //Wait for TF1 to Roll Over

	TCCR1A=0x00;
	TCCR1B=0x00;
	
	TIFR=0x1<<TOV1;  //Clearing the Register
}

void TIMER0_COMP() org 0x014
{
	PORTA=0x00; // PORTA cleared

	PORTA=shift;         // select data selection line
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

void clock()  //Clock Increment Function
{
    m++;   //Seconds
   
    if(m>60)
    {
        m=0;
        n++;
    }
    
	if(n>9)
    {
        n=0;
        o++;
    }
   
    if(o>5)       //Incrementing According to Need
    {
        o=0;
        p++;
    }
   
    if(p>thresh)
    {
        p=0;
        q++;
    }
   
    if(q>2)
    {
        q=0;
    }

    if(q==2)
    {
        thresh=3;
    }
    else
    {
	   thresh=9;
    }

    store[0]=SevenSegment_Cathod[n]; // Convert it to SevenSegment Common cathode

    store[1]=SevenSegment_Cathod[o];// Convert it to SevenSegment Common cathode

    store[2]=SevenSegment_Cathod[p] | 0x80;// Convert it to SevenSegment Common cathode

    store[3]=SevenSegment_Cathod[q];// Convert it to SevenSegment Common cathode

}



int main(void)
{
	DDRC=0xFF;        // Configure data line port C as output
	DDRA=0x0F;        // Configure selection lines of lower nibble of PORTA
					  //   as OUTPUT
	PORTA=0x01;       // Since display is required only at 1st SevenSegment

	TCCR0=0x0B;
	
	OCR0=0xF9;

	SREG.B7=1;           //Enable Global Interrupt

	TIMSK.B1=1; // Enable Timer 0 Comp interrupt OCEI0

	while(1)      //Clock Running
	{
	   T1DELAY();
	   store[0]=SevenSegment_Cathod[n]|0x80; //Displaying the Data and Dot
	   T1DELAY();
	   clock();

	}
	
    return 0;
}