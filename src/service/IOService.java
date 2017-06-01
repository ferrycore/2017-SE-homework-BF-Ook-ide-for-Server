//需要客户端的Stub
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IOService extends Remote{	
	public String readFile(String userId, String fileName)throws RemoteException;
	
	public String readFileList(String userId)throws RemoteException;
	
	public String register(String username,String password) throws RemoteException;

	public Boolean writeFile(String file, String userId, String fileName, String dive) throws RemoteException;
	
}
