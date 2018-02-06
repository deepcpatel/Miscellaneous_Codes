% -> Given the sequence x(n) and sequence n write a program to compute DTFT and 
% plot magnitude and phase spectrum
% 
% -> Compute DFT of x(n) using built in function fft and verify that for a finite 
% sequence x(n) DFT has an exact match with DTFT at F = k/N , k = 0,1,...N-1

clc;
clear;

Fs = 100;

f = 0:1:Fs-1;

x = randn(1,Fs);

y = DTFT(x,f);
y1 = fft(x);

disp(y(1:3));
disp(y1(1:3));

figure;

subplot(5,1,1);
plot(x);
title('x');

subplot(5,1,2);
plot(abs(y));
title('Magnitude Part of DTFT');

subplot(5,1,3);
stem(angle(y));
title('Phase Part of DTFT');

subplot(5,1,4);
plot(abs(y1));
title('Magnitude Part of FFT');

subplot(5,1,5);
stem(angle(y1));
title('Phase Part of FFT');

