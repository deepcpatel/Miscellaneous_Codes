clear;
clc;

x_r = 7;
x_c = 6;

X = randi(30,x_r,x_c);

[U, S, V] = svd(X,'econ'); % Economic SVD

X_updated = [X zeros(x_r,1)];
A = randi(30,x_r,1);
B = [zeros(x_c,1) ; eye(1) ];

X_updated = X_updated + A*B';

V = [V;zeros(1,size(V,2))];

disp(X_updated);

[m_u, n_u] = size(U);
[m_s, n_s] = size(S);
[m_v, n_v] = size(V);
[m_a, n_a] = size(A);
[m_b, n_b] = size(B);

m = m_u;    % Number of rows in X=U*S*V'
n = m_v;    % Number of columns in X
r = n_u;    % Rank of the SVD we are given ( r = n_u = n_v )
c = n_a;    % Number of columns in A and B

[Q,R] = qr([U,A]);

%Q,R

[m_q, n_q] = size(Q);
[m_r, n_r] = size(R);


if (n_q == r)
    P = [];
    Ra = [];
    dimRa = 0;
else
    P = Q(:, r+1:n_q);
    Ra = R(r+1:m_r,  r+1:n_r);              
    dimRa = m_r - r;
end

M = U'*A;

[Q,R] = qr([V,B]);

[m_q, n_q] = size(Q);
[m_r, n_r] = size(R);

if (n_q == r)
    Q = [];
    Rb = [];
    dimRb = 0;
else
    Q = Q(:, r+1:n_q); 
    Rb = R(r+1:end, r+1:end);
    dimRb = m_r - r;
end

N = V'*B;

Saug = [M; Ra] * [N; Rb]';
S = [S, zeros(r, dimRb); zeros(dimRa, r), zeros(dimRa, dimRb)] + Saug;
[U2,S2,V2] = svd(S,0);
U = [U,P]*U2;
S = S2;
V = [V,Q]*V2;

disp(U*S*V');


