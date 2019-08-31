# CS4103-P1
A distributed system for the prisoner dilemma

Compiling and running the example

a) Compile .java files:
Bash$ javac RMI_Server/*.java RMI_Client/*.java RMI_RemoteInterface/*.java


b) Start rmiregistry and leave it running in the background, and start the server: Bash$ rmiregistry &
Bash$ java RMI_Server.TestServer
Note: kill old rmiregistry before starting new one!


c) Running the client:
Bash$ java RMI_Client.TestClient localhost TestServer
