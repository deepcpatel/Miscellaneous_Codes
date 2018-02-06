% -> Write a program to calculate filter coefficients for band pass filter.
% 
% -> Use these coefficients in the DTFT program and plot the frequency response
% 
% -> Verify that you indeed get a low pass filter response

clc;
clear;

F1 = 0.25;
F2 = 0.40;

Fs = 20;
n = 1:1:Fs;

h_0 = 2*(F2 - F1);
h = 2*((F2*sin(2*pi*F2.*n)./(2*pi*F2.*n))-(F1*sin(2*pi*F1.*n)./(2*pi*F1.*n)));

h = [fliplr(h) h_0 h];

f = 0:1:(length(h)-1);

y = DTFT(h,f);

disp(y(1:10));

figure;

subplot(2,1,1);
plot(h);
title('');

subplot(2,1,2);
plot(f/length(h),abs(y));
title('Filter Responce');
xlabel('Frequency');
ylabel('H(f)');