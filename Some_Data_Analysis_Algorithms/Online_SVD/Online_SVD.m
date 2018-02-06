% Name: Deep C. Patel
% Roll: 1401010

% U, S, V are calculated from X as "[U,S,V] = svd(X,'econ');" which is
% Economic SVD as Stated in the Paper by Brand
% It is rank - k update

function [u_new,s_new,v_new] = Online_SVD(U,S,V,A,B)

    [u_r,u_c] = size(U);
    [s_r,s_c] = size(S);
    [v_r,v_c] = size(V);
    [a_r,a_c] = size(A);
    
    % Let U*S*V' = X
    
    m = u_r;    % No. of rows in X
	n = v_c;    % No. of columns in X
	r = u_c;    % Rank of X
	c = a_c;    % Rank of A and B
    
    [Q_1,R_1] = qr([U A]);
    
    [q_1_r, q_1_c] = size(Q_1); % Q_1 is Orthonormal bases matrix for column space of [U A]
    
    if q_1_c == u_c

        p = []; % A is within column space of U so no Orthogonal Subspace to U
        ra = []; % [U'A]
    else
        p = Q_1(:,r+1:end);
        ra = R_1(r+1:end,r+1:end); % [U'A ; ra]
    end
    
    temp_a = U'*A;
    % temp_a = R_1(1:r,r+1:r+c);    % Produces Error. So instead using temp_a = U'*A;
    % Though this is computationally expensive
    
    [Q_2,R_2] = qr([V B]);
    
    [q_2_r, q_2_c] = size(Q_2); % Q_2 is Orthonormal bases matrix for column space of [V B]
    
    if q_2_c == v_c

        q = []; % B is within column space of V so no Orthogonal Subspace to V
        rb = []; % [V'B]
    else
        q = Q_2(:,r+1:end);
        rb = R_2(r+1:end,r+1:end); % [V'B ; rb]
    end 
    
    temp_b = V'*B;
    % temp_b = R_2(1:r,r+1:end);    % Produces Error. So instead using temp_b = V'*B;
    % Though this is computationally expensive
    
    m = [temp_a;ra]*[temp_b;rb]';
    
    k = [S zeros(s_r,size(m,2)-s_c);zeros(size(m,1)-s_r,size(m,2))] + m;
    
    [u_k,s_k,v_k] = svd(k,'econ');
    
    u_new = [U p]*u_k;
    s_new = s_k;
    v_new = [V q]*v_k;
    
end