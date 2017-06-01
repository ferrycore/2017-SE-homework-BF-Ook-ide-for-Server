//请不要修改本文件名
package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {
    //解释器实现
	@Override
	public String execute(String code, String param) throws RemoteException {
		 String output ="";
		 int reglength = 1;
		 for(int i=0;i<code.length();i++){
		 if(code.charAt(i)=='>'){
		 reglength++;
		 }}
		 char[]char1 =new char[reglength];
		 for(int j =0;j<reglength;j++){
		 char1[j] =0;
		 }
		 int count1 =0;
		 for(int g =0;g<code.length();g++){
		 if(code.charAt(g)=='['){
		 count1++;
		 }
		 }
		 int first[] = new int[count1];
		 int later[] = new int[count1];
		
		 for(int r =0;r<count1;r++){
		 for(int a =0;a<code.length();a++){
		 if(code.charAt(a)=='['){
		  first[r]= a;
		 }
		 int sum =0;
		 for(int t =a;t<code.length();t++){
		 if(code.charAt(t)=='['){
		 sum++;
		 }
		 if(code.charAt(t)==']'){
		 sum--;
		 if(sum==0){
		 later[r] = t;
		 break ;
		 }
		 }
		 }
		 }
		 }
		 int pointer =0;
		 for(int q =0;q<code.length();q++){
		 char ch =code.charAt(q);
		 try{
		 if(ch=='+'){
		 char1[pointer]++;
		 }
		 if(ch=='-'){
		 char1[pointer]--;
		 }
		 if(ch=='>'){
		 pointer++;
		 }
		 if(ch=='<'){
		 pointer--;
		 }
		 if(ch=='.'){
		 output = output+(char)char1[pointer];
		 }
		 if(ch==','){
		 char1[pointer] =param.charAt(0);
		 try{
		 param = param.substring(1);
		 }
		 catch(Exception e){
		  param =null;	 
		 }
		 
		 }
		 if(ch=='['&&char1[pointer]==0){
		 for(int k =0;k<count1;k++){
		 if(q==first[k]){
		  q =later[k];
		 }
		 }
		 }
			 
		 if(ch==']'&&char1[pointer]!=0){
			 for(int k =0;k<count1;k++){
			 if(q==later[k]){
			  q =first[k];
			 }
			 }
			 } 
			 
			 
			 
			 
			 
			 
	    
		 }
		 catch(Exception e){
		 System.out.println("Error!");	 
		 }
		 }
		 return output;
	}

}
