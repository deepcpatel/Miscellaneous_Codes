% Generate function for unit ramp signal ur(n) Also plot ur(n + 1) and ur (n - 1).

clc;
clear;

n = -50:1:50;

figure;

x=Ur(n);
x1=Ur(n-ones(1,length(n)));
x2=Ur(n+ones(1,length(n)));

subplot(3,1,1);
plot(n,x);
title('Ur(n)');

subplot(3,1,2);
plot(n,x1);
title('Ur(n-1)');

subplot(3,1,3);
plot(n,x2);
title('Ur(n+1)');
