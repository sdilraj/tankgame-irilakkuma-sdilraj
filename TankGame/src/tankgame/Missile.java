package tankgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Missile extends GameObject{
    private long timer = 0;
    private final int SPEED = 4;
    private int tankXPos = TankWars.getTank().x;
    public static boolean launch = false;
    private Tank tk;
    private Wall w;
    
    public Missile(ObjectID id, int x, int y, Image img) {
        super(id, x, y, img);
    }
    
    //shoot according to the direction
    //loop it to continue going
    //reload the bullet and the image
    //finish the shoot process once it hits the wall/tank
    public void shoot() {
        int i = 0;
        
        while(i != 20)
        {
            this.x += 10;
            i++;
            
        }
         
    }        
    
    public void getStats() {
    }
    
    public boolean isHit() {
        return false;
    }
    
    public void reload() {
        
    }
    
    public boolean isLaunched() {
        return launch;
    }

    @Override
    public void update() {
        x += velX;
    }

    @Override
    public void draw(Graphics2D g2D) {
        // Since x based on x coordinates of tank, doesn't work really well when moving and shooting
        g2D.drawImage(Img, x, y, null);
    }

    @Override
    public Rectangle checkBounds() {
        return null;
    }

    @Override
    public boolean collide() {
        return true;
    }
    
    public void keyPressed(KeyEvent e) {
        //if (System.currentTimeMillis() - timer > 1500) {
        int code = e.getKeyCode();
        switch(code){
        case KeyEvent.VK_SPACE:
            launch = true;
            x = TankWars.getTank().x + 60;
            y = TankWars.getTank().y + 20;
            velX = SPEED;
            timer = System.currentTimeMillis();
            break;
        }
        //}
    }
}
