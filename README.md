# Smart Campus Sensor & Room Management API

## Overview

The Smart Campus Sensor & Room Management API is an API. It is built using JAX-RS (Jersey) and Apache Tomcat. The API helps manage rooms and sensors across a university campus. It supports CRUD operations for rooms and sensors. It also handles sensor readings and advanced error handling.

## Technology Stack

- Java 11

- JAX-RS (Jersey 3.1.3)

- Apache Tomcat 10.1.54

- Maven

- Jackson (JSON)

## How to Build and Run

### Prerequisites

- Java JDK 11+

- Apache Maven

- Apache Tomcat 10.1.54

- NetBeans IDE (or any IDE)

### Steps

1. Clone the repository:

git clone https://github.com/yourusername/SmartCampusAPI.git

2. Open project in NetBeans

3. Clean and Build:

Right-click project → Clean and Build

4. Run:

Right-click project → Run ( Apache Tomcat)

5. API will be available at:

http://localhost:8080/api/v1

## Sample curl Commands

### 1. Get API Discovery

curl -X GET http://localhost:8080/api/v1

### 2. Create a Room

curl -X POST http://localhost:8080/api/v1/rooms \

-H "Content-Type: application/json" \

-d '{"id":"LIB-301","name":"Library","capacity":50}'

### 3. Get All Rooms

curl -X GET http://localhost:8080/api/v1/rooms

### 4. Create a Sensor

curl -X POST http://localhost:8080/api/v1/sensors \

-H "Content-Type: application/json" \

-d '{"id":"TEMP-001","type":"Temperature","status":"ACTIVE","currentValue":0.0,"roomId":"LIB-301"}'

### 5. Get Sensors by Type

curl -X GET http://localhost:8080/api/v1/sensors?type=Temperature

### 6. Add a Sensor Reading

curl -X POST http://localhost:8080/api/v1/sensors/TEMP-001/readings \

-H "Content-Type: application/json" \

-d '{"value":23.5}'

### 7. Get Sensor Readings

curl -X GET http://localhost:8080/api/v1/sensors/TEMP-001/readings

### 8. Delete a Room

curl -X DELETE http://localhost:8080/api/v1/rooms/LIB-301

## API Endpoints

Method | Endpoint | Description |

|--------|----------|-------------|

| GET | /api/v1 | API Discovery |

| GET | /api/v1/rooms | Get all rooms |

| POST | /api/v1/rooms | Create a room |

| GET | /api/v1/rooms/{id} | Get a room |

DELETE | /api/v1/rooms/{id} | Delete a room |

| GET | /api/v1/sensors | Get all sensors |

| POST | /api/v1/sensors | Create a sensor |

| GET | /api/v1/sensors?type={type} | Filter sensors by type |

| GET | /api/v1/sensors/{id}/readings | Get sensor readings |

| POST | /api/v1/sensors/{id}/readings | Add a sensor reading |

## Report. Question Answers

### Part 1. Setup & Discovery

**Q: Explain the default lifecycle of a JAX-RS Resource class.**

The JAX-RS Resource class has a per-request lifecycle. This means a new instance is created for every HTTP request. So instance variables cannot be used to store data between requests.

**Q: Why is HATEOAS considered a hallmark of RESTful design?**

HATEOAS allows clients to discover actions from API responses. This makes the API self- and reduces client-server coupling.

### Part 2. Room Management

**Q: Returning IDs versus full room objects?**

Returning full room objects is preferred. This is because it reduces round trips making it more efficient for clients that need all the data immediately.

**Q: Is DELETE idempotent in your implementation?**

Yes DELETE is idempotent. The first DELETE request removes the room and any subsequent DELETE requests return HTTP 404 Not Found.

### Part 3. Sensor Operations

**Q: What happens if a client sends data in a format?**

If a client sends data in a different format JAX-RS returns HTTP 415 Unsupported Media Type.

**Q: Why is @QueryParam better than path-based filtering?**

Query parameters are better for filtering. They are optional. Do not change the resource identity.

### Part 4. Sub-Resources

**Q: Benefits of the Sub-Resource Locator pattern?**

The Sub-Resource Locator pattern promotes separation of concerns. It delegates handling of paths to dedicated classes.

### Part 5. Error Handling

**Q: Why is HTTP 422 accurate than 404 for missing references?**

HTTP 422 is more accurate. This is because it indicates the request was well-formed but could not be processed due to errors.

**Q: Security risks of exposing stack traces?**

Exposing stack traces is a security risk. It reveals implementation details that can be used to identify known vulnerabilities.

**Q: Why use filters, for logging of manual Logger statements?**

Filters implement the cross-cutting concern principle. They intercept all requests and responses automatically ensuring logging across the API.