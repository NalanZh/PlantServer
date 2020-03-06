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

    private Ray r;

    public bullet(double startX, double startY, double dX, double dY) {
        Vector v = new Vector(dX, dY);
        double speed = v.length();
        r = new Ray(new Point(startX, startY), v, speed);
    }

    public Ray getRay() {
        return r;
    }

    public void setRay(Ray r) {
        this.r = r;
    }

    public void move(double time) {
        r = new Ray(r.endPoint(time), r.v, r.speed);
    }
}
