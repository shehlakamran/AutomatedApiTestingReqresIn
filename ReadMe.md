# API Automation Framework – ReqRes.in (Java 22 + Rest Assured + TestNG)

## 📌 Project Repository
GitHub Repository: **https://github.com/shehlakamran/AutomatedApiTestingReqresIn**

---

## 🧩 Overview
This project demonstrates API automation using **Java 22**, **Rest Assured**, and **TestNG**.  
It covers complete CRUD testing of the public API service **ReqRes.in**, following a clean and modular automation framework.

The automated scenarios include:
- Get All Users
- Get Single User
- Create User (POST)
- Update User (PUT)
- Delete User (DELETE)

---

## ⚙️ Tech Stack
| Component | Description |
|----------|-------------|
| **Language** | Java 22 |
| **Build Tool** | Maven |
| **Testing Framework** | TestNG |
| **API Automation Library** | Rest Assured |
| **IDE** | IntelliJ IDEA / Eclipse |
| **Version Control** | Git + GitHub |

---


---

## 🚀 Automated API Scenarios

| Scenario | Method | Endpoint |
|----------|--------|----------|
| **Get All Users** | GET | `/api/users?page=2` |
| **Get Single User** | GET | `/api/users/{id}` |
| **Create User** | POST | `/api/users` |
| **Update User** | PUT | `/api/users/{id}` |
| **Delete User** | DELETE | `/api/users/{id}` |

Each test validates:
- Status codes
- Response body
- JSON fields
- Response time
- Headers

---

## 🧪 How to Run Tests

### 1. Clone the repository
```bash
git clone https://github.com/shehlakamran/AutomatedApiTestingReqresIn.git
