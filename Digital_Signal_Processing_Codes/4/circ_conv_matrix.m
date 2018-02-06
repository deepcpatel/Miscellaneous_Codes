% Circular Convolution using Matrix Method

function y = circ_conv_matrix(x, h) 

    lenX = length(x); 
    lenH = length(h); 
    
    if lenX == lenH 
        
        x = [x(1,1) flip(x(1,2:end))];
        
        c = zeros(lenX,lenX);
        
        for i = 1:lenX 
            c(i,:) = x; 
            x = circshift(x,1,2);
        end
        
        % disp(c);
        
        y = c*h';
        y = y';
       
    elseif lenX>lenH
        
        h = [h zeros(1,lenX-lenH)];
        
        x = [x(1,1) flip(x(1,2:end))];
        
        c = zeros(lenX,lenX);
        
        for i = 1:lenX 
            c(i,:) = x; 
            x = circshift(x,1,2);
        end
        
        % disp(c);
        
        y = c*h';
        y = y';
        
    else
        
        x = [x zeros(1,lenH-lenX)];
        
        x = [x(1,1) flip(x(1,2:end))];
        
        c = zeros(lenX,lenX);
        
        for i = 1:lenX 
            c(i,:) = x; 
            x = circshift(x,1,2);
        end
        
        % disp(c);
        
        y = c*h';
        y = y';
    end
end
