% -> Write a program to calculate filter coefficients for low pass filter.
% 
% -> Use these coefficients in the DTFT program and plot the frequency response
% 
% -> Verify that you indeed get a low pass filter response

clc;
clear;

Fc = 0.25;

Fs = 20;
n = 1:1:Fs;

h_0 = 2*Fc;
h = 2*Fc*sin(2*pi*Fc.*n)./(2*pi*Fc.*n);

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