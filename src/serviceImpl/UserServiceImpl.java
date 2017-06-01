package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import service.UserService;

public class UserServiceImpl implements UserService{
	public  Boolean islog =false;
	public  String usename ="";

	@Override
	//强调动作已经执行 islog置为true
	public boolean login(String username, String password) throws RemoteException {
		islog  =true;
		return islog;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		islog =false;
		usename ="";
		return islog;
	}
	public Boolean isok(String username,String password) throws RemoteException{
	    Boolean judge =false;
	    boolean isexist =false;
	    File file =new File("C:/Users/core/Desktop/BFServer/Users/information");
	    File[]filelist = file.listFiles();
	    for(int i =0;i<filelist.length;i++){
	    if(filelist[i].getName().equals(username)){
	    isexist =true;
	    }
	    }
		if(isexist){
		for(int j =0;j<filelist.length;j++){
		if(filelist[j].getName().equals(username)){
		try{
		BufferedReader reader =new BufferedReader(new FileReader("C://Users//core//Desktop//BFServer//Users//information//"+username+"//password.txt"));
	    String pass =reader.readLine();
	    reader.close();
		if(pass.equals(password)){
		judge =true;
		usename =username;
		break;
		}
		//else{
		//JOptionPane.showMessageDialog(null, "Wrong logging!","Error",JOptionPane.INFORMATION_MESSAGE);
		//}
		}catch (Exception e){
		e.printStackTrace();
		}
		}
		}
		}
		
		return judge;
	}
public Boolean islogging() throws RemoteException{
	return islog;
}
	
	public String  getpassword() throws RemoteException{
	 return usename;
	}
	
	public boolean haslogout() throws RemoteException{
	islog =false;
	return islog;
	}
public String getname()throws RemoteException{
	
	return usename;
}



}
