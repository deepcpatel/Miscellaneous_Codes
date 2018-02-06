/*
 Project Description : Display 4 digit Number
*/

int SevenSegment_Cathod[]={0X3F,0X06,0X5B};
// values to 7 segment display data values

unsigned int number=4805; // Number to be displayed
unsigned short int store[4];// Store hex values in an array
unsigned short int shift=1;

int temp,count=0;
int count_time2=125;

/*
  In multiplexing, data and selection lines are changed at very small time
  intervals. In this case 8 msec.

*/

void TIMER0_COMP() org 0x014
{
	PORTA=0x00; // PORTA cleared

	PORTA=shift; // select data selection line
	PORTC=store[count];//Assign data to PORTC i.e. seven segment

	shift=shift<<1; // left shift 'shift' till it reahes 0x80
	
	if(shift==0x10)
	{
		shift=1; // Initialize once 0x80 is reached
	}

	count++; // increment count till it reaches 4

	if (count==4)
	{
		count=0; // Initialize once it reaches 4
	}


}

void main() {

// PORT declaration
DDRC=0xFF;    // Configure data line port C as output
DDRA=0x0F;   // Configure selection lines @ PORTA

PORTA=0x01; //Initialize

//Timer Set-Up

// Timer 0 CTC mode, pre-scaler 256 , count: 250
TCCR0=0x0B;
OCR0=0xF9;

//Interrupt Set-Up
SREG.B7=1; // Enable Global interrupt I
TIMSK.B1=1; // Enable Timer O Comp interrupt OCEI0


while(1)

{

 temp=number%10u; // Calculate unit digit of number
 store[0]=SevenSegment_Cathod[temp]; // Convert it to SevenSegment Common cathode

 temp=(number/10u)%10u;// // Calculate tens digit
 store[1]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

 temp=(number/100u)%10u; // Calculate hundreds digit
 store[2]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

 temp=number/1000u; // Calculate thousands digit
 store[3]=SevenSegment_Cathod[temp];// Convert it to SevenSegment Common cathode

}


}
