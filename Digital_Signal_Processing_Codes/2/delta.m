% Delta Function

function u = delta(v)

    u = length(v);

    for i = 1:u
       
        if v(i)==0
            u(i)=1;
        else
            u(i)=0;
        end
    end
end