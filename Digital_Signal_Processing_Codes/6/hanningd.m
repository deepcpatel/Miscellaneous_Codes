% Hanning Window

function y = hanningd(L)

    n = 1:1:L; 
    y = 0.5 - 0.5*cos(2*pi*n/L); 

end