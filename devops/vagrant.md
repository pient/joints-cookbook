# Vagrant简易教程

## 介绍

Joints Kitchen用于构建支持Joints开发与部署的私有云平台

Vagrant为此平台提供开发环境

## 常用

### Vagrant运行环境

运行Vagrant前，请参考[Vagrant安装文档](https://www.vagrantup.com/docs/installation/)安装Vagrant


- 启动并运行

```

// 查看当前已安装box
vagrant box list

// 安装box(eg. vagrant box add centos/7)
// [vagrant box库](https://atlas.hashicorp.com/boxes/search)
vagrant box add <box-name>

// 完全删除box
vagrant box remove <box-name>

// 启动 vagrant
vagrant up --provider virtualbox

// 重新加载 vagrant
vagrant reload

// 登入 vagrant（Vagrantfile文件夹下）
// Ctrl+D或执行logout或exit退出
vagrant ssh

// 关闭vagrant虚拟机(vagrant up启动后，不执行provision)
vagrant halt

// vagrant halt后，单独执行 provision，启动并执行privision(vagrant up --privision)
vagrant provision

// 保存当前状态并暂停vagrant虚拟机
vagrant suspend

// suspend后，resume虚拟机
vagrant resume

// 退出box（Vagrantfile文件夹下）
vagrant destroy

// 共享
// 登录vagrantshare
vagrant login

// 共享vagrant文件
vagrant share

// 列出已安装vagrant plugins
vagrant plugin list

// 安装插件
vagrant plugin install <plugin-name>


```

- Vagrantfile文件


```

//初始化Vagrantfile
vagrant init


// Vagrantfile文件解析
Vagrant.configure("2") do |config|
  # 基础box
  config.vm.box = "centos/7" 

  # 同步文件夹
  # 若出现一下错误：Failed to mount folders in Linux guest. This is usually because the "vboxsf" file system is not available.
  # 尝试执行命令: vagrant plugin install vagrant-vbguest

  # src为原文件夹，src/website为vagrant中文件夹
  config.vm.synced_folder "src/", "/srv/website",
    owner: "root", group: "root"

  # 加disabled: true, 禁用同步文件夹
  config.vm.synced_folder ".", "/vagrant", disabled: true


end


```



