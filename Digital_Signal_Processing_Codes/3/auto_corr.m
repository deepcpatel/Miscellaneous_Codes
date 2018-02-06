%Auto Correlation Function

function y = auto_corr(x,n1)

    lenX = length(x);
    lenH = lenX;
    h = x;
    y = zeros(1,lenH+lenX-1);
    
    h = [zeros(1,lenX) h zeros(1,lenX-1)];
    newlenH = length(h);
    
    m = lenH+lenX;
    i=1;
    
    while m ~= 1 
        y(1,i) = sum(x.*h(1,m:newlenH-(i-1)));
        m = m-1;
        i = i+1;
    end
    
end