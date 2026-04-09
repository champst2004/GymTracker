@echo off
echo =========================================
echo Compiling GymTracker...
echo =========================================

REM Create classes directory if it doesn't exist
if not exist "webapp\WEB-INF\classes" mkdir "webapp\WEB-INF\classes"

REM Compile all java files into the WEB-INF/classes directory
javac -cp "lib\javax.servlet-api.jar" -d "webapp\WEB-INF\classes" src\model\*.java src\util\*.java src\dao\*.java src\service\*.java src\controller\*.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Compilation Failed! Please check the errors above.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [SUCCESS] Compilation Successful! All .class files generated in webapp\WEB-INF\classes.
echo.
echo ========================================================
echo HOW TO DEPLOY TO TOMCAT MANUALLY:
echo ========================================================
echo 1. Make sure you download "mysql-connector-j-8.x.jar" and 
echo    place it inside: GymTracker\webapp\WEB-INF\lib\
echo.
echo 2. Copy the ENTIRE contents of your "webapp" folder.
echo.
echo 3. Paste it into your Tomcat installation's webapps folder, 
echo    under a new folder named "GymTracker".
echo    (e.g., C:\Program Files\Apache\Tomcat\webapps\GymTracker)
echo.
echo 4. Go to your Tomcat \bin folder and run startup.bat.
echo.
echo 5. Open your browser and go to: http://localhost:8080/GymTracker
echo ========================================================
pause
