% Write a MATLAB program to find circular convolution of two sequences using Matrix
% Multiplication method.

clc;
clear;

x1 = [1,-1,-2,3,-1];
h1 = [1,2,3];

y1 = circ_conv_matrix(x1,h1);
y1mat = cconv(x1,h1);

x2 = [1, 2, 1, 2];
h2 = [3, 2, 1, 4];

y2 = circ_conv_matrix(x2,h2);
y2mat = cconv(x2,h2,length(x2));

N = 8;

n = 0:1:N-1;

x3 = cos(2*pi*n/N);
h3 = sin(2*pi*n/N);

y3 = circ_conv_matrix(x3,h3);
y3mat = cconv(x3,h3,length(x3));

fprintf('Y1            = ');
disp(y1);

fprintf('Y1 by Inbuilt = ');
disp(y1mat);

fprintf('Y2            = ');
disp(y2);

fprintf('Y2 by Inbuilt = ');
disp(y2mat);

fprintf('Y3            = ');
disp(y3);

fprintf('Y3 by Inbuilt = ');
disp(y3mat);



