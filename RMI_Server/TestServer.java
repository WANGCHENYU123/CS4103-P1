package RMI_Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI_Server.RemoteImpl;

public class TestServer {
	public static void main(String args[]) {
		try {
			String name = "TestServer";
			RemoteImpl reIm = new RemoteImpl();
			//register remote object
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, reIm);
			System.out.println("Judge Start!");
		} catch (Exception e){
			 System.err.println("CalculatorServer exception:");
	          e.printStackTrace();
		}
	}
}
