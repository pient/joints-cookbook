# Linux简易教程

## 介绍

Joints Kitchen用于构建支持Joints开发与部署的私有云平台

linux为Joints运行环境（当前linux全部为centos）


## 常用

### 查看系统信息
```
// 查看CentOs版本
lsb_release -a

// 安装lsb_release
yum install lsb -y

cat /etc/redhat-release

rpm -q centos-release

// 查看cpu信息
cat /proc/cpuinfo

// 查看内存信息
free -m

// 查看磁盘信息
df -h
fdisk -l
cat /proc/partitions

// 查看网卡信息
dmesg | grep eth0
ifcfg -eth0
ethtool // 并非所有网卡支持此命令

// 查看网关
route |grep default

// 查看linux端口
netstat -lntp #查看监听(Listen)的端口
netstat -antp #查看所有建立的TCP连接

// 查看开启的服务
chkconfig --list

// 查看DNS
cat /etc/resolv.conf

// 查看内存信息
sed -n '/MemTotal\|MemFree/p' /proc/meminfo

// 查看语言字符集
echo $LANG $LANGUAGE

// 查看服务器上面所有用户
cat /etc/passwd|awk -F: '{print $1}'

```


### 磁盘管理

```

// 查看当前目录大小
du -h -d 0 .

// 查看文件大小
df -h

// 硬链接
ln <source-path> <link-path>

// 软链接
ln -s <source-path> <link-path>

// 删除软链接
rm -rf <link-path>

// 查找文件, eg: find / -name '*.log'
find <path> <options> <target-text>

```


### 命令执行
```
// 不挂断执行命令 
nohup <command> <arge> <&>

// eg.
nohup /root/net_speeder venet0 "ip" >/dev/null 2>&1 &

// 查看正在执行的命令
jobs

// 关闭命令
fg %n

```


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

// 列出所有已安装的软件包
yum list installed
  
// 其他命令
yum info package1
yum list
yum list package1
yum groupinfo group1

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
 eg. $ netstat -tunlp |grep  18080

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

// 生成本机公钥
ssh-keygen

// 添加ssh公钥访问
mkdir ~/.ssh    #如果当前用户目录下没有 .ssh 目录，请先创建目录
chmod 700 ~/.ssh
cd ~/.ssh
touch authorized_keys
chmod 600 authorized_keys
// 复制公钥至authorized_keys文件

// 把公钥复制到远程机器
ssh-copy-id -i ~/.ssh/id_rsa.pub $user@$ip

// ssh远程执行命令
ssh -p $port $user@$ip 'cmd'

```

- nc (发送tcp/udp包)

```

// 安装nc
yum install nc


```

- 防火墙

最新版Linux
```
// 关闭防火墙
sudo systemctl stop firewalld.service

// 开启防火墙
sudo systemctl start firewalld.service

// 禁用防火墙
sudo systemctl disable firewalld.service

// 启用防火墙
sudo systemctl enable firewalld.service

// 查看防火墙状态
firewall-cmd --state

// 重新加载防火墙
firewall-cmd --reload

// 获取防火墙区域
firewall-cmd --get-zones

// 获取防火墙支持服务
firewall-cmd --get-services

// 打开防火墙端口
sudo firewall-cmd --zone=public --add-port=<port>/tcp


```

老版Linux(iptables)

```
// 查看当前端口情况
iptables -L -n

// 清除预设表filter中的所有规则链的规则
iptables -F

// 清除预设表filter中使用者自定链中的规则
iptables -X

// 保存配置信息
/etc/rc.d/init.d/iptables save

// 重启服务
service iptables restart

// 开启80端口
iptables -A INPUT -p tcp --dport 80 -j ACCEPT

```

- scp

```
// 查看服务器日志：
ssh -p 1224 guest@192.168.2.120

// 从服务器上下载文件
scp username@servername:/path/filename /var/www/local_dir（本地目录）

// 上传本地文件到服务器
scp /path/filename username@servername:/path

// 从服务器下载整个目录
scp -r username@servername:/var/www/remote_dir/（远程目录） /var/www/local_dir（本地目录）

// 上传目录到服务器
scp  -r local_dir username@servername:remote_dir
```

- curl
```
```

- wget
```
// 通过Active Directory验证并访问
wget --http-user='jspdi\600841' --http-passwd=password http://172.17.16.109/default.asp

```

- tar

```
// 仅打包，不压缩！
tar -cvf /tmp/etc.tar /etc

// 打包后，以 gzip 压缩
tar -zcvf /tmp/etc.tar.gz /etc

// 打包后，以 bzip2 压缩
tar -jcvf /tmp/etc.tar.bz2 /etc

// 查阅上述 /tmp/etc.tar.gz 文件内有哪些文件
tar -ztvf /tmp/etc.tar.gz

// 解压到当前目录
tar -zxvf /tmp/etc.tar.gz

// 解压压缩文件内的etc/passwd目录至当前目录
tar -zxvf /tmp/etc.tar.gz etc/passwd

// 解压压缩文件内的etc目录至当前目录并保留其权限
tar -zxvpf /tmp/etc.tar.gz /etc

```

- grep

```

// 多个文件查询
grep "sort" *.doc

// 输出文档中含有48字符的行数
grep -c "48" data.doc   

// 显示所有匹配48的行和行号
grep -n "48" data.doc

// 输出所有不包含48的行   
grep -vn "48" data.doc      

// 输出所有含有ab或Ab的字符串的行  
grep -i "ab" data.doc

// 文件查找
grep -n -A 20 -B 20 <target-text> <file-name>


```

- 其他常用命令

```

pgrep -l <porc-name> // 查看进程id
kill -s USR1 <pid> // 发送USR1信号

uname -r // 查看linux内核版本

top // eg. top -bnc 1
nslookup  // 查询域名对应ip或相反
route     // 管理系统路由
traceroute // 跟踪路由(当ping不通时，追踪原因)
rcp       // 远程文件拷贝
finger    // 查询登录记录

// 文件查看
tail -f <log-file>
tail -n <row-number> <log-file>

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
cat /etc/group // 查看所有用户及组

// 重设root密码
sudo passwd root

useradd
adduser
passwd // 设置密码
usermod // 修改用户信息，如登录名，home目录等
usermod -a -G <target-group> <user-name> // 修改用户所在组
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

// 权限管理

chgrp <group-name> <file/dir> // 修改文件用户组

// 用户加入sudo
visudo
// 找到root ALL=(ALL) ALL，加上 
<user-name> ALL=(ALL) NOPASSWD: ALL


// 相关配置文件
/etc/group // 组配置文件
/etc/gshadow // 组影子配置文件
/etc/passwd // 用户配置文件
/etc/shadow // 用户影子口令文件
/etc/skel // 启动文件目录


// Linux初始化admin用户
useradd admin -p Ll@9186

// 查看用户tty
w

// 踢人
pkill -kill -t <user-tty>

```
