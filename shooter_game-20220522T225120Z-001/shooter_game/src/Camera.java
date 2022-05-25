/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class Camera
{
    private float x = 0,y = 0 ;
    public Camera(float x , float y )
    {
        this.x= x ;
        this.y = y;
    }
    public void tick(GameObject object)
    {
		x+= ((object.getX()-x)-1000/2)* 0.05f;
                y+= ((object.getY()-y)-563/2) *0.05f;
                
                if (x <= 0 ) x=0;
                if(x >= 1032) x=1032;
                if( y<= 0) y=0;
                if( y>= 563+48) y=563+48;
                
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
    
}
