# Gradle 简单教程


## 安装设置

### 设置Gradle加载国内镜像

```
repositories {
    maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
}
```

## 配置执行

### 运行web应用
build.gradle
```
apply plugin: 'jetty'

```

执行命令：
```
// 加载工程至jetty容器并运行
gradle jettyRun

// 打包并启动部署到jetty容器
gradle jettyRunWar
```


