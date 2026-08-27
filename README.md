# 📚 EcaBookshop - Book Service Microservice (`ecabookshop-book-service`)

---

## 📌 Repository Information & Metadata

* **Student Name:** Sainsa Rethmi Thennakoon
* **Student Number:** 241722038
* **Slack Handle:** Rethmi Thennakoon
* **GCP Project ID:** `ecabookshop-app-2026`
* **Repository Role:** Book Catalog & Inventory Management Microservice (NoSQL / MongoDB)
* **Default Port:** `8001`
* **Database:** MongoDB (`localhost:27017` or port `13500`, Database: `eca_bookshop`)
* **GCP Deployment Target:** Managed Instance Group `mig-services` (`asia-northeast1-a`)

---

## 📖 Project Description

The **Book Service** is a dedicated business domain microservice managing all book inventory data, author details, category classifications, and pricing for the ECA Bookshop system.

Built using **Spring Boot 3.4.1** and **Spring Data MongoDB**, it utilizes document-based NoSQL persistence to flexibly store and rapidly query dynamic book catalog attributes. It automatically registers with Netflix Eureka and obtains centralized configurations from the Spring Cloud Config Server.

### 🌟 Key Features & Capabilities
* **Flexible Document Schema:** Leverages MongoDB document collections for catalog items.
* **Full CRUD Operations:** REST APIs to query, create, update, and remove book listings.
* **Eureka Dynamic Discovery:** Registers as `BOOK-SERVICE` with Eureka on port `8001`.
* **API Gateway Routing:** Accessible externally through Spring Cloud Gateway at `/api/v1/books/**`.

---

## 🛠️ Technology Stack

| Technology | Version | Purpose |
| :--- | :--- | :--- |
| **Java Platform** | OpenJDK `25` | High-performance Java Runtime |
| **Spring Boot** | `3.4.1` | Core Microservice Framework |
| **Spring Data MongoDB** | `3.4.1` | NoSQL Object-Document Mapping & Repository Layer |
| **MongoDB** | `v6.0+` / `v7.0+` | NoSQL Document Database |
| **Netflix Eureka Client** | `2024.0.0` | Service Discovery Registration |
| **Spring Cloud Config Client** | `2024.0.0` | External Configuration Client |
| **Project Lombok** | `1.18+` | Code Boilerplate Reduction |
| **Maven** | `3.9+` | Build & Dependency Management |

---

## 📡 REST API Specifications

All endpoints are accessible directly or routed via API Gateway (`http://localhost:7000/api/v1/books`):

| HTTP Method | Endpoint Path | Description | Sample Request / Body | Sample Response Status |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/books` | Get all books in catalog | None | `200 OK` (JSON Array) |
| `GET` | `/api/v1/books/{id}` | Get single book by ID/ISBN | None | `200 OK` / `404 Not Found` |
| `POST` | `/api/v1/books` | Create a new book entry | `{"title":"...", "author":"...", "price":..., "qty":...}` | `201 Created` |
| `PUT` | `/api/v1/books/{id}` | Update existing book info | `{"title":"...", "author":"...", "price":..., "qty":...}` | `200 OK` |
| `DELETE` | `/api/v1/books/{id}` | Delete book from catalog | None | `204 No Content` |

---

## 🚀 Setup & Getting Started Instructions

### Prerequisites
* **Java Development Kit (JDK):** `Java 21+` (Java 25 recommended)
* **Apache Maven:** `3.9+`
* **MongoDB Server:** Running on port `27017` (or PM2 mapped port `13500`)
* **Platform Services Running:**
  1. Config Server (`http://localhost:9000`)
  2. Service Registry (`http://localhost:9001`)

### 1. Clone the Repository
```bash
git clone https://github.com/Rethmi/ecabookshop-book-service.git
cd ecabookshop-book-service
```

### 2. Configure MongoDB
Ensure MongoDB is running locally or provide custom URI in `application.yaml` / Config Server:
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/eca_bookshop
```

### 3. Build the Application
```bash
mvn clean package -DskipTests
```

### 4. Run the Book Service
```bash
java -jar target/book-service-1.0.0.jar
```
*The Book Service starts on port `8001` and announces itself to Eureka as `BOOK-SERVICE`.*

---

## 🔗 Related Repositories

* **Services Super Repo:** [ecabookshop-services](https://github.com/Rethmi/ecabookshop-services)
* **Customer Service:** [ecabookshop-customer-service](https://github.com/Rethmi/ecabookshop-customer-service)
* **Order Service:** [ecabookshop-order-service](https://github.com/Rethmi/ecabookshop-order-service)
* **Platform Super Repo:** [ecabookshop-platform](https://github.com/Rethmi/ecabookshop-platform)
* **Frontend Web App:** [ecabookshop-web](https://github.com/Rethmi/ecabookshop-web)
