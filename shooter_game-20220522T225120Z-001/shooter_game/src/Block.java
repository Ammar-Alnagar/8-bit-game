
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class Block extends GameObject
{
    private BufferedImage block_image;

    public Block(int x, int y, ID id,SpriteSheet ss) {
        super(x, y, id, ss);
        block_image = ss.grabImage(5, 2, 32, 32);
    }

    @Override
    public void tick() 
    {
     }

    @Override
    public void render(Graphics g)
    {
       g.drawImage(block_image, x, y, null);
     }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,32,32);
     }
    
}
