# Food App: Food Review & Sharing Platform

A full-stack social platform where users share food posts, comment, like posts and rate restaurants.

- **Backend:** Spring Boot REST API with MongoDB
- **Frontend:** React single-page app with Material UI

## Features

- User sign-up, login and profile management
- Create, edit and delete food posts
- Comment on posts (add, edit, delete)
- Like and unlike posts
- Rate and review restaurants with star ratings
- Profile page with each user's own posts

## Tech stack

| Layer | Tools |
|-------|-------|
| Backend | Java 17, Spring Boot 3, Spring Web, Spring Data MongoDB, Bean Validation, Lombok, Maven |
| Database | MongoDB |
| Frontend | React 18, React Router 6, Axios, Material UI, styled-components, react-star-ratings, Moment.js |

## Project structure

```text
food-app/
├── food-app-backend/            # Spring Boot API
│   └── src/main/java/com/foodapp/backend/
│       ├── controller/          # REST controllers (User, Post, Comment, Like, Rating)
│       ├── service/             # Business logic
│       ├── repositoreis/        # MongoDB repositories
│       └── model/               # Documents
└── food-app-frontend/           # React app
    └── src/
        ├── Screens/             # Home, Profile
        └── Components/          # Header, Post, Login, Signup, InputField
```

## API overview

| Resource | Endpoints |
|----------|-----------|
| Users | `GET /getUser/{userName}` · `POST /addUser` · `PUT /editUser` · `DELETE /deleteUser/{userName}` |
| Posts | `GET /getPosts` · `GET /getSingleUserPosts/{userID}` · `POST /addPost` · `PUT /editPost` · `DELETE /deletePost/{id}` |
| Comments | `GET /getAllComments` · `GET /getComments/{postID}` · `POST /addComment` · `PUT /editComment` · `DELETE /deleteComment/{id}` |
| Likes | `GET /getLikes/{postID}` · `GET /getUserLike/{postId}/{userId}` · `POST /addLike` · `DELETE /removeLike/{userId}/{postId}` |
| Ratings | `GET /getRatings/{resturantName}` · `POST /addRating` · `PUT /updateRating` · `DELETE /deleteRating/{id}` |

## Getting started

**Prerequisites:** Java 17, Node.js 16+, MongoDB running on `localhost:27017`.

**Backend** (runs on `http://localhost:8080`):

```bash
cd food-app-backend
./mvnw spring-boot:run
```

The database `FoodAppDB` is created automatically by MongoDB.

**Frontend** (runs on `http://localhost:3000`):

```bash
cd food-app-frontend
npm install
npm start
```

## Contributors

- **Samitha Prabath**: [GitHub](https://github.com/SamithaPrabath)
- **Venura Warnasooriya**
