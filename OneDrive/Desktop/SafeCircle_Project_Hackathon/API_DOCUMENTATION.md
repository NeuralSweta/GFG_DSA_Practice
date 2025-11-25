# SafeCircle API Documentation

## Base URL
```
http://localhost:8080/api
```

---

## Authentication Endpoints

### 1. User Registration
**Endpoint:** `POST /auth/register`

**Parameters:**
- `email` (string, required): User email
- `password` (string, required): User password
- `name` (string, required): User full name
- `phone` (string, required): User phone number

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/auth/register" \
  -H "Content-Type: application/json" \
  -d '{
    "email": "sweta@example.com",
    "password": "SecurePassword123",
    "name": "Sweta Jha",
    "phone": "9876543210"
  }'
```

**Response (Success - 200):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "user": {
    "userId": 1,
    "name": "Sweta Jha",
    "email": "sweta@example.com",
    "phone": "9876543210",
    "isActive": true
  },
  "message": "Registration successful"
}
```

### 2. User Login
**Endpoint:** `POST /auth/login`

**Parameters:**
- `email` (string, required): User email
- `password` (string, required): User password

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/auth/login" \
  -H "Content-Type: application/json" \
  -d '{
    "email": "sweta@example.com",
    "password": "SecurePassword123"
  }'
```

**Response (Success - 200):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "user": {
    "userId": 1,
    "name": "Sweta Jha",
    "email": "sweta@example.com",
    "phone": "9876543210",
    "isActive": true,
    "lastLogin": "2025-11-25T10:30:00"
  },
  "message": "Login successful"
}
```

---

## SOS Emergency Endpoints

### 1. Trigger SOS Emergency
**Endpoint:** `POST /sos/trigger`

**Parameters:**
- `userId` (integer, required): User ID
- `latitude` (decimal, required): Location latitude
- `longitude` (decimal, required): Location longitude
- `address` (string, optional): Human-readable address
- `notes` (string, optional): Additional notes

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/sos/trigger" \
  -H "Authorization: Bearer <token>" \
  -d "userId=1&latitude=28.6139&longitude=77.2090&address=New%20Delhi"
```

**Response (Success - 200):**
```json
{
  "message": "SOS Triggered Successfully! Incident ID: 42",
  "incidentId": 42,
  "status": "active",
  "contactsNotified": 3,
  "smsQueue": "Queued"
}
```

### 2. Get Active Incidents
**Endpoint:** `GET /sos/active`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/sos/active" \
  -H "Authorization: Bearer <token>"
```

**Response (Success - 200):**
```json
[
  {
    "incidentId": 42,
    "userId": 1,
    "latitude": 28.6139,
    "longitude": 77.2090,
    "address": "New Delhi",
    "status": "active",
    "triggerTime": "2025-11-25T10:30:00",
    "notes": null
  }
]
```

### 3. Get User's Incidents
**Endpoint:** `GET /sos/user/{userId}`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/sos/user/1" \
  -H "Authorization: Bearer <token>"
```

### 4. Resolve Incident
**Endpoint:** `POST /sos/resolve/{incidentId}`

**Parameters:**
- `notes` (string, optional): Resolution notes

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/sos/resolve/42" \
  -d "notes=Crisis%20resolved.%20Woman%20is%20safe."
```

**Response (Success - 200):**
```json
{
  "incidentId": 42,
  "status": "resolved",
  "resolvedTime": "2025-11-25T10:35:00",
  "notes": "Crisis resolved. Woman is safe."
}
```

### 5. Mark as False Alarm
**Endpoint:** `POST /sos/false-alarm/{incidentId}`

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/sos/false-alarm/42"
```

---

## Community Report Endpoints

### 1. Create Safety Report
**Endpoint:** `POST /community/report`

**Parameters:**
- `latitude` (decimal, required): Location latitude
- `longitude` (decimal, required): Location longitude
- `riskLevel` (enum, required): LOW, MEDIUM, HIGH, CRITICAL
- `incidentType` (string, required): Type of incident
- `description` (string, required): Detailed description
- `isAnonymous` (boolean, optional): Default false
- `userId` (integer, optional): Required if not anonymous

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/community/report" \
  -d "latitude=28.6139&longitude=77.2090&riskLevel=HIGH&incidentType=Harassment&description=Harassment%20reported%20in%20area&isAnonymous=true"
```

**Response (Success - 200):**
```json
{
  "reportId": 15,
  "latitude": 28.6139,
  "longitude": 77.2090,
  "riskLevel": "HIGH",
  "incidentType": "Harassment",
  "description": "Harassment reported in area",
  "isAnonymous": true,
  "reportedAt": "2025-11-25T10:30:00",
  "verified": false,
  "upvotes": 0
}
```

### 2. Get Reports by Risk Level
**Endpoint:** `GET /community/reports/risk/{riskLevel}`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/community/reports/risk/high"
```

**Response (Success - 200):**
```json
[
  {
    "reportId": 15,
    "riskLevel": "HIGH",
    "latitude": 28.6139,
    "longitude": 77.2090,
    ...
  }
]
```

### 3. Get Verified Reports
**Endpoint:** `GET /community/reports/verified`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/community/reports/verified"
```

### 4. Get Nearby Reports
**Endpoint:** `GET /community/reports/nearby`

**Parameters:**
- `latitude` (decimal, required): User latitude
- `longitude` (decimal, required): User longitude
- `radiusKm` (double, optional): Search radius in km (default: 5)

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/community/reports/nearby?latitude=28.6139&longitude=77.2090&radiusKm=10"
```

### 5. Upvote Report
**Endpoint:** `POST /community/reports/{reportId}/upvote`

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/community/reports/15/upvote"
```

### 6. Verify Report (Admin)
**Endpoint:** `POST /community/reports/{reportId}/verify`

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/community/reports/15/verify"
```

---

## Emergency Contact Endpoints

### 1. Add Emergency Contact
**Endpoint:** `POST /contacts/add`

**Parameters:**
- `userId` (integer, required): User ID
- `contactName` (string, required): Contact name
- `contactPhone` (string, required): Contact phone
- `relationship` (string, optional): Relationship to user
- `priority` (integer, optional): Priority (1-5, default: 1)

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/contacts/add" \
  -d "userId=1&contactName=Mom&contactPhone=9123456789&relationship=Mother&priority=1"
```

### 2. Get User Contacts
**Endpoint:** `GET /contacts/user/{userId}`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/contacts/user/1"
```

**Response (Success - 200):**
```json
[
  {
    "contactId": 5,
    "userId": 1,
    "contactName": "Mom",
    "contactPhone": "9123456789",
    "relationship": "Mother",
    "priority": 1
  }
]
```

### 3. Delete Emergency Contact
**Endpoint:** `DELETE /contacts/{contactId}`

**Example Request:**
```bash
curl -X DELETE "http://localhost:8080/api/contacts/5"
```

---

## Safe Zone Endpoints

### 1. Get All Safe Zones
**Endpoint:** `GET /zones/all`

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/zones/all"
```

### 2. Get Zones by Type
**Endpoint:** `GET /zones/type/{type}`

**Parameters:**
- `type`: POLICE_STATION, HOSPITAL, VERIFIED_SAFE, COMMUNITY_MARKED

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/zones/type/police_station"
```

### 3. Get Nearby Safe Zones
**Endpoint:** `GET /zones/nearby`

**Parameters:**
- `latitude` (decimal, required): User latitude
- `longitude` (decimal, required): User longitude
- `radiusKm` (double, optional): Search radius (default: 5)

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/zones/nearby?latitude=28.6139&longitude=77.2090"
```

### 4. Add Safe Zone
**Endpoint:** `POST /zones/add`

**Parameters:**
- `zoneName` (string, required): Zone name
- `latitude` (decimal, required): Zone latitude
- `longitude` (decimal, required): Zone longitude
- `zoneType` (enum, required): Zone type

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/zones/add" \
  -d "zoneName=Delhi%20Police%20Station&latitude=28.6139&longitude=77.2090&zoneType=POLICE_STATION"
```

---

## Error Responses

### 400 Bad Request
```json
{
  "status": "error",
  "error": "INVALID_REQUEST",
  "message": "Please fill all required fields",
  "statusCode": 400
}
```

### 401 Unauthorized
```json
{
  "status": "error",
  "error": "UNAUTHORIZED",
  "message": "Invalid or missing authentication token",
  "statusCode": 401
}
```

### 404 Not Found
```json
{
  "status": "error",
  "error": "NOT_FOUND",
  "message": "Resource not found",
  "statusCode": 404
}
```

### 500 Internal Server Error
```json
{
  "status": "error",
  "error": "INTERNAL_SERVER_ERROR",
  "message": "An internal server error occurred",
  "statusCode": 500
}
```

---

## Rate Limiting

- **Limit**: 100 requests per minute per IP
- **Headers**:
  - `X-RateLimit-Limit: 100`
  - `X-RateLimit-Remaining: 95`
  - `X-RateLimit-Reset: 1635147300`

---

## Authentication

Include JWT token in Authorization header:
```
Authorization: Bearer <token>
```

Token validity: 24 hours

---

## Response Codes

- `200 OK`: Successful request
- `201 Created`: Resource created
- `204 No Content`: Successful, no response body
- `400 Bad Request`: Invalid request
- `401 Unauthorized`: Authentication failed
- `403 Forbidden`: Access denied
- `404 Not Found`: Resource not found
- `500 Internal Server Error`: Server error

---

Last Updated: November 25, 2025
