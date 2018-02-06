% Generate the function for time multiplication. Use it for sequence x 1 (n) ={1,-1,2,5,1,5,-1}.

clc;
clear;

x =[1,-1,2,5,1,5,-1];
index_zero = 2;
sample = 3;

[n,Y] = time_multiply(x,index_zero);

fprintf('Original Signal =');
disp(x);
fprintf('New Signal      =');
disp(Y);
fprintf('New Index       =');
disp(n);