package RMI_Server;

import RMI_Client.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import RMI_RemoteInterface.InterRemote;
import java.util.*
;
public class RemoteImpl implements InterRemote {
	
	private Hashtable h = new Hashtable();  
	private Hashtable hd = new Hashtable();
	
	public RemoteImpl() throws RemoteException {
		//exports the Remote object to the RMI runtime, 
		//so that it is made available to receive incoming remote invocations from clients.
	        UnicastRemoteObject.exportObject(this, 0);
	    }
	
	public String login(ClientInterface c) throws RemoteException {
		//put the id and the user's information to a hashtable
		h.put(c.getId(), c);
		System.out.println("Prisoner No."+c.getId()+" login");
		return "[Confirmation of Attandence] from the Judge to Prisoner No."+c.getId();
	}
	
	public void judgeDecision(String s, ClientInterface c) throws RemoteException {
		System.out.println("Statement received from prisoner No."+ c.getId());
		//put the id and user's decision to another hashtable
		hd.put(c.getId(),s);
		//confirming there are at least decisions
		if (hd.size()<2) {
			System.out.println("Waiting for more statements for final decision.");
			return; 
		}		
		Enumeration ids = hd.keys();

			String next = (String) ids.nextElement();
			ClientInterface c2 = (ClientInterface) h.get(next);
			//confirming the user who invokes the method "judgeDecision()" is the person who gives the decision 
		    while (c.getId().equals(c2.getId())) {
		    		next = (String) ids.nextElement();
		    		c2 = (ClientInterface) h.get(next);
		    }
		    String s2 = (String) hd.get(next);
			if (s.equals("B") && s2.equals("B")) {
				try {
				c.printDecision("Decision from the Judge: 1");
				c2.printDecision("Decision from the Judge: 1");
			    }catch(Exception e) {System.err.println("error");}				
			}
			else if (s.equals("C") && s2.equals("C")) {
				try {
				c.printDecision("Decision from the Judge to Prisoner No."+c.getId()+" is: 5");
				c2.printDecision("Decision from the Judgeto Prisoner No."+c2.getId()+" is: 5");
			    }catch(Exception e) {System.err.println("error");}				
			}
			else if (s.equals("B") && s2.equals("C")) {
				try {
				c.printDecision("Decision from the Judge: 3");
				c2.printDecision("Decision from the Judge: 2");
			    }catch(Exception e) {System.err.println("error");}				
			}
			else if (s.equals("C") && s2.equals("B")) {
				try {
				c.printDecision("Decision from the Judge: 2");
				c2.printDecision("Decision from the Judge: 3");
			    }catch(Exception e) {System.err.println("error");}			
			}
			else {
				try {
				c.printDecision("Input problem: No Decision");
				c2.printDecision("Input problem: No Decision");
			    }catch(Exception e) {System.err.println("error");}				
			}
			return;	
	}
}
