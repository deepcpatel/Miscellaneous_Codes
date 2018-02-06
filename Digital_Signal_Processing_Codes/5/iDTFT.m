% Inverse DTFT

function y = iDTFT(x,f)

    N = length(x);
    y = zeros(1,N);
   
    for m = 1:1:N
        for k = 1:1:length(f)
            
            y(1,k) = y(1,k) + (x(m)*exp(1i*2*pi*(m-1)*(f(k)/N)));
            
        end
    end
    
    y = y/N;
    
end