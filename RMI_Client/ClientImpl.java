package RMI_Client;

import java.rmi.*;
import java.rmi.server.*;
import RMI_Server.*;
import RMI_RemoteInterface.*;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {

	private String id;
	private InterRemote server;

	public ClientImpl (String u, InterRemote s) throws RemoteException {
		id = u;
		server = s;

	}
	public String getId() throws RemoteException {
		return id;
	} 
	public void printDecision(String s) throws RemoteException {
		System.out.println(s);
	}
	
	
}
