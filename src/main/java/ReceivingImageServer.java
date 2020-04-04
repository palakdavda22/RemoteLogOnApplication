/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class ReceivingImageServer implements Runnable{
	ObjectInputStream dis;
	Socket s;
	static HashMap<String,Socket> map;
	ReceivingImageServer(ObjectInputStream obj, Socket soc, HashMap<String,Socket> hmap ){
		dis = obj;
		s = soc;
		map = hmap;
		new Thread(this).start();
	}	
	public void run(){
		try{
			int i = 0;
			while(true){
				System.out.println("Received Image Server");
				Thread.sleep(100);
				// dis =new ObjectInputStream(s.getInputStream());
    			ImageData obj=(ImageData)dis.readUnshared();
    			String receiver = obj.getReceipent();
    			Socket socrec = map.get(receiver);
    			System.out.println("image: " + i++);
    			ObjectOutputStream os=new ObjectOutputStream(socrec.getOutputStream());
    			os.writeUnshared(obj);
    			System.out.println("Sent image server");
    		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
} 	
