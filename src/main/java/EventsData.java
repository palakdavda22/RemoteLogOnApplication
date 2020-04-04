import java.io.Serializable;
import java.util.*;
class EventsData implements Serializable{
		int x,y;
		boolean clicked = false,typed = false;
		List<Character> keys;
    private String receipent;
		public void setX(int a){
			x = a;
		}
		public void setY(int b){
			y = b;
		}
		public void setClicked(boolean click){
			clicked = click;
		}
		public void setTyped(boolean type){
			typed = type;
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		public boolean getClicked(){
			return clicked;
		}
		public boolean getTyped(){
			return typed;
		}
		public String getReceipent(){
        	return receipent;
    	}
		public void setReceipent(String str){
	        receipent = str;
	    }
	    public List<Character> getKeys(){
	    	return keys;
	    }
	    public void setKeys(List keys){
	    	this.keys = keys;
	    }

	    public void printKeys(){
	    	System.out.println("Trying to print keys");
	    	for(Character ch: keys){
	    		System.out.print(ch +" , ");
	    	}
	    }
}