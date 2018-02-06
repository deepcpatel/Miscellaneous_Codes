% 1). Use MATLAB to obtain impulse response & step response of the systems specified below
% 2). Use MATLAB to obtain pole-zero plot of the systems specified in (a), (b), (c)
%     a. Y(n) = 0.75 y(n-1) – 0.125 y(n-2) +x(n)
%     b. Y(n) = y(n-1)+x(n)
%     c. Y(n) = 0.7 y(n-1) - 0.1 y(n-2) + 2 x(n) –x(n-2)

clc;
clear;

syms n z;

% (a)

z_1 = 1/(1 - 0.75*z^(-1) + 0.125*z^(-2));   % Z-Transform (a)   
disp('Impulse Response of (a): ')
ir_1 = iztrans(z_1,z,n);                    % Impulse Response
disp(ir_1);

sz1 = z_1*(z/(z - 1));                      % For Step Response, Multiplying in Z domain
disp('Step Response of (a): ')
sr_1 = iztrans(sz1,z,n);                    % Step Response
disp(sr_1);

x = 1;                                      % Numerator Coefficients (Zeros)
y = [1,-0.75,0.125];                        % Denominator Coefficients (Poles)

figure;
zplane(x,y);                                
title('(A)');

% (b)

z_1 = 1/(1 - (z^(-1)));                             % Z-Transform of (b)   
disp('Impulse Response of (b): ')
ir_1 = iztrans(z_1,z,n);                            % Impulse Response
disp(ir_1);

sz1 = z_1*(z/(z - 1));                              % For Step Response, Multiplying in Z domain
disp('Step Response of (b): ')
sr_1 = iztrans(sz1,z,n);                            % Step Response
disp(sr_1);

x = 1;                                              % Numerator Coefficients (Zeros)
y = [1,-1];                                         % Denominator Coefficients (Poles)

figure;
zplane(x,y);                                
title('(B)');



% (c)

z_1 = (2 - (z^(-2)))/(1 - 0.7*(z^(-1)) + 0.1*z^(-2));   % Z-Transform of (c)   
disp('Impulse Response of (c): ')
ir_1 = iztrans(z_1,z,n);                                % Impulse Response
disp(ir_1);

sz1 = z_1*(z/(z - 1));                                  % For Step Response, Multiplying in Z domain
disp('Step Response of (c): ')
sr_1 = iztrans(sz1,z,n);                                % Step Response
disp(sr_1);

x = [2,0,-1];                                           % Numerator Coefficients (Zeros)
y = [1,-0.75,0.125];                                    % Denominator Coefficients (Poles)

figure;
zplane(x,y);                                
title('(C)');