function [n,Y] = signal_folding(x,index_zero)

    Y = fliplr(x);
    index_zero = length(x)-index_zero+1;
    n = (1-index_zero):1:(length(x)-index_zero);

end