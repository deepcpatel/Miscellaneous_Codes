% -> Design 4th Order Chebyshev-I Bandpass Filter with lower cutoff frequency 
%    wL =0.3p, passband, ripple 0.11 and higher cutoff frequencywH = 0.6p, using
%    impulse invariance method for sampling time T=0.1
% -> Study Cheby1  :  Lp2bp

clc;
clear;

Fs = (1/0.1);
n = 2;              % Filter Order

Rp = (-20*log10(1-0.11));

Wp = 1;
Wh = 0.6*pi*Fs;
Wl = 0.3*pi*Fs;

Wo = sqrt(Wh*Wl);   % Cutoff Frequency
bandwidth = Wh-Wl;    

[b,a] = cheby1(n,Rp,Wp,'s');
[bc,ac] = lp2bp(b,a,Wo,bandwidth);

[bz,az] = impinvar(bc,ac,Fs);

freqz(bz,az);