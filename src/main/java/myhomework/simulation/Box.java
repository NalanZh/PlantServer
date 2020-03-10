package myhomework.simulation;

/**
 *
 * @author samsung1
 */
import java.util.ArrayList;
import myhomework.physics.LineSegment;
import myhomework.physics.Point;

public class Box {
    private ArrayList<LineSegment> walls;
    public double x;
    public double y;
    public double width;
    public double height;
    
    // Set outward to true if you want a box with outward pointed normals
    public Box(double x,double y,double width,double height,boolean outward)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        walls = new ArrayList<LineSegment>();
        if(outward) {
            walls.add(new LineSegment(new Point(x+width,y+height),new Point(x+width,y)));
            walls.add(new LineSegment(new Point(x,y),new Point(x,y+height)));
            walls.add(new LineSegment(new Point(x+width,y),new Point(x,y)));
            walls.add(new LineSegment(new Point(x,y+height),new Point(x+width,y+height)));
        } else {
            walls.add(new LineSegment(new Point(x+width,y),new Point(x+width,y+height)));
            walls.add(new LineSegment(new Point(x+width,y+height),new Point(x,y+height)));
            walls.add(new LineSegment(new Point(x,y),new Point(x+width,y)));
            walls.add(new LineSegment(new Point(x,y+height),new Point(x,y)));
        }
    }

    /*
    public void move(double deltaX,double deltaY)
    {
        for(int n = 0;n < walls.size();n++)
            walls.get(n).move(deltaX,deltaY);
        x += deltaX;
        y += deltaY;
    }*/
    
    public boolean contains(Point p)
    {
        if(p.x >= x && p.x <= x + width && p.y >= y && p.y <= y + height)
            return true;
        return false;
    }
}
