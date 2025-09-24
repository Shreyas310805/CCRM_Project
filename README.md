<<<<<<< HEAD
Project Overview & How to Run- The Campus Course & Records Manager (CCRM) is a comprehensive, console-based application developed using Java SE. It's designed to serve as a robust system for an educational institute to manage its core academic operations, including student information, course catalogs, enrollments, and grading.

Prerequisites- Java Development Kit (JDK): Version 17 or later
=======
Project Overview & How to Run-
The Campus Course & Records Manager (CCRM) is a comprehensive, console-based application developed using Java SE. It's designed to serve as a robust system for an educational institute to manage its core academic operations, including student information, course catalogs, enrollments, and grading.

Prerequisites-
Java Development Kit (JDK): Version 17 or later
>>>>>>> b9425a2ddb06083c6bf5ed3d07b34c56e3df7b2e

IDE: Eclipse, IntelliJ IDEA, or VS Code with Java extensions

How to Run-
<<<<<<< HEAD

1\. Clone the Repository:  
   git clone \<your-repository-link\>  
   cd \<repository-folder\>

2\. Open in IDE:

(a). Open your IDE (e.g., Eclipse).

(b). Select File \> Open Projects from File System... or Import... \> Existing Maven/Gradle Project.

(c). Navigate to and select the cloned repository folder.

3\. Run the Application:

(a). Locate the main class, which should be in a file like edu/ccrm/cli/Main.java.

(b). Right-click on the Main.java file and select Run As \> Java Application.

4\. Run from Command Line (Optional):

(a). Navigate to the project's source directory.

(b). Compile the code:  
	javac \-d out edu/ccrm/cli/Main.java

(c). Run the compiled code:  
	java \-cp out edu.ccrm.cli.Main

Evolution of Java:

1\. JDK 1.0 (1996): The initial release of Java, codenamed "Oak."

2\. J2SE 1.2 (1998): Introduced the Swing GUI toolkit, the Collections Framework, and the JIT (Just-In-Time) compiler.

3\. J2SE 5.0 (2004): A major update that added Generics, Enums, Autoboxing, and Annotations.

4\. Java SE 8 (2014): A landmark release introducing Lambda Expressions, the Stream API, a new Date and Time API, and default methods in interfaces.

5\. Java SE 11 (2018): The first Long-Term Support (LTS) release after the new six-month release cadence. Added the var keyword for local variables.

6\. Java SE 17 (2021): The next LTS release, which brought Sealed Classes and refined Pattern Matching.

7\. Java SE 21 (2023): The latest LTS release, introducing major features like Virtual Threads (Project Loom), Record Patterns, and Sequenced Collections.

Java ME vs SE vs EE Comparison-

Java SE-

Primary Use- Core Java platform for desktop and server applications.

Core API- The foundation of the Java language (java.lang, java.util, etc.).

Example APIs- Swing, Collections, Stream API, NIO.2

Target Audience	General- purpose developers.

Java EE-

Primary Use- For large-scale, web-based, enterprise applications.

Core API- Built on top of Java SE, adds APIs for web services, servlets, etc.

Example APIs- Servlets, JSP, EJB, JPA, RESTful web services (JAX-RS)

Target Audience General- Enterprise application developers.

Java ME-

Primary Use- For resource-constrained and embedded devices (IoT, older phones).

Core API- A strict subset of the Java SE API, optimized for small memory.

