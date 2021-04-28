package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Exersice1 extends SimpleApplication {

    Geometry player;
       private boolean isRunning = true;
       
       
    public static void main(String[] args) {
        Exersice1 app = new Exersice1();
        app.start();
    }

    @Override
    public void simpleInitApp() {
   
        Box b = new Box(1, 1, 1);
        player = new Geometry("Player", b);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        player.setMaterial(mat);
        rootNode.attachChild(player);
        initKeys(); // load my custom keybinding
      
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
       
    }
     private void initKeys() {
        // You can map one or several inputs to one named action
    
        inputManager.addMapping("Up",   new KeyTrigger(KeyInput.KEY_H), new MouseAxisTrigger(MouseInput.AXIS_WHEEL,false));
        inputManager.addMapping("Down",  new KeyTrigger(KeyInput.KEY_J),new MouseAxisTrigger(MouseInput.AXIS_WHEEL,true));
    
        // Add the names to the action listener.
        inputManager.addListener(actionListener, "Pause");
        inputManager.addListener(analogListener, "Up", "Down");
    }
        private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("Pause") && !keyPressed) {
                isRunning = !isRunning;
            }
        }
    };
                    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {
            if (isRunning) {
               
                if (name.equals("Up")) {
                    Vector3f v = player.getLocalTranslation();
                    player.setLocalTranslation(v.x,value*speed+v.y , v.z);
                }
                if (name.equals("Down")) {
                    Vector3f v = player.getLocalTranslation();
                    player.setLocalTranslation(v.x ,v.y - value*speed, v.z);
                }
            } else {
                System.out.println("Press P to unpause.");
            }
        }
    };
}
