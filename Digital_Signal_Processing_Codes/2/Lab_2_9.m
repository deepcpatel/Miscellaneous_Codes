% Generate function for unit step signal u(n) Also plot u(n-1) and u(n+1).

clc;
clear;

n = -50:1:50;

figure;

x=U(n);
x1=U(n-ones(1,length(n)));
x2=U(n+ones(1,length(n)));

subplot(3,1,1);
plot(n,x);
title('U(n)');

subplot(3,1,2);
plot(n,x1);
title('U(n-1)');

subplot(3,1,3);
plot(n,x2);
title('U(n+1)');