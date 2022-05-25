
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Shooter extends GameObject
{
    Handler handler ;
    private BufferedImage wizard_image;
    private Game game;
    

    public Shooter(int x, int y, ID id, Handler handler , SpriteSheet ss, Game game) {
        super(x, y, id,ss);
        this.handler = handler ;
        wizard_image = ss.grabImage(1, 1, 32, 48);
        this.game = game;
    }

    @Override
    public void tick() 
    {
        x +=velx ;
        y+= vely;
        collision();
         if(handler.isUp()) vely = -5;
         else if (!handler.isDown()) vely = 0;
         
         if(handler.isDown()) vely = 5;
         else if (!handler.isUp()) vely = 0;
         
         if(handler.isRight()) velx = 5;
         else if (!handler.isLeft()) velx = 0;
         
         if(handler.isLeft()) velx = -5;
         else if (!handler.isRight()) velx = 0;
         
         
         
         
         
     }
    private void collision()
    {
        for(int i = 0 ; i <handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Block)
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {
                    x+= velx* -1 ;
                    y+= vely *-1;
                                        
                }
                
            }
            if(tempObject.getId() == ID.Enemy)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    game.hp--;
                    if (game.hp == 0 )
                    {
                        System.out.println("GAME OVER !!!");
                        System.out.println("you lost due HP hitting ZERO!");
                         System.out.println("You have accumulated ->" +game.point+ "    Points");
                        System.exit(0);
                    }
                    
                }
            }
            
            
            
        }
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(wizard_image, x, y, null);
     }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,32,48);
        
     }
    
}
