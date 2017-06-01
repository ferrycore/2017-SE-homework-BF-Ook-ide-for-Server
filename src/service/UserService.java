//需要客户端的Stub
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote{
	public boolean login(String username, String password) throws RemoteException;

	public boolean logout(String username) throws RemoteException;
	
	public Boolean isok(String username,String password) throws RemoteException;
	
	public Boolean islogging() throws RemoteException;
	
	public String  getpassword() throws RemoteException;
	
	public boolean haslogout() throws RemoteException;
	
	public String getname() throws RemoteException;
}
