% Perform the operation on x(n)
% x(n) = (1,-1,2,5,1,5,-1)
% (1). sum(-1,3,x) ;
% (2). product(-1,3,x) ;
% (3). energy(-infinite,infinite,x);

clc;
clear;

x = [1 -1 2 5 1 5 -1];
origin = 2;

sum_x = sum(x(1:5));

product_x = prod(x(1:5));

energy_x = x*x';

disp(['Sum of all the elements of Signal X = ', num2str(sum_x)]);
fprintf('Product of all the elements of Signal X = %d', product_x);
disp(sprintf('\nEnergy of the Signal X = %d', energy_x));