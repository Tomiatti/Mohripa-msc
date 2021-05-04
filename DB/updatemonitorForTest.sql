INSERT INTO Monitor_tb (Hostname,ID_calc,ID_cpu,ID_mem,tool,Whenhappen) VALUES("cos01",0.0,0.0,0.0,"dstat","2020-01-01 14:39:37");
INSERT INTO Monitor_tb (Hostname,ID_calc,ID_cpu,ID_mem,tool,Whenhappen) VALUES("cos02",0.0,0.0,0.0,"dstat","2020-01-01 14:39:37");
INSERT INTO Monitor_tb (Hostname,ID_calc,ID_cpu,ID_mem,tool,Whenhappen) VALUES("cos03",0.0,0.0,0.0,"dstat","2020-01-01 14:39:37");
INSERT INTO Monitor_tb (Hostname,ID_calc,ID_cpu,ID_mem,tool,Whenhappen) VALUES("cos04",0.0,0.0,0.0,"dstat","2020-01-01 14:39:37");

update Monitor_tb set ID_calc = 0.1,ID_cpu = 0.4,ID_mem= 0.6, Whenhappen="2020-01-01 14:39:37" where  Hostname = "cos01";
update Monitor_tb set ID_calc = 0.2,ID_cpu = 0.5,ID_mem= 0.5, Whenhappen="2020-01-01 14:39:37" where  Hostname = "cos02";
update Monitor_tb set ID_calc = 0.3,ID_cpu = 0.6,ID_mem= 0.4, Whenhappen="2020-01-01 14:39:37" where  Hostname = "cos03";
update Monitor_tb set ID_calc = 0.4,ID_cpu = 0.7,ID_mem= 0.3, Whenhappen="2020-01-01 14:39:37" where  Hostname = "cos04";