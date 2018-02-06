% Plot the continuous and discrete time sinusoidal wave for given amplitude, 
% frequency, phase and sampling frequency.

clc;
clear;

% Time specifications:
Fs = 1000;                    % samples per second or Sampling frequency
dt = 1/Fs;                    % seconds per sample
stop = 1;                     % seconds
t = 0:dt:stop;                % seconds
n = 0:1:100;                  % seconds
a = 10;                       % amplitude
phi = 20;                     % phase
Fc = 5;                       % Frequency in hertz

% Sine wave:

x_c = a*sin(2*pi*Fc*t + phi);

x_d = a*sin(2*pi*Fc*n/100 + phi);

figure;
subplot(1,2,1);
plot(x_c);
title('Continuous Signal'); 

subplot(1,2,2);
stem(x_d);
title('Discerete Signal');