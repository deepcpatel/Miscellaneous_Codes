% Unit Step Function

function u = U(v)

    u = length(v);

    for i = 1:u
       
        if v(i)<0
            u(i)=0;
        else
            u(i)=1;
        end
    end
end