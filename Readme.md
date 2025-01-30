# 🗳️ Voting System Project

## 📚 Table of Contents
- [📖 Project Overview](#project-overview)
- [✨ Features](#features)
- [💻 Technologies Used](#technologies-used)
- [🚀 Getting Started](#getting-started)
- [🛠️ Usage Instructions](#usage-instructions)
- [🏗️ Class Descriptions](#class-descriptions)
- [🔮 Future Improvements](#future-improvements)
- [📜 License](#license)

## 📖 Project Overview
This project implements an **Online Voting System** in Java. It allows users to cast votes for various political parties and candidates while enabling administrators to manage and monitor the voting process. The system is designed for a specific election day and ensures that voters can only vote once.

## ✨ Features
- **🧑‍⚖️ User Mode:**
    - ✅ Cast votes on the specified election date.
    - 🗂️ View a list of candidates and parties.
    - 🚫 Prevents duplicate voting by verifying Voter IDs.

- **🛡️ Admin Mode:**
    - 📊 View vote counts for each candidate.
    - ➕ Add or ➖ remove candidates and parties.
    - 👤 View details of voters who have cast votes.

- **🛡️ Data Validation:**
    - ✅ Ensures valid input for voter IDs.
    - ⚠️ Provides error handling for invalid entries.

## 💻 Technologies Used
- **Programming Language:** ☕ Java
- **Date Handling:** 🗓️ `SimpleDateFormat`
- **Data Structures:** 📚 ArrayLists, HashSets
- **Development Environment:** 🛠️ IntelliJ IDEA

## 🚀 Getting Started

### Prerequisites
- ☑️ Java Development Kit (JDK) 8 or higher
- 🛠️ IntelliJ IDEA (optional but recommended)

### Setup
1. 🔄 Clone the repository or download the project files.
2. 🖥️ Open the project in IntelliJ IDEA.
3. ▶️ Compile and run the `votingsystem` class.

## 🛠️ Usage Instructions

### 🧑‍⚖️ User Mode
1. Select the **USER** option.
2. ✍️ Enter your **full name** and a **10-digit voter ID**.
3. 📅 If the election date matches today's date, proceed to vote.
4. 🗳️ Choose your preferred candidate from the list.
5. ✅ Confirm your vote and exit.

### 🛡️ Admin Mode
1. Select the **ADMIN** option.
2. 🔑 Enter the credentials (default username and password: `Admin123`).
3. Perform the following operations:
    - 📊 View vote counts.
    - ➕ Add or ➖ remove candidates and parties.
    - 👤 View voter details.

### ❌ Exit
Select the `EXIT` option to terminate the program.

## 🏗️ Class Descriptions

### `votingsystem`
The main class that initializes the application and handles the user and admin workflows.

### `Voter`
Encapsulates voter details, including the voter's name and ID.

- **Methods:**
    - `display1()`: ✅ Displays voter login success message.

### `Login2`
Handles the admin functionalities.

- **Methods:**
    - `display2()`: ⚙️ Manages candidate and party operations.
    - `display3()`: 📋 Displays voter details.

## 🔮 Future Improvements
- 💾 Persistent storage for voter data and vote counts.
- 🔐 Enhanced user authentication.
- 📆 Support for multiple election dates.
- 🖥️ Improved user interface.

## 📜 License
This project is open-source and available under the MIT License.

