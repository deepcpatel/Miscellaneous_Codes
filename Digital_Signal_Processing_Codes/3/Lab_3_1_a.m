% Write Convolution Function using built in convolution

clc;
clear;

x1 = [1,2,2,1];
h1 = [1,-1,2];

n1_1 = [-1 0 1 2];
n2_1 = [-2 -1 0];

y1 = convn(x1,h1);

fprintf('Y1 = ');
disp(y1);

x2 = [-2,0,1,-1,3];
h2 = [1,2,0,-1];

n1_2 = [-3 -2 -1 0 1];
n2_2 = [-1 0 1 2];

y2 = convn(x2,h2);

fprintf('Y2 = ');
disp(y2);

x3 = [1,2,3,1];
h3 = [1,2,1,-1];

n1_3 = [-3 -2 -1 0];
n2_3 = [0 1 2 3];

y3 = convn(x3,h3);

fprintf('Y3 = ');
disp(y3);

x4 = [9,1,5,4];
h4 = [0,2,2];

n1_4 = [0 1 2 3];
n2_4 = [-1 0 1];

y4 = convn(x4,h4);

fprintf('Y4 = ');
disp(y4);