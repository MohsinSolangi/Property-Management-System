# 🏠 Property Management System

A Spring Boot 3 backend application to manage property units, landlords, tenants, leases, and rent tracking. Ideal for real estate managers or rental agencies.

---

## 📦 Tech Stack

- Java 21  
- Spring Boot 3.1.5  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- SpringDoc Swagger (OpenAPI)  
- Lombok  

---

## 🛠️ Setup Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/property-management-system.git
   cd property-management-system
   ```

2. **Create PostgreSQL database**
   ```sql
   CREATE DATABASE pms;
   ```

3. **Update `application.properties`**
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/pms
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Build & Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Open Swagger UI**
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 🧩 ERD Diagram

```text
Contact
 └── id (PK)
 └── name
 └── contactInfo
 └── type (LANDLORD / TENANT)
      └── owns → Unit

Unit
 └── id (PK)
 └── unitNumber, type, location, value, status
 └── owner_id (FK → Contact)

Lease
 └── id (PK)
 └── unit_id (FK → Unit)
 └── tenant_id (FK → Contact)
 └── landlord_id (FK → Contact)
 └── startDate, rentAmount, duration, paymentFrequency

```
![ERD diagram(1)](https://github.com/user-attachments/assets/7c3d2480-246e-4f0f-9b75-9180da8a3a55)


---

## 🧪 Test Data (Manually inserted for API testing)

### 🔹 Test Case 1: Unit A1

| Entity    | Details |
|-----------|---------|
| Landlord  | **John Doe** - Contact: 03108282376 |
| Tenant    | **Jane Smith** - Contact: 01927654381 |
| Unit      | **Unit A1** - Type: Apartment, Location: Kharadar, Karachi, Value: 1,000,000, Status: Occupied |
| Lease     | Start Date: 2025-04-23, Duration: 12 months, Rent Amount: 50000, Payment Frequency: Monthly |

---

### 🔹 Test Case 2: Unit A2

| Entity    | Details |
|-----------|---------|
| Landlord  | **Waqar Shah** - Contact: 034012224321 |
| Tenant    | **Jawwad** - Contact: 03568632129 |
| Unit      | **Unit A2** - Type: Vila, Location: Gulistan E Jhor, Value: 900000, Status: Occupied |
| Lease     | Start Date: 2025-04-23, Duration: 12 months, Rent Amount: 30000, Payment Frequency: Monthly |

---

## 📘 API Documentation

API is documented using **SpringDoc Swagger (OpenAPI)**.

### 🔗 Access Here:
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`  
- Raw JSON Docs: `http://localhost:8080/v3/api-docs`

### ✅ Covered Endpoints:
- `POST /contact/saveContact`
- `GET /contact/{id}`
- `PUT /contact/update/{id}`
- `GET /contact/types`
- `POST /unit/create`
- `GET /unit/{id}`
- `PUT /unit/update/{id}`
- `POST /lease/create`
- `GET /dashboard`
- `GET /summary`

---

## 📂 Folder Structure

```
├── controller
├── service
├── model
├── dto
├── mapper
├── repository
├── PropertyManagementSystemApplication.java
└── application.properties
```

## 🧾 Property Management System - API Collection

This collection includes all the essential API endpoints for managing:

- 🧑‍💼 Landlords & Tenants
- 🏢 Property Units
- 📄 Leases
- 📊 Dashboard and Summary views

### 📌 Highlights
- Fully RESTful
- JSON payloads with validation
- Ready-to-use test data
- Linked entity flow (Contact → Unit → Lease)

🔥 Built using Spring Boot 3.1.5 and PostgreSQL

Link
---

```
 https://.postman.co/workspace/My-Workspace~b653fd18-cfd0-4f07-80ab-090e1f526424/folder/39965677-59d30061-f1f2-4965-9ccf-8b2ef1f1f632?action=share&creator=39965677&ctx=documentation
```
---


## 📩 Contact

For issues or queries, feel free to create an issue or connect via [LinkedIn](linkedin.com/in/mohsin-solangi-1a2b3c/).
