% Generate function for unit step signal delta(n) Also plot delta(n-1) and delta(n+1).

clc;
clear;

n = -50:1:50;

figure;

x=delta(n);
x1=delta(n-ones(1,length(n)));
x2=delta(n+ones(1,length(n)));

subplot(3,1,1);
stem(n,x);
title('Delta(n)');

subplot(3,1,2);
stem(n,x1);
title('Delta(n-1)');

subplot(3,1,3);
stem(n,x2);
title('Delta(n+1)');