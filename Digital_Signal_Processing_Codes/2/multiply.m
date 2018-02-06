% Signal Multiplication

function [x1, x2, mult, n] = multiply(x1, zero_ind_1, x2, zero_ind_2)

    len1 = length(x1);
    len2 = length(x2);

    if len1>len2
        x2 = [x2 zeros(1,(len1-len2))];
    elseif  len1<len2
        x1 = [x1 zeros(1,(len2-len1))];
    end    

    if zero_ind_1==zero_ind_2
        mult = x1.*x2;
        n = (1-zero_ind_1):1:(length(x1)-zero_ind_1);
    elseif zero_ind_1<zero_ind_2
        x1 = [zeros(1,(zero_ind_2-zero_ind_1)) x1];
        x2 = [x2 zeros(1,(zero_ind_2-zero_ind_1))];
        mult = x1.*x2;
        n = (1-zero_ind_2):1:(length(x2)-zero_ind_2);
    else        
        x1 = [x1 zeros(1,(zero_ind_1-zero_ind_2))];
        x2 = [zeros(1,(zero_ind_1-zero_ind_2)) x2];
        mult = x1.*x2;        
        n = (1-zero_ind_1):1:(length(x1)-zero_ind_1);
    end

end