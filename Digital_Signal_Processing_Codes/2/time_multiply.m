function [n,Y] = time_multiply(x,index_zero)

    n = (1-index_zero):1:(length(x)-index_zero);
    Y = n.*x;
    
end