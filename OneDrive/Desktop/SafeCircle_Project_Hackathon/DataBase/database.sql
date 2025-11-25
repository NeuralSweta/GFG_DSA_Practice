CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL,
    is_active BOOLEAN DEFAULT TRUE
);

-- Emergency Contacts Table
CREATE TABLE emergency_contacts (
    contact_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    contact_name VARCHAR(100) NOT NULL,
    contact_phone VARCHAR(15) NOT NULL,
    relationship VARCHAR(50),
    priority INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- SOS Incidents Table
CREATE TABLE sos_incidents (
    incident_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    address VARCHAR(255),
    status ENUM('active', 'resolved', 'false_alarm') DEFAULT 'active',
    trigger_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    resolved_time TIMESTAMP NULL,
    audio_recording VARCHAR(255),
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_user_status (user_id, status),
    INDEX idx_trigger_time (trigger_time)
);

-- Location Tracking Table (for active SOS)
CREATE TABLE location_tracking (
    tracking_id INT PRIMARY KEY AUTO_INCREMENT,
    incident_id INT NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    accuracy DECIMAL(5, 2),
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (incident_id) REFERENCES sos_incidents(incident_id) ON DELETE CASCADE,
    INDEX idx_incident_time (incident_id, recorded_at)
);

-- Community Reports Table
CREATE TABLE community_reports (
    report_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    risk_level ENUM('low', 'medium', 'high', 'critical') NOT NULL,
    incident_type VARCHAR(50),
    description TEXT,
    is_anonymous BOOLEAN DEFAULT FALSE,
    reported_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    verified BOOLEAN DEFAULT FALSE,
    upvotes INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE SET NULL,
    INDEX idx_location (latitude, longitude),
    INDEX idx_risk_time (risk_level, reported_at)
);

-- Safe Zones Table
CREATE TABLE safe_zones (
    zone_id INT PRIMARY KEY AUTO_INCREMENT,
    zone_name VARCHAR(100) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    radius INT DEFAULT 100,
    zone_type ENUM('police_station', 'hospital', 'verified_safe', 'community_marked') NOT NULL,
    safety_score DECIMAL(3, 2) DEFAULT 5.0,
    verified_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (verified_by) REFERENCES users(user_id) ON DELETE SET NULL,
    INDEX idx_location (latitude, longitude)
);

-- Risk Zones Table (AI-generated or community-identified)
CREATE TABLE risk_zones (
    risk_zone_id INT PRIMARY KEY AUTO_INCREMENT,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    radius INT DEFAULT 100,
    risk_score DECIMAL(3, 2) NOT NULL,
    incident_count INT DEFAULT 0,
    last_incident TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_location_risk (latitude, longitude, risk_score)
);

-- Notifications Log Table
CREATE TABLE notifications (
    notification_id INT PRIMARY KEY AUTO_INCREMENT,
    incident_id INT,
    contact_id INT,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delivery_status ENUM('sent', 'delivered', 'failed') DEFAULT 'sent',
    FOREIGN KEY (incident_id) REFERENCES sos_incidents(incident_id) ON DELETE CASCADE,
    FOREIGN KEY (contact_id) REFERENCES emergency_contacts(contact_id) ON DELETE CASCADE
);

-- User Check-ins Table
CREATE TABLE user_checkins (
    checkin_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    status ENUM('safe', 'need_help', 'emergency') DEFAULT 'safe',
    checkin_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_user_time (user_id, checkin_time)
);

-- Sample Data Insertion
INSERT INTO users (name, email, phone, password_hash) VALUES
('Sweta Jha', 'sweta@example.com', '9876543210', 'hashed_password_here'),
('Demo User', 'demo@example.com', '9876543211', 'hashed_password_here');

INSERT INTO safe_zones (zone_name, latitude, longitude, radius, zone_type, safety_score) VALUES
('Central Police Station', 28.6139, 77.2090, 200, 'police_station', 9.5),
('City Hospital', 28.6150, 77.2100, 150, 'hospital', 9.0),
('Metro Station Area', 28.6160, 77.2110, 300, 'verified_safe', 8.5);