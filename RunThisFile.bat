@echo off
set CLASSPATH=.\res
javac src/Main.java
if %errorlevel% neq 0 goto compile_error
java Main
timeout /t 1 >nul & exit 
goto end

:end
