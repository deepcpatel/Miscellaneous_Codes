% 1D Convolution Function

function [y, n] = convi(x, n1, h, n2) 

    lenX = length(x); 
    lenH = length(h); 
    
    h = flip(h); 
    
    y = zeros(1,lenH+lenX-1); 
    
    h = [zeros(1,lenX) h zeros(1,lenX-1)]; 
    newlenH = length(h); 
    
    m = lenH+lenX; 
    i=1; 
    
    while m ~= 1 
        y(1,i) = sum(x.*h(1,m:newlenH-(i-1))); 
        
        m = m-1;
        i = i+1; 
    end
    
    c = min(n2) + min(n1); 
    n = c:1:c+length(y)-1; 
end