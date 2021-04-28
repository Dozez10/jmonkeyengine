package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Exersice extends SimpleApplication {

    Geometry box;
    public static void main(String[] args) {
        Exersice app = new Exersice();
        app.start();
    }

    @Override
    public void simpleInitApp() {
       Material mbox = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
       mbox.setColor("Color", ColorRGBA.Blue);
             this.box = new Geometry("boxToRotate",new Box(1,1,1));
             box.setMaterial(mbox);
           rootNode.attachChild(box);
        
        
    }

    @Override
    public void simpleUpdate(float tpf)
    {
        box.rotate(0,2*tpf,0);
             
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
