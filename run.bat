@echo off
set "CATALINA_HOME=%~dp0tomcat"
set "CATALINA_BASE=%~dp0tomcat"

echo ========================================================
echo GymTracker - Auto Build ^& Run Script
echo ========================================================
echo.

echo [1/5] Shutting down currently running Tomcat server...
call tomcat\bin\shutdown.bat >nul 2>&1
timeout /t 2 /nobreak >nul

echo [2/5] Clearing old server caches to prevent errors...
if exist "tomcat\work\Catalina\localhost\GymTracker" (
    rmdir /s /q "tomcat\work\Catalina\localhost\GymTracker"
)

echo [3/5] Compiling your new Java code...
if not exist "webapp\WEB-INF\classes" mkdir "webapp\WEB-INF\classes"

javac -cp "lib\javax.servlet-api.jar" -d "webapp\WEB-INF\classes" src\model\*.java src\util\*.java src\dao\*.java src\service\*.java src\controller\*.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Compilation Failed! Please check your code.
    pause
    exit /b %ERRORLEVEL%
)

echo [4/5] Deploying freshly compiled code to the server...
if not exist "tomcat\webapps\GymTracker" mkdir "tomcat\webapps\GymTracker"
xcopy /E /I /Y "webapp\*" "tomcat\webapps\GymTracker\" >nul

echo [5/5] Booting up the Tomcat server...
call tomcat\bin\startup.bat

echo.
echo ========================================================
echo ALL DONE! Your project is now running exactly as coded.
echo Refresh your browser at: http://localhost:8080/GymTracker/
echo ========================================================
pause
