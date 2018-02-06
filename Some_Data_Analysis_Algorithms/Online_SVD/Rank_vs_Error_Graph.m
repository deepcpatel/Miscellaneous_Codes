% Plot Graph of Rank vs. Error for the Online SVD, rank-r modifications

clc;
clear;

r = 50;

x_r = 1000;
x_c = 950;

X = randi(30,x_r,x_c);

[U, S, V] = svd(X,'econ'); % Economic SVD

o = 1;  % Intervals for considering Rank Update

error = zeros(1,r/o);
counter = 1;

for i = 1:o:r
   
    X_updated = [X zeros(x_r,i)];
    A = randi(30,x_r,i);
    B = [zeros(x_c,i) ; eye(i) ];
    
    X_updated = X_updated + A*B';
    
    [U_new, S_new, V_new] = Online_SVD(U,S,[V;zeros(i,size(V,2))],A,B);
    
    X_new = (U_new * S_new) * V_new';
    
    err = X_updated-X_new;
    err = err(:,x_c+1:end);
    [er_r, err_c] = size(err);
    
    error(1,counter) = sqrt(sum(sum(err.^2))/(er_r*err_c))/norm(X_new,'fro');
    counter = counter + 1;
    
end

plot(error);
title('Rank vs. Error for the Online SVD');
xlabel('Rank');
ylabel('Error / Data Frobenius Norm ');



