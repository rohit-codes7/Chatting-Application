<h1>Java Chatting Application</h1>

<p>A simple real-time chat application built in Java using Swing for the graphical user interface. This project simulates a basic messaging platform where users can send and receive text messages in a chat window, making it ideal for learning socket programming and building desktop-based applications.</p>

<h2>Features</h2>

<ul>
    <li><strong>Real-time Messaging</strong>: Instant message sending and receiving between the server and client.</li>
    <li><strong>Graphical User Interface (GUI)</strong>: Created using Java Swing to provide a chat interface with a look and feel similar to modern messaging apps.</li>
    <li><strong>Customizable Components</strong>: Includes header icons for profile, video call, and options.</li>
    <li><strong>Networking</strong>: Uses <code>ServerSocket</code> and <code>Socket</code> classes to establish server-client communication.</li>
    <li><strong>Message Formatting</strong>: Messages are displayed with timestamps for better readability.</li>
    <li><strong>Exit Button Functionality</strong>: Allows the application to be closed via a back button.</li>
</ul>

<h2>Running the Application</h2>

<h3>Start the Server</h3>
<p>Run the <code>Server</code> class to start the chat server. The server will listen for incoming client connections on port <code>6001</code>.</p>

<h3>Connect a Client</h3>
<p>To establish a connection, run a corresponding client application (to be implemented or provided separately). Once the client connects, messages can be sent between the server and client.</p>

<h3>Usage</h3>
<ul>
    <li><strong>Sending Messages</strong>: Type a message in the text field and click the "Send" button to transmit the message.</li>
    <li><strong>Exiting the Chat</strong>: Click the back button (top-left) to close the chat application.</li>
</ul>
