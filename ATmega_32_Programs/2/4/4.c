void main()
{
        unsigned char z;
        
        DDRA=0XFF;
        DDRB=0X00;

        x:
        while(1)
        {
                if(PINB.B4==~(0X1))
                {
                        goto y;
                }
        }

        y:

        z=0X00;
        PORTA=z;

        while(1)
        {
                if(z==0x0F)
                {
                        z=0x00;
                }
                else
                {
                        z++;
                }

                if(PINB.B4==~(0X1))
                {
                        z=0X00;
                        PORTA=z;
                        goto q;
                }

                PORTA=z;
                Delay_ms(1000);
        }
        
        q:
        goto x;
}