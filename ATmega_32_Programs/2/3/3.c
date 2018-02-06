void main()
{
     unsigned char e;
     DDRA=0XAA;
     while(1)
     {
              e=~PINA;
              e=e<<1;
              PORTA=e;
     }
}