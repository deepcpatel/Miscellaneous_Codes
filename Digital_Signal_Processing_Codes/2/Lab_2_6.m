% Generate the function for signal folding. Fold the sequence x(n) ={1,-1,2,5,1,5,-1}.

clc;
clear;

x =[1,-1,2,5,1,5,-1];
index_zero = 2;
sample = 3;

[n,Y] = signal_folding(x,index_zero);

fprintf('Original Signal =');
disp(x);
fprintf('Folded Signal   =');
disp(Y);
fprintf('New Index       =');
disp(n);