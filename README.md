# Simple Banking System in Java

This project is a **Simple Banking System** built in Java. It allows users to create accounts, deposit money, withdraw funds, check their account balances, and manage their transactions through a user-friendly **Graphical User Interface (GUI)**.

---

## Features

- **Account Management**:
  - Create new accounts with unique account numbers.
  - View account details, including balance and transaction history.

- **Transactions**:
  - Deposit funds into an account.
  - Withdraw funds with balance validation.
  - View transaction history for detailed insights.

- **Error Handling**:
  - Ensures proper validation for all inputs (e.g., non-negative amounts).
  - Displays clear error messages for invalid actions (e.g., insufficient funds).

- **Intuitive GUI**:
  - Built using Java Swing for a clean, user-friendly interface.
  - Separate windows or panels for various operations.

---

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher).
- A code editor or IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code (optional).

### Steps to Run

1. **Download the Code**:
   - Clone the repository or download the source code file.

2. **Save the Source File**:
   - Save the code as `BankingSystem.java`.

3. **Compile and Run**:
   - Compile the Java file:
     ```bash
     javac BankingSystem.java
     ```
   - Run the program:
     ```bash
     java BankingSystem
     ```

4. The Banking System window will open, and you can start managing accounts and transactions.

---

## Code Structure

- **Main Class**: `BankingSystem`
  - Entry point for the application, initializing the GUI.
- **Components**:
  - `JFrame`: Main window for the application.
  - `JPanel`: Separate sections for account creation, transactions, and viewing balances.
  - `JTextField` and `JButton`: For user input and actions.

---

## Usage

1. **Create an Account**:
   - Enter account details and click "Create Account."
   - The system assigns a unique account number automatically.

2. **Perform Transactions**:
   - Deposit or withdraw funds by entering the account number and amount.
   - Ensure sufficient funds for withdrawals.

3. **Check Balances**:
   - Enter the account number to view the current balance and transaction history.

4. **Error Messages**:
   - Invalid inputs or actions (e.g., insufficient funds) display clear error prompts.

---

## Screenshots

### Main Menu
![Main Menu](https://github.com/user-attachments/assets/c0a1aa4d-595e-4860-a8fc-9b642781f787)


### Transaction Window
![Transaction Window](https://github.com/user-attachments/assets/df933f82-f24c-4be7-97b8-3e19cf46b111)


---

## Future Enhancements

- **Login System**: Add user authentication for account access.
- **Database Integration**: Replace in-memory storage with persistent database storage (e.g., MySQL or SQLite).
- **Enhanced Reporting**: Include monthly statements and exportable reports.

---

## License

This project is licensed under the MIT License. Feel free to use, modify, and distribute it.

---

## Contributing

Contributions are welcome! To contribute:
1. Fork the repository.
2. Make improvements or add features.
3. Submit a pull request with a detailed explanation of your changes.

---

## Author

Developed by **Shrey Varshney**  
Contact: shreyvarshney1@gmail.com  
