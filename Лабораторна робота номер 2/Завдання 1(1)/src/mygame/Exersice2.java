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
public class Exersice2 extends SimpleApplication {
    int i=0;
    Geometry box;
boolean growOrNot = true;
    
    public static void main(String[] args) {
        Exersice2 app = new Exersice2();
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
      
        if(i<100)
        {
            box.scale(1.008f);
            i++;
            
        }
        else if(i>=100&&i<200)
        {
            box.scale(1/1.008f);
            i++;
        }
        else{
            i=0;
        }
             
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
}
