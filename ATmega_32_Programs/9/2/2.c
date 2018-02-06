// ADC Single Conversion
// INPUT : PORTA.0  0-5V

unsigned int count=0x0;//Declaring the Required Variables
float v;
int no;
int no1;
int no2;
int no3;

unsigned int take1;
unsigned int take2;

#define LCD_RS  PORTA.B2   //RS
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

//LCD Command
void lcdcommand(unsigned char command)
{
        PORTC=command&0xF0; 			  // Send Higher nibble (D7-D4)
        LCD_RS=0;                         // Register Select =0 (for Command register)
        LCD_EN=1;                         //Enable=1 for H to L pulse
        delay_us(5);
        LCD_EN=0;
        delay_us(100);

        PORTC=((command<<4)&0xF0);  // Send Lower nibble (D3-D0)
        LCD_EN=1;                   //Enable=1 for H to L pulse
        delay_us(5);
        LCD_EN=0;

        delay_us(40);
}

// Cursor Position
void Cursor_Position(unsigned short int x,unsigned short int y)
{
        unsigned char firstcharadd[] ={0x80,0xC0};         // First line address 0X80 and Second line address 0XC0
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

void ADC() org 0x020
{
    unsigned int o=0x0000;                //Declaring variables
    unsigned char asc=48;

    take1=ADCL;  //Display ADCL value
    take2=ADCH;  //Display ADCH value
    take2=0x03 & take2;
     
    o=o|take2;
    o=o<<8;
    o=o|take1;
      
    v=(float)(o*5)/1024;        			//Converting the Register data to Usable form
        
        no=v*100;
											//Retrieving the Digits for Display
        no1=no%10;
        no=no/10;
        no2=no%10;
        no3=no/10;
           
        Cursor_Position(count+1,1);        //Displaying on the LCD
        asc=asc+no3;
        LCD_data(asc);                     //Converting to character form and displaying them
        asc=48;
        Cursor_Position(count+1,2);
        LCD_data('.');
        asc=asc+no2;
        Cursor_Position(count+1,3);
        LCD_data(asc);
        asc=48;
        asc=asc+no1;
        Cursor_Position(count+1,4);
        LCD_data(asc);
        asc=48;

        count=count^0x1;
        
        ADMUX=ADMUX^0b00000001;      //Reference Voltage Vcc, Right Adjust, ADC0/ADC1
        
    ADCSRA.B6=1; 					//After completion of earlier conversion, start new conversion
}

void main() 
{
    //Initialize
     
    DDRC=0xF0;  // For D3-D0
    DDRA.B2=1;  // For RS
    DDRD.B6=1;  // For Enable
     
    ADCSRA=0b10001111;     //ADC enable,ADC interrupt enable,Prescalar 128

    SREG.B7=1;             // Global Interrupt enable
        
    ADMUX=0b00000000;      //Reference Voltage Vcc, Right Adjust, ADC0

    ADCSRA.B6=1;           //Start ADC conversion

    LCD_Initialize(); 		//Initialize
     
    while(1);
}