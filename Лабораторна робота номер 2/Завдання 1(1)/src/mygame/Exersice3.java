/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Home
 */
public class Exersice3 extends SimpleApplication {
   
    Geometry box;
Material mbox;
    
    public static void main(String[] args) {
        Exersice3 app = new Exersice3();
        app.start();
    }

    @Override
    public void simpleInitApp() {
      this.mbox = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
       this.mbox.setColor("Color", ColorRGBA.randomColor());
     
      
       this.box = new Geometry("boxToRotate",new Box(1,1,1));
    

  
            box.setMaterial(mbox);
      
            
           rootNode.attachChild(box);
          
        
        
    }

    @Override
    public void simpleUpdate(float tpf)
    {
      
            mbox.setColor("Color", ColorRGBA.randomColor());
             
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
}
