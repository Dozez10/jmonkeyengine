/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Home
 */
public class Exersice4 extends SimpleApplication {
   
    Geometry box;

    
    public static void main(String[] args) {
        Exersice4 app = new Exersice4();
        app.start();
    }

    @Override
    public void simpleInitApp() {
      Material mbox = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
      mbox.setColor("Color", ColorRGBA.randomColor());
       this.box = new Geometry("boxToRotate",new Box(1,1,1));
 
            box.setMaterial(mbox);
      
            
           rootNode.attachChild(box);
          
        
        
    }

    @Override
    public void simpleUpdate(float tpf)
    {
      
           box.rotate(FastMath.DEG_TO_RAD*1,0,0);
           box.move(0,0,0.0001f);
             
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
}
