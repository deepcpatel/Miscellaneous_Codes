% Use MATLAB to Plot poles and zeros of the Z-transform obtained for following signals.
% a. X(n) = ((1/2)^n) u(n) + ((-1/3)^n) u(n)
% b. X(n) = ((-1/3)^n) u(n) - ((1/2)^n) u(-n-1)
% c. X(n) = ((1/2)^n) u(-n)
% d. X(n) = {-1,0,-1,0,-1,0,-1,0,-1……}

clc;
clear;

% (a)
syms z n a;

f(n) = ((1/2)^n) + ((-1/3)^n);
X = collect(ztrans(f(n),n,z));
[n, d] = numden(X);
figure;
zplane(sym2poly(n),sym2poly(d));
title('A');

% (b)
syms z n a;

f(n) = ((-1/3)^n) - (2^n);
X = collect(ztrans(f(n),n,z));
[n, d] = numden(X);
figure;
zplane(sym2poly(n),sym2poly(d));
title('B');

% (c)
syms z n a;

f(n) = (2^(n+1));
X = collect(ztrans(f(n),n,z));
[n, d] = numden(X);
figure;
zplane(sym2poly(n),sym2poly(d));
title('C');

% (d)
syms z n a;

f(n) = mod(n,2) - 1;
X = collect(ztrans(f(n),n,z));
[n, d] = numden(X);
figure;
zplane(sym2poly(n),sym2poly(d));
title('D');