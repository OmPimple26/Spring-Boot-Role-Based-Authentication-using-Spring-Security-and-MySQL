# 🔐 Spring Boot Role-Based Authentication System

A complete **Spring Boot Security** project implementing **database-backed authentication** and **role-based authorization** using **Spring Security** and **MySQL**.

This project demonstrates real-world authentication concepts used in enterprise applications.

---

## 🚀 Features

- ✅ Custom `UserDetailsService`
- ✅ Authentication using MySQL database
- ✅ BCrypt password encryption
- ✅ Role-based access control (ADMIN / USER)
- ✅ Custom login page
- ✅ Custom authentication success handler
- ✅ Separate dashboards for Admin and User
- ✅ Secure form-based login

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **Lombok**
- **Maven**

---

## 📂 Project Structure

```
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── springsecurity/
│   │   │           └── learningspringsecurity/
│   │   │               ├── config/
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── model/
│   │   │               │   ├── MyUserDetailService.java
│   │   │               │   ├── RegistrationController.java
│   │   │               │   ├── User.java
│   │   │               │   └── UserRepository.java
│   │   │               ├── HomeController.java
│   │   │               ├── LearningspringsecurityApplication.java
│   │   │               ├── SpringConfig.java
│   │   │               └── SuccessHandler.java
│   │   └── resources/
│   │       ├── public/
│   │       │   └── error/
│   │       │       ├── 403.html
│   │       │       └── 404.html
│   │       ├── templates/
│   │       │   ├── admin_home.html
│   │       │   ├── custom_login.html
│   │       │   ├── home.html
│   │       │   └── user_home.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── springsecurity/
│                   └── learningspringsecurity/
│                       └── LearningspringsecurityApplicationTests.java
├── .gitattributes
├── .gitignore
├── LICENSE
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🔑 Roles & Access

```
| Role   | Accessible URLs                     |
|--------|-------------------------------------|
| ADMIN  | `/admin/**`                         |
| USER   | `/user/**`                          |
| Public | `/home`, `/register/user`, `/login` |
```

---

## 🔄 Authentication Flow

1. User registers via `/register/user`
2. Password is encrypted using BCrypt
3. User logs in via custom login page
4. Roles are fetched from DB
5. User is redirected:
   - ADMIN → `/admin/home`
   - USER → `/user/home`

---

## ⚙️ Database Configuration

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/springsecuritydb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

1. Clone the repository

```
git clone https://github.com/OmPimple26/Spring-Boot-Role-Based-Authentication-using-Spring-Security-and-MySQL.git
```

2. Open in IDE (VS Code / IntelliJ)

3. Configure MySQL database

4. Run the application:

```
mvn spring-boot:run
```

5. Open browser:

```
http://localhost:8080/login
```

---

## 🧠 Learning Outcomes

> Understand Spring Security internals

> Implement database-based authentication

> Apply role-based authorization

> Create custom login & success handlers

---

## 📌 Future Enhancements

> 🔐 JWT Authentication

> 📱 OTP-based Login

> 🌐 OAuth2 (Google Login)

> 🧾 User Registration Validation

---

## 👨‍💻 Author

Om Pimple
BTech Computer Engineering Student
Learning Spring Boot & Backend Development 🚀

---

⭐ If you found this project useful, don’t forget to star the repository!