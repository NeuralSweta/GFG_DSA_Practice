# SafeCircle - Setup Instructions

## Quick Start Guide

### For Windows Users

#### 1. Install MySQL
```cmd
# Download from https://dev.mysql.com/downloads/mysql/
# Run installer and set password for root user
# Default password: root
```

#### 2. Create Database
```cmd
# Open Command Prompt
mysql -u root -p

# In MySQL terminal:
CREATE DATABASE safecircle;
USE safecircle;
source "C:\Users\sweta\OneDrive\Desktop\SafeCircle_Project_Hackathon\DataBase\database.sql";
```

#### 3. Install Java & Maven
```cmd
# Download JDK 11+ from https://www.oracle.com/java/technologies/downloads/
# Download Maven from https://maven.apache.org/download.cgi

# Verify installation:
java -version
mvn -version
```

#### 4. Build Backend
```cmd
cd "C:\Users\sweta\OneDrive\Desktop\SafeCircle_Project_Hackathon\Backend"

# Update application.properties with your MySQL password
notepad src\main\resources\application.properties

# Build
mvn clean install

# Run
mvn spring-boot:run
```

#### 5. Access Frontend
```cmd
# Open in browser:
file:///C:/Users/sweta/OneDrive/Desktop/SafeCircle_Project_Hackathon/Frontend/index.html

# Or use Python server:
cd "C:\Users\sweta\OneDrive\Desktop\SafeCircle_Project_Hackathon\Frontend"
python -m http.server 8000
# Visit: http://localhost:8000
```

---

## API Endpoints Reference

### Start backend first:
```
Backend: http://localhost:8080/api
Frontend: http://localhost:8000
```

### Test SOS Endpoint:
```bash
curl -X POST "http://localhost:8080/api/sos/trigger?userId=1&latitude=28.6139&longitude=77.2090"
```

---

## Troubleshooting

### MySQL Connection Issues
- Check username and password in `application.properties`
- Ensure MySQL service is running: `services.msc`

### Port Already in Use
- Change port in `application.properties`: `server.port=8081`
- Or kill process: `netstat -ano | findstr :8080`

### Frontend Not Loading
- Check browser console for errors (F12)
- Verify API base URL in `index.html`

---

## Development Tips

1. **Hot Reload**: Use Spring DevTools for automatic reload
2. **Database Debugging**: Use MySQL Workbench
3. **API Testing**: Use Postman collection (if available)
4. **Frontend Debugging**: Use browser DevTools

---

## Next Steps

After setup:
1. ✅ Create test user account
2. ✅ Test SOS button functionality
3. ✅ Create community reports
4. ✅ Add emergency contacts
5. ✅ Verify location services work

---

For more help, refer to `README.md`
