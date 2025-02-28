# 📟 Product Management API

## 🚀 Overview
This project is a simple **REST API** for managing a product catalog using **Spring Boot**. The API allows users to:
- **Create** new products.
- **Update** existing product details.
- **Delete** products from the catalog.
- **View** the list of all added products.

The API follows **RESTful principles** and uses the **MVC pattern** for structuring the application.

## ♨️ Technologies Used
- **Java**
- **Spring Boot**
- **Spring MVC**
- **Lombok**

## 🌐 API Endpoints

### 1. Create a New Product
**Method:** `POST /products`
- Request Body (JSON):
    ```json
    {
      "id": 1,
      "name": "Sample Product",
      "price": 100.0
    }
    ```
- Response: `201 Created`

### 2. Update a Product
**Method:** `PUT /products/{id}`
- Request Body (JSON):
    ```json
    {
      "id": 1,
      "name": "Updated Product",
      "price": 150.0
    }
    ```
- Response: `200 OK` (if successful) or `404 Not Found` (if product does not exist)

### 3. Delete a Product
**Method:** `DELETE /products/{id}`
- Response: `200 OK` (if successful) or `404 Not Found`

### 4. Get All Products
**Method:** `GET /products`
- Response Example:
    ```json
    [
      {
        "id": 1,
        "name": "Sample Product",
        "price": 100.0
      }
    ]
    ```

## 📜 REST Principles
1. **Resource-Based**: Each product is a resource identified by a unique ID.
2. **Statelessness**: Each request contains all the necessary data.
3. **Client-Server Architecture**: The API serves as the backend, and clients (e.g., Postman, frontend apps) interact with it.
4. **Uniform Interface**: Standardized HTTP methods (GET, POST, PUT, DELETE) and response codes are used.

## 🔄 MVC Pattern Explanation
- **Model**: `Product` class represents the data structure (id, name, price).
- **View**: API responses (JSON) act as the view for the client.
- **Controller**: `ProductController` handles HTTP requests.
- **Service**: `ProductService` contains business logic to manage products.

## 🏃🏻‍♀️ How to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/luizorodrigues-alumni/productManagement.git
   ```
2. Navigate to the project directory:
   ```sh
   cd productManagement
   ```
3. Run the application:
   ```sh
   ./gradlew bootRun
   ```
4. Access the API via Postman or your preferred client.