Example APIs- CLDC (Connected Limited Device Configuration), MIDP (Mobile Information Device Profile

Target Audience General- Embedded systems developers.
=======
    
	1. Clone the Repository:
       git clone <your-repository-link>
       cd <repository-folder>
    
    2. Open in IDE:

	(a). Open your IDE (e.g., Eclipse).

	(b). Select File > Open Projects from File System... or Import... > Existing Maven/Gradle Project.

	(c). Navigate to and select the cloned repository folder.

    3. Run the Application:

	(a). Locate the main class, which should be in a file like edu/ccrm/cli/Main.java.

	(b). Right-click on the Main.java file and select Run As > Java Application.

    4. Run from Command Line (Optional):

	(a). Navigate to the project's source directory.

	(b). Compile the code:
		javac -d out edu/ccrm/cli/Main.java
	
	(c). Run the compiled code:
		java -cp out edu.ccrm.cli.Main


Evolution of Java:


    1. JDK 1.0 (1996): The initial release of Java, codenamed "Oak."

    2. J2SE 1.2 (1998): Introduced the Swing GUI toolkit, the Collections Framework, and the JIT (Just-In-Time) compiler.

    3. J2SE 5.0 (2004): A major update that added Generics, Enums, Autoboxing, and Annotations.

    4. Java SE 8 (2014): A landmark release introducing Lambda Expressions, the Stream API, a new Date and Time API, and default methods in interfaces.

    5. Java SE 11 (2018): The first Long-Term Support (LTS) release after the new six-month release cadence. Added the var keyword for local variables.

    6. Java SE 17 (2021): The next LTS release, which brought Sealed Classes and refined Pattern Matching.

    7. Java SE 21 (2023): The latest LTS release, introducing major features like Virtual Threads (Project Loom), Record Patterns, and Sequenced Collections.


Java ME vs SE vs EE Comparison-

  Java SE-

	Primary Use- Core Java platform for desktop and server applications.

	Core API- The foundation of the Java language (java.lang, java.util, etc.).
	
	Example APIs- Swing, Collections, Stream API, NIO.2

	Target Audience	General- purpose developers.

  
  Java EE- 
	
	Primary Use- For large-scale, web-based, enterprise applications.

	Core API- Built on top of Java SE, adds APIs for web services, servlets, etc.

	Example APIs- Servlets, JSP, EJB, JPA, RESTful web services (JAX-RS)

	Target Audience General- Enterprise application developers.

  Java ME- 

	Primary Use- For resource-constrained and embedded devices (IoT, older phones).

	Core API- A strict subset of the Java SE API, optimized for small memory.

	Example APIs- CLDC (Connected Limited Device Configuration), MIDP (Mobile Information Device Profile

	Target Audience General- Embedded systems developers.
	
	
>>>>>>> b9425a2ddb06083c6bf5ed3d07b34c56e3df7b2e

JDK / JRE / JVM Explanation

The Java platform consists of three core components that work together to enable Java's "write once, run anywhere" philosophy.

JVM (Java Virtual Machine): The JVM is an abstract machine that provides the runtime environment in which Java bytecode can be executed. It interprets the compiled .class files into native machine code for the underlying operating system. The JVM is platform-dependent, and it is the component that makes Java code platform-independent.

JRE (Java Runtime Environment): The JRE is the software package required to run a Java application. It includes the JVM, along with the core Java class libraries and supporting files. If you are an end-user and only want to run Java programs, the JRE is all you need.

JDK (Java Development Kit): The JDK is the full-featured software development kit for creating Java applications. It contains everything in the JRE, plus essential development tools like the Java compiler (javac), a debugger (jdb), and Wan archiver (jar). Developers need the JDK to write, compile, and debug Java code.

<<<<<<< HEAD
In simple terms: JDK \= JRE \+ Development Tools, and JRE \= JVM \+ Core Libraries.

Usage and Sample Data This section provides a brief look at how to interact with the CCRM application via the command line and the format for the data files used for import operations.

Sample CLI Interaction 📝 The application is menu-driven. You interact by entering the number corresponding to your desired action.

Welcome to the Campus Course & Records Manager (CCRM)\!

Please select an option:

1. Manage Students  
2. Manage Courses  
3. File Operations (Import/Export)  
4. Exit

1

\--- Student Management \---

1. Add New Student  
2. List All Students  
3. Find Student by Registration Number  
4. Back to Main Menu

1

Enter Student ID: S101 Enter Full Name: Priya Sharma Enter Email: priya.s@example.com Enter Date of Birth (YYYY-MM-DD): 2004-08-15 Enter Registration Number: R2025001 Student 'Priya Sharma' added successfully\!

4

Please select an option:

1. Manage Students  
2. Manage Courses  
3. File Operations (Import/Export)  
4. Exit

3

\--- File Operations \---

1. Import Students from CSV  
2. Import Courses from CSV  
3. Export All Data  
4. Create Backup  
5. Back to Main Menu

1 Attempting to import from 'data/students.csv'... Import successful. 2 new students added. Sample Data Files The application can import data from simple, comma-separated value (.csv) files. These files should be placed in a

test-data folder in the project root. The expected format for each file is described below.

students.csv This file contains student records. Each line represents one student with the following comma-separated fields:

ID, Registration Number, Full Name, Email, and Date of Birth.

=======
In simple terms: JDK = JRE + Development Tools, and JRE = JVM + Core Libraries.




Usage and Sample Data
This section provides a brief look at how to interact with the CCRM application via the command line and the format for the data files used for import operations.

Sample CLI Interaction 📝
The application is menu-driven. You interact by entering the number corresponding to your desired action.

Welcome to the Campus Course & Records Manager (CCRM)!

Please select an option:
1. Manage Students
2. Manage Courses
3. File Operations (Import/Export)
4. Exit
> 1

--- Student Management ---
1. Add New Student
2. List All Students
3. Find Student by Registration Number
4. Back to Main Menu
> 1

Enter Student ID: S101
Enter Full Name: Priya Sharma
Enter Email: priya.s@example.com
Enter Date of Birth (YYYY-MM-DD): 2004-08-15
Enter Registration Number: R2025001
Student 'Priya Sharma' added successfully!

> 4

Please select an option:
1. Manage Students
2. Manage Courses
3. File Operations (Import/Export)
4. Exit
> 3

--- File Operations ---
1. Import Students from CSV
2. Import Courses from CSV
3. Export All Data
4. Create Backup
5. Back to Main Menu
> 1
Attempting to import from 'data/students.csv'...
Import successful. 2 new students added.
Sample Data Files 
The application can import data from simple, comma-separated value (.csv) files. These files should be placed in a 

test-data folder in the project root. The expected format for each file is described below.

students.csv
This file contains student records. Each line represents one student with the following comma-separated fields: 

ID, Registration Number, Full Name, Email, and Date of Birth.



>>>>>>> b9425a2ddb06083c6bf5ed3d07b34c56e3df7b2e
Example students.csv:

Code snippet

<<<<<<< HEAD
S001,R2025001,Alice Johnson,alice.j@example.com,2003-05-10 S002,R2025002,Bob Williams,bob.w@example.com,2004-02-20 S003,R2025003,Charlie Brown,charlie.b@example.com,2003-09-30 courses.csv This file contains course records. Each line represents one course with the following comma-separated fields:

Course Code, Title, Credits, Department, and Semester.

=======
S001,R2025001,Alice Johnson,alice.j@example.com,2003-05-10
S002,R2025002,Bob Williams,bob.w@example.com,2004-02-20
S003,R2025003,Charlie Brown,charlie.b@example.com,2003-09-30
courses.csv
This file contains course records. Each line represents one course with the following comma-separated fields: 

Course Code, Title, Credits, Department, and Semester.


>>>>>>> b9425a2ddb06083c6bf5ed3d07b34c56e3df7b2e
Example courses.csv:

Code snippet

<<<<<<< HEAD
CS101,Introduction to Programming,3,Computer Science,FALL MA203,Advanced Calculus,4,Mathematics,FALL PH105,Classical Mechanics,3,Physics,SPRING  
=======
CS101,Introduction to Programming,3,Computer Science,FALL
MA203,Advanced Calculus,4,Mathematics,FALL
PH105,Classical Mechanics,3,Physics,SPRING

	
>>>>>>> b9425a2ddb06083c6bf5ed3d07b34c56e3df7b2e
