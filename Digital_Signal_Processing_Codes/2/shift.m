% Time Shift Function

function [n,Y] = shift(x,index_zero,sample,shifttype)

    Y = x;

    if strcmp(shifttype,'advance')==1
       n = (1-index_zero-sample):1:(length(Y)-index_zero-sample);
    elseif strcmp(shifttype,'delay')==1
       n = (1-index_zero+sample):1:(length(Y)-index_zero+sample);
    else
       disp('Error in Shift Type') 
    end    

end




