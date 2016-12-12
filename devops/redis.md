# Redis简易教程

## 安装部署

### CentOS 7 / RHEL 7
#### 使用yum安装

这种安装方法需要首先，安装EPEL repo
```
// 先安装wget
yum install wget

// 安装EPEL repo
wget -r --no-parent -A 'epel-release-*.rpm' http://dl.fedoraproject.org/pub/epel/7/x86_64/e/

rpm -Uvh dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-*.rpm

// 应当有epel.repo, epel-testing.repo
ls -l /etc/yum.repos.d/

// 安装redis
yum install redis

// 启动redis
systemctl start redis.service

// 检查状态
systemctl status redis.service

// 继续检查
redis-cli ping

// 系统启动时启动/不启动redis server
systemctl enable/disable redis.service

```


#### 下载安装

下载安装包进行安装，redis最新版网址 （http://download.redis.io/redis-stable.tar.gz）
```
wget http://download.redis.io/redis-stable.tar.gz
tar xzvf redis-stable.tar.gz
cd redis

make 

make install

```

## 配置

如果用yum 安装，则配置文件保存在文件/etc/redis.conf中


```
// 修改访问地址
bind localhost


// 设置密码, 去掉requiriepass, 后段则为redis密码
#requirepass foobared

#为public域开放tcp协议的6379端口
firewall-cmd --zone=public --add-port=6379/tcp --permanent

#为public域添加http服务
firewall-cmd --zone=public --add-service=http --permanent

#重启firewall服务
firewall-cmd --reload

```

