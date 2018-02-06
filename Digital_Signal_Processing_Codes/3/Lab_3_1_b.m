% Write Convolution Function using custom convolution

clc;
clear;

x1 = [1,2,2,1];
h1 = [1,-1,2];

n1_1 = [-1 0 1 2];
n2_1 = [-2 -1 0];

[y1, n1] = convi(x1,h1,n1_1,n2_1);

fprintf('Y1 = ');
disp(y1);
fprintf('n1 = ');
disp(n1);

x2 = [-2,0,1,-1,3];
h2 = [1,2,0,-1];

n1_2 = [-3 -2 -1 0 1];
n2_2 = [-1 0 1 2];

[y2, n2] = convi(x2,h2,n1_2,n2_2);

fprintf('Y2 = ');
disp(y2);
fprintf('n2 = ');
disp(n2);

x3 = [1,2,3,1];
h3 = [1,2,1,-1];

n1_3 = [-3 -2 -1 0];
n2_3 = [0 1 2 3];

[y3, n3] = convi(x3,h3,n1_3,n2_3);

fprintf('Y3 = ');
disp(y3);
fprintf('n3 = ');
disp(n3);

x4 = [9,1,5,4];
h4 = [0,2,2];

n1_4 = [0 1 2 3];
n2_4 = [-1 0 1];

[y4, n4] = convi(x4,h4,n1_4,n2_4);

fprintf('Y4 = ');
disp(y4);
fprintf('n4 = ');
disp(n4);
