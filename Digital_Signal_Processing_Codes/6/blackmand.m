% Blackman Window

function y = blackmand(L)

    n = 1:1:L;
    y = 0.42 - 0.5*cos(2*pi*n/L) + 0.08*cos(4*pi*n/L); 

end