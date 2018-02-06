% Hamming Window

function y = hammingd(L)

    n = 1:1:L; 
    y = 0.54 - 0.46*cos(2*pi*n/L); 

end