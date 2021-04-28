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
public class Exersice1 extends SimpleApplication {
    
    Geometry box;
    Geometry box1;
    
    public static void main(String[] args) {
        Exersice1 app = new Exersice1();
        app.start();
    }

    @Override
    public void simpleInitApp() {
       Material mbox = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
       mbox.setColor("Color", ColorRGBA.Blue);
       
       Material mbox1 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
       
       mbox1.setColor("Color", ColorRGBA.Red);
       
       this.box = new Geometry("boxToRotate",new Box(1,1,1));
       
       this.box1 = new Geometry("boxToRotate1",new Box(1,1,1));
            
       this.box1.move(3f,0,0);

       
            box.setMaterial(mbox);
            box1.setMaterial(mbox1);
            
           rootNode.attachChild(box);
           rootNode.attachChild(box1);
        
        
    }

    @Override
    public void simpleUpdate(float tpf)
    {
      
        box.rotate(0,tpf,0);
       box1.rotate(0,2*tpf,0);
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
}
