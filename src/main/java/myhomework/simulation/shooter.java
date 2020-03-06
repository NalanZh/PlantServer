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
    
    public void getHurt(shooter s,bullet b)
    {   if(s.intersects(b))
            HP--;
    }
    
    public boolean intersects()
    {}
    
    public void move(double deltaX,double deltaY)  {    
        x += deltaX;
        y += deltaY;
    }
    
}
