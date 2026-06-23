# Spring Boot Twitter Clone API

A full-stack Twitter clone project built with Java, Spring Boot, Spring Security, PostgreSQL, JPA, and React.
The project focuses on RESTful API design, layered backend architecture, authentication flows, relational database modeling, validation, and frontend-backend integration.

## Overview

This project simulates core Twitter-like features such as user registration, authentication, tweet creation, comments, likes, retweets, and user-based tweet retrieval.
It was developed as a full-stack training project to practice building a real backend system with Spring Boot and connecting it to a React frontend.

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* Maven
* REST API
* Validation
* Global Exception Handling

### Frontend

* React
* JavaScript
* CSS
* API integration with backend services

### Tools

* Git & GitHub
* Postman / HTTP client
* Maven Wrapper
* PostgreSQL

## Features

* User registration and login flows
* Tweet creation, update, deletion, and retrieval
* Retrieve tweets by user ID
* Retrieve tweet details by tweet ID
* Comment creation, update, and deletion
* Like and unlike functionality
* Retweet creation and removal
* Layered backend structure using controller, service, repository, and entity layers
* Relational data modeling with PostgreSQL and JPA
* Validation and centralized exception handling
* React frontend integration for testing backend functionality
* CORS configuration for frontend-backend communication

## Backend Architecture

The backend follows a layered architecture:

```text
Controller Layer
↓
Service Layer
↓
Repository Layer
↓
Entity / Database Layer
```

This structure helps keep request handling, business logic, database operations, and data models separated and easier to maintain.

## Main API Endpoints

### Tweet Endpoints

| Method | Endpoint              | Description              |
| ------ | --------------------- | ------------------------ |
| POST   | `/tweet`              | Create a new tweet       |
| GET    | `/tweet/findByUserId` | Get all tweets by a user |
| GET    | `/tweet/findById`     | Get tweet details by ID  |
| PUT    | `/tweet/{id}`         | Update an existing tweet |
| DELETE | `/tweet/{id}`         | Delete a tweet           |

### Comment Endpoints

| Method | Endpoint        | Description              |
| ------ | --------------- | ------------------------ |
| POST   | `/comment`      | Add a comment to a tweet |
| PUT    | `/comment/{id}` | Update a comment         |
| DELETE | `/comment/{id}` | Delete a comment         |

### Like Endpoints

| Method | Endpoint   | Description                |
| ------ | ---------- | -------------------------- |
| POST   | `/like`    | Like a tweet               |
| POST   | `/dislike` | Remove a like from a tweet |

### Retweet Endpoints

| Method | Endpoint        | Description      |
| ------ | --------------- | ---------------- |
| POST   | `/retweet`      | Retweet a tweet  |
| DELETE | `/retweet/{id}` | Remove a retweet |

### Authentication Endpoints

| Method | Endpoint    | Description                   |
| ------ | ----------- | ----------------------------- |
| POST   | `/register` | Register a new user           |
| POST   | `/login`    | Authenticate an existing user |

## Project Structure

```text
src/
 └── main/
     ├── java/
     │   └── ...
     │       ├── controller/
     │       ├── service/
     │       ├── repository/
     │       ├── entity/
     │       ├── dto/
     │       ├── exception/
     │       └── security/
     └── resources/
         └── application.properties

twitter-front/
 └── React frontend application
```

## What I Practiced

* Designing RESTful APIs with Spring Boot
* Implementing controller-service-repository architecture
* Modeling relational database entities with JPA
* Managing user, tweet, comment, like, and retweet relationships
* Applying validation rules and exception handling
* Using Spring Security for authentication-related flows
* Connecting a React frontend to a Spring Boot backend
* Handling CORS issues between frontend and backend
* Structuring a full-stack project for maintainability

## Getting Started

### Prerequisites

Make sure you have the following installed:

* Java 17+
* Maven
* PostgreSQL
* Node.js and npm

### Backend Setup

1. Clone the repository:

```bash
git clone https://github.com/emreyildirim-33/spring-boot-twitter-clone.git
cd spring-boot-twitter-clone
```

2. Configure PostgreSQL database settings in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/twitter_clone
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Run the backend:

```bash
./mvnw spring-boot:run
```

The backend will run on:

```text
http://localhost:3000
```

### Frontend Setup

1. Go to the frontend folder:

```bash
cd twitter-front
```

2. Install dependencies:

```bash
npm install
```

3. Start the frontend:

```bash
npm start
```

## API Testing

The repository includes an `api.http` file that can be used to test backend endpoints with an HTTP client.

You can also test the endpoints using Postman or similar tools.

## Notes

This project was developed as a hands-on full-stack training project.
The main focus was not cloning Twitter visually, but practicing backend architecture, REST API design, relational data modeling, authentication flow, and frontend-backend communication.

## Repository

GitHub: https://github.com/emreyildirim-33/spring-boot-twitter-clone
