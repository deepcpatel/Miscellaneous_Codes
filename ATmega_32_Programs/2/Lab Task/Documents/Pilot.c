// Pilot
// Turn on LED at PortA.0

void main()
{
 // Assign PORTA.0 direction as output
 DDRA=0X01;

 // Assign PORTA.0 state as high
 PORTA=0X01;

 // Do nothing
 while(1)
 {
 }
}