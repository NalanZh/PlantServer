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
        this.HP=10;
        this.width = width;
        this.height = height;
        this.player=playerid;/*
        if(player==1){
            // "D:\\COMPUTER SCIENCE\\CMSC250\\Final plants\\PlantServer\\src\\main\\resources\\shooter1.jpg
        Image peashooter = new Image("images/shooter1.jpg");
			ImageView imageView = new ImageView();
			imageView.setImage(peashooter);//add children while calling 
			width = peashooter.getWidth();
			height = peashooter.getHeight();}
        else
        {Image peashooter = new Image("images/shooter2.jpg");
			ImageView imageView = new ImageView();
			imageView.setImage(peashooter);
			width = peashooter.getWidth();
			height = peashooter.getHeight();}*/
        //image is not here! It looks fine for me right now!
    }
 /*   
public bullet[] shoot(){     
            double xStep =20;
            bullet[] b = new bullet[1];  
            b[0] = new bullet(x-xStep,y);    
            return b;  
            // need to rethink! about getGameStatus: hard to include all messy bullets on screen 
        }  */
    
public bullet shootbullet(){
    bullet b=new bullet(getX(), getY());
    b.shooted();
    return b;
}

public double getX()
{return x;}

public double getY()
{return y;}

public boolean hit(bullet other){  
          
        double xx = other.x - this.width/2;
        double yy = other.y - this.height/2; 
      
        double playerx1 = x;
        double playerx2=this.x + this.width;  
        double playery1= y;
        double playery2=this.y + this.height;  
                  
        return xx>=playerx1 && xx<=playerx2 && yy>=playery1 && yy<=playery2;
    }  

public void AHH()
    {HP-=1;}
      
public void move(double deltaX,double deltaY)  {    
        x += deltaX;
        y += deltaY;
    }
    
}
