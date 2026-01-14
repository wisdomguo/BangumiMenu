# Bangumi Menu Java 桌面应用程序

## 项目结构

```
BangumiMenu/
├── pom.xml                 # Maven 项目配置文件
├── README.md               # 项目说明文档
├── src/
│   ├── main/
│   │   ├── java/           # Java 源代码
│   │   │   └── com/
│   │   │       └── bangumimenu/
│   │   │           ├── BangumiMenuApp.java      # 应用程序入口
│   │   │           └── gui/
│   │   │               └── MainWindow.java      # 主窗口类
│   │   └── resources/      # 资源文件
│   │       ├── application.properties           # 应用程序配置
│   │       └── logback.xml                      # 日志配置
└── target/                 # 编译输出目录（Maven生成）
```

## 功能特性

- 基于 Swing 的图形用户界面
- 模块化的代码结构
- Maven 项目管理
- 日志记录功能
- 可扩展的应用架构

## 运行方式

### 使用 Maven

1. 确保已安装 Maven 和 JDK 8+
2. 在项目根目录执行：
   ```
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.bangumimenu.BangumiMenuApp"
   ```

或者打包后运行：
   ```
   mvn package
   java -jar target/bangumi-menu-1.0.0.jar
   ```

### 在 IDE 中运行

1. 导入项目到 IntelliJ IDEA 或 Eclipse
2. 将 `src/main/java` 设置为源代码目录
3. 运行 `com.bangumimenu.BangumiMenuApp` 类

## 开发指南

### 添加新功能

1. 在 `com.bangumimenu.gui` 包中创建新的 GUI 组件
2. 在 `com.bangumimenu.service` 包中创建业务逻辑类（如需添加）
3. 通过依赖注入或服务定位器模式连接组件

### 代码规范

- 使用驼峰命名法
- 类名使用 PascalCase
- 方法和变量使用 camelCase
- 遵循 Java 编码标准

## 依赖项

- JDK 8+
- Maven 3.6+
- Swing (内置在 JDK 中)
- SLF4J + Logback (日志)
- Gson (JSON 处理)

## 构建信息

- 编译目标：Java 8
- 字符编码：UTF-8
- 打包格式：JAR

## Git数据同步功能

本应用内置了Git数据同步功能，支持跨设备数据同步：

- 应用启动时自动从远程仓库拉取最新数据
- 数据变更时自动推送到远程仓库
- 使用内置账户进行认证（无需用户手动配置）
- 支持离线使用，联网时自动同步

要使用此功能，请在 `application.properties` 中配置以下参数：
- `git.remote.url`：远程仓库地址
- `git.username`：Git用户名
- `git.password`：访问令牌或密码