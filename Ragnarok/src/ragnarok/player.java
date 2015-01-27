
package ragnarok;

/**
 *
 * @author Beau Marwaha
 */
import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class player {

    private String craft = "viking_Sprites/walkingS.gif";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int health;
    private boolean dead;
    private Image image;

    private ArrayList missiles;
    private ArrayList missilesDirections;
    
    private final int CRAFT_SIZE = 20;

    public player(int health) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        missiles = new ArrayList();
        missilesDirections = new ArrayList();
        x = 40;
        y = 60;
        this.health = health;
        dead = false;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getImgW() {
        return image.getWidth(null);
    }

    public int getImgH() {
        return image.getHeight(null);
    }
    
    public int getHealth(){
        return health;
    }
    
    public void hit(int damage){
        health -= damage;
        if(health <= 0){
            dead = true;
        }
    }

    public Image getImage() {
        return image;
    }

    public ArrayList getMissiles() {
        return missiles;
    }
    
    public ArrayList getMissilesDirections() {
        return missilesDirections;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            fireLeft();
        }
        
        if(key == KeyEvent.VK_RIGHT){
            fireRight();
        }
        
        if(key == KeyEvent.VK_UP){
            fireUp();
        }
        
        if(key == KeyEvent.VK_DOWN){
            fireDown();
        }

        if (key == KeyEvent.VK_A) {
            if(x > 0){
                dx = -1;
            }else{
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_D) {
            if(x < 900){
                dx = 1;
            }else{
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_W) {
            if(y > 0){
                dy = -1;
            }else{
                dy = 0;
            }
        }

        if (key == KeyEvent.VK_S) {
            if(y < 700){
                dy = 1;
            }else{
                dy = 0;
            }
        }
    }

    public void fireUp() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("up"));
    }
    
    public void fireDown() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("down"));
    }
    
    public void fireLeft() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("left"));
    }
    
    public void fireRight() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("right"));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}
