#!/bin/bash
# Bangumi Menu 启动脚本
# 用于在 Linux/Mac 上启动 Java 应用程序

# 检查 JAVA_HOME 是否设置
if [ -z "${JAVA_HOME}" ]; then
    echo "Error: JAVA_HOME is not set."
    exit 1
fi

# 设置类路径
export CLASSPATH=$JAVA_HOME/lib/tools.jar:target/classes:src/main/resources

# 启动应用程序
echo "Starting Bangumi Menu Application..."
$JAVA_HOME/bin/java -cp $CLASSPATH com.bangumimenu.BangumiMenuApp