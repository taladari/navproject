figure%10.84
y=simout.time
x=simout.data
subplot(2,1,2)

plot(y,x)
title('k=10.84','FontSize',18)
xlabel('Time(s)')
ylabel('Data')
%7.84
y1=simout1.time
x1=simout1.data
subplot(2,1,1)
plot(y1,x1)
title('k=7.84','FontSize',18)

xlabel('Time(s)')
ylabel('Data')