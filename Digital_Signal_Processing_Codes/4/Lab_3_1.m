% Explore command conv2 in Matlab. Take input of 2 Matrix from user and Find 2D convolution of the same. 
% Also explore the properties of conv2 command and analyze the result.

clc;
clear;

X = input('Input Matrix X:\n');
h = input('Input Matrix h:\n');

% X = [10 20 30;40 50 60;70 80 90];
% h = [1 2 3;4 5 6;7 8 9];

% X = [17 24 1 8 15;23 5 7 14 16;4 6 13 20 22;10 12 19 21 3;11 18 25 2 9];
% h = [1 3 1;0 5 0;2 1 2];

% [row_X, column_X] = size(X);
% [row_h, column_h] = size(h);

Y = conv2d(X,h);

fprintf('Output Y = \n');
disp(Y);
