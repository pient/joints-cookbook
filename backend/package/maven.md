# Maven 简单教程

## 设置Maven加载国内镜像

### 设置mvn命令加载国内镜像

修改maven根目录下的conf文件夹中的setting.xml文件，内容如下：
```
<mirrors>
  <mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>        
  </mirror>
</mirrors>

```

### 设置eclipse 设置Maven加载国内镜像
eclispe window-》preferences-》maven-> User Settings
.m2下建settings.xml文件
```
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">  
    <mirrors>  
        <!-- mirror | Specifies a repository mirror site to use instead of a given   
            repository. The repository that | this mirror serves has an ID that matches   
            the mirrorOf element of this mirror. IDs are used | for inheritance and direct   
            lookup purposes, and must be unique across the set of mirrors. | -->  
        <mirror>
          <id>alimaven</id>
          <name>aliyun maven</name>
          <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
          <mirrorOf>central</mirrorOf>
        </mirror> 
    </mirrors>
    <profiles>  
        <profile>  
            <id>default</id>  
            <repositories>  
                <repository>  
                    <id>nexus</id>  
                    <name>local private nexus</name>  
                    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
                    <releases>  
                        <enabled>true</enabled>  
                    </releases>  
                    <snapshots>  
                        <enabled>false</enabled>  
                    </snapshots>  
                </repository>  
            </repositories>  
            <pluginRepositories>  
                <pluginRepository>  
                    <id>nexus</id>  
                    <name>local private nexus</name>  
                    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
                    <releases>  
                        <enabled>true</enabled>  
                    </releases>  
                    <snapshots>  
                        <enabled>false</enabled>  
                    </snapshots>  
                </pluginRepository>  
            </pluginRepositories>  
        </profile>  
    </profiles>  
</settings>  
```

