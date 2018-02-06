% Find out the output of Accumulator if input x(n) = cos((2n*pi)/20)u(n).

clc;
clear;

stop = 100;                   % seconds
n = 0:1:stop;                % seconds

% Cosine Wave:

x1 = 3*cos((pi*2/20)*n);

accumulate_x = sum(x1);

plot(x1);

fprintf('Accumulater output of all the elements of Signal X = %d \n', accumulate_x);