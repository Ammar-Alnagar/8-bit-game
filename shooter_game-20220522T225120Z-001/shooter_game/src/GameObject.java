
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class GameObject 
{
   protected int x,y;
   protected float velx = 0 , vely = 0 ;
   private ID id ;
   protected SpriteSheet ss;
   public int hp  =100 ;
    
    public GameObject(int x , int y, ID id, SpriteSheet ss  )
    {
        this.x = x ; 
        this.y= y ;
        this.id = id ;
        this.ss = ss;
        
    }
    public abstract void tick();
    public abstract void render(Graphics g );
    public abstract Rectangle getBounds();

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the velx
     */
    public float getVelx() {
        return velx;
    }

    /**
     * @param velx the velx to set
     */
    public void setVelx(float velx) {
        this.velx = velx;
    }

    /**
     * @return the vely
     */
    public float getVely() {
        return vely;
    }

    /**
     * @param vely the vely to set
     */
    public void setVely(float vely) {
        this.vely = vely;
    }

    /**
     * @return the id
     */
    public ID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ID id) {
        this.id = id;
    }
    
    
    
    
    
}
