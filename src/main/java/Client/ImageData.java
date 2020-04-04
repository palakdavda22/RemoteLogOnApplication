/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Dell
 */
import java.io.Serializable;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class ImageData implements Serializable{

    // private ImageIcon image;
    private byte[] image;
    private String receipent;
    public byte[] getImage(){
        return image;
    }
    public void setImage(byte[] image){
        this.image = image;
    }
    public String getReceipent(){
        return receipent;
    }
    public void setReceipent(String str){
        receipent = str;
    }
}
