% Unit Ramp Function

function u = Ur(v)

    u = length(v);

    for i = 1:u
       
        if v(i)<0
            u(i)=0;
        else
            u(i)=v(i);
        end
    end
end