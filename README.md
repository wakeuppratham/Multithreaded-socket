# Multithreaded Socket Server

This project demonstrates a simple implementation of a multithreaded socket server in Java. The server can handle multiple client connections concurrently using threads, allowing for improved scalability and responsiveness.

## How to Use

1. **Server Setup**
   - Compile and run the `Server.java` file.
   - The server will start listening on port 8010.
   
2. **Client Setup**
   - Compile and run the `Client.java` file.
   - The client will connect to the server running on localhost at port 8010.
   
3. **Communication**
   - The client sends a message "Hello from the Client" to the server.
   - The server responds with "Hello from the server".
   - The client then displays the response received from the server.
   
4. **Termination**
   - Close the client and server programs after testing.

## About the Project

The project demonstrates how to implement a multithreaded socket server in Java. It utilizes the `ServerSocket` and `Socket` classes to establish socket connections between clients and the server. Each client connection is handled in a separate thread, allowing the server to handle multiple client requests concurrently.

## Additional Notes

- Ensure that the server is running before starting the client.
- The server listens on port 8010 by default. You can change the port if needed by modifying the `port` variable in the `Server.java` file.

This project serves as a basic example of multithreaded socket programming in Java. Feel free to explore and modify the code according to your requirements.
