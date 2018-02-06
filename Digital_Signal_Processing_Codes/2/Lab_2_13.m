% Plot all the given signals and comment on their output for periodicity writing common
% MATLAB code.
% (1). x1 = cos((pi*0.002)*n);
% (2). x2 = sin((30*pi/105)*n);
% (3). x3 = sin(5*n);
% (4). x4 = cos((32*pi/10)*n);
% (5). x5 = 10*cos((7)*n + (pi/6));
% (6). x6 = 2*(cos(n-pi) + 1i*sin(n-pi));

clc;
clear;

% Time specifications:
Fs = 1000;                    % samples per second or Sampling frequency
dn = 1/Fs;                    % seconds per sample
stop = 100;                   % seconds
n = 0:dn:stop;                % seconds

% Waves:

x1 = cos((pi*0.002)*n);
x2 = sin((30*pi/105)*n);
x3 = sin(5*n);
x4 = cos((32*pi/10)*n);
x5 = 10*cos((7)*n + (pi/6));
x6 = 2*(cos(n-pi) + 1i*sin(n-pi));

figure;

subplot(3,2,1);
plot(n, x1);
title('x1');

subplot(3,2,2);
plot(n, x2);
title('x2');

subplot(3,2,3);
plot(n, x3);
title('x3');

subplot(3,2,4);
plot(n, x4);
title('x4');

subplot(3,2,5);
plot(n, x5);
title('x5');

subplot(3,2,6);
plot(n, x6);
title('x6');
