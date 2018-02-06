% Sample the sinusoid x = sin(2 pi f t), where f = 2 kHz, and plot the sampled signals over the
% continuous-time signal.
% - Let x1 be the signal sampled at 10 kHz.
% - Let x2 be the signal sampled at 3 kHz.
% Plot required waveforms and comment on the same by writing common MATLAB code.

clc;
clear;

% Time specifications:
Fs1 = 10*10^3;                % samples per second or Sampling frequency 1
Fs2 = 3*10^3;                 % samples per second or Sampling frequency 2
dn1 = 1/Fs1;                  % seconds per sample
dn2 = 1/Fs2;                  % seconds per sample
stop = 1;                     % seconds
n1 = 0:dn1:stop;              % seconds
n2 = 0:dn2:stop;              % seconds
a = 1;                        % amplitude
Fc = 2*10^3;                  % Frequency in hertz

% Sine wave:

x1 = a*sin(2*pi*Fc*n1);

x2 = a*sin(2*pi*Fc*n2);

figure;
subplot(1,2,1);
plot(n1(1:100),x1(1:100));             %Plotting First 100 Samples only
title('Sinusoidal at Sampling Frequency = 10 Khz'); 

subplot(1,2,2);
plot(n2(1:100),x2(1:100));             %Plotting First 100 Samples only
title('Sinusoidal at Sampling Frequency = 3 Khz');

