package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.ExecuteService;
import service.IOService;
import service.UserService;
import serviceImpl.ExecuteServiceImpl;
import serviceImpl.IOServiceImpl;
import serviceImpl.UserServiceImpl;

public class DataRemoteObject extends UnicastRemoteObject implements IOService, UserService,ExecuteService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private IOService iOService;
	private UserService userService;
	private ExecuteService executeService;
	protected DataRemoteObject() throws RemoteException {
		iOService = new IOServiceImpl();
		userService = new UserServiceImpl();
		executeService = new ExecuteServiceImpl();
	}

	

	@Override
	public String readFile(String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFile(userId, fileName);
	}

	@Override
	public String readFileList(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFileList(userId);
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.login(username, password);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.logout(username);
	}

	@Override
	public Boolean isok(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.isok(username, password);
	}

	@Override
	public Boolean islogging() throws RemoteException {
		// TODO Auto-generated method stub
		return userService.islogging();
	
	}

	@Override
	public String getpassword() throws RemoteException {
		return userService.getpassword();
	}

	@Override
	public boolean haslogout() throws RemoteException {
		// TODO Auto-generated method stub
		return userService.haslogout();
	}

	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub
		return executeService.execute(code,param);
	}
	public String register(String username,String password) throws RemoteException{
		
	   return iOService.register(username, password);
	}

	


	@Override
	public String getname() throws RemoteException {
		// TODO Auto-generated method stub
		return userService.getname();
	}






	@Override
	public Boolean writeFile(String file, String userId, String fileName, String dive) throws RemoteException {
		// TODO Auto-generated method stub
		return iOService.writeFile(file, userId, fileName, dive);
	}}



