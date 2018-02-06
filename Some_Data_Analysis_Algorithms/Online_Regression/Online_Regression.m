%Online Regression

X=[ones(size(lpsa,1),1) lpsa];
y=lcavol;

A=(X'*X);
b=(X'*y);

beta=A\b;

figure(1);

plot(X(:,2),X*beta);
hold;
plot(X(:,2),y,'+');

X_new=[1 5];
y_new=0;

A=(A + X_new'*X_new);
b=(b + X_new'*y_new);

beta=A\b;

X=[X;X_new];
y=[y;y_new];


figure(2);

plot(X(:,2),X*beta);
hold;
plot(X(:,2),y,'+');

X_new=[1 3];
y_new=2;

A=(A + X_new'*X_new);
b=(b + X_new'*y_new);

beta=A\b;

X=[X;X_new];
y=[y;y_new];


figure(3);

plot(X(:,2),X*beta);
hold;
plot(X(:,2),y,'+');

X_new=[1 1];
y_new=5;

A=(A + X_new'*X_new);
b=(b + X_new'*y_new);

beta=A\b;

X=[X;X_new];
y=[y;y_new];


figure(4);

plot(X(:,2),X*beta);
hold;
plot(X(:,2),y,'+');

