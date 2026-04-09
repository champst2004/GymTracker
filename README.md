# GymTracker (GymTracker) 💪

> A comprehensive, Java-based web application tailored for gym and fitness center management. Clean, efficient, and easy to deploy!

**GymTracker** (marketed as GymTracker) allows fitness center administrators to securely log in, manage trainers, onboard members, track their subscriptions, and securely log their daily attendance. It leverages a rigorous Java Servlet backend linked with a robust MySQL database to give gym owners total control over their business operations.

---

## 🚀 Key Features

* **Secure Admin Portal**: Dedicated admin login ensuring data integrity and secure access to management tools.
* **Member Management**: Create, view, and manage comprehensive member profiles including their health metrics (weight), contact details, and assigned trainers.
* **Trainer Directory**: Manage your gym staff, recording their specializations, and safely assigning them to specific members.
* **Subscription Tracking**: Support for various tiered subscription plans (Monthly, Quarterly, Half-Yearly, Yearly) tracking both start/end dates and revenue amounts.
* **Attendance Logging**: Keep accurate historic check-in timestamps of the members to analyze gym occupancy and member activity.

## 🛠️ Tech Stack

* **Backend Environment**: Java 11+, Jakarta Servlet API (javax.servlet)
* **Web Server**: Apache Tomcat 9.0+
* **Database Management**: MySQL 8.x
* **Frontend**: Vanilla HTML / CSS / JavaScript / JSP *(Served from the `webapp` directory)*

## 📐 Database Schema Overview

The application features a fully normalized relational database (`gym_tracker`) containing 5 key core tables:
1. `admins` - Manages backend user authorization.
2. `trainers` - Houses gym staff data.
3. `members` - Client personal identifiers and metrics.
4. `subscriptions` - Client revenue and plan expiration data (Cascades on Member deletion).
5. `attendance` - Log of member check-in times.

---

## ⚙️ Prerequisites

Before you set up the project locally, ensure you have the following installed on your machine:
* [Java Development Kit (JDK 11+)](https://www.oracle.com/java/technologies/downloads/)
* [Apache Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/)
* `mysql-connector-java-8.x.jar` downloaded locally.

## Deploying Locally

### 1. Database Configuration
1. Start your local MySQL Background Service.
2. Execute the provided `gym_tracker.sql` script to automatically generate the database, tables, and populate it with sample data.
3. Verify your database connection strings inside `/src/util/DBConnection.java`. (Change the `USER`, `PASSWORD`, and `URL` to match your local desktop config if necessary).

### 2. Compilation
You can compile all backend `.java` classes via the included Windows Batch file!
1. Double-click or run `build.bat` from your command prompt.
2. All compiled `.class` outputs will be safely deposited into `webapp/WEB-INF/classes/`.

### 3. Server Deployment
1. Copy your physical `mysql-connector-java.jar` file and paste it into `/webapp/WEB-INF/lib/`.
2. Move the entire `/webapp/` folder contents over into a new subdirectory inside your Tomcat Server (ex: `C:\Program Files\Apache\Tomcat\webapps\GymTracker`).
3. Start the Apache Tomcat server process using the `\bin\startup.bat` protocol.
4. Open your browser and navigate to: [http://localhost:8080/GymTracker/](http://localhost:8080/GymTracker/)

---

## 🔐 Default Admin Credentials

If you've run the provided sample SQL, you can test the application using the following master admin credentials:

* **Username:** `admin`
* **Password:** `admin123`

---

