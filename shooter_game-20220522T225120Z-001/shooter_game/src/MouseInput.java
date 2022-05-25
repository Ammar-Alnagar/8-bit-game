
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class MouseInput extends MouseAdapter 
{
    private Handler handler ;
    private Camera camera ; 
    protected SpriteSheet ss;
    Game game;
    public MouseInput(Handler handler, Camera camera, SpriteSheet ss , Game game )
    {
        this.handler = handler;
        this.camera= camera ;
        this.ss = ss ;
        this.game = game;
    }
    public void mousePressed(MouseEvent e)
    {
        int mx = (int) (e.getX()+camera.getX());
        int my = (int) (e.getY()+camera.getY());
        
        for(int i = 0; i < handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player)
            {
                handler.addObject(new Bullet(tempObject.getX()+16 , tempObject.getY()+24 ,ID.Bullet , handler, mx ,my,ss));
                 game.ammo--;
                 if ( game.ammo == 0 )
                 {
                     System.out.println("GAME OVER !!!");
                        System.out.println("you lost due Ammo hitting ZERO!");
                         System.out.println("You have accumulated ->" +game.point+ "    Points");
                        System.exit(0);
                 }
            }
            
        }
    }
    
}
