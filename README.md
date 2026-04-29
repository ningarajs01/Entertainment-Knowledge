# Entertainment-Knowledge
# 🎭 Entertainment Knowledge (UUCMS - Prototype)

### 🚀 Overview
"Entertainment Knowledge" ek experimental project hai jise **AI (Google Gemini)** aur **Human Developer** ne milkar ek team ki tarah build kiya hai. Ye project ek **University Unified College Management System (UUCMS)** ka prototype hai, jise testing aur learning purpose ke liye banaya gaya hai.

Is project ka main maqsad Java Swing aur JDBC (Oracle) ke beech ke "Action-Reaction" ko samajhna aur ek functional role-based management system khada karna tha.

### 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **GUI:** Java Swing & AWT
- **Database:** Oracle DB (11g/12c/19c)
- **Connector:** JDBC (ojdbc8.jar)

### ✨ Key Features
- **Role-Based Authentication:** Admin aur Student ke liye alag-alag access levels.
- **Admin Panel:** Student management, Attendance tracking, aur Fee updates.
- **Student Portal:** Personalized view jahan students apni fee status aur results check kar sakte hain.
- **Live Connection:** Oracle Database ke saath real-time data sync.

### 📂 Project Structure
- `src/`: Saari Java source files (`.java`).
- `lib/`: JDBC driver (`ojdbc8.jar`).
- `db/`: Database configuration aur table scripts.

### 🚦 How to Setup & Run
1. **Database Setup:** - Oracle SQL Plus mein `users`, `fees`, aur `results` table create karein.
   - `users` table mein 'role' column add karein (admin/student).
2. **Library Connection:** - `ojdbc8.jar` ko apne IDE (VS Code/Eclipse) ke referenced libraries mein add karein.
3. **Configuration:** - `DBConnection.java` mein apna local DB URL, Username aur Password update karein.
4. **Launch:** - `LoginFrame.java` ko run karein aur system mein entry maarein!

### 🤖 AI Collaboration
Ye project ek perfect misaal hai ki kaise AI ka istemal karke complex logical bugs ko solve kiya ja sakta hai aur ek raw idea ko professional software mein badla ja sakta hai. 

---
*Developed for Entertainment & Knowledge Purpose.*
