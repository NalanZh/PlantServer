package myhomework.simulation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import myhomework.physics.Point;
import myhomework.plantserver.PlantConstants;

public class Simulation implements PlantConstants{//where things are and what happen to them
    private Box outer;
    private bullet b1;
    private bullet b2;
    private shooter s1;
    private shooter s2;
    private Lock lock;
    
    public Simulation(int dX,int dY)
    {
        outer = new Box(0,0,WIDTH,HEIGHT,false);
        s1 = new shooter(MARGIN,MARGIN, THICKNESS, LENGTH,1);
        s2 = new shooter(WIDTH - MARGIN - THICKNESS,MARGIN, LENGTH, THICKNESS,2);
        b1=new bullet(s1.getX(), s1.getY());
        b2=new bullet(s2.getX(), s2.getY());
        lock = new ReentrantLock();
    }
    
    public void evolve(double time)
    {          // go fly bullet
        lock.lock();
        
        if(b1!=null)
          { 
            b1.fly(1);
          
            if(s2.hit(b1))
            {s2.AHH(); }
            
            if(b1.crashOuter())
            {b1.delete(b1);}
          }
        
        if(b2!=null)
          {b2.fly(2);
            if(s1.hit(b2))
            {s1.AHH();}
            if(b2.crashOuter())
            {b2.delete(b2);}      
           }

        lock.unlock();
    }
    
    public void movePlayer(int player,int deltaX,int deltaY)
    {//moving players 
        lock.lock();
        
        shooter mover = s1;
        if(player == 2)
            mover = s2;
        
        double dX = deltaX;
        double dY = deltaY;
        if(mover.x + deltaX < 0)
          dX = -mover.x;
        if(mover.x + mover.width + deltaX > outer.width)
          dX = outer.width - mover.width - mover.x;
       
        if(mover.y + deltaY < 0)
           dY = -mover.y;
        if(mover.y + mover.height + deltaY > outer.height)
           dY = outer.height - mover.height - mover.y;        
        mover.move(dX,dY);
        lock.unlock();
    }
    
        public void firePlayer(int player)
    {//moving players 
        lock.lock();  
        if(player == 1) {
            b1 = s1.shootbullet();
        } else {
            b2 = s2.shootbullet();
        }
                lock.unlock();
    }
        
    public String getGameState() {
       // Point bulletpoint = bullet.getX();        
       // return Double.toString(ballLoc.x) + ' ' + ballLoc.y + ' ' + s1.y + ' ' + s2.y;
       return Double.toString(b1.x) + ' ' +b1.y+ ' ' +b2.x+ ' ' +b2.y+ ' ' + s1.y+ ' ' +s2.y;// how about if b1 b2 are null?????
    }
}
