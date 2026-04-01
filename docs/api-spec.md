# 🏠 HomeServ – On-Demand Service Marketplace (PWA)

HomeServ is a scalable, real-time service marketplace platform that connects users with nearby service providers (electricians, plumbers, appliance repair, etc.) for immediate or scheduled services.

This project follows a **visiting-fee-based model**, where users pay only for inspection, and the actual service (repairs, spare parts) is handled offline between the user and provider.

The platform is built as a **Progressive Web App (PWA)** using modern technologies and a **production-grade microservices architecture**.

---

## 🚀 Features

### 👤 User Features

* Book services (Immediate / Scheduled)
* Real-time provider matching
* Secure OTP-based service start
* Online payment for visiting fee
* Track booking status
* Rate & review providers
* Installable PWA (Add to Home Screen)

---

### 👷 Provider Features

* Register with Aadhaar-based verification (mocked)
* Submit documents & service details
* Receive real-time booking requests
* Accept/reject jobs instantly
* OTP verification at service location
* Earn via visiting fees + offline services

---

## 💡 Business Model

* Users pay a **fixed visiting fee** (e.g., ₹200)
* Platform takes **20–30% commission**
* Remaining amount goes to the provider
* Actual service cost is handled **offline**

---

## 🧭 Booking Lifecycle

```
CREATED
   ↓
PAID
   ↓
SEARCHING_PROVIDER
   ↓
ACCEPTED
   ↓
STARTED (OTP Verified)
   ↓
COMPLETED

OR

SEARCHING_PROVIDER → EXPIRED → REFUNDED
```

---

## ⚡ Immediate Booking Flow

1. User requests service
2. System finds nearby providers (Redis Geo search)
3. Booking request sent in real-time
4. First provider accepts
5. User completes payment
6. Service starts with OTP verification

---

## 🏗️ Architecture Overview

```
Frontend (PWA - User & Provider)
        ↓ REST
API Gateway (Spring Cloud Gateway)
        ↓
---------------------------------------------------
| Auth Service                                    |
| User Service                                    |
| Provider Service                                |
| Booking Service                                 |
| Matching Service (Redis Geo + Real-time)        |
| Payment Service                                 |
| Notification Service                            |
| Verification Service (Aadhaar Mock)             |
---------------------------------------------------
        ↓
Internal Communication → gRPC
        ↓
Event Streaming → Kafka
        ↓
PostgreSQL + Redis
```

---

## ⚙️ Tech Stack

### 🎯 Frontend (PWA)

* React + TypeScript + Vite
* Tailwind CSS
* Zustand (state management)
* Axios (API communication)
* vite-plugin-pwa

---

### ⚙️ Backend

* Java + Spring Boot (Microservices)
* Spring Cloud Gateway
* Spring Security + JWT
* REST APIs (external communication)
* gRPC (internal communication)

---

### 📡 Messaging

* Apache Kafka (event-driven architecture)

---

### ⚡ Real-time & Caching

* Redis (caching + geo-location search)
* WebSocket (live updates)

---

### 🗄️ Database

* PostgreSQL

---

### 💳 Payments

* Razorpay (visiting fee payment)

---

## 🔌 Communication Design

### REST (External APIs)

* Frontend → API Gateway
* Used for:

  * Authentication
  * Booking creation
  * Payment initiation

---

### gRPC (Internal Communication)

* Booking → Provider (availability check)
* Booking → User (validation)
* Payment → Booking (status update)
* Verification → Provider

---

### Kafka (Event-Driven)

**Topics:**

```
booking.created
booking.accepted
provider.verified
payment.success
notification.trigger
```

---

## 🧩 Microservices

* **API Gateway** – Entry point, routing, security
* **Auth Service** – OTP login, JWT generation
* **User Service** – User profile management
* **Provider Service** – Provider onboarding & status
* **Verification Service** – Aadhaar verification (mocked)
* **Booking Service** – Booking lifecycle & OTP handling
* **Matching Service** – Nearby provider discovery
* **Payment Service** – Razorpay integration & webhooks
* **Notification Service** – SMS/Email/Push notifications

---

## 📂 Project Structure

```
HomeServ_Project/
│
├── backend/
│   ├── api-gateway/
│   ├── auth-service/
│   ├── user-service/
│   ├── provider-service/
│   ├── booking-service/
│   ├── matching-service/
│   ├── payment-service/
│   ├── notification-service/
│   ├── verification-service/
│   ├── proto/
│   └── common-lib/
│
├── frontend/
│   ├── user-app/
│   └── provider-app/
│
├── infrastructure/
│   ├── docker/
│   ├── kubernetes/
│   ├── kafka/
│   ├── postgres/
│   ├── redis/
│
├── docs/
│   ├── architecture.md
│   ├── api-spec.md
│   ├── kafka-events.md
│
└── README.md
```

---

## 🔐 Security Features

* JWT-based authentication
* Role-based access (USER, PROVIDER, ADMIN)
* OTP-based service start verification
* Aadhaar data masking (for demo purposes)
* Secure payment integration

---

## 📱 Progressive Web App (PWA)

* Installable on mobile (Add to Home Screen)
* Offline support (basic caching)
* Fast loading & responsive design
* Push notifications (future enhancement)

---

## 🚀 Future Enhancements

* AI-based provider matching
* Push notifications (Firebase)
* Wallet system
* Admin dashboard
* Real-time tracking (maps)
* Native mobile app (Capacitor / React Native)

---

## 📌 Project Status

🚧 Currently in **MVP Development Phase**

---

## 👨‍💻 Author

**Deenadhayalan M**

---

## ⭐ Support

If you like this project, please ⭐ the repository!

---

## 🤝 Contribution

Contributions are welcome!
Feel free to fork the repo and submit pull requests.
