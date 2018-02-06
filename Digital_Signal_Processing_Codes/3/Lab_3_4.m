% Develop function for Auto-correlation and find out auto-correlation for any sequence and
% plot required outputs.

clc;
clear;

x1 = [1,2,2,1];

n1_1 = [-1 0 1 2];

y = cross_corr(x1,n1_1);

figure(1)
stem(y);
title('Auto Correlation');
