# AgriTech Backend

A beginner-friendly Spring Boot backend project for managing farmer data using CRUD operations.

## Features
- Add farmer
- Get all farmers
- Get farmer by ID
- Update farmer
- Delete farmer
- DTO layer
- Global exception handling
- MySQL database integration
- REST API testing with Postman

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Postman

## Project Structure
- Controller
- Service
- Repository
- Entity
- DTO
- Exception Handling

## API Endpoints

### Create Farmer
`POST /api/farmers`

### Get All Farmers
`GET /api/farmers`

### Get Farmer By ID
`GET /api/farmers/{id}`

### Update Farmer
`PUT /api/farmers/{id}`

### Delete Farmer
`DELETE /api/farmers/{id}`

## Sample Farmer JSON

    {
      "name": "Mahesh",
      "village": "Damkora",
      "crop": "Rice"
    }

## Database
This project uses MySQL database for storing farmer data.

## Author
Dhara Bansal



