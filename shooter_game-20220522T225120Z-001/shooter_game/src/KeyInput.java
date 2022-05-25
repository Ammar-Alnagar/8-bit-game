
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ammar
 */
public class KeyInput  extends KeyAdapter
{
    private Handler handler;
    Game  game;

	public KeyInput(Handler handler , Game game) {
		this.handler = handler;
                this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
                                        game.moves--;
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
                                         game.moves--;
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
                                         game.moves--;
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
                                         game.moves--;
				}
                                if ( game.moves == 0 )
                                {
                                     System.out.println("GAME OVER !!!");
                                    System.out.println("you lost due moves hitting ZERO!");
                                     System.out.println("You have accumulated ->" +game.point+ "    Points");
                                    System.exit(0);
                                }
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(false);
				}
			}
		}
	}
}
