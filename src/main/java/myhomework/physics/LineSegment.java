/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhomework.physics;

/**
 *
 * @author Khanh Toan
 */
public class LineSegment {
    public Point a;
    public Point b;
    
    public LineSegment(Point a,Point b)
    {
        this.a = a;
        this.b = b;
    }
    
    public void move(double deltaX,double deltaY)
    {
        a.x += deltaX;
        a.y += deltaY;
        b.x += deltaX;
        b.y += deltaY;
    }
    
    public Vector toVector()
    {
        return new Vector(b.x - a.x,b.y - a.y);
    }
    
    // Return the point at which these two line segments intersect,
    // or null if they do not.
    public Point intersection(LineSegment other)
    {
        // The technique used to compute the intersection is described at
        // http://stackoverflow.com/questions/563198/how-do-you-detect-where-two-line-segments-intersect
        LineSegment connector = new LineSegment(this.a,other.a);
        Vector me = this.toVector();
        Vector them = other.toVector();
        Vector us = connector.toVector();
        double common = Vector.crossProduct(me,them);
        // If the cross product is positive, the other line segment is coming
        // from our right side, and we should not allow it to intersect us.
        if(common >= 0.0)
            return null;
        double t = Vector.crossProduct(us,them)/common;
        double u = Vector.crossProduct(us,me)/common;
        if(0 <= t && t <= 1 && 0 <= u && u <= 1) {
            return new Point(a.x + me.dX*t,a.y + me.dY*t);
        }
        return null;
    }
}
