# **E-Hotels Booking System**

This project is a **Spring Boot** application for an **e-Hotels booking and renting system** (CSI2132).

---

## **Prerequisites**

1. **Java 17 or Above**  
   - The project is configured for Java **21** in `pom.xml` but you can use at least Java **17** or higher.  
   - [Download and install the latest JDK](https://www.oracle.com/java/technologies/downloads/).  

2. **Apache Maven** (Version 3.8+ recommended)  
   - [Download Maven](https://maven.apache.org/download.cgi) if it’s not already installed.  
   - Confirm installation by running:
     ```bash
     mvn -v
     ```
   - You should see a version number (e.g., `Apache Maven 3.8.x`).  

3. **PostgreSQL** (Version 13+ recommended)  
   - [Download PostgreSQL](https://www.postgresql.org/download/).  
   - Install and start the PostgreSQL server.  
   - You will need the following info later:
     - **Host** (default: `localhost`)
     - **Port** (default: `5432`)
     - **Database name** (we'll use `ehotels`)
     - **Username** and **Password** (e.g., `postgres` / `changemeinprod!`)

4. **DBeaver** (optional)  
   - If you’d like a GUI to browse your PostgreSQL database.  
   - [Download DBeaver](https://dbeaver.io/download/) or use any other DB client.

---

## **Installation & Setup**

1. **Clone the repository** (or download and unzip):
   ```bash
   git clone https://github.com/YourUsername/ehotels-database-application.git
   cd ehotels-database-application
### **Create the PostgreSQL Database**

```bash
psql -U postgres -c "CREATE DATABASE ehotels;"

In terminal:
mvn clean package
This compiles your code and packages it into a JAR in target/.
Run the application:
mvn spring-boot:run

Check logs:
If successful, you’ll see lines like:
Tomcat started on port(s): 8080 (http)
Started EHotelsBookingSystemApplication in ...
Also look for messages like Executing SQL script from class path resource [schema.sql] / [data.sql].
Verify the DB is populated:
In terminal: psql -h localhost -U postgres -d ehotels
In a psql shell:
\c ehotels
\dt
SELECT * FROM hotel;
You should see the newly created tables and inserted data.
Alternatively use DBeaver to view database 