package myhomework.simulation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import myhomework.plantserver.PlantConstants;

/**
 *
 * @author samsung1
 */
public class Simulation implements PlantConstants{
    private shooter outer;
    private bullet ball;
    private shooter s1;
    private shooter s2;
    private Lock lock;
    
    public Simulation(int dX,int dY)
    {
        s1 = new shooter(MARGIN,MARGIN, THICKNESS, LENGTH,true);
        s2 = new shooter(WIDTH - MARGIN - THICKNESS,MARGIN, LENGTH, THICKNESS,true);
        lock = new ReentrantLock();
    }
    
    public void evolve(double time)
    {
        lock.lock();
        
        
        
        Ray newLoc = boxOne.bounceRay(ball.getRay(), time);
        if(newLoc != null)
            ball.setRay(newLoc);
        else {
            newLoc = boxTwo.bounceRay(ball.getRay(), time);
            if(newLoc != null)
                ball.setRay(newLoc);
            else {
                newLoc = outer.bounceRay(ball.getRay(), time);
                if(newLoc != null)
                    ball.setRay(newLoc);
                else
                    ball.move(time);
            }                //copy from Gregg need to revise
            } 
        
        lock.unlock();
    }
    
    public void movePlayer(int player,int deltaX,int deltaY)
    {//moving paddles 
        lock.lock();
        Box mover = boxOne;
        if(box == 2)
            mover = boxTwo;
        
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
        if(mover.contains(ball.getRay().origin)) {
            // If we have discovered that the box has just jumped on top of
            // the ball, we nudge them apart until the box no longer
            // contains the ball.
            int bumpX = -1;
            if(dX < 0) bumpX = 1;
            int bumpY = -1;
            if(dY < 0) bumpY = 1;
            do {
            mover.move(bumpX, bumpY);
            ball.getRay().origin.x += -bumpX;
            ball.getRay().origin.y += -bumpY;
            } while(mover.contains(ball.getRay().origin));
        }
        lock.unlock();
    }
    
    public String getGameState() {
        Point ballLoc = ball.getRay().origin;
        
        return Double.toString(ballLoc.x) + ' ' + ballLoc.y + ' ' + 
                boxOne.y + ' ' + boxTwo.y;
    }
}
