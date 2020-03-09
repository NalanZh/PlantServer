package myhomework.simulation;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myhomework.simulation.bullet;

public class shooter{
    public double x;
    public double y;
    public int HP;
    public double width;
    public double height;
    
    public shooter(double x,double y,double width,double height,int player)
    {
        this.x = x;
        this.y = y;
        this.HP=3;
        this.width = width;
        this.height = height;
        if(player==1){
        Image peashooter = new Image("D:\\COMPUTER SCIENCE\\CMSC250\\Final plants\\PlantServer\\src\\main\\resources\\shooter1.jpg");
			ImageView imageView = new ImageView();
			imageView.setImage(peashooter);//add children while calling 
			width = peashooter.getWidth();
			height = peashooter.getHeight();}
        else
        {Image peashooter = new Image("D:\\COMPUTER SCIENCE\\CMSC250\\Final plants\\PlantServer\\src\\main\\resources\\shooter2.jpg");
			ImageView imageView = new ImageView();
			imageView.setImage(peashooter);
			width = peashooter.getWidth();
			height = peashooter.getHeight();}
    }
    
public bullet[] shoot(){     
            double xStep =20;
            bullet[] b = new bullet[1];  
            b[0] = new bullet(x-xStep,y);    
            return b;  
            // need to rethink! about getGameStatus: hard to include all messy bullets on screen 
        }  

    public boolean hit(bullet other){  
          
        double x1 = other.x - this.width/2;                 
        double x2 = other.x + this.width/2 + 5.0;   //set bullet as 2r=5.0 circle
        double y1 = other.y - this.height/2;               
        double y2 = other.y + this.height/2 + 5.0; 
      
        double playerx = this.x + this.width/2;              
        double playery = this.y + this.height/2;             
          
        return playerx>x1 && playerx<x2 && playery>y1 && playery<y2;  
    }  
    
    public void ifHit()
    {this.HP-=1;}
    
    public void move(double deltaX,double deltaY)  {    
        x += deltaX;
        y += deltaY;
    }
    
}
