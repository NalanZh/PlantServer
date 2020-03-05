package myhomework.simulation;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class shooter{
    public double x;
    public double y;
    public double width;
    public double height;
    
    public shooter()
    {
        Image peashooter = new Image("D:\\COMPUTER SCIENCE\\CMSC250\\Final plants\\PlantServer\\src\\main\\resources");
			ImageView imageView = new ImageView();
			imageView.setImage(peashooter);
			width = peashooter.getWidth();
			height = peashooter.getHeight();
    }
    
    public void move(double deltaX,double deltaY)  {
    
        x += deltaX;
        y += deltaY;
    }
    
}
