Project Overview & How to Run-
The Campus Course & Records Manager (CCRM) is a comprehensive, console-based application developed using Java SE. It's designed to serve as a robust system for an educational institute to manage its core academic operations, including student information, course catalogs, enrollments, and grading.

Prerequisites-
Java Development Kit (JDK): Version 17 or later

IDE: Eclipse, IntelliJ IDEA, or VS Code with Java extensions

How to Run-
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
	
	

JDK / JRE / JVM Explanation

The Java platform consists of three core components that work together to enable Java's "write once, run anywhere" philosophy.

JVM (Java Virtual Machine): The JVM is an abstract machine that provides the runtime environment in which Java bytecode can be executed. It interprets the compiled .class files into native machine code for the underlying operating system. The JVM is platform-dependent, and it is the component that makes Java code platform-independent.

JRE (Java Runtime Environment): The JRE is the software package required to run a Java application. It includes the JVM, along with the core Java class libraries and supporting files. If you are an end-user and only want to run Java programs, the JRE is all you need.

JDK (Java Development Kit): The JDK is the full-featured software development kit for creating Java applications. It contains everything in the JRE, plus essential development tools like the Java compiler (javac), a debugger (jdb), and Wan archiver (jar). Developers need the JDK to write, compile, and debug Java code.

In simple terms: JDK = JRE + Development Tools, and JRE = JVM + Core Libraries.


	
