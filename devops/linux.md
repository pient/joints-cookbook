# Linux简易教程

## 介绍

Joints Kitchen用于构建支持Joints开发与部署的私有云平台

linux为Joints运行环境（当前linux全部为centos）


## 常用

### 基础配置

- yum (CentOs中前端软件包管理器)

```

// 安装
yum install

// 安装包
yum install package1

// 安装程序组
yum groupinstall group1

// 更新所有软件包
yum update

// 删除包
yum remove package1
yum groupremove group1

// 查看依赖
yum deplist package1

// 清除缓存
yum clean
  
// 其他命令
yum info package1
yum list
yum list package1
yum groupinfo group1

```

### 磁盘管理

- du

```

// 查看当前目录大小
du -h -d 0 .


```


### 网络命令

- net-tools

```
// net-tools包含如下软件包:

 - arp用来操作核心的ARP（地址解析协议）的高速缓存，通常用来增加、删除一个条目以及转储ARP高速缓存。

 - dnsdomainname显示系统的DNS域名。

 - domainname显示系统的 NIS/YP 域名。

 - hostname用来设置或显示系统的主机名。

 - ifconfig 用来配置网络接口。

 - nameif基于MAC地址给网络界面命名。

 - netstat可以显示网络连接、路由列表、界面状态、虚拟连接等信息。

 - nisdomainname 同domainname。

 - plipconfig 用来优化PLIP设备的参数以加快该设备的速度。

 - rarp 和arp命令类似，处理操作系统的RARP（逆向地址解析协议）表。

 - route 用来管理IP路由表。

 - slattach 将某个网络接口对应为串行线，例如将一个通常的终端线添加为某种网络模。

 - ypdomainname同domainname.


```

- ifconfig

```

// 查看ifconfig所在包
yum provides ifconfig

// 安装ifconfig
yum install nettools

```

- ssh

```

// 安装openssh server
yum install openssh-server

// 去掉PAM验证
修改/etc/ssh/sshd_config文件，将UsePAM参数设置为“no”

// 启动sshd服务
/usr/sbin/sshd start



```

- nc (发送tcp/udp包)

```

// 安装nc
yum install nc


```

- 其他常用命令

```
top // eg. top -bnc 1
nslookup  // 查询域名对应ip或相反
route     // 管理系统路由
traceroute // 跟踪路由(当ping不通时，追踪原因)
rcp       // 远程文件拷贝
finger    // 查询登录记录


```

- 网络配置文档

```
- /etc/hosts
DNS解析

- /etc/host.conf
指定域名解析顺序

- /etc/resolv.conf
存放DNS服务器ip地址

- /etc/services
用语定义现有网络服务，一般无需修改此文件

- /etc/xinetd.d目录
Linux中大部分网络服务是由一个的超级服务程序inetd启动（如：chargen, echo, finger, talk, telnet, wu-ftpd等）
CentOs 7.0后这些网络服务的配置信息就在这个文件夹下 修改完配置后需要执行：

/etc/rc.d/init.d/xinetd restart生效
或者
killall -HUP xinetd
/etc/rc.d/init.d/network start
/etc/rc.d/init.d/network stop

```

- 用户及组管理

```

// 用户管理

who // 查看当前用户
w // 查看本机当前用户信息信息

// 其他用户查看命令
users
id -un // 获取当前登入用户名称
whoami // 等同于id -un

useradd
adduser
passwd // 设置密码
usermod // 修改用户信息，如登录名，home目录等
pwcov // 从/etc/passwd同步用户至/etc/shadow
pwck // 校验用户配置是否合法
pwunconv // pwcov的反向操作


// 组管理

groups // 查看当前登录用户的组内成员
groups gliethttp // 查看gliethttp用户所在的组,以及组内成员
groupadd
groupdel
groupmod
grpck grpconv
grpunconv


// 相关配置文件
/etc/group // 组配置文件
/etc/gshadow // 组影子配置文件
/etc/passwd // 用户配置文件
/etc/shadow // 用户影子口令文件
/etc/skel // 启动文件目录

```
