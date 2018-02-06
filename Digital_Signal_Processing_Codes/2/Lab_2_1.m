% Generate deterministic continuous time signal having equation 
% x(t)= 3t/(4+t^2) and discrete time signal having equation x(n)= 3n/(4+n^2)

clc;
clear;

t=0:0.5:50;
n=0:1:100;

x_c=3*t./(4+t.^2);
x_d=3*n./(4+n.^2);

figure;
subplot(1,2,1);
plot(x_c);
title('Continuous Signal'); 

subplot(1,2,2);
stem(x_d);
title('Discerete Signal');
