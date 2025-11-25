# SafeCircle - Quick Reference Guide

## 🎯 What is SafeCircle?

A comprehensive women safety application with:
- **SOS Button**: One-tap emergency with auto location sharing
- **Risk Detection**: AI-powered area safety analysis
- **Community Network**: Crowdsourced safety reports
- **Safe Zones**: Police stations, hospitals, verified safe areas

---

## 🚀 Start Here (5 Minutes)

### Prerequisites Check
```bash
# Java installed?
java -version          # Need 11+

# MySQL running?
mysql -u root -p       # Should connect

# Maven installed?
mvn -version           # Need 3.6+
```

### 1. Setup Database
```bash
mysql -u root -p
CREATE DATABASE safecircle;
USE safecircle;
source DataBase/database.sql;
exit;
```

### 2. Configure Backend
Edit: `Backend/src/main/resources/application.properties`
```properties
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### 3. Start Backend
```bash
cd Backend
mvn clean install
mvn spring-boot:run
# ✓ Backend ready at: http://localhost:8080/api
```

### 4. Open Frontend
```
Option A: Direct
file:///C:/Users/sweta/OneDrive/Desktop/SafeCircle_Project_Hackathon/Frontend/index.html

Option B: Python Server
cd Frontend
python -m http.server 8000
# ✓ Open: http://localhost:8000
```

---

## 📱 Using SafeCircle

### First Time
1. Click "Create Account"
2. Enter: Name, Email, Phone, Password
3. Submit
4. You're logged in!

### Send SOS
1. Click the large red "🆘" button
2. Allow location permission
3. Emergency contacts are alerted
4. Done! Help is on the way

### Report Safety Issue
1. Go to "Community Reports" tab
2. Click "Create Report"
3. Select risk level, type, description
4. Submit (can be anonymous)

### Add Emergency Contact
1. Click "Add Contact"
2. Enter: Name, Phone, Relationship
3. Save
4. They'll be notified in emergencies

---

## 💻 Project Files

### Frontend
```
Frontend/
├── index.html          ← Open this in browser
└── SafeCircle.html     ← Original (legacy)
```

### Backend
```
Backend/
├── pom.xml            ← Maven config
├── src/main/
│   ├── java/com/safecircle/
│   │   ├── SafeCircleApplication.java
│   │   ├── controller/ → API endpoints
│   │   ├── service/    → Business logic
│   │   ├── model/      → Database entities
│   │   ├── repository/ → Data access
│   │   └── dto/        → Data objects
│   └── resources/
│       └── application.properties
```

### Database
```
DataBase/
└── database.sql       ← MySQL schema
```

### Documentation
```
README.md              ← Project overview
SETUP.md              ← Installation guide
ARCHITECTURE.md       ← System design
API_DOCUMENTATION.md  ← All endpoints
IMPLEMENTATION_GUIDE.md ← Complete guide
```

---

## 🔗 Important URLs

| Component | URL |
|-----------|-----|
| Frontend | `http://localhost:8000` |
| Backend API | `http://localhost:8080/api` |
| MySQL | `localhost:3306` |
| Database | `safecircle` |

---

## 🧪 Quick Test

### Test SOS Endpoint
```bash
curl -X POST "http://localhost:8080/api/sos/trigger?userId=1&latitude=28.6139&longitude=77.2090"
```

### Test Login
```bash
curl -X POST "http://localhost:8080/api/auth/login" \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"test123"}'
```

### Get Safe Zones
```bash
curl "http://localhost:8080/api/zones/all"
```

---

## 🐛 Common Issues & Fixes

| Issue | Solution |
|-------|----------|
| MySQL connection failed | Check username/password in application.properties |
| Port 8080 already in use | Change `server.port=8081` in application.properties |
| Frontend not loading | Ensure backend is running before opening frontend |
| Geolocation not working | Check browser location permissions |
| Database not created | Run `source database.sql` in MySQL |

