import java.net.*;
import java.io.*;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
class MainServer{
	static ServerSocket ss;
	static ImageData obj;
	static HashMap<String,Socket> map;
	static Socket s;
	static ObjectInputStream is;
	static ObjectInputStream is2;
	public static void main(String arg[]) throws Exception
    {
    	ss=new ServerSocket(1900);
    	obj = new ImageData();
    	map = new HashMap<>(); 
	   try{  
	   		while(true){
				s=ss.accept();//establishes connection   
				DataInputStream dis=new DataInputStream(s.getInputStream());  
				String  name=(String)dis.readUTF();  
				String operation = (String)dis.readUTF();
	   			map.put(name,s);
	   			for(String str : map.keySet()){
					System.out.println(str + " : "+ map.get(str));
				}
				// s.close();
				dis= null;
				if(operation.equals("send")){
					System.out.println("Sending client " + name);
					Socket socsend = map.get(name);
					is = new ObjectInputStream(socsend.getInputStream());
					ReceivingImageServer ris  = new ReceivingImageServer(is,socsend,map);
				}
				if(operation.equals("receive")){
					System.out.println("Receiving client " + name);
					Socket socrec = map.get(name);
					is2 = new ObjectInputStream(socrec.getInputStream());
					ReceivingEventServer res = new ReceivingEventServer(socrec,is2,map);
				}
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
		finally{
			ss.close(); 
		}
		
	}  
	

}


