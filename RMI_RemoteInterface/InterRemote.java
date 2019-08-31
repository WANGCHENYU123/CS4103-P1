package RMI_RemoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import RMI_Client.ClientInterface;

public interface InterRemote extends Remote {
    public String login(ClientInterface c) throws RemoteException;
//    public void getInput(String args) throws java.rmi.RemoteException,java.io.IOException;
//    public String toClient(String b) throws java.rmi.RemoteException,java.io.IOException;
    public void judgeDecision(String s, ClientInterface c) throws RemoteException; 
}