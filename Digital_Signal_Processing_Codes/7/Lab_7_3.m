% Use MATLAB to obtain Symbolic Inverse Z-Transform of some basic signals.
% a. X(z) = ((1+3*(z^(-1)))/(1-3*(z^(-1))+2*(z^(-2))))
% b. X(z) = ((1+2*(z^(-1)))/(1+(z^(-2))))
% c. X(z) = ((1+2*(z^(-1))+(z^(-2)))/(1+4*(z^(-1))+4*(z^(-2)))))

% clc;
clear;

syms z n;

% (a)
X(z) = (1+3*z^(-1))/(1-3*z^(-1)+2*z^(-2));
out=iztrans(X, z, n);
disp('A:');
disp(out);

% (b)
X(z) = (1+2*z^(-1))/(1 + z^(-2));
out=iztrans(X, z, n);
disp('B:');
disp(out);

% (c)
X(z) = (1+2*z^(-1)+z^(-2))/(1+4*z^(-1)+4*z^(-2));
out=iztrans(X, z, n);
disp('C:');
disp(out);