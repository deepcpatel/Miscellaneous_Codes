% Plot all the given signals and comment on their output for periodicity writing common
% MATLAB code.
% (1). x1 = 3*cos((pi/6)*n) + 5*cos((3*pi/6)*n);
% (2). x2 = cos((pi/7)*n) .* cos((pi/7)*n);
% (3). x3 = cos((pi/6)*n) .* cos((pi/9)*n);
% (4). x4 = 2*cos((pi/4)*n) - sin((pi/6)*n) + 3*cos((pi/8)*n + (pi/3));

clc;
clear;

% Time specifications:
Fs = 1000;                    % samples per second or Sampling frequency
dn = 1/Fs;                    % seconds per sample
stop = 100;                   % seconds
n = 0:dn:stop;                % seconds

% Waves:

x1 = 3*cos((pi/6)*n) + 5*cos((3*pi/6)*n);
x2 = cos((pi/7)*n) .* cos((pi/7)*n);
x3 = cos((pi/6)*n) .* cos((pi/9)*n);
x4 = 2*cos((pi/4)*n) - sin((pi/6)*n) + 3*cos((pi/8)*n + (pi/3));

figure;

subplot(2,2,1);
plot(n, x1);
title('x1');

subplot(2,2,2);
plot(n, x2);
title('x2');

subplot(2,2,3);
plot(n, x3);
title('x3');

subplot(2,2,4);
plot(n, x4);
title('x4');
