# Ionic基础

## Ionic2线上部署基本步骤

```
// 增加运行平台
sudo ionic platforms browser

// 使用release启动
sudo ionic run browser --release
sudo ionic run browser --release -- --port=80  // 指定80端口

// 不重启更新
sudo ionic build browser --release

// 查看环境信息
ionic info
```

