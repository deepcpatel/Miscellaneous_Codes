% Convolution function returning Index of Y, using inbuilt convolution
% function

function [y, n] = convn(x, h, n1, n2)

    y = conv(x,h,'full');
    
    c = min(n2) + min(n1);
    
    n = c:1:c+length(y)-1;
    
end