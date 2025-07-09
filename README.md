# OrgConnect

A multi-tenant organization-aware user management system built using **Java**, **Spring Boot**, and **PostgreSQL**. This application demonstrates dynamic tenant filtering and basic authorization simulation using request headers. It is designed to simulate enterprise-grade access control logic where users from one organization cannot access or interfere with data from another.

---

## 🔥 Features

- 🚪 Header-based authentication simulation (`X-ORG-GROUP`, `X-ROLE`)
- 🧵 Context-aware multi-tenancy using `ThreadLocal`
- 🧱 Role-based structure (`ADMIN`, `MANAGER`, `EMPLOYEE`)
- 🗃️ PostgreSQL database integration
- 🌐 REST API with Spring Boot
- 🧪 Ready for unit and integration test extensions

---

## 📁 Project Structure

org-connect/

├── model/ # JPA Entities like User, Organization

├── filter/ # OrgContext & OrgContextFilter

├── enums/ # Role Enum 

├── OrgConnectApplication.java

├── resources/

│ └── application.properties

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL (running locally on default port `5432`)
- IntelliJ or any IDE of choice

### Database Setup

1. Create a PostgreSQL user and database:
   ```sql
   CREATE USER orguser WITH PASSWORD 'orgpass';
   CREATE DATABASE orgconnect;
   GRANT ALL PRIVILEGES ON DATABASE orgconnect TO orguser;
Set up environment variables in your IDE or application.properties:

ini
Copy
Edit
DB_USERNAME=orguser
DB_PASSWORD=orgpass
DB_URL=jdbc:postgresql://localhost:5432/orgconnect
📦 Build & Run
bash
Copy
Edit
# Build the project
./mvnw clean install

# Run the app
./mvnw spring-boot:run
🔧 API Simulation
You can simulate organization-based access using headers:

Required Headers:
Header	Description
X-ORG-GROUP	Name/code of the organization (e.g., CnS, Digital)
X-ROLE	Role of the user (e.g., ADMIN, EMPLOYEE)

These headers are used to dynamically set org context for request handling.

🧠 How It Works
A custom Filter reads the headers and stores them in a ThreadLocal holder.

This allows your services and repositories to access the org/role context per request.

The context is cleared at the end of each request to avoid memory leaks.

🛣️ Roadmap
 Phase 1: Auth simulation using headers

 Phase 2: Token-based authentication & validation

 Phase 3: Role-based access enforcement

 Phase 4: Audit logs & org-aware reporting

 Phase 5: Deployment on cloud (Azure/AWS)


 

🤝 Contributing
Feel free to fork, raise issues, or submit pull requests if you'd like to improve or extend this simulation.

📄 License
This project is open-source and available under the MIT License.

✨ Author
Thomas Philip
Java Developer | Spring Boot Enthusiast | System Design Learner
