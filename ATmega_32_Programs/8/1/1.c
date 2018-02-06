
int SevenSegment_Cathod[]={0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};  //Number from 0 to F

unsigned short int number;

void main(void)
{
	DDRC=0xFF;        // Configure data line port C as output
	DDRA=0x0F;        // Configure selection lines of lower nibble of PORTA
									  //   as OUTPUT
	PORTA=0x01;       // Since display is required only at 1st SevenSegment
	
	number=0;         //Initialize number

	while(1)
	{
		PORTC=SevenSegment_Cathod[number];
		number++;
		delay_ms(1000);
		/* Pass number(decimal value) to 7 SevenSegment_Cathod function, which will
		return value for Seven Segment Common cathode */
	   
		if(number==16)
		{
		   number=0;
		}
	}
        
}