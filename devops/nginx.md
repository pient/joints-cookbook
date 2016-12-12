# Nginx简易教程


## 安装部署

### CentOS 7 / RHEL 7下使用yum安装，

```
// 安装前先确保安装了epel-release
sudo yum install epel-release

// 执行安装
sudo yum install nginx

// 启动
sudo systemctl start nginx

// 开机启动
sudo systemctl enable nginx

// 打开防火墙
sudo firewall-cmd --permanent --zone=public --add-service=http 
sudo firewall-cmd --permanent --zone=public --add-service=https
sudo firewall-cmd --reload


```

### 编译安装

nginx下载地址：http://nginx.org/download/

```
// 下载
wget http://nginx.org/download/nginx-1.11.6.tar.gz

// 解压
tar -zxvf /tmp/nginx-1.11.6.tar.gz

// 安装
cd nginx-1.11.6
./configure
make
make install

// 通常安装过程中会提示安装（PCRE library）
sudo yum install pcre-devel



```

##配置

配置文件地址：
yum 安装时：/etc/nginx/conf
编译安装时：/usr/local/nginx/conf

#### 基本身份验证

直接通过

参考：http://serverfault.com/questions/230749/how-to-use-nginx-to-proxy-to-a-host-requiring-authentication

```
server {
  listen       8000;
  server_name  localhost;

  location /msgdoc/ {
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_pass   http://172.17.16.109/;
    proxy_set_header Authorization "Basic anNwZGlca21zMDAxOlBhc3MxMjM0";
  }
}
```


