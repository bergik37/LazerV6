

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;



public class DesktopLauncher {
	public static void main (String[] arg) {
		Game myGame = new LazerLogik ();
		LwjglApplication launcher = new LwjglApplication(
				myGame, "LazerLogik", 800, 600 );
	}
}
