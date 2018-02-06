% Find cross-correlation between two sequences by developing your own function. 
% Verify your program for following sequence and Plot required outputs.

clc;
clear;

x1 = [1,2,2,1];
h1 = [1,-1,2];

n1_1 = [-1 0 1 2];
n2_1 = [-2 -1 0];

y = cross_corr(x1,h1,n1_1,n2_1);

figure(1)
stem(y);
title('Cross Correlation');
