# Gym Membership & Fitness Tracker - Deployment Guide

1. **Import the Project:** Open your Eclipse IDE, choose `File > Import > Web > Dynamic Web Project`. Select the parent directory of `GymTracker`. Alternatively, `Import > General > Existing Projects into Workspace` and select `GymTracker`.
2. **Add MySQL Connector:** Since we aren't using Maven, download `mysql-connector-java-8.x.jar` and place it physically inside `webapp/WEB-INF/lib/` or right-click your project -> `Build Path -> Configure Build Path...` -> Add the MySQL driver JAR to the classpath.
3. **Set Up Database:** 
   - Ensure your local MySQL router is active.
   - Run the included `gym_tracker.sql` script into your MySQL server to spin up the `gym_tracker` database with the sample data.
   - Inside `DBConnection.java`, verify the `URL`, `USER`, and `PASSWORD` to match your local installation.
4. **Deploy with Tomcat 9:**
   - Go to the `Servers` tab (Window -> Show View -> Servers).
   - Add a new Tomcat v9.0 Server. Right click the server, select `Add and Remove...`, and verify that `GymTracker` is configured.
   - Start the server.
5. **Launch Application:**
   - Head to `http://localhost:8080/GymTracker/`. The `index.html` will automatically re-route you to the GymTracker login portal!

**Login Credentials:**
Username: `admin`
Password: `admin123`
