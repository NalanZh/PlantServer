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
public class Ray {
  public Point origin;
  public Vector v;
  public double speed;
  
  public Ray(Point origin,Vector v,double speed)
  {
      this.origin = origin;
      this.v = v;
      this.v.normalize();
      this.speed = speed;
  }
  
  // Construct and return a line segment representing the path
  // the object would take over the given span of time.
  public LineSegment toSegment(double time)
  {
      return new LineSegment(origin,this.endPoint(time));
  }
  
  // Compute the location after the given time span.
  public Point endPoint(double time)
  {
      double destX = origin.x + v.dX*time*speed;
      double destY = origin.y + v.dY*time*speed;
      return new Point(destX,destY);
  }
  
  // Compute and return the time at which this ray will 
  // be closest to the given point.
  public double getTime(Point p)
  {
      if(Math.abs(v.dX) > Math.abs(v.dY))
          return (p.x - origin.x)/(v.dX*speed);
      return (p.y - origin.y)/(v.dY*speed);
  }
}
