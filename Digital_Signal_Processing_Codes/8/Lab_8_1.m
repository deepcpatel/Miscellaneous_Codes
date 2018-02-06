% -> Write a program to design and test  digital IIR lowpass Butterworth 
%    Prototype Filter with a passband edge of 500 Hz, a stopband edge of 2KHz, 
%    Passband ripple of 1 dB, stopband attenuation of 20 dB and a sampling 
%    frequency of 8KHz using impulse invariance method.
%
% -> Study and use Buttord,Butter,Impinvar, freqz.

clc;
clear;

Fs = 8000; % Hz Sampling Frequency

Wp = 500/(Fs/2);   % Hz
Ws = 2000/(Fs/2);  % Hz

ripple = 1; % dB
amin = 20;  %dB

[n,Wo] = buttord(Wp,Ws,ripple,amin, 's'); % Finding Order(n) and Cutoff Frequency(Wo) of the filter

[b,a] = butter(n,Wo);   % Making Filter, [a,b] are transfer function coefficients

[bz,az] = impinvar(b,a,Fs);  % Analog to Digital filter conversion

[h,w] = freqz(bz,az,2001);

plot(w/pi,20*log10(abs(h)));