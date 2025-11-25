# SafeCircle Architecture & Technical Details

## System Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                        Frontend Layer                        │
│            (HTML5 / CSS3 / JavaScript / Geolocation)        │
└────────────────────────┬────────────────────────────────────┘
                         │ REST API (JSON)
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                    API Gateway Layer                         │
│               (Spring Boot Controllers)                      │
│    Auth  │  SOS  │  Community  │  Contacts  │  Zones        │
└────────────────────────┬────────────────────────────────────┘
                         │
         ┌───────────────┼───────────────┐
         ▼               ▼               ▼
┌──────────────────┐ ┌──────────────┐ ┌──────────────┐
│  Auth Service    │ │ SOS Service  │ │ Community    │
│  User Mgmt       │ │ Location Mgr  │ │ Reports      │
│  Password Enc    │ │ Notif Send    │ │ Risk Analysis│
└──────────────────┘ └──────────────┘ └──────────────┘
         │               │               │
         └───────────────┼───────────────┘
                         ▼
         ┌───────────────────────────────┐
         │    Spring Data JPA/Hibernate  │
         │        ORM Layer              │
         └───────────────┬───────────────┘
                         ▼
         ┌───────────────────────────────┐
         │       MySQL Database          │
         │  (InnoDB Engine, Indexes)     │
         └───────────────────────────────┘
```

## Database Design

### Entity Relationship Diagram

```
Users (1) ─────┐
              ├──────── (N) Emergency_Contacts
              ├──────── (N) SOS_Incidents
              │              │
              │              └──── (N) Location_Tracking
              │
              └──────── (N) Community_Reports

Independent Tables:
- Safe_Zones
- Risk_Zones
- Notifications
- User_Checkins
```

## Security Implementation

### Authentication Flow
1. User submits email + password
2. Backend validates credentials
3. Password verified against BCrypt hash
4. JWT token generated and sent
5. Token stored in localStorage (frontend)
6. Token sent with each API request

### Data Protection
- Passwords: BCrypt with salt rounds (10)
- Transit: HTTPS (in production)
- Database: Encrypted connections
- Sensitive fields: Never logged

## API Design Patterns

### Request-Response Format
```json
{
  "status": "success",
  "data": { },
  "message": "Operation successful",
  "timestamp": "2025-11-25T10:30:00Z"
}
```

### Error Handling
```json
{
  "status": "error",
  "error": "INVALID_REQUEST",
  "message": "User not found",
  "statusCode": 404
}
```

## Performance Optimization

### Database Indexes
- `users`: email, phone
- `sos_incidents`: user_id, status, trigger_time
- `community_reports`: latitude, longitude, risk_level

### Caching Strategy
- In-memory cache for safe zones (10 min TTL)
- Redis for session management (optional)
- CDN for static frontend assets

### Query Optimization
- Lazy loading for relationships
- Pagination for large result sets
- Database connection pooling

## Deployment Architecture

### Development Environment
```
Laptop/PC
├── MySQL (localhost:3306)
├── Spring Boot (localhost:8080)
└── Frontend (localhost:8000)
```

### Production Environment (Recommended)
```
Cloud (AWS/Azure)
├── RDS MySQL
├── EC2/App Service (Spring Boot)
├── S3/Blob Storage (uploads)
├── CloudFront/CDN (frontend)
└── Route53/DNS
```

## Scalability Considerations

### Horizontal Scaling
- Stateless API servers behind load balancer
- Database read replicas for reporting
- Message queue for async operations

### Vertical Scaling
- Increase server resources
- Optimize database queries
- Add caching layers

### Future: Microservices Architecture
```
Gateway
├── User Service
├── SOS Service
├── Community Service
├── Location Service
└── Notification Service
```

## Testing Strategy

### Unit Tests
- Service layer: 80% coverage
- DTOs and models
- Utility functions

### Integration Tests
- Controller endpoints
- Database operations
- API workflows

### E2E Tests
- User registration → SOS trigger → Contact alert
- Report creation → Community verification

## Monitoring & Logging

### Key Metrics
- API response time
- SOS trigger latency
- Database query performance
- User registration rate
- Active incidents count

### Log Levels
- ERROR: System failures
- WARN: Potential issues
- INFO: Major operations
- DEBUG: Detailed trace (dev only)

## Compliance & Standards

✅ GDPR: User data privacy
✅ WCAG 2.1: Accessibility
✅ OWASP: Security best practices
✅ REST: API design conventions

---

Document Version: 1.0
Last Updated: November 25, 2025
