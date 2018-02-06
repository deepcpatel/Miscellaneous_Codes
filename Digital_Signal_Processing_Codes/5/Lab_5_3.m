% -> Write a program to calculate DFT of a given sequence
% -> Compare the result using built in function
% -> Write a program to calculate inverse DFT 
% -> Compare the result using the built in function

clc;
clear;

x = [1 2 1 0];

f = 0:1:length(x)-1;

y = DTFT(x,f);
y1 = fft(x);

disp('DTFT of x :');
disp(y);

disp('DTFT of x using built in function :');
disp(y1);

iy = iDTFT(y,f);
iy1 = ifft(y);

disp('iDTFT of y :');
disp(iy);

disp('iDTFT of y using built in function :');
disp(iy1);

