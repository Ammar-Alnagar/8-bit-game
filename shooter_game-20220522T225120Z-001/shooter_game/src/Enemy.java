
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class Enemy extends GameObject {

    int points= 0 ;
    private Game game;
    Random r = new Random() ;
    int choose = 0 ;
    int hp = 100;
    int hp2 = 500;
    Handler handler ;
    private BufferedImage enemy_image;
    public Enemy(int x, int y, ID id, Handler handler,SpriteSheet ss , Game game) {
        super(x, y, id,ss);
        this.handler = handler ;
        enemy_image = ss.grabImage(4, 1, 32, 32);
        this.game = game;
    }

    @Override
    public void tick() 
    {
        x+= velx ;
        y+=vely;
        choose = r.nextInt(10);
        for(int i = 0 ; i< handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
          
            if ( tempObject.getId() == ID.Block)
            {
                if ( getBoundsBig().intersects(tempObject.getBounds()))
                {
                    x += (velx*2)* -1;
                    y += (vely*2)* -1;
                    velx *= -1 ;
                    vely *= -1;
                     
                }
                else if (choose == 0 )
        {
            velx = r.nextInt((4- -4) + -4);
            vely = r.nextInt((4- -4) + -4);
        }
        
                
            }
                    if(tempObject.getId()== ID.Bullet)
                    {
                        if ( getBounds().intersects(tempObject.getBounds()))
                        {
                          hp -= 50 ;
                          handler.removeObject(tempObject);
                        }
                    }
           
        }
        if (hp<= 0 )
        {
             
                handler.removeObject(this);
                game.point++;
                if (game.point == 22)
                {
                    System.out.println("Well Done!!");
                     System.out.println("You have accumulated amount of ->" +game.point +"  Points");
                     System.exit(0);
                    
                }
                System.out.println(game.point);
                //System.out.println("+1 Point");
               
               
        }
        
        
        
       
        
     }

    @Override
    public void render(Graphics g) {
         g.drawImage(enemy_image, x, y, null);
     }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
        
     }
    public Rectangle getBoundsBig() {
        return new Rectangle(x-16,y-16,64,64);
        
     }
    
    
}
