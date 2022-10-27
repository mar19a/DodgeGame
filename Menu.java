import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
 

 
import java.awt.*;
 
public class Menu extends MouseAdapter  {
 
   private Game game;
   private Handler handler ;
   private HUD hud;
   private Random r = new Random();
   public Menu(Game game, Handler handler, HUD hud)
   {
       this.game = game;
       this.hud = hud;
       this.handler = handler;
   }
  public void mousePressed(MouseEvent e)
  {
 
 
       int mx = e.getX();
       int my = e.getY();

       if(game.gameState == Game.STATE.Menu)
       {
        
            /* play */
       if(mouseOver(mx,my,210, 150, 200, 64))
       {
           /*game.gameState = Game.STATE.Game;
           handler.addObject(new Player(Game.WIDTH/2 - 32 , Game.HEIGHT/2 - 32, ID.Player, handler));
           handler.clearEnemys();
           handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
            */

            game.gameState = Game.STATE.Select;
            return;
       }

       /* help */
       if(mouseOver(mx, my, 210, 250, 200, 64))
       {
        game.gameState = Game.STATE.Help;
       }

       
       /*quit */
       if(mouseOver(mx,my,210,350,200,64))
       {
        System.exit(1);
       }
       }

       if(game.gameState == Game.STATE.Select)
       {
        
            /* normal button */
       if(mouseOver(mx,my,210, 150, 200, 64))
       {
           game.gameState = Game.STATE.Game;
           handler.addObject(new Player(Game.WIDTH/2 - 32 , Game.HEIGHT/2 - 32, ID.Player, handler));
           handler.clearEnemys();
           handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
            
            game.diff = 0;
       }

       /* hard button*/
       if(mouseOver(mx, my, 210, 250, 200, 64))
       {
        game.gameState = Game.STATE.Game;
        handler.addObject(new Player(Game.WIDTH/2 - 32 , Game.HEIGHT/2 - 32, ID.Player, handler));
        handler.clearEnemys();
        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
         
         game.diff = 1;
       }

       
       /*back button */
       if(mouseOver(mx,my,210,350,200,64))
       {
         game.gameState = Game.STATE.Menu;
       }
       }

       /* back button for help */

       if(game.gameState == Game.STATE.Help)
       {
            if(mouseOver(mx,my,210, 350, 200,64))
            {
                game.gameState = Game.STATE.Menu;
                return;
            }
       }

       if(game.gameState == Game.STATE.End)
       {
            if(mouseOver(mx,my,210, 350, 200,64))
            {
                game.gameState = Game.STATE.Menu;
               // return;

               hud.setLevel(1);
               hud.setScore(0);
          
            }
       }
  }
 
  public void mouseReleased(MouseEvent e)
  {
 
  }
  private boolean mouseOver(int mx, int my,int x, int y, int width, int height)
  {
   if( mx > x && mx < x + width )
   {
       if(my > y && my < y + height)
       {
           return true;
       } else return false;
   } else return false;
  }
   public void tick()
   {
 
   }
   public void render( Graphics g)
   {
    if(game.gameState == Game.STATE.Menu)
    {

    
       Font fnt = new Font("arial", 1 ,50);
       Font fnt2 = new Font("arial", 1 ,30);
     
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("DODGE", 240,70);
 
 
       g.setFont(fnt2);
       g.drawRect(210,150,200, 64);
       g.drawString("Start", 280,190);
 
       g.drawRect(210,250,200, 64);
       g.drawString("Help", 280,290);
 
       g.drawRect(210,350,200, 64);
       g.drawString("Exit", 280,390);
    } else if(game.gameState == Game.STATE.Help)
    {
        Font fnt = new Font("arial", 1 ,50);
        Font fnt2 = new Font("arial", 1 ,30);
        Font fnt3 = new Font("arial", 1 ,20);
      
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help", 270,70);

        g.setFont(fnt3);
        g.drawString("Move and Dodge Enemies By Using The WASD Keys", 50,200);
        g.setFont(fnt2);
        g.drawRect(210,350,200, 64);
        g.drawString("Back", 270,390);
    } else if(game.gameState == Game.STATE.End)
    {
        Font fnt = new Font("arial", 1 ,50);
        Font fnt2 = new Font("arial", 1 ,30);
        Font fnt3 = new Font("arial", 1 ,20);
      
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Game Over", 180,70);

        g.setFont(fnt3);
        g.drawString("You lost with a score of: " + hud.getScore() , 190,200);
        g.setFont(fnt2);
        g.drawRect(210,350,200, 64);
        g.drawString("Try Again", 245,390);
    } else if(game.gameState == Game.STATE.Select)
    {

    
       Font fnt = new Font("arial", 1 ,50);
       Font fnt2 = new Font("arial", 1 ,30);
     
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("SELECT DIFFICULTY", 90,70);
 
 
       g.setFont(fnt2);
       g.drawRect(210,150,200, 64);
       g.drawString("Normal", 265,190);
 
       g.drawRect(210,250,200, 64);
       g.drawString("Hard", 275,290);
 
       g.drawRect(210,350,200, 64);
       g.drawString("Back", 275,390);
    }

   }
  
}
