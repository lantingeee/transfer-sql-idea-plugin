# TRANSFER SQL IDEA PLUGIN

## 简单介绍

一个关于 Mybatis 的 IDEA 插件
当使用 Mybatis 框架时，经常需要拷贝 Mybatis mapper 层的长 sql 到剪切板去运行，但是一般直接拷贝的 sql 都会含有特殊字符。

支持：

* 从 Mybatis mapper annotation 中拷贝 sql 时自动移除特殊字符
* 从 剪切板粘贴 sql 到 Mybatis mapper annotation 中时自动添加特殊字符

## 演示
如何使用插件：
![plugin gif](./gif/transfer-sql-idea-plugin.gif)

## 如何使用
#### 下载
下载生成的 Jar 文件:

https://github.com/lantingeee/transfer-sql-idea-plugin/raw/master/transfer-sql-idea-plugin.jar

#### 拷贝 Jar 文件
* 拷贝 Jar 文件到 .IntelliJIDEAx0\config\plugins (IDEA 插件的安装路径)
如果想知道本地 IDEA 的安装地址，可以查看I DE Settings, Caches, Logs, 或者 Plugins.

#### 重启 Intellij IDEA
重启之后，插件便会自动安装，可以右键查看效果 参考 [演示](#demonstration) 

## 如何利用代码自己打包
* 可以下载项目到本地，正确将项目引入 IDEA
* IDEA 主菜单可以看到 Build | Make Project.
* 再 IDEA 主菜单中选择 Build | Prepare Plugin Module ‘transfer-sql-idea-plugin’ for Deployment 便会自动生成 transfer-sql-idea—plugin.jar (在项目中已经包含)

## 支持的 IDEs
这个插件支持的 IntelliJ-based:
* IntelliJ 2016.1+ 

## License