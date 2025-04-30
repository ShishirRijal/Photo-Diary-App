# Photo Diary App

A modern Spring Boot application for securely storing and organizing personal memories through photos and diary entries.

![Java](https://img.shields.io/badge/Java-Spring%20Boot-green)
![Storage](https://img.shields.io/badge/Cloud-Azure%20Blob%20Storage-blue)
![Security](https://img.shields.io/badge/Security-JWT-yellow)

---

## 💡 **What is the Photo Diary App?**

The **Photo Diary App** allows users to maintain a personal photo diary, where they can upload photos, write daily entries, and even tag moods or experiences. You can view your memories by date, mood, or tags, making it easy to find specific memories anytime.

It uses modern technologies like **Spring Boot**, **JWT Authentication**, **Azure Blob Storage**, and much more to ensure smooth functionality and user experience.

This app is built with **Java** and follows a solid **MVC pattern** for maintainable and scalable development. It's the perfect project for managing your personal memories securely while being user-friendly.

---


## 🚀 **Key Features**

- **Personal Diary Entries**: Keep track of your thoughts, feelings, and experiences. Each diary entry can have photos attached, making it more vivid and meaningful.
  
- **Image Uploading**: Upload your photos directly to the cloud via **Azure Blob Storage**. No more worrying about losing your precious memories. All images are stored securely, and the upload process is smooth and fast.

- **Custom Search & Filters**: You can search through your diary by specific dates, moods, or tags, making it super easy to revisit specific moments.

- **JWT Authentication**: Secure user authentication through **JSON Web Tokens** (JWT), so only the rightful owners have access to their diaries.

- **CORS Support**: Built to be frontend-friendly! CORS is enabled to ensure smooth communication between your frontend and backend, making it accessible from any domain.

- **Swagger Integration**: API documentation right at your fingertips! Thanks to Swagger, you can easily explore the app's endpoints.

---

# Swagger Documentation Snapshot
<img width="1512" alt="Screenshot 2025-04-30 at 10 26 33 PM" src="https://github.com/user-attachments/assets/24e8ef7d-624d-4077-97ca-a1b30cd4c2cc" />
<img width="1510" alt="Screenshot 2025-04-30 at 10 26 45 PM" src="https://github.com/user-attachments/assets/3a35e9f6-a866-45c2-a725-867204865026" />
<img width="1497" alt="Screenshot 2025-04-30 at 10 26 56 PM" src="https://github.com/user-attachments/assets/06bb0601-3cec-44fb-9083-c96f9dd7a8e7" />


---

## ⚙️ **Technologies Used**

- **Java** (Spring Boot)
- **JWT (JSON Web Tokens)** for secure user authentication
- **Azure Blob Storage** for efficient and reliable cloud storage
- **MySQL** for database 
- **Spring Data JPA** for database management
- **Swagger** for API documentation
- **CORS** for seamless integration with frontend apps
- **BCrypt** for secure password encryption

---

## 🛠 **Project Setup**

### 1. **Clone the Repository**

```bash
git clone https://github.com/ShishirRijal/Photo-Diary-App.git
cd Photo-Diary-App
```

### 2. **Configure Application Properties**

Before running the application, make sure to set up your **application.properties** file. Here are some essential properties you’ll need to set:

```properties

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/DB_NAME
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Azure Blob Storage settings
azure.storage.connection-string=your_azure_connection_string
azure.storage.container-name=your_container_name

# JWT settings
jwt.secret=your_jwt_secret_key
```

### 3. **Run the Application**

Once you have the properties configured, you can run the app by executing the following command:

```bash
./mvnw spring-boot:run
```

The app will start on `http://localhost:8080`.

---

## 📑 **API Endpoints**

### User Authentication
- **POST /api/auth/register** - Register a new user
- **POST /api/auth/login** - Login and get a JWT token
- **GET /api/auth/csrf-token** - Fetch CSRF token

### Diary Entries
- **POST /api/diaries** - Create a new diary entry
- **GET /api/diaries** - Get all diary entries
- **GET /api/diaries/{id}** - Get a single diary entry by ID
- **PUT /api/diaries/{id}** - Update an existing diary entry
- **DELETE /api/diaries/{id}** - Delete a diary entry
- **GET /api/diaries/user/{userId}** - Get all diary entries of a user
- **GET /api/diaries/search** - Search diary entries by mood/tags
- **GET /api/diaries/date-range** - Get diary entries by date range

### File Uploads
- **POST /api/files/upload** - Upload a photo to Azure Blob Storage
 


## 📜 **License**

This project is licensed under the MIT License - see the [LICENSE](https://github.com/ShishirRijal/Photo-Diary-App/blob/main/LICENSE) file for details.

---

## 🚀 **Let's Connect!**

- **LinkedIn**: [Shishir Rijal](https://www.linkedin.com/in/shishir-rijal)
- **GitHub**: [ShishirRijal](https://github.com/ShishirRijal)

---






