# 🎬 Movie Booking Application (Spring Boot)

A backend **Movie Booking Application** built using **Spring Boot 3.0.0** and **Java 17**.  
This mini-project allows users to manage movies in a ticket booking system with full CRUD functionality, validations, and strong error handling.

---

## 🚀 Features
- View a list of all available movies
- Add a new movie with a unique ID
- Retrieve details of a movie by its ID
- Update movie details by ID
- Delete a movie from the system
- Validations on fields:
  - `movieName`: 3–20 characters
  - `id`: minimum 1 character, cannot be blank
  - `movieDirector`: cannot be null
  - `movieRating`: between 1–10
- Error handling:
  - Prevent duplicate IDs (`IdAlreadyExist` exception)
  - Handle missing IDs (`IdNotFound` exception)
  - Validation errors return meaningful messages

---

## 🔗 Endpoints

| Method | Endpoint             | Description                        |
|--------|----------------------|------------------------------------|
| GET    | `/ticket/movies`     | Get all movies                     |
| GET    | `/ticket/movie/{id}` | Get movie by ID                    |
| POST   | `/ticket/movie`      | Add a new movie                    |
| PUT    | `/ticket/update/{id}`| Update an existing movie by ID     |
| DELETE | `/ticket/movie/{id}` | Delete a movie by ID               |

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.0.0
- Spring Web
- Jakarta Validation API
- In-memory storage (`List` + `Map`)

---

## ▶️ Running the Application
1. Clone this repository:
   ```bash
   git clone https://github.com/Kurdekar1101/spring-boot-movie-booking-app.git
