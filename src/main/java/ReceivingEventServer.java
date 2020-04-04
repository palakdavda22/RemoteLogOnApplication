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
public class ReceivingEventServer implements Runnable{
	ObjectInputStream dis;
	Socket s;
	static HashMap<String,Socket> map;
	ReceivingEventServer(Socket soc, ObjectInputStream os,HashMap<String,Socket> hmap ){
		try{
		dis = os;
		s = soc;
		// dis = new ObjectInputStream(s.getInputStream());
		map = hmap;
		new Thread(this).start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	public void run(){
		try{
			while(true){
				System.out.println("Received Event Server");
				Thread.sleep(100);
				// dis =new ObjectInputStream(s.getInputStream());
    			EventsData obj=(EventsData)dis.readUnshared();
    			obj.printKeys();
    			String receiver = obj.getReceipent();
    			Socket socrec = map.get(receiver);
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
