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
    public int player;
    
    public shooter(double x,double y,double width,double height,int playerid)
    {
        this.x = x;
        this.y = y;
        this.HP=3;
        this.width = width;
        this.height = height;
        this.player=playerid;
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
 /*   
public bullet[] shoot(){     
            double xStep =20;
            bullet[] b = new bullet[1];  
            b[0] = new bullet(x-xStep,y);    
            return b;  
            // need to rethink! about getGameStatus: hard to include all messy bullets on screen 
        }  */
    
public void shootbullet(shooter s){
    bullet b=new bullet(s.getX(), s.getY());
    b.fly(s.player);
}

public double getX()
{return x;}

public double getY()
{return y;}

    public void hit(bullet other){  
          
        double xx = other.x - this.width/2;
        double yy = other.y - this.height/2; 
      
        double playerx1 = x;
        double playerx2=this.x + this.width;  
        double playery1= y;
        double playery2=this.y + this.height;  
          
        if( xx>=playerx1 && xx<=playerx2 && yy>=playery1 && yy<=playery2)
            HP-=1;
    }  
  
    
    public void move(double deltaX,double deltaY)  {    
        x += deltaX;
        y += deltaY;
    }
    
}
