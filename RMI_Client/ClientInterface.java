package RMI_Client;

import java.rmi.*;

public interface ClientInterface extends Remote {

	public String getId() throws RemoteException;
	
	public void printDecision(String s) throws RemoteException;
	
}
