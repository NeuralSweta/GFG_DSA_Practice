# SafeCircle - Women Safety & Tech
## IEEE Hackathon Project 2025

**Vision:** Empowering every woman to move freely and fearlessly through intelligent technology and community support.

---

## 🎯 Project Overview

SafeCircle is a comprehensive mobile application designed to enhance women's safety through:

### Core Features

#### 1. **Intelligent SOS System 🆘**
- One-tap emergency alert button
- Automatic location sharing with emergency contacts
- Real-time incident tracking
- Audio recording capability
- Instant SMS/notification to emergency contacts

#### 2. **AI-Powered Risk Detection 🤖**
- Real-time location safety analysis
- ML-based risk zone identification
- Predictive safety alerts
- Safety scoring system for areas
- Pattern analysis for incident hotspots

#### 3. **Community Safety Network 👥**
- Anonymous safety reporting
- Community-verified risk zones
- Crowdsourced safety data
- Upvoting system for report credibility
- Real-time community alerts

#### 4. **Safe Zone Mapping 🗺️**
- Police stations and hospitals
- Community-marked safe areas
- Real-time safe zone navigator
- Distance to nearest safe location

---

## 📁 Project Structure

```
SafeCircle_Project_Hackathon/
├── Backend/                          # Java Spring Boot Backend
│   ├── pom.xml                      # Maven configuration
│   └── src/main/
│       ├── java/com/safecircle/
│       │   ├── SafeCircleApplication.java    # Main application
│       │   ├── controller/          # REST API endpoints
│       │   │   ├── AuthController.java
│       │   │   ├── SOSController.java
│       │   │   └── CommunityController.java
│       │   ├── service/             # Business logic
│       │   │   ├── UserService.java
│       │   │   ├── SOSService.java
│       │   │   └── CommunityService.java
│       │   ├── model/               # Database entities
│       │   │   ├── User.java
│       │   │   ├── SOSIncident.java
│       │   │   ├── CommunityReport.java
│       │   │   ├── SafeZone.java
│       │   │   └── EmergencyContact.java
│       │   ├── repository/          # Data access layer
│       │   │   ├── UserRepository.java
│       │   │   ├── SOSIncidentRepository.java
│       │   │   ├── CommunityReportRepository.java
│       │   │   └── SafeZoneRepository.java
│       │   └── dto/                 # Data transfer objects
│       │       ├── UserDTO.java
│       │       ├── SOSIncidentDTO.java
│       │       ├── AuthRequest.java
│       │       └── AuthResponse.java
│       └── resources/
│           └── application.properties    # Configuration
├── Frontend/                         # Web Application
│   ├── index.html                   # Main UI
│   ├── SafeCircle.html              # Original UI (legacy)
│   ├── css/                         # Stylesheets
│   └── js/                          # JavaScript files
├── DataBase/
│   └── database.sql                 # MySQL schema
├── README.md                        # This file
└── .gitignore                       # Git ignore file
```

---

## 🚀 Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)**: Version 11 or higher
- **MySQL**: Version 5.7 or higher
- **Maven**: Version 3.6.0 or higher
- **Node.js**: Optional (for frontend development)
- **Git**: For version control

### Step 1: Database Setup

```bash
# Connect to MySQL
mysql -u root -p

# Create database
CREATE DATABASE safecircle;

# Use database
USE safecircle;

# Import schema
source DataBase/database.sql;
```

### Step 2: Backend Configuration

```bash
# Navigate to Backend directory
cd Backend

# Update database credentials in application.properties
# Edit: src/main/resources/application.properties
```

**Update these properties:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/safecircle
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
jwt.secret=your-secret-key-min-256-bits-for-production
```

### Step 3: Build & Run Backend

```bash
# Build project
mvn clean install

# Run application
mvn spring-boot:run

# Backend will run on: http://localhost:8080/api
```

### Step 4: Frontend Setup

```bash
# Open Frontend/index.html in browser
# Or serve using a local server:
cd Frontend
python -m http.server 8000

