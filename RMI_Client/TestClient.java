package RMI_Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI_RemoteInterface.InterRemote;;

public class TestClient {

	
	static String priChoice = "";
	
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			//synthesize a remote reference to the registry on the server’s host
			 Registry registry = LocateRegistry.getRegistry(host);
			 //The RMI client constructs a name to look up a Calculator remote object,
			 //the same name used by CalculatorServer to bind its remote object.
			 InterRemote intRe = (InterRemote) registry.lookup(args[1]);
			 String id = args[2];
			 ClientInterface c = new ClientImpl(id, intRe);
			 String say = intRe.login(c);
			 System.out.println(say);
			
			 InputStreamReader in = new InputStreamReader(System.in);
			 BufferedReader bufferedReader = new BufferedReader(in);
			 System.out.println("Please enter your choice (C or B)");
			 intRe.judgeDecision(bufferedReader.readLine(),c);

		} catch (Exception e) {
			System.err.println("error");
            e.printStackTrace();
		}
	}
	
	public String getP1() throws RemoteException {
		return priChoice;
	}
}
