package jme3test.helloworld;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**

 * @author Ivan
 */
public class HelloJME3 extends SimpleApplication {

    public static void main(String[] args) {
        HelloJME3 app = new HelloJME3();
        app.start();
    }

    @Override
    public void simpleInitApp() {
         Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);  
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  
        mat.setColor("Color", ColorRGBA.Blue);  
        geom.setMaterial(mat);                   
        rootNode.attachChild(geom);  
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
