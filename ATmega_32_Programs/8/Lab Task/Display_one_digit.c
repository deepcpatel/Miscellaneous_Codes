/*
Program Description: Display any single digit number at Seven Segment.

Seven Segment Hardware Description for MikroElectronika Easy AVR 7:

In MikroElektronika Easy AVR 7 Multiplexing is used to display data @
4 seven segment display.

Driving such a display is done using multiplexing techniques.Data lines are
shared between segments,and therefore the same segment LEDs in each digit are
connected in parallel. Each digit has it’s unique digit select line, which is
used to enable the digit to which the data is currently being sent.

By multiplexing data through all four segments fast enough, you create an
illusion that all four segments are in operation simultaneously. This is
possible because human eye has a slower reaction time than the mention changes.
This way you can represent numbers in decimal or hexadecimal form. Eight data
lines that are common for all the digits are connected to PORTC, and digit
select lines are connected to PA0–PA3 lines on the microcontroller sockets.

(You may find this description @ Page 23 Easy AVR 7)

Data Line : PORTC
7 Segment Selection Line : PA.3-PA.0

*/
int SevenSegment_Cathod[]={0X3F,0X06,0X5B};

unsigned short int number;

main(void)
{
        DDRC=0xFF;        // Configure data line port C as output
        DDRA=0x0F;        // Configure selection lines of lower nibble of PORTA
                          //   as OUTPUT
        PORTA=0x01;       // Since display is required only at 1st SevenSegment
        number=2;         //Initialize number
    while(1)
    {
        PORTC=SevenSegment_Cathod[number];
      /* Pass number(decimal value) to 7 SevenSegment_Cathod function, which will
        return value for Seven Segment Common cathode */
    }
}
