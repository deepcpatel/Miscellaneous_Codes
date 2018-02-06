% DTFT

function y = DTFT(x,f)

    N = length(x);
    y = zeros(1,N);
   
    for k = 1:1:length(f)
        for m = 1:1:N
            
            y(1,k) = y(1,k) + (x(m)*exp(-1i*2*pi*(m-1)*(f(k)/N)));
            
        end
    end
    
end