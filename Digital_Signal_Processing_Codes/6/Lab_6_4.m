% Write the program to test FIR linear phase low pass filter with cut-off 
% frequency c = using the following Window having filter length M=7 and 11.
% Use the above commands in your program:-			
%  -> Rectangular Window
%  -> Bartlett window
%  -> Blackman Window
%  -> Hamming Window
%  -> Hanning window	

clc;
clear;

Fc = 0.125; % Wc = 2*pi*Fc

Fs = 20;
M1 = 7;
M2 = 11;

% Rectangular Window

W1 = rectwin(M1+1); % Rectangular Window
W2 = rectwin(M2+1); % Rectangular Window
h_7 = fir1(M1,2*Fc,'low',W1); % M = 7
h_11 = fir1(M2,2*Fc,'low',W2); % M = 11

f7 = 0:1:(length(h_7)-1);
f11 = 0:1:(length(h_11)-1);

H_7 = DTFT(h_7,f7);
H_11 = DTFT(h_11,f11);

figure;

subplot(4,1,1);
plot(h_7);
title('Rectangular Windowed Low Pass Filter, M = 7');

subplot(4,1,2);
plot(h_11);
title('Rectangular Windowed Low Pass Filter, M = 11');

subplot(4,1,3);
plot(f7/length(h_7),abs(H_7));
title('Low Pass Filter with Rectangular Window, M = 7');

subplot(4,1,4);
plot(f11/length(h_11),abs(H_11));
title('Low Pass Filter with Rectangular Window, M = 11');

% Blackman Window

W1 = blackman(M1+1); % Blackman Window
W2 = blackman(M2+1); % Blackman Window
h_7 = fir1(M1,2*Fc,'low',W1); % M = 7
h_11 = fir1(M2,2*Fc,'low',W2); % M = 11

f7 = 0:1:(length(h_7)-1);
f11 = 0:1:(length(h_11)-1);

H_7 = DTFT(h_7,f7);
H_11 = DTFT(h_11,f11);

figure;

subplot(4,1,1);
plot(h_7);
title('Blackman Windowed Low Pass Filter, M = 7');

subplot(4,1,2);
plot(h_11);
title('Blackman Windowed Low Pass Filter, M = 11');

subplot(4,1,3);
plot(f7/length(h_7),abs(H_7));
title('Low Pass Filter with Blackman Window, M = 7');

subplot(4,1,4);
plot(f11/length(h_11),abs(H_11));
title('Low Pass Filter with Blackman Window, M = 11');

% Bartlett Window

W1 = bartlett(M1+1); % Barlett Window
W2 = bartlett(M2+1); % Barlett Window
h_7 = fir1(M1,2*Fc,'low',W1); % M = 7
h_11 = fir1(M2,2*Fc,'low',W2); % M = 11

f7 = 0:1:(length(h_7)-1);
f11 = 0:1:(length(h_11)-1);

H_7 = DTFT(h_7,f7);
H_11 = DTFT(h_11,f11);

figure;

subplot(4,1,1);
plot(h_7);
title('Barlett Windowed Low Pass Filter, M = 7');

subplot(4,1,2);
plot(h_11);
title('Barlett Windowed Low Pass Filter, M = 11');

subplot(4,1,3);
plot(f7/length(h_7),abs(H_7));
title('Low Pass Filter with Barlett Window, M = 7');

subplot(4,1,4);
plot(f11/length(h_11),abs(H_11));
title('Low Pass Filter with Barlett Window, M = 11');

% Hamming Window

W1 = hamming(M1+1); % Hamming Window
W2 = hamming(M2+1); % Hamming Window
h_7 = fir1(M1,2*Fc,'low',W1); % M = 7
h_11 = fir1(M2,2*Fc,'low',W2); % M = 11

f7 = 0:1:(length(h_7)-1);
f11 = 0:1:(length(h_11)-1);

H_7 = DTFT(h_7,f7);
H_11 = DTFT(h_11,f11);

figure;

subplot(4,1,1);
plot(h_7);
title('Hamming Windowed Low Pass Filter, M = 7');

subplot(4,1,2);
plot(h_11);
title('Hamming Windowed Low Pass Filter, M = 11');

subplot(4,1,3);
plot(f7/length(h_7),abs(H_7));
title('Low Pass Filter with Hamming Window, M = 7');

subplot(4,1,4);
plot(f11/length(h_11),abs(H_11));
title('Low Pass Filter with Hamming Window, M = 11');

% Hanning Window

W1 = hann(M1+1); % Hanning Window
W2 = hann(M2+1); % Hanning Window
h_7 = fir1(M1,2*Fc,'low',W1); % M = 7
h_11 = fir1(M2,2*Fc,'low',W2); % M = 11

f7 = 0:1:(length(h_7)-1);
f11 = 0:1:(length(h_11)-1);

H_7 = DTFT(h_7,f7);
H_11 = DTFT(h_11,f11);

figure;

subplot(4,1,1);
plot(h_7);
title('Hanning Windowed Low Pass Filter, M = 7');

subplot(4,1,2);
plot(h_11);
title('Hanning Windowed Low Pass Filter, M = 11');

subplot(4,1,3);
plot(f7/length(h_7),abs(H_7));
title('Low Pass Filter with Hanning Window, M = 7');

subplot(4,1,4);
plot(f11/length(h_11),abs(H_11));
title('Low Pass Filter with Hanning Window, M = 11');
