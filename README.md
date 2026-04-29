# 🎭 Entertainment Knowledge (UUCMS - Prototype)

### 🌟 Project Vision
**Entertainment Knowledge** is a professional prototype of a **University Unified College Management System (UUCMS)**. Developed through a strategic collaboration between a **Human Developer** and **AI (Google Gemini)**, this project serves as a comprehensive case study in building robust, role-based desktop applications using Java.

The primary objective was to master the full lifecycle of a database-driven application, focusing on the seamless integration between **Java Swing** and **Oracle Database**.

---

### 🛠️ Technical Stack
* **Core Language:** Java (JDK 8 or higher)
* **User Interface:** Java Swing & AWT (Event-driven Architecture)
* **Database:** Oracle Database (11g/12c/19c compatible)
* **Middleware:** JDBC (Java Database Connectivity)
* **Driver:** ojdbc8.jar

---

### 🚀 Key Functional Modules
* **Role-Based Access Control (RBAC):** A secure authentication gateway that differentiates between **Administrative** and **Student** dashboards.
* **Admin Command Center:** Enables full management of student records, real-time attendance logging, and financial (fee) auditing.
* **Student Self-Service Portal:** A specialized read-only interface allowing students to securely monitor their own academic results and fee status.
* **Data Integrity:** Implements rigorous data handling to ensure real-time synchronization between the UI and the Oracle backend.

---

### 📂 Project Architecture
```text
Entertainment-Knowledge/
├── src/com/uucms/ui/      # GUI Components & Frames
├── src/com/uucms/config/  # Database Connection Logic
├── src/com/uucms/dao/     # Data Access Objects
├── lib/                   # External Dependencies (ojdbc8.jar)
└── README.md              # Project Documentation
