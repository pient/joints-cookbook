# Mongo简易教程

## 安装部署

#### Red Hat

yum 安装：

新建文件 /etc/yum.repos.d/mongodb-org-3.4.repo

内容如下
```
[mongodb-org-3.4]
name=MongoDB Repository
baseurl=https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/3.4/x86_64/
gpgcheck=1
enabled=1
gpgkey=https://www.mongodb.org/static/pgp/server-3.4.asc

```

执行yum命令
```
sudo yum install -y mongodb-org
```

