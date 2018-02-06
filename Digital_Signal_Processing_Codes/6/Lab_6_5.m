% Write the program to test FIR linear phase low pass filter with cut-off
% frequency c = using the following Window having filter length M=7 and 11.
% Use the custom commands in your program:-	
%  -> Rectangular Window
%  -> Bartlett window
%  -> Blackman Window
%  -> Hamming Window
%  -> Hanning window

clc;
clear;

Fc = 0.25; % Wc = 2*pi*Fc

M1 = 7;
M2 = 11;
n1 = 1:1:round(M1/2);
n2 = 1:1:round(M2/2);

h_0 = 2*Fc;

h7 = 2*Fc*sin(2*pi*Fc.*n1)./(2*pi*Fc.*n1);
z1 = fliplr(h7);
h7 = [z1(2:end) h_0 h7];

h11 = 2*Fc*sin(2*pi*Fc.*n2)./(2*pi*Fc.*n2);
z1 = fliplr(h11);
h11 = [z1(2:end) h_0 h11];

% Rectangular Window

W1 = rectwind(M1+1); % Rectangular Window
W2 = rectwind(M2+1); % Rectangular Window
h_7 = fird(h7,W1);   % M = 7
h_11 = fird(h11,W2); % M = 11

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

W1 = blackmand(M1+1); % Blackman Window
W2 = blackmand(M2+1); % Blackman Window
h_7 = fird(h7,W1);    % M = 7
h_11 = fird(h11,W2);  % M = 11

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

W1 = bartlettd(M1+1); % Barlett Window
W2 = bartlettd(M2+1); % Barlett Window
h_7 = fird(h7,W1);    % M = 7
h_11 = fird(h11,W2);  % M = 11

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

W1 = hammingd(M1+1); % Hamming Window
W2 = hammingd(M2+1); % Hamming Window
h_7 = fird(h7,W1);   % M = 7
h_11 = fird(h11,W2); % M = 11

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

W1 = hanningd(M1+1); % Hanning Window
W2 = hanningd(M2+1); % Hanning Window
h_7 = fird(h7,W1);   % M = 7
h_11 = fird(h11,W2); % M = 11

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
