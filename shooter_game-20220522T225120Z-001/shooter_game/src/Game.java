
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game extends Canvas implements Runnable  
{
    private static final long serialVersionUID = 1L;
    private boolean isRunning = false ;
    private Thread thread;
    private Handler handler ; 
    private BufferedImage level = null;
    private Camera camera ;
    private BufferedImage sprite_sheet = null;
    private SpriteSheet ss;
    private BufferedImage floor ;
    public int  hp = 100;
    public int ammo = 100;
    public int point = 0;
    public int moves = 100 ;
    int timer=0;
   
    
    
       
    
    
    
    
     
    
    
    
    
    
    public Game()
    {
        new Window(1000,563,"Shooter game",this  );
        start();
        handler = new Handler() ;
        camera = new Camera(0,0);
        this.addKeyListener(new KeyInput(handler,this));
       
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/wizard_level.png");
        sprite_sheet = loader.loadImage("/wizard_images.png");
        
        ss =new SpriteSheet(sprite_sheet);
        floor= ss.grabImage(4, 2, 32, 32);
        
         this.addMouseListener(new MouseInput(handler , camera , ss,this));
        
       
       
      loadLevel(level);
    }
    private void start()
    {
        isRunning=true;
        thread = new Thread(this);
        thread.start();
        
    }
    private void stop()
    {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
  
    @Override
    public void run() 
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0 ;
        long timer = System.currentTimeMillis();
        int frames = 0 ;
        while(isRunning)
        {
            long now = System.nanoTime();
            delta+= (now - lastTime) / ns ;
            lastTime = now ; 
            while(delta>= 1 )
            {
                tick();
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer >1000)
            {
                timer+=1000;
                frames = 0 ;
            }
        }
        stop();
    }
        
        public void tick ()
        {
            for(int i = 0 ; i < handler.object.size(); i++ )
            {
                if(handler.object.get(i).getId() == ID.Player)
                {
                    camera.tick(handler.object.get(i));
                }
            }
            handler.tick();
        }
        public void render()
        {
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null)
            {
                this.createBufferStrategy(3);
                return;
            }
            Graphics g = bs.getDrawGraphics();
            Graphics2D g2d = (Graphics2D) g;
            //////////////////////////////////////
           
            
            g2d.translate(-camera.getX() , -camera.getY());
            
            for(int xx = 0 ; xx<32*100 ; xx+=32 )
            {
                for(int yy= 0 ; yy<32*100; yy+=32)
                {
                    g.drawImage(floor, xx, yy, null);
                }
            }
           
            handler.render(g);
            
              g2d.translate(camera.getX() , camera.getY());
              
              g.setColor(Color.gray);
              g.fillRect(5, 5, 200, 32);
              g.setColor(Color.black);
              g.fillRect(5, 5, 200, 32);
               g.setColor(Color.green);
              g.fillRect(5, 5, hp*2, 32);
              
              g.setColor(Color.white);
              g.drawString("POINTS -:> "+point +" s" , 10,50);
               g.setColor(Color.white);
              g.drawString("HP  :"+hp ,10,70);
              g.setColor(Color.white);
              g.drawString("Ammo : "+ammo,10,90);
               g.setColor(Color.white);
              g.drawString("MOVES : "+moves,10,110);
              
              
              
              
                
                
                    
                    
             
                    
                
                  
              
             
            /////////////////////////////////////
            
            g.dispose();
            bs.show();
             
        }
        
        
        /////// loading level 
        
        
        private void loadLevel(BufferedImage image )
        {
            int w = image.getWidth();
            int h = image.getHeight();
            for(int xx =0 ; xx < w ; xx++)
            {
                for(int yy=0 ; yy<h ; yy++)
                {
                    int pixel = image.getRGB(xx, yy);
                  
                    int red = (pixel >> 16 )& 0xff;
                    int green = (pixel>>8) & 0xff;
                    int blue = (pixel )& 0xff;
                    if (red == 255)
                        handler.addObject(new Block(xx*32 , yy*32 ,ID.Block,ss));
                    if(blue == 255)
                        handler.addObject(new Shooter(xx*32 ,yy*32 , ID.Player,handler,ss,this));
                    if(green ==255)
                        handler.addObject(new Enemy (xx*32 , yy*32 , ID.Enemy , handler,ss, this));
                    
                    
                    
                        
                }
            }
        }
        
        
        
        
     public static void main(String[] args)
    {
      
        Game game = new Game();
       
        
       
        
        
    }
      

    
}

