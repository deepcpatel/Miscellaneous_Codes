/*
   Program :2
 */

//LCD Connections

#define LCD_RS  PORTA.B2   // RS
#define LCD_EN  PORTD.B6   //Enable
#define LCD_D4  PORTC.B4   //Data Bit 4
#define LCD_D5  PORTC.B5   //Data Bit 5
#define LCD_D6  PORTC.B6   //Data Bit 6
#define LCD_D7  PORTC.B7   //Data Bit 7

unsigned char m=53;
unsigned char n=57;
unsigned char o=57;
unsigned char p=57;
unsigned int flag=0;

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

	// Till NULL character is reached, take each character
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
	LCD_RS=0; 			// Register Select =0 (for Command register)
	LCD_EN=1; 			//Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;
	delay_us(100);

	PORTC=((command<<4)&0xF0);  // Send Lower nibble (D3-D0)
	LCD_EN=1; 					//Enable=1 for H to L pulse
	delay_us(5);
	LCD_EN=0;

	delay_us(40);
}

// Cursor Position
void Cursor_Position(unsigned short int x,unsigned short int y)
{
	unsigned char firstcharadd[] ={0x80,0xC0}; 	// First line address 0X80 and Second line address 0XC0
	lcdcommand((firstcharadd[x-1]+y-1));
}

void clear()
{
	lcdcommand(0x01);
	delay_ms(2);
}

//LCD Initialize

void LCD_Initialize()
{
	LCD_EN=0;

	lcdCommand(0x33); // Initialize LCD for 4 bit mode
	lcdCommand(0x32); // Initialize LCD for 4 bit mode
	lcdCommand(0x28); // Initialize LCD for 5X7 matrix mode
	lcdCommand(0x0E); // Display on,cursor blinking

	clear();

	lcdCommand(0x06); //Shift cursor to right
	lcdCommand(0x80); //Starting Address
}

void interrupt() org 0x04 //Interrupt Function
{
   m++;
   if(m>57)
   {
		m=48;
		n++;
   }
   if(n>57)
   {
		n=48;
		o++;
   }
   if(o>57)
   {
		o=48;
		p++;
   }
   if(p>57)
   {
		p=48;
		flag=1;
   }
}


void main()
{

	char disp1[]="Welcome to IET";	//Declaring the Messages
	char disp2[]="Count:";
	char disp3[]="Dean needs a break. Please come tomorrow";

	//Set-up PORTS for LCD
	DDRC=0xF0;  // For D3-D0
	DDRA.B2=1;  // For RS
	DDRD=(1<<6)|(0<<3);  // Enable and Interrupt
    PORTD = 1<<3;

    SREG.B7=1;
	
	MCUCR = 0X08;

    GICR = (1<<INT1);

	LCD_Initialize(); //Initialize

	while(1)
	{
		if(flag==1)
		{
		   clear();	//Clear the Screen
		   goto z;
		}
		else
		{
			Cursor_Position(1,1);
			LCD_Print(disp1); //Display Text
			Cursor_Position(2,1);
			LCD_Print(disp2); //Display Text
			Cursor_Position(2,7);
			LCD_Data(p); 	//Display Text
			Cursor_Position(2,8);
			LCD_Data(o); //Display Text
			Cursor_Position(2,9);
			LCD_Data(n); //Display Text
			Cursor_Position(2,10);
			LCD_Data(m); //Display Text
		}
	}
	 
	z:
	
	while(1)	//While Loop to Display "Dean Needs a Break....."
	{
		Cursor_Position(1,1);
		LCD_Print(disp3); //Display Text
		delay_ms(200);
		lcdCommand(0x18);
	}
}