package jme3test.helloworld;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**

 * @author Ivan
 */
public class HelloNode extends SimpleApplication {

    public static void main(String[] args) {
        HelloNode app = new HelloNode();
        app.start();
    }

    @Override
    public void simpleInitApp() {
         Box box1 = new Box(1,1,1);
        Geometry blue = new Geometry("Box", box1);
        blue.setLocalTranslation(new Vector3f(1,-1,1));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Blue);
        blue.setMaterial(mat1);

       
        Box box2 = new Box(1,1,1);
        Geometry red = new Geometry("Box", box2);
        red.setLocalTranslation(new Vector3f(1,3,1));
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
        red.setMaterial(mat2);

     
        Node pivot = new Node("pivot");
        
        rootNode.attachChild(pivot); 

        pivot.attachChild(blue);
        pivot.attachChild(red);
      
        pivot.rotate(.4f,.4f,0f);
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
