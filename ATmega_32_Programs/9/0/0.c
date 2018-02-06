// ADC Single Conversion
// INPUT : PORTA.0  0-5V
// OUTPUT : PORTB  ADCH value
//          PORTC  ADCL value



void ADC() org 0x020
{
	PORTC=ADCL; //Diplay ADCL value @ PORTC
	PORTB=ADCH; //Diplay ADCH value @ PORTB
	ADCSRA.B6=1; // After completion of earlier conversion, start 		//new conversion
}




void main() 
{
	DDRA.B0=0;  // Set PinA.0 as input

	DDRB=0xFF;  //ADCH output
	DDRC=0xFF;  //ADCL Output

	//Initialize
	PORTB=0x00;
	PORTC=0x00;

	ADMUX=0b00000000;      //Reference Voltage Vcc, Left Adjust, ADC0
	ADCSRA=0b10001111;     //ADC enable,ADC interrupt enable,Presclaer 128

	SREG.B7=1; // Global Interrupt enable

	ADCSRA.B6=1;  //Start ADC conversion

	while(1);

}