package applet;

import entidades.Drawable;
/**
 *
 * @author yeray
 */
public interface ConectionManager{ 
        public abstract void sendScene(Drawable scene);
        public abstract Drawable receiveScene();
}
