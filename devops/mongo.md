# Mongo简易教程

## 安装部署

```
// On mac
brew install mongodb

// 安装完成后启动(--auth: 认证模式启动)
mongod --config /usr/local/etc/mongod.conf [--auth]

// 创建用户
> use admin
> db.createUser({user: "root", pwd: "root", roles: ['readWrite', 'dbAdmin']});


```