% Incremental PCA
% Reference : A Novel Incremental Principal Component Analysis and Its Application for Face Recognition
% by Haitao Zhao, Pong Chi Yuen and James T. Kwok

clc;
clear;

load 'Test_1.mat';
k = 3;  % Specify the no. of Principal Components to be Taken

%--------------------------------------------------------------------------
% Step - 0

[r_o, c_o] = size(X_orig);
[r_n, c_n] = size(X_new);

%--------------------------------------------------------------------------
% Step - 1

X = [X_orig, X_new];    % Assuming Images are Stacked Column Wise

[r_x, c_x] = size(X);

mean = sum(X,1);
mean = mean/r_x;
X_norm = X - (mean'*ones(1,r_x))';

mean = sum(X_orig,1);
mean = mean/r_o;
Xo_norm = X_orig - (mean'*ones(1,r_o))';

mean = sum(X_new,1);
mean = mean/r_n;
Xn_norm = X_new - (mean'*ones(1,r_n))';

sigma1 = Xo_norm' * Xo_norm;   % Used Formula 2
sigma2 = Xo_norm' * Xn_norm;
sigma3 = Xn_norm' * Xn_norm;

r = size(sigma2,2);

%--------------------------------------------------------------------------  

[U,lambda] = eig(sigma1);   % As sigma1 and sigma are Positive Definite 
                            % Matrices, we would not get complex eigen
                            % values

lambda = diag(lambda);      
[lambda, I] = sort(lambda, 'descend');
U = U(:,I);
lambda = diag(lambda);

lambda = diag(lambda);       % Removing Eigenvalues <= 0
I = find((lambda>0.000001)); % Taking "l" eigen values
lambda = diag(lambda(I));
U = U(:,I);

[m, l] = size(U);            % m = dimensions

lambda_l = lambda;
U_l = U;

lambda = lambda_l(1:k,1:k);    % Taking First "k" Eigenvalues and Eigen Vectors
U = U_l(:,1:k);   

%--------------------------------------------------------------------------
% Step - 2

P = (lambda_l.^(1/2))*U_l';
P_1 = [eye(k); zeros(l-k,k)]*(lambda.^(1/2)) * U';  % Problem in Paper

%--------------------------------------------------------------------------
% Step - 3

temp = diag(lambda_l);
temp = (temp.^(-1/2));
temp = diag(temp);

Q_1 = (temp * U_l') * sigma2;

raw = (sigma3 - (Q_1' * Q_1));   % Here is the problem in formula for Q3 in Paper
[v, d] = eig(raw);

Q_3 = v*sqrt(d)*v';

final = [P, Q_1; zeros(size(Q_3,1),size(P,2)), Q_3]; % [P Q_1; Q_2 Q_3]

%--------------------------------------------------------------------------
% Step - 4

I_1 = eye(l+r);
I_1(1:k,1:k) = zeros;

[J,K] = qr(I_1*[Q_1;Q_3]);

%--------------------------------------------------------------------------
% Step - 5

tmp = [eye(k) zeros(k,l+r-k)]*[Q_1;Q_3];

matrix = [lambda^(1/2) tmp ; zeros(l+r,k) K];

[U_hat, lambda_hat, V_hat] = svd(matrix, 'econ');

%--------------------------------------------------------------------------
% Step -6  

tmp = [eye(k) ; zeros(l+r-k, k)];   % I think here is also the mistake in paper

U_new = [tmp J] * U_hat;

I = zeros(m+r,size(V_hat,1));
I(1:m,1:k) = U;
I(m+1:end,k+1:end) = eye(r);

V_new = I*V_hat;

y = (U_new*lambda_hat)*V_new';      % Final Matrix

%--------------------------------------------------------------------------
% Over
%--------------------------------------------------------------------------

% Testing

[U, d] = eig(X_norm*X_norm');
g = lambda_hat.^(2);

d = diag(d); 
[d, I] = sort(d, 'descend');
U = U(:,I);
d = diag(d);

tmp = (diag(lambda_hat)*ones(1,size(U,1)))';    % Eigenvalues Matrix

[T, r1] = eig(y'*y);

r1 = diag(r1);      
[r1, I] = sort(r1, 'descend');
T = T(:,I);
r1 = diag(r1);

disp('d:'); % Eigenvalue from Eigen decomposition of X*X'
disp(d);

disp('g:'); % Eigenvalues obtained from IPCA
disp(g);


% g and d are Same

disp('U:'); % Eigenvector from Eigen decomposition of X_norm*X_norm'
disp(U);

res = X_norm * V_new;

% Method (1)
% EV = (res)./tmp;  % Converting from principal components of X'*X to X*X'

% Method (2)
% EV = normc(res);  % Normalizing res such that ||res|| = 1
                    % Converting from principal components of X'*X to X*X'

EV = normc(res);    % Normalizing res such that ||res|| = 1

disp('Eigenvector of X*transpose(X) from IPCA:'); % Eigenvector from Eigen decomposition of X_norm'*X_norm
disp(EV);

% Stop
