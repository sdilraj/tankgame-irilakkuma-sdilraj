package tankgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Tank extends GameObject{
    private boolean launch = false;
    private final int SPEED = 2;
    private int health = 100;
    private final int DAMGE = 25;
     
    public Tank(ObjectID id, int x, int y, Image Img) {
        super(id, x, y, Img);
    }

    @Override
    public void update() {
        //if (!collide()) {
            x += velX;
            y += velY;
        /*} else {
            x += 0;
            y += 0;
        }*/
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.drawImage(Img, x, y, null);
        //if(launch == true) {
            //for (int i = 0; i < 100; i++) 
                //g2D.drawImage(bullet.get(0).Img, x + (Img.getWidth(null)), y + (Img.getHeight(null)/3), null);
        //}
    }
    
    @Override
    public Rectangle checkBounds() {
        return new Rectangle(x, y, Img.getWidth(null), Img.getHeight(null));
    }
    
    @Override
    public boolean collide() {
        //Tank_2 tank = TankWars.getTank_2();
        Tank_2 tank = TankWars.getTank_2();
        return checkBounds().intersects(tank.checkBounds());
    }
    
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code){
        case KeyEvent.VK_DOWN:
            velY = SPEED;
            break;
        case  KeyEvent.VK_UP:
            velY = -SPEED;
            break;
        case  KeyEvent.VK_LEFT:
            velX = -SPEED;
            break;
        case KeyEvent.VK_RIGHT:
            velX = SPEED;
            break;
        case KeyEvent.VK_C:
            launch = true;
            break;
        }        
    }
    
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code){
        case KeyEvent.VK_DOWN:
            velY = 0;
            break;
        case  KeyEvent.VK_UP:
            velY = 0;
            break;
        case  KeyEvent.VK_LEFT:
            velX = 0;
            break;
        case KeyEvent.VK_RIGHT:
            velX = 0;
            break;
        case KeyEvent.VK_C:
            launch = false;
            break;
        }
    }
}
