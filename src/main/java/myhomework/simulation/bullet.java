/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhomework.simulation;

import myhomework.physics.Point;
import myhomework.physics.Ray;
import myhomework.physics.Vector;

/**
 *
 * @author samsung1
 */
public class bullet {
    public double x, y;
    public int speed= 5;
   // public double width, height;
    
    
    public bullet(double x,double y){  
        this.x = x;  
        this.y = y;  
       // this.image = game.bullet;   get image or draw one for bullet in simulation        
       // this.width = image.width();  
       // this.height = image.height(); 
    }  
  

    public void fly(int player){ 
        if(player==1)
        x+=speed;  
        else
        x-=speed; 
    }  
    
    public boolean shooted()
    {return true;}
    //messege from client: move the paddle
 
    public void delete(bullet b)
    {b=null;}
    
    public boolean crashOuter()
    {return x>= 450 && x<0;}
    
public void setX( double xx)
{this.x= xx;}

public void setY(double yy)
{this.y=yy;}
}
