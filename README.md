# 🏢 Employee Management System

A web-based **Employee Management System** built using **Java Servlets**, **Apache Tomcat**, and **HTML**. This application allows you to manage employee records including adding and viewing employees with their project assignments.

---

## 📸 Preview

> All Employees listing page with employee details such as ID, Name, Type, and Project.

---

## 🚀 Features

- ✅ View all employees in a tabular format
- ✅ Add new employees via a registration form
- ✅ Display Employee ID, Name, Employment Type, and Project
- ✅ Dynamic employee count in the heading
- ✅ Servlet-based MVC architecture

---

## 🛠️ Tech Stack

| Layer        | Technology              |
|--------------|-------------------------|
| Backend      | Java Servlets (Jakarta EE) |
| Server       | Apache Tomcat 11.0.18   |
| Frontend     | HTML (generated via PrintWriter) |
| Build Tool   | Maven (`pom.xml`)       |
| IDE          | IntelliJ IDEA           |

---

## 📁 Project Structure

```
Employee-Project-Management/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── cfs/
│                   └── web/
│                       ├── Employee.java           # Employee model class
│                       ├── EmployeeListServlet.java # Lists all employees
│                       ├── EmployeeRegServlet.java  # Handles employee registration
│                       ├── Driver.java              # Data source / list provider
│                       ├── BackendProject.java      # Project type: Backend
│                       ├── DevopsProject.java       # Project type: DevOps
│                       ├── FrontendProject.java     # Project type: Frontend
│                       └── Project_Assign.java      # Project assignment logic
├── src/
│   └── main/
│       └── webapp/
│           ├── index.html      # Add Employee form
│           └── web.xml         # Servlet mappings
└── pom.xml                     # Maven build configuration
```

---

## 👨‍💼 Sample Employee Data

| # | Emp ID | Name           | Type      | Project       |
|---|--------|----------------|-----------|---------------|
| 1 | 234    | Sagar Pawase   | Full Time | Book-my-show  |
| 2 | 123    | Kiran Dhonnar  | Part Time | DevOps        |
| 3 | 111    | Sam Binnar     | Hybrid    | Backend       |
| 4 | 1      | Vishal Sahane  | Full Time | Frontend      |

---

## ⚙️ Getting Started

### Prerequisites

- Java JDK 8 or higher
- Apache Tomcat 10+ (project uses Tomcat 11.0.18)
- Maven
- IntelliJ IDEA (recommended) or any Java IDE

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/Employee-Project-Management.git
   cd Employee-Project-Management
   ```

2. **Open in IntelliJ IDEA**
   - File → Open → Select the project folder
   - Wait for Maven to resolve dependencies

3. **Configure Tomcat in IntelliJ**
   - Go to **Run → Edit Configurations**
   - Click `+` → **Tomcat Server → Local**
   - Set your Tomcat installation path
   - Under **Deployment**, add the project artifact (`.war` or exploded)

4. **Run the Application**
   - Click the **Run** button or press `Shift + F10`
   - Tomcat will start on port **8080**

5. **Access the Application**
   ```
   http://localhost:8080/Employee-Project-Management
   ```

---

## 🔗 Application URLs

| Page                    | URL                                                                   |
|-------------------------|-----------------------------------------------------------------------|
| Add Employee Form       | `http://localhost:8080/Employee-Project-Management/index.html`        |
| View All Employees      | `http://localhost:8080/Employee-Project-Management/employee`          |
| Register New Employee   | `http://localhost:8080/Employee-Project-Management/employee-reg`      |

---

## 📌 Servlet Mapping (Annotation-based)

This project uses **`@WebServlet` annotations** directly on the Servlet classes instead of `web.xml` mappings.

```java
// EmployeeListServlet.java — View all employees
@WebServlet("/employee")
public class EmployeeListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // renders employee list as HTML table
    }
}

// EmployeeRegServlet.java — Register a new employee
@WebServlet("/employee-reg")
public class EmployeeRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // handles form submission and adds employee to list
    }
}
```

---

## 🔄 How It Works

1. **`index.html`** — Displays the **Employee-Management-System Form** with four fields:
   - `EmpID` — Employee ID (numeric)
   - `EmpName` — Full name of the employee
   - `EmpType` — Employment type (Full Time / Part Time / Hybrid)
   - `Project` — Assigned project name
   - Submits via `POST` to `/employee-reg`, with a **"View Employee"** link to `/employee`

2. **`EmployeeRegServlet` (`@WebServlet("/employee-reg")`)**  
   Handles `POST` from the form → creates an `Employee` object → adds it to the shared list in `Driver` → redirects to `/employee`.

3. **`EmployeeListServlet` (`@WebServlet("/employee")`)**  
   Handles `GET` → fetches employee list from `Driver` → renders a dynamic HTML table showing all employees with a count in the heading.

4. **`Driver`** — Acts as an in-memory data store (static list), holding all employee records for the session.

---

## 🧩 Key Classes

### `Employee.java`
Model class with fields: `empId`, `empName`, `empType`, `project`.

### `EmployeeListServlet.java`
```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    resp.setContentType("text/html");
    List<Employee> list = getList();
    PrintWriter out = resp.getWriter();
    out.println("<html><body>");
    out.println("<h2>All Employees (" + list.size() + ")</h2>");
    // renders HTML table...
}
```

---

## 🛣️ Future Enhancements

- [ ] Connect to a relational database (MySQL / PostgreSQL)
- [ ] Add Edit and Delete functionality for employees
- [ ] Use JSP + JSTL instead of inline HTML in Servlets
- [ ] Implement proper MVC with a DAO layer
- [ ] Add input validation and error handling
- [ ] Style with Bootstrap or Tailwind CSS

---

## 👤 Author

**Rushikesh Sahane**  
📧 rushikeshsahane2000@gmail.com  
🔗 [GitHub](https://github.com/rushi-sahane2000)

---
