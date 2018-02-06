% Generate the function for timing shifting. For sequences x(n) ={1,-1,2,5,1,5,-1}.

clc;
clear;

x =[1,-1,2,5,1,5,-1];
index_zero = 2;
sample = 3;

[n,Y] = shift(x,index_zero,sample,'advance');

fprintf('Original Signal =');
disp(x);
fprintf('Shifted Signal  =');
disp(Y);
fprintf('Shifted Index   =');
disp(n);
