% Application of 2D convolution on image processing applications
% (B). Now in order to perform 2D convolution, Given image becomes first 
% input as matrix and second input will be a sets of kernel matrix 
% performing different operations on image which are mentioned below


clc;
clear;

I = imread('lenna.png');
I_gray = rgb2gray(I);
image = double(I_gray);

average = [1/9 1/9 1/9;...
           1/9 1/9 1/9;...
           1/9 1/9 1/9];
       
sharp = [0 -1 0;...
         -1 5 -1;...
         0 -1 0];
     
edge_detection = [0 -1 0;...
                  -1 4 -1;...
                  0 -1 0];
              
edge_detection_horizontal = [0 0 0;...
                             -1 2 -1;...
                             0 0 0];

edge_detection_vertical = [0 -1 0;...
                           0 2 0;...
                           0 -1 0];
                       
gradient_horizontal = [-1 -1 -1;...
                       0 0 0;...
                       1 1 1];
                   
gradient_vertical = [-1 0 1;...
                     -1 0 1;...
                     -1 0 1];
                 
sobel_horizontal = [1 2 1;...
                       0 0 0;...
                       -1 -2 -1];
                   
sobel_vertical = [1 0 -1;...
                     2 0 -2;...
                     1 0 -1];
                 
                 

image_average = conv2d(image,average);
image_sharp = conv2d(image,sharp);
image_edge_detection_horiz = conv2d(image,edge_detection_horizontal);
image_edge_detection_vert = conv2d(image,edge_detection_vertical);
image_edge_detection = conv2d(image,edge_detection);
image_gradient_vert = conv2d(image,gradient_vertical);
image_gradient_horiz = conv2d(image,gradient_horizontal);
image_sobel_horiz = conv2d(image,sobel_horizontal);
image_sobel_vert = conv2d(image,sobel_vertical);



figure;

subplot(4,3,1);
imshow(I);
title('Original');

subplot(4,3,2);
imshow(int8(image_average));
title('Average Image');

subplot(4,3,3);
imshow(int8(image_sharp));
title('Sharpen Image');

subplot(4,3,4);
imshow(int8(image_edge_detection_horiz));
title('Hori Edge Image');

subplot(4,3,5);
imshow(int8(image_edge_detection_vert));
title('Vert Edge Image');

subplot(4,3,6);
imshow(int8(image_edge_detection));
title('Edge Image');

subplot(4,3,7);
imshow(int8(image_gradient_vert));
title('Vert Grad Image');

subplot(4,3,8);
imshow(int8(image_gradient_horiz));
title('Horiz Grad Image');

subplot(4,3,9);
imshow(int8(image_sobel_horiz));
title('Horiz Sobel Image');

subplot(4,3,10);
imshow(int8(image_sobel_vert));
title('Vert Sobel Image');
