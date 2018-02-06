% Use MATLAB to obtain Symbolic Z-Transform of some basic signals.
% a. X(n)= u(n)
% b. X(n)= nu(n)
% c. X(n) = (1+n) u(n)
% d. X(n) = cos(w0n)u(n)
% e. X(n) = sin(w0n)u(n)
% f. X(n) = (a^n)cos(w0n)u(n)
% g. X(n) = (a^n)sin(w0n)u(n)
% h. X(n) = n(a^n)u(n)
% i. X(n) = -n(a^n)u(-n-1)
% j. X(n) = n((-1)^n)u(n)
% k. X(n) = (n^2)u(n)

clc;
clear;

syms z n a w;
sympref('HeavisideAtOrigin','default');

% (a)
disp('A:');
out = ztrans(1,n,z);
disp(out);

% (b)
disp('B:');
f(n) = n;
ztrans(f(n),n,z)

% (c)
disp('C:');
f(n) = (1+n);
out = ztrans(f(n),n,z);
disp(out);

% (d)
disp('D:');
f(n) = cos(w*n);
out = ztrans(f(n),n,z);
disp(out);

% (e)
disp('E:');
f(n) = sin(w*n);
out = ztrans(f(n),n,z);
disp(out);

% (f)
disp('F:');
f(n) = (a^n)*cos(w*n);
out = ztrans(f(n),n,z);
disp(out);

% (g)
disp('G:');
f(n) = (a^n)*sin(w*n);
out = ztrans(f(n),n,z);
disp(out);

% (h)
disp('H:');
f(n) = n*(a^n);
out = ztrans(f(n),n,z);
disp(out);

% (i)
disp('I:');
f(n) = n*(a^-n);
out = ztrans(f(n),n,1/z);
disp(out);

% (j)
disp('J:');
f(n) =  n*(-1^n);
out = ztrans(f(n),n,z);
disp(out);

% (k)
disp('K:');
f(n) = n^2;
out = ztrans(f(n),n,z);
disp(out);