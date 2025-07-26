<h1>📚 Library Management System (Java Console App)</h1>

<p>
  A simple yet functional <strong>Library Management System</strong> built using <strong>Java</strong>. This is a console-based application designed to manage books and users in a library. It supports basic operations like adding/removing books, issuing/returning books, and managing registered users.
</p>

<hr />

<h2>🚀 Features</h2>
<ul>
  <li>Add and remove books from the library</li>
  <li>Register new users with unique ID</li>
  <li>Issue books to users (with book availability check)</li>
  <li>Return books from users</li>
  <li>Display all books with status (Issued / Available)</li>
  <li>Display all users along with count of borrowed books</li>
  <li>Enforces a borrowing limit (e.g., max 3 books per user)</li>
</ul>

<hr />

<h2>🛠️ Tech Stack</h2>
<ul>
  <li><strong>Language:</strong> Java</li>
  <li><strong>Environment:</strong> Console-based (CLI)</li>
  <li><strong>Concepts Used:</strong> OOP (Classes, Objects), ArrayLists, Loops, Conditionals, Scanner for input</li>
</ul>

<hr />

<h2>📂 Project Structure</h2>
<ul>
  <li><code>Book</code> – Represents a book (name, ID, status)</li>
  <li><code>User</code> – Represents a user (name, ID, list of borrowed books)</li>
  <li><code>Library</code> – Manages book collection and issue/return logic</li>
  <li><code>Library_Management</code> – Main class with menu-driven console interface</li>
</ul>

<hr />

<h2>📸 Demo</h2>
<pre>
=======================================
  WELCOME TO LIBRARY MANAGEMENT SYSTEM
=======================================
--------------- MENU ---------------
1: Add a book
2: Remove a book
3: Issue a book to a user
4: Return a book from a user
5: Register new user
6: View all books
7: View all registered users
8: Exit
</pre>

<hr />

<h2>✅ How to Run</h2>
<ol>
  <li>Clone the repository</li>
  <li>Compile all Java files</li>
  <li>Run the <code>Library_Management</code> main class</li>
</ol>

<pre>
javac Library_Management.java
java Library_Management
</pre>

<hr />

<h2>📌 Notes</h2>
<ul>
  <li>Currently uses in-memory storage (no file or DB persistence)</li>
  <li>Designed for learning purposes and can be extended with GUI or database</li>
</ul>

<hr />