# Access at: http://localhost:8000
```

---

## 📱 API Endpoints

### Authentication
```
POST /api/auth/register
POST /api/auth/login
```

### SOS Emergency
```
POST /api/sos/trigger              # Trigger emergency
GET  /api/sos/active               # Get active incidents
GET  /api/sos/user/{userId}        # Get user incidents
POST /api/sos/resolve/{incidentId} # Resolve incident
POST /api/sos/false-alarm/{id}     # Mark as false alarm
```

### Community Reports
```
POST /api/community/report              # Create report
GET  /api/community/reports/risk/{level} # Get by risk level
GET  /api/community/reports/verified    # Get verified reports
GET  /api/community/reports/nearby      # Get nearby reports
POST /api/community/reports/{id}/upvote # Upvote report
POST /api/community/reports/{id}/verify # Verify report
```

---

## 🗄️ Database Schema

### Users Table
- Stores user profile information
- Encrypts passwords using BCrypt
- Tracks login history

### SOS Incidents Table
- Records all emergency calls
- Status: active, resolved, false_alarm
- Stores location and audio recordings

### Community Reports Table
- Crowdsourced safety reports
- Risk levels: low, medium, high, critical
- Supports anonymous reporting

### Safe Zones Table
- Police stations, hospitals, verified safe areas
- Safety score calculation
- Location-based queries

### Emergency Contacts Table
- User's emergency contact list
- Priority-based notification sending

---

## 🔐 Security Features

✅ Password encryption using BCrypt
✅ JWT token-based authentication
✅ Role-based access control
✅ SQL injection prevention via parameterized queries
✅ CORS configuration for frontend integration
✅ Input validation on all endpoints

---

## 🎨 Frontend Features

### User Interface
- **Responsive Design**: Works on mobile, tablet, and desktop
- **SOS Button**: Large, prominent emergency trigger
- **Real-time Alerts**: Toast notifications for actions
- **Dark/Light Mode**: Automatic theme detection
- **Accessibility**: WCAG 2.1 compliant

### Key Screens
1. **Login/Registration**: Secure user authentication
2. **Dashboard**: Overview of incidents and reports
3. **SOS Emergency**: One-tap emergency trigger
4. **Community Reports**: View and create safety reports
5. **Safe Zones**: Find nearby safe locations
6. **Emergency Contacts**: Manage contacts

---

## 💻 Key Technologies

### Backend
- **Spring Boot 3.1.5**: REST API framework
- **Spring Security**: Authentication & authorization
- **Spring Data JPA**: ORM for database access
- **MySQL**: Relational database
- **JWT**: Token-based authentication
- **Lombok**: Boilerplate code reduction

### Frontend
- **HTML5**: Semantic markup
- **CSS3**: Modern styling with animations
- **Vanilla JavaScript**: No framework dependencies
- **Geolocation API**: GPS tracking
- **Local Storage**: Client-side data persistence

### Database
- **MySQL 8.0**: Robust relational database
- **Spatial Queries**: Location-based searches

---

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### API Testing with Postman
1. Import API collection from `Backend/postman-collection.json`
2. Set environment variables
3. Run test suite

---

## 🚀 Deployment

### Docker Deployment

```dockerfile
# Dockerfile for Backend
FROM openjdk:11-jre-slim
COPY target/safecircle-backend-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Deploy to AWS/Azure
1. Build Docker image
2. Push to container registry
3. Deploy to App Service or EC2

---

## 📊 Use Cases

### Scenario 1: Emergency Response
1. User triggers SOS button
2. Automatic GPS location captured
3. SMS alerts sent to emergency contacts
4. Incident logged in real-time
5. Location shared with authorities

### Scenario 2: Community Risk Alert
1. User reports safety concern in area
2. Report shared with community
3. Other users can verify/upvote
4. Risk zone identified via ML
5. Community members alerted

### Scenario 3: Safe Zone Navigation
1. User requests nearby safe locations
2. System shows police stations, hospitals
3. Distance and route provided
4. Real-time updates on safety

---

## 🎓 Learning Resources

### For Beginners
- [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- [MySQL Tutorial](https://www.mysql.com/why-mysql/white-papers/)
- [HTML/CSS/JavaScript](https://developer.mozilla.org/en-US/)

### Advanced Topics
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT Authentication](https://jwt.io/introduction)
- [Microservices Architecture](https://microservices.io/)

---

## 🔮 Future Enhancements

- [ ] Mobile app (iOS/Android) using React Native
- [ ] Machine Learning for predictive risk analysis
- [ ] Real-time location tracking
- [ ] Integration with emergency services
- [ ] IoT device integration (smartwatch alerts)
- [ ] Video call support with contacts
- [ ] Push notifications
- [ ] Multi-language support

---

## 🤝 Contributing

We welcome contributions! Please:
1. Fork the repository
2. Create a feature branch
3. Commit changes with clear messages
4. Push to branch
5. Create Pull Request

---

## 📝 License

This project is licensed under the MIT License - see LICENSE file for details.

---

## 📞 Support & Contact

- **Author**: Sweta Jha (B.Tech CSE 2nd Year)
- **Email**: sweta@example.com
- **LinkedIn**: [Sweta Jha](https://linkedin.com)

---

## 🎉 Acknowledgments

- IEEE for organizing the hackathon
- All contributors and mentors
- The open-source community

---

## 📈 Project Status

✅ Core features completed
✅ Database schema finalized
✅ REST API endpoints implemented
✅ Frontend UI developed
🔄 Testing in progress
⏳ Deployment preparation

**Last Updated**: November 25, 2025
