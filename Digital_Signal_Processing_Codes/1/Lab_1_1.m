%Lab_1_1 LMS Test

clear;
clc;

% Time specifications:
Fs = 10300;                  % samples per second or Sampling frequency
dt = 1/Fs;                   % seconds per sample
stop = 1;                    % seconds
t = 0:dt:stop;               % seconds

% Sine wave:
Fc = 10;  % hertz
d = sin(2*pi*Fc*t);
x = d + randn(1,Fs+1);
N=100;                      %Number of Coefficients

delta=0.001;

[h, Y, E] = LMS(x,d,delta,N);

figure;

subplot(2,3,1);
plot(t,d);
title('Desired Signal');
%xtitle('Time');
%ytitle('Signal Value(d)');

subplot(2,3,2);
plot(t,x);
title('Noisy Signal');
%xtitle('Time');
%ytitle('Signal Value(x)');

subplot(2,3,3);
stem(h);
title('Coefficients');
%ytitle('h');

subplot(2,3,4);
plot(t,Y);
title('Adapted Output Signal');
%xtitle('Time');
%ytitle('Signal Value(Y)');

subplot(2,3,5);
plot(t,E);
title('Error Vector');
%ytitle('E');
