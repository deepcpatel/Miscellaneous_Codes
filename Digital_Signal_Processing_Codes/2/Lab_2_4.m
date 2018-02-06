% Generate the function for signal multiplication. For Two sequences x 1 (n) ={1,-1,2,5,1,5,-1} and x 2 (n) ={-2,-8,9,4,2,3,5}.

clc;
clear;

x1 = [1,-1,2,5,1,5,-1];
zero_ind_1 = 2;

x2 = [-2,-8,9,4,2,3,5];
zero_ind_2 = 1;

[x1, x2, mult, n] = multiply(x1, zero_ind_1, x2, zero_ind_2);

fprintf('  X1  =');
disp(x1);
fprintf('* X2  =');
disp(x2);
fprintf('      =');
disp(mult);
fprintf('Index =');
disp(n);