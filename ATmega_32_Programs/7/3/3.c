
//LCD Connections
#define LCD_RS  PORTA.B2   // RS
#define LCD_EN  PORTD.B6   //Enable
#define LCD_D4  PORTC.B4   //Data Bit 4
#define LCD_D5  PORTC.B5   //Data Bit 5
#define LCD_D6  PORTC.B6   //Data Bit 6
#define LCD_D7  PORTC.B7   //Data Bit 7

void LCD_data(unsigned char Data)
{
	PORTC=Data&0xF0; // Send Higher nibble (D7-D4)
	LCD_RS=1;       // Register Select =1 (for data select register)
	LCD_EN=1;      //Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;


	PORTC=((Data<<4)&0xF0); // Send Lower nibble (D3-D0)
	LCD_EN=1;               //Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;

	delay_us(100);
}


//LCD Print
void LCD_Print(char * str)
{
	unsigned char i=0;

	// Till NULL charecter is reached, take each character
	while(*(str+i)!=0)
	{
		LCD_data(*(str+i)); // Data sent to LCD data register
		i++;
		delay_ms(10);
	}
}

//LCD Command
void lcdcommand(unsigned char command)
{
	PORTC=command&0xF0; // Send Higher nibble (D7-D4)
	LCD_RS=0; // Register Select =0 (for Command register)
	LCD_EN=1; //Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;
	delay_us(100);

	PORTC=((command<<4)&0xF0);  // Send Lower nibble (D3-D0)
	LCD_EN=1; //Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;

	delay_us(40);
}

// Cursor Posotion
void Cursor_Position(unsigned short int x,unsigned short int y)
{
	unsigned char firstcharadd[] ={0x80,0xC0}; // First line address 0X80
											//Second line address 0XC0
	lcdcommand((firstcharadd[x-1]+y-1));

}

void clear()
{
	lcdcommand(0x01);
	delay_ms(2);
}

 //LCD Iniatialize
void LCD_Initialize()
{
	LCD_EN=0;

	lcdCommand(0x33); // Initialize LCD for 4 bit mode
	lcdCommand(0x32); // Initialize LCD for 4 bit mode
	lcdCommand(0x28); // Initialize LCD for 5X7 matrix mode
	lcdCommand(0x0E); //Display on,cursor blinking
	clear();
	lcdCommand(0x06); //Shift cursor to right
	//lcdCommand(0x80);
}


void main()
{
	unsigned int i;
	char disp1[]="*****PORTB******";	//Message
	char disp2[]="*****STATUS*****";
	//Set-up PORTS for LCD
	char c[16];
	char d,m;
	char disp3[]=" 7 6 5 4 3 2 1 0";
	DDRC=0xF0;  // For D3-D0
	DDRA.B2=1;  //For RS
	DDRD.B6=1;  //For Enable
	DDRB = 0x00;//PORT B as Input
	PORTB =0xFF;

	LCD_Initialize(); //Initialize
	Cursor_Position(1,1);
	LCD_Print(disp1);	//Printing Message
	Cursor_Position(2,1);
	LCD_Print(disp2);
	Delay_ms(1000);
	clear();
	
	d = PINB;
	
	c[0] = 0x20;
	c[1] = 0 |  (0x30);
	c[2] = 0x20;
	c[3] = 0 |  (0x30);
	c[4] = 0x20;
	c[5] = 0 |  (0x30);
	c[6] = 0x20;
	c[7] = 0 |  (0x30);
	c[8] = 0x20;
	c[9] = 0 |  (0x30);
	c[10] = 0x20;
	c[11] = 0 |  (0x30);
	c[12] = 0x20;
	c[13] = 0 | (0x30);
	c[14] = 0x20;
	c[15] = 0 | (0x30);
	Cursor_Position(1,1);	//Setting Cursor Position
	LCD_Print(disp3);		//Display Current Status of Port B
	Cursor_Position(2,1);
	LCD_Print(c);
		
	while(1)
	{
	   if(d!=PINB)		//Scanning the Change in Port B
	   {
			c[0] = 0x20;
			c[1] = PINB.b7 |  (0x30);	//Storing the Changed Value for Showing
			c[2] = 0x20;
			c[3] = PINB.b6 |  (0x30);
			c[4] = 0x20;
			c[5] = PINB.b5 |  (0x30);
			c[6] = 0x20;
			c[7] = PINB.b4 |  (0x30);
			c[8] = 0x20;
			c[9] = PINB.b3 |  (0x30);
			c[10] = 0x20;
			c[11] = PINB.b2|  (0x30);
			c[12] = 0x20;
			c[13] = PINB.b1 | (0x30);
			c[14] = 0x20;
			c[15] = PINB.b0 | (0x30);
			Cursor_Position(1,1);	//Setting Cursor Position
			LCD_Print(disp3);		//Displaying the Current position of Port B
			Cursor_Position(2,1);
			LCD_Print(c);
		}

	}

}