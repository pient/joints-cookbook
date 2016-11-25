# MySQL简易教程


## 安装部署

```

// 下载并安装mysql
wget http://dev.mysql.com/get/mysql-community-release-el7-5.noarch.rpm
rpm -ivh mysql-community-release-el7-5.noarch.rpm
yum install mysql-community-server

// 重启MySQL
service mysqld restart

// 客户端登录
mysql -uusername -p

// 显示所有配置变量
show variables;

// 显示运行状态
show global status;

// 打开防火墙端口
sudo firewall-cmd --zone=public --add-port=3306/tcp


```

## mysql配置文件
配置文件位置: /etc/my.cnf

```


// mysql 日志相关配置
explicit_defaults_for_timestamp=1
log-queries-not-using-indexes

log_error               =../log/mysql_error.log

general_log             =1
general_log_file        =../log/mysql.log

slow_query_log          =1
slow_query_log_file     =../log/mysql_slow.log
long_query_time         =2


```

## 用户及权限管理
```
// 创建数据库
CREATE DATABASE <dbname> CHARACTER SET utf8 COLLATE utf8_bin;

// 对数据库授权
GRANT ALL PRIVILEGES ON <dbname>.* TO '<username>'@'%' IDENTIFIED BY '<password>';
FLUSH PRIVILEGES;
QUIT;

```

## 备份还原
```
// mysqldump基本语法
mysqldump -u <username> -p <dbname> <table1> <table2> ... > dbbackup.sql

// 数据还原
mysql -u root -p <dbname> < dbbackup.sql

// 目录备份(还原时直接复制目录)
mysqlhotcopy [option] <dbname1> <dbname2> backupDir/



```
