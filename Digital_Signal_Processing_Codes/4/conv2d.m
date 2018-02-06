function y = conv2d(X,h)

    [rx, cx] = size(X);
    [rh, ch] = size(h);

    h = flip(h);
    
    y = zeros(rx+rh-1,cx+ch-1);
    
    beginh = rh;
    endh = rh;
    
    for i = 1:size(y,1)
        
        if i > rx
            
            endh = endh - 1;
            cntr = rx;
            
        else
           
            cntr = i;
        end

        for j = endh:-1:beginh
           
            y(i,:)= y(i,:) + convn(X(cntr,:),h(j,:));
            cntr = cntr - 1;
            
        end
        
        if beginh ~= 1
           
            beginh = beginh - 1;
        end
        
    end

end