%Lab_1_2 FIR Filter

clear;
clc;

b=[1 0.5 -0.6];				%Unknown Filter Coefficients
a=1;           				%Unknown Filter Coefficients
x=randn(1,1000+1);

d=filter(b,a,x);			%Simulates the signal from unknown system

N=3;                       	%Number of Coefficients

delta=0.001;

[h, Y, E] = LMS(x,d,delta,N);

figure;

subplot(3,1,1);
plot(d(900:1000));
title('Desired Signal');

subplot(3,1,2);
stem(h);
title('Coefficients');

subplot(3,1,3);
plot(Y(900:1000));
title('Adapted Output Signal');

