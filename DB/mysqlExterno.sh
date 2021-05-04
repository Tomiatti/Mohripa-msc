#!/bin/bash

mysql --host=localhost --user="root" -p  -e filename.sql

GRANT ALL PRIVILEGES ON *.* TO 'tomiatti'@'localhost' IDENTIFIED BY 'hulk7BRA=';

mysqldump -u root -e -B zabbixdb | gzip > /opt/zabbix34-$date.gz 2>> /scripts/export.log

GRANT SELECT ON *.* TO 'zabbix'@'localhost';
