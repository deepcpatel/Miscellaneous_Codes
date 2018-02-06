%Linear Mean Square Algorithm (LMS Algorithm)

function [h,Y,E] = LMS(x,d,delta,N)

M=length(x);
Y=zeros(1,M);
h=zeros(1,N);
E=zeros(1,M);

for n=N:M
   
    x1=x(n:-1:n-N+1);
    Y(n)=h*x1';
    e=d(n)-Y(n);
    h=h+(delta*e*x1);
    E(n)=e;
    
end

end