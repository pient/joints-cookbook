# Docker简易教程

## 介绍

Joints Kitchen用于构建支持Joints开发与部署的私有云平台

Docker为此平台提供容器

## 常用

### Docker运行环境

- 设置docker deamon

```

// 查看当前机器docker-machine
docker-machine ls

// 启动目标machine(通常为默认default)
docker-machine start default

// 设置默认deamon环境(如下采用default作为deamon虚拟机)
eval "$(docker-machine env default)"

// 查看docker环境
docker info

// 拉取镜像
docker pull centos

// 运行并操作镜像，参数如下：
// -i for interactive, -t for tty(stdin, stdout)
// -d 后台运行Docker容器
// -P 映射所有网络容器端口至host
// --name <container-name> 设置自定义container名
// --volumn-driver=<volumn-driver-name> -v <volumn-name>:<container-dir>
// -v <host-dir>:<container-dir>共享数据卷, -v /src/webapp:/opt/webapp
docker run -it centos 

// 创建新的卷
docker volumn create -d flocker --name <volumn-name> -o size=20GB

```

- 常驻进程操作

```

// 启动docker常驻工作进程
JOB=$(docker run -d centos /bin/sh -c "while true; do echo Hello world; sleep 1; done")

// 收集工作进程日志
docker logs $JOB

docker stop $JOB

docker start $JOB

// 杀死Job
docker kill $JOB

docker exec -it <container-name> command

// 查看容器, -l返回详细信息
docker ps # Lists only running containers

docker ps -a # Lists all containers

```

- docker Image

```

docker login [<repository-site>] // 默认docker.io

// create image
docker build -t <image-name> . // 在Dockerfile目录下执行创建 image

// tag image
docker tag <image-id> <account-name>/<image-name>:<label>

// 保存运行状态
docker commit centos centos_name

// remove image
docker rmi <image-id>

// 拉取image
docker pull

// 上传image
docker push


```



