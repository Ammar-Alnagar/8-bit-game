
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class Window
{
        public static final int WIDTH = 1000;
	public static final int HEIGHT = 563;
     //   public static final String operatingSystem = System.getProperty("os.name");
	public static int hp = 50;
	public static int ammo = 30;

    public Window(int width , int height , String title , Game game)
    {
        
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width , height ));
        frame.setMaximumSize(new Dimension(width , height ));
        frame.setMinimumSize(new Dimension(width , height ));
        
        frame.add(game);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

   
    
}
