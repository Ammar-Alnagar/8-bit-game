
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class Bullet extends GameObject {
 private Handler handler; 
    public Bullet(int x, int y, ID id , Handler handler , int mx , int my , SpriteSheet ss ) {
        super(x, y, id,ss);
        this.handler = handler;
        velx = (mx-x) /10;
        vely = (my-y)/10;
    }

    @Override
    public void tick()
    {
        x+= velx;
        y+= vely;
        for ( int i = 0 ; i< handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Block)
            {
            if(getBounds().intersects(tempObject.getBounds()))
            {
                handler.removeObject(this);
            }
            }
            
        }
        
     }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 8, 8);
        
        
     }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
     }
    
}
