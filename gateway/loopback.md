# loopback简易教程

## 部署

SLC命令参考(https://docs.strongloop.com/display/NODE/Command-line+reference)

```
// 打包
slc build --npm
// 或
slc build --pack


```

### strong-pm部署

```

npm install -g strong-pm && sl-pm-install

// 在strong-pm下启动 app
slc start [app]

// slc ctl
// 查看状态
slc ctl status [service]

// 查看日志
slc ctl log-dump express-example-app

// 操作服务
slc ctl start/stop/restart [service]


```

### apiconnect

```
// 安装IBM api connect
npm install -g apiconnect


```

## 使用

```

// 登录用户


// 查询参数传递
{"skip":1,"limit":10,"where":{"name":{"like":"%江苏%"}}}

```