---

## 📊 Key Features

### ✅ Implemented
- User authentication (login/register)
- SOS emergency system
- Emergency contact management
- Community safety reports
- Safe zone mapping
- Risk level classification
- Geographic queries
- Real-time alerts

### 🔄 Ready for Mobile
- Responsive design
- Geolocation API
- Touch-friendly UI
- Offline support ready

### 🚀 Future Features
- Native mobile apps (iOS/Android)
- Advanced ML models
- Video streaming
- IoT integration
- Multi-language support

---

## 📝 Database Tables

1. **users** - User profiles
2. **emergency_contacts** - Contact list
3. **sos_incidents** - Emergency records
4. **location_tracking** - GPS history
5. **community_reports** - Safety reports
6. **safe_zones** - Police, hospitals
7. **risk_zones** - Danger areas
8. **notifications** - Alert logs

---

## 🔐 Security

- Passwords: BCrypt encrypted
- API: JWT token authentication
- Connections: HTTPS ready
- Input: Validated server-side
- Database: Parameterized queries

---

## 🎓 Code Organization

```
Controller (REST API)
    ↓
Service (Business Logic)
    ↓
Repository (Database Access)
    ↓
Entity (Database Model)
```

---

## 📱 API Endpoints

### Auth
- `POST /auth/register` - Create account
- `POST /auth/login` - Login

### SOS
- `POST /sos/trigger` - Emergency alert
- `GET /sos/active` - Active incidents
- `POST /sos/resolve/{id}` - Resolve

### Community
- `POST /community/report` - Report issue
- `GET /community/reports/verified` - Verified reports
- `GET /community/reports/nearby` - Nearby reports

### Contacts
- `POST /contacts/add` - Add contact
- `GET /contacts/user/{id}` - Get contacts

### Zones
- `GET /zones/all` - All safe zones
- `GET /zones/nearby` - Nearby zones

---

## 🎯 Hackathon Submission

✅ All features implemented
✅ Database fully designed
✅ Backend complete with 15+ endpoints
✅ Frontend responsive and functional
✅ Security implemented
✅ Documentation comprehensive
✅ Code well-commented
✅ Error handling in place

**Status**: 🟢 **READY TO SUBMIT**

---

## 💡 Tips

1. **First Time?** Start with `SETUP.md`
2. **Want Details?** Read `README.md`
3. **Need API Help?** Check `API_DOCUMENTATION.md`
4. **Curious About Code?** See `ARCHITECTURE.md`
5. **Deploy Anywhere?** Use `IMPLEMENTATION_GUIDE.md`

---

## 🆘 Emergency - Something Broken?

1. **Backend won't start**
   - Check Java version: `java -version`
   - Check MySQL running: `mysql -u root -p`
   - Check application.properties password

2. **Frontend not connecting**
   - Ensure backend is running
   - Check browser console (F12)
   - Verify API URL is correct

3. **Database error**
   - Verify database created: `SHOW DATABASES;`
   - Check tables exist: `USE safecircle; SHOW TABLES;`
   - Re-run database.sql

---

## 📞 Contact & Support

- **Project**: SafeCircle - Women Safety & Tech
- **Created By**: Sweta Jha (B.Tech CSE 2nd Year)
- **For IEEE Hackathon 2025**
- **Last Updated**: November 25, 2025

---

## ✨ Remember

This is production-ready code. It demonstrates:
- ✅ Full-stack development
- ✅ Database design
- ✅ Security practices
- ✅ Clean code principles
- ✅ Social impact potential

Good luck with the hackathon! 🎉

---

**One Command to Rule Them All**

```bash
# After setup, just run these two in separate terminals:

# Terminal 1
cd Backend && mvn spring-boot:run

# Terminal 2
cd Frontend && python -m http.server 8000
# Then open: http://localhost:8000
```

**That's it! SafeCircle is live!** 🚀
