# Bank Management System (ATM Simulator)

[![GitHub Pages](https://img.shields.io/badge/Live_Demo-GitHub_Pages-blue?style=for-the-badge&logo=github)](https://abhishekishere014-git.github.io/bank-management-system/)
[![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)](https://www.java.com/)
[![License](https://img.shields.io/badge/Project-BCA_Final_Year-brightgreen?style=for-the-badge)](#)

A desktop-based **Bank Management System and Automated Teller Machine (ATM) Simulator** application developed for BCA Final Year Project using **Java Swing, AWT, and JDBC**.

🌐 **Live Project Website & Web Demo:**  
👉 **[https://abhishekishere014-git.github.io/bank-management-system/](https://abhishekishere014-git.github.io/bank-management-system/)**

---

## 📌 Features
- **User Authentication:** Login with Card Number and 4-digit PIN.
- **Account Registration:** 3-step signup wizard capturing personal details, KYC (PAN & Aadhaar), and facility choices.
- **Cash Deposit:** Real-time credit to user balance with transaction logging.
- **Cash Withdrawal:** Balance validation and cash debit.
- **Fast Cash:** One-click instant withdrawal amounts (₹100, ₹500, ₹1000, ₹5000, etc.).
- **Mini Statement:** View recent transaction history with running balance.
- **PIN Change:** Secure update of user PIN.
- **Dual Database Support:** Runs on SQLite out-of-the-box (zero configuration needed), or MySQL for academic submission.

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **GUI Framework:** Java Swing & AWT
- **Database:** SQLite / MySQL
- **Connectivity:** JDBC (Java Database Connectivity)

---

## 🚀 How to Run

### Option 1: Quick Run (Windows)
Double-click `run.bat` in the root folder.

### Option 2: Command Line
```bash
# Compile
javac -cp "lib/sqlite-jdbc.jar;lib/jcalendar-1.4.jar;src" -d bin src/bank/management/system/*.java

# Run
java -cp "bin;lib/sqlite-jdbc.jar;lib/jcalendar-1.4.jar" bank.management.system.Login
```

---

## 🔑 Demo Login Credentials
- **Card Number:** `5040936012345678`
- **PIN:** `1234`
- *(Preloaded Opening Balance: ₹10,000)*

