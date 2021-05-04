select * from TimerMethod_tb where WhichMethod="RequestDirectInternal";

truncate table LogTimer_tb;

SET GLOBAL max_connections = 200000;



use logserver;


truncate table LogRequest_tb ;
truncate table LogResponse_tb ;
truncate table LogAlocator_tb ;
truncate table LogApp_tb ;
truncate table LogTransportador_tb ;









select * from LogRequest_tb;

select * from LogResponse_tb;

select * from LogAlocator_tb;

select * from  LogTransportador_tb;

select * from LogApp_tb;



















select WhichModule,TookTime,Whenfinish from LogTimer_tb where WhichModule="Broker-Internal-alocate";

SELECT idTimerClass_tb,SUM(TookTime) AS total_response
    FROM (SELECT idTimerClass_tb,TookTime FROM LogRequest_tb
          UNION ALL
          SELECT idTimerClass_tb,TookTime FROM LogResponse_tb
          UNION ALL
          SELECT idTimerClass_tb,TookTime FROM LogApp_tb) t GROUP BY idTimerClass_tb;
          
          
          SELECT idTimerClass_tb,SUM(TookTime) AS BrokerToGER
    FROM (SELECT idTimerClass_tb,TookTime FROM LogRequest_tb
          UNION ALL
          SELECT idTimerClass_tb,TookTime FROM LogResponse_tb) t GROUP BY idTimerClass_tb;

select WhichModule,TookTime.a,Whenfinish from LogRequest_tb 
inner join LogResponse_tb on WhichModule,TookTime.b,Whenfinish 
inner join LogApp_tb on WhichModule,TookTime.c,Whenfinish;
# sum (TookTime.a,TookTime.b,TookTime.c);



















