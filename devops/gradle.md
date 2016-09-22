# Gradle简易教程

## 介绍
Gradle用于构建Java项目管理
参考： https://docs.gradle.org

## 常用

```

// 初始化Gradle项目
gradle init --type=java-library

// 执行任务
gradle -q hello

// maven项目转换为gradle项目
gralde init --type pom

```



## Build Scripts

```
// default gradle task
// eg. gradle -q
defaultTasks 'hello', 'count'

// Configure by DAG
gradle.taskGraph.whenReady {taskGraph ->
    if (taskGraph.hasTask(release)) {
        version = '1.0'
    } else {
        version = '1.0-SNAPSHOT'
    }
}

task distribution << {
    println "We build the zip with version=$version"
}

// task dependencies
task release(dependsOn: 'distribution') << {
    println 'We release now'
}

task hello << {
    println 'Hello World!'
}

task upper << {
    String someString = 'mY_nAmE'
    println "Original: " + someString 
    println "Upper case: " + someString.toUpperCase()
}

task count << {
    4.times { print "$it " }
}

// dynamic tasks
// run eg. gradle -q task1
//         gradle -q task2
4.times { counter ->
    task "task$counter" << {
        println "I'm task number $counter"
    }
}

// extra task properties
task myTask {
    ext.myProperty = "myValue"
}

// try: gradle -q printTaskProperties
task printTaskProperties << {
    println myTask.myProperty
}


```