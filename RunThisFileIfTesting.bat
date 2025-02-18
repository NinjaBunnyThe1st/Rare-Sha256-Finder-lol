@echo off
set CLASSPATH=.\bin
javac src/Main.java
if %errorlevel% neq 0 goto compile_error
java Main
exit 
goto end

:end
