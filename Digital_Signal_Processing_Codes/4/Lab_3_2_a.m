% Application of 2D convolution on image processing applications
% (A).Take a standard test image “lenna.png” from shared folder. 
% Explore following commands and apply for given image.
% -> imread
% -> rgb2gray
% -> imshow

clc;
clear;

image = imread('lenna.png');
image = rgb2gray(image);

figure;
imshow(image);