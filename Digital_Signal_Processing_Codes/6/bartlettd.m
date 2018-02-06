% Bartlett Window

function y = bartlettd(L)

    n = 1:1:L;
    y = 1 - 2*abs(n - (L/2))/L; 

end