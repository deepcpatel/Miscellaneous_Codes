% Linear Discriminant Analysis

clc;
clear;

load 'fisheriris';

% Preprocessing Data
% Data Stacked Row Wise

class = 3;
q = 2; % Take first q eigenvectors as Linear Discriminants

X = meas;
y = zeros(size(species,1),1);

for i = 1:size(species,1)
    
    if strcmp(species(i),'setosa')
        y(i) = 1;
    elseif strcmp(species(i),'versicolor')
        y(i) = 2;
    else
        y(i) = 3;
    end  
end

class_mean = zeros(class,size(X,2));    % Dimensions : class x parameters
global_mean = sum(X,1)/size(X,1);
size_class = zeros(class,1);

% Finding mean of data for each class

for i = 1:class
    
    m = X(y == i,:);
    size_class(i,1) = size(m,1);
    class_mean(i,:) = sum(m,1)/size_class(i,1);
end

Sw = zeros(size(X,2));  % Within Class Scatter Matrix
Sb = Sw;                % Between Class Scatter Matrix

for i = 1:class
    
   m = X(y == i,:);
   
   for j = 1:size(m,1)
      
       Sw = Sw + (m(j,:) - class_mean(i,:))'*(m(j,:) - class_mean(i,:)); % Data Stacked Row Wise
   end
end

for i = 1:class
    
   Sb = Sb + (size_class(i,1)*((class_mean(i,:) - global_mean)'*(class_mean(i,:) - global_mean)));
end

D = Sb*pinv(Sw); % Sb*inv(Sw)

[U,lambda] = eig(D);    
lambda = diag(lambda);
[lambda, I] = sort(lambda, 'descend');
U = U(:,I);
lambda = diag(lambda);

U_1 = U(:,1:q);

New_X = X*U_1;

figure;
hold on;

scatter(New_X(y == 1,1),New_X(y == 1,2),'r','o');
scatter(New_X(y == 2,1),New_X(y == 2,2),'g','x');
scatter(New_X(y == 3,1),New_X(y == 3,2),'b','+');
title('LDA Projection of Iris Dataset');

legend('Setosa', 'Versicolor', 'Virginica');