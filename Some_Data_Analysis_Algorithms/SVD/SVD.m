%Compute SVD of a Matrix using Eigen Decomposition

clc;
clear;

A = [ 4 5 2 6 7 1 8 9 ;10 11 12 13 15 2 16 17 ];

T2 = A'*A;

[v, D] = eig(T2);

D = diag(D);    % Sorting the Eigenvalues
[D, i] = sort(D, 'descend');
v = v(:,i);
D = diag(D);

sigma = sqrt(D);

u = (A*v)*inv(sigma);  %Similar to (A*v)*inv(sigma)

[U, S, V] = svd(A);
