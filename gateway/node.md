# Docker简易教程

## PM2安装部署


```

// 安装日志rotate模块
pm2 install pm2-logrotate
pm2 set pm2-logrotate:interval_unit ‘DD'

// 安装mongodb模块
pm2 install pm2-mongodb

// 使用配置文件启动pm2
pm2 start -x ./pm2.json

```

