% Custom 2D Convolution Function 

function Y = conv2d(X,h)

    [row_X, column_X] = size(X);
    [row_h, column_h] = size(h);
    
    n1 = 0:1:column_X;
    n2 = 0:1:column_h;
    
    row_Y = row_X + row_h - 1;
    column_Y = column_X + column_h - 1;
    
    Y = zeros(row_Y, column_Y);
    
    % Flipping and Padding h
    
    h = flip(h);
    
    h = [zeros(row_X-1,column_h);h];
    new_r_h = size(h,1);
    
    i=0;
    
    while i ~= column_Y
        
        if(i >= row_X)
            k = row_X - 1;
            new_r_h = new_r_h - 1;
        else
            k = i;
        end
        
        j = new_r_h;
        
        for n = k+1:-1:1
            
            Y(i+1,:) = Y(i+1,:) + convn(X(n,:),h(j,:));
            j = j - 1;
            
        end
        
        i = i + 1;

    end
end
