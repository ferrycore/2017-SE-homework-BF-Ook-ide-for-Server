package serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import service.IOService;

public class IOServiceImpl implements IOService{
	
	@Override
	public Boolean writeFile(String file, String userId, String fileName,String dive) {
		boolean ready = false;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String version = dateFormat.format(date);
		try{
		File path =new File("C:\\Users\\core\\Desktop\\BFServer\\Users\\information\\"+userId+"\\"+dive+"\\"+fileName);
		if(!path.exists()){
		path.mkdirs();
		}
		}
		catch(Exception e){
		e.printStackTrace();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\core\\Desktop\\BFServer\\Users\\information\\"+userId+"\\"+dive+"\\"+fileName+"\\"+version+".txt"));
			writer.write(file);
			writer.close();
			ready = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ready;
	}

	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
		return "OK";
	}

	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		return "OK";
	}
     
	@Override
	public String register(String username, String password) throws RemoteException {
		File file =new File("C:\\Users\\core\\Desktop\\BFServer\\Users\\information"+username);
		if(!file.exists()){
		file.mkdirs();
		try{
		BufferedWriter write =new BufferedWriter(new FileWriter("C:\\Users\\core\\Desktop\\BFServer\\Users\\information"+username+"\\password.txt"));
		write.write(password);
		write.close();
		}
		
		catch(Exception e){
		e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "You have registered successfully!","Tip",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
		JOptionPane.showMessageDialog(null, "This account has existed !","error",JOptionPane.WARNING_MESSAGE);
		
		}
		return null;
	}

	

	
}
