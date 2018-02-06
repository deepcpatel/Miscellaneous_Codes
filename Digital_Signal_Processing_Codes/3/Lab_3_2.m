% Find the linear convolution for following infinite length sequences and Plot required outputs.

clc;
clear;

xs = input('Start Index of X:');
hs = input('Last Index of X:');
xl = input('Start Index of h:');
hl = input('Last Index of h:');

n1 = xs:1:1;

n2 = xl:1:hl;

lengthn1 = length(n1);

lengthn2 = length(n2);

ones1 = ones(1,lengthn1);

ones2 = ones(1,lengthn2);

for i=1:lengthn1
    if(n1(i)<0)
        ones1(i) = 0;
    end
end

for i=1:lengthn2
    if(n2(i)<0)
        ones2(i) = 0;
    end
end

[y,n] = convi(ones1,ones2,n1,n2);
subplot(3,1,1);
stem(n,y);
title('u(n)*u(n)');

for i=1:lengthn1
    if(n1(i)<0)
        ones1(i) = 0;
    end
    ones1(i) = ones1(i)*cos(n1(i)*pi);
end

for i=1:lengthn2
    if(n2(i)<0)
        ones2(i) = 0;
    end
end

[y,n] = convi(ones1,ones2,n1,n2);
subplot(3,1,2);
stem(n,y);
title('cos(n*pi).u(n) * u(n)');

for i=1:lengthn1
    if(n1(i)<0)
        ones1(i) = 0;
    end
    ones1(i) = ones1(i)*n1(i);
end

for i=1:lengthn2
    if(n2(i)<0)
        ones2(i) = 0;
    end
    ones2(i) = (6+n(i))*ones2(i);
end

[y,n] = convi(ones1,ones2,n1,n2);
subplot(3,1,3);
stem(n,y);
title('n.u(n) * (6+n).u(n)');

