@echo off
rem Bangumi Menu 启动脚本
rem 用于在 Windows 上启动 Java 应用程序

setlocal

rem 检查 JAVA_HOME 是否设置
if not "%JAVA_HOME%" == "" goto gotJavaHome

echo Error: JAVA_HOME is not set.
exit /b 1

:gotJavaHome

rem 设置类路径
set CLASSPATH=%JAVA_HOME%\lib\tools.jar;target\classes;src\main\resources

rem 启动应用程序
echo Starting Bangumi Menu Application...
"%JAVA_HOME%\bin\java" -cp %CLASSPATH% com.bangumimenu.BangumiMenuApp

endlocal