% 1D Convolution Function

function [y, n] = convi(x, n1, h, n2) 

    cx = size(x,2);
    ch = size(h,2);

    h = flip(h);
    
    y = zeros(1,cx+ch-1);
    
    beginh = ch;
    endh = ch;
    
    for i = 1:size(y,2)
        
        if i > cx
            
            endh = endh - 1;
            cntr = cx;
            
        else
           
            cntr = i;
        end

        for j = endh:-1:beginh
           
            y(1,i)= y(1,i) + x(1,cntr).*h(1,j);
            cntr = cntr - 1;
            
        end
        
        if beginh ~= 1
           
            beginh = beginh - 1;
        end
        
    end
    
    c = min(n2) + min(n1); 
    n = c:1:c+length(y)-1; 
end