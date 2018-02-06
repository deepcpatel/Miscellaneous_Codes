% Circular Convolution

function y = circ_conv(x, h) 

    lenX = length(x); 
    lenH = length(h); 
    
    if lenX == lenH 
        
        y = zeros(1,lenX);
        h = flip(h);
        for i = 1:lenX 
            y(1,i) = sum(x.*h); 
            h = circshift(h,1,2);
        end
        
        y = circshift(y,length(y)-1,2);
       
    elseif lenX>lenH
        
        h = [h zeros(1,lenX-lenH)];
        
        y = zeros(1,lenX);
        h = flip(h);
        for i = 1:lenX 
            y(1,i) = sum(x.*h); 
            h = circshift(h,1,2);
        end
        
        y = circshift(y,length(y)-1,2);
        
    else
        
        x = [x zeros(1,lenH-lenX)];
        
        y = zeros(1,lenH);
        h = flip(h);
        for i = 1:lenH 
            y(1,i) = sum(x.*h); 
            h = circshift(h,1,2);
        end
        
        y = circshift(y,length(y)-1,2);
    end
end
