#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
	clrscr();
	float a,b,c,s,area;

	printf("\nEnter the Side A of the triangle:");
	scanf("%f", &a);
	printf("\nEnter the Side B of the triangle:");
	scanf("%f", &b);
	printf("\nEnter the Side C of the triangle:");
	scanf("%f", &c);

	if((a+b)>c)
	{
		s=(a+b+c)/2;
		area=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("\nThe area of the Triangle is:%f", area);
	}
	else
	{
		printf("\nAccording to the Size you have entered, the Triangle is not Possible->Sorry...");
	}
	getch();
}




