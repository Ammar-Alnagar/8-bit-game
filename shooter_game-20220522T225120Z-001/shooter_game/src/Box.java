
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
public class Box extends GameObject 
{

    public Box(int x, int y,ID id ,SpriteSheet ss)
    {
        super(x, y, id,ss);
    }

    @Override
    public void tick()
    {
        x+=velx;
        y+=vely;
    }

    @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
        
        
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
    
}
