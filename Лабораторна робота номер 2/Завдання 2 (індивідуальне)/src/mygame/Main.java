package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
 private toGetCharacter character1;
 
private toGetCharacter character2;

private toGetCharacter character3;


boolean foRC1 = false;
boolean foRC2 = false;
boolean foRC3 = false;
ControlToRotate ctr1;
ControlToRotate ctr2;
ControlToRotate ctr3;

int status1 ;
int status2 ;
int status3 ;

boolean shiftIsPressed = false;

boolean check1 = false;

boolean check2 = false;

boolean check3 = false;

private ChangeSizeOfSpatial css1;
private ChangeSizeOfSpatial css2;
private ChangeSizeOfSpatial css3;

private Node nodes;

private ActionListener actionListener1;
  private ActionListener actionListener2;
   private ActionListener actionListener3;
     private ActionListener actionListener4;
    private ActionListener actionListener5;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
     
    }
//OZ OX OY
  
    @Override
    public void simpleInitApp()
    {
    
        initCharacters();
        initTriggers();
        initCrossHairs() ;
        nodes  = new Node("nodes");
        rootNode.attachChild(nodes);
        nodes.attachChild(character1.getCharacter());
        nodes.attachChild(character2.getCharacter());
        nodes.attachChild(character3.getCharacter());
        status1 = 1;
        status2 = 1;
        status3 = 1;
        ctr1 = null;
        ctr2 = null;
        ctr3 = null;
        css1 = null;
        css2 = null;
        css3 = null;
           
    }
    
    public void initCharacters()
    {
      
        Material matForHats = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        matForHats.setColor("Color", ColorRGBA.Yellow);
      
        this.character1 = new toGetCharacter(new Vector3f(1,0,3),new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md"),matForHats);
        this.character2 = new toGetCharacter(new Vector3f(3.8f,0,3),new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md"),matForHats);
   
        this.character3 = new toGetCharacter(new Vector3f(6.6f,0,3),new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md"),matForHats);
        
        this.character1.getMatForBody().setColor("Color", ColorRGBA.Pink);
        this.character2.getMatForBody().setColor("Color", ColorRGBA.Green);
        this.character3.getMatForBody().setColor("Color", ColorRGBA.Gray);
        
        character1.createABody();
        character2.createABody();
        character3.createABody();
        
        
    }
    //Magenta C`A Cyan C`B LightGray C`C
    
    private void  initTriggers()
    {
        
    
    
    inputManager.addMapping("ChangeColorCharacterOne", new KeyTrigger(KeyInput.KEY_1));
    inputManager.addMapping("ChangeColorCharacterTwo", new KeyTrigger(KeyInput.KEY_2));
    inputManager.addMapping("ChangeColorCharacterThree", new KeyTrigger(KeyInput.KEY_3));
    inputManager.addMapping("Rotate1", new KeyTrigger(KeyInput.KEY_F));
    inputManager.addMapping("Rotate2", new KeyTrigger(KeyInput.KEY_G));
    inputManager.addMapping("Rotate3", new KeyTrigger(KeyInput.KEY_H));
    inputManager.addMapping("SizeChange1", new KeyTrigger(KeyInput.KEY_COMMA));
    inputManager.addMapping("SizeChange2", new KeyTrigger(KeyInput.KEY_PERIOD));
    inputManager.addMapping("SizeChange3", new KeyTrigger(KeyInput.KEY_SLASH));
    inputManager.addMapping("ToPress", new KeyTrigger(KeyInput.KEY_LSHIFT));
     inputManager.addMapping("begin", new KeyTrigger(KeyInput.KEY_Z));
     inputManager.addMapping("clickOnHat",new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
   actionListener1 = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {

        
        
      if (name.equals("ChangeColorCharacterOne") && keyPressed) { 
          
          if(!foRC1)
          {
           character1.getMatForBody().setColor("Color", ColorRGBA.Magenta);
           foRC1 = true;
              
         
           
          }
           else
          {
               character1.getMatForBody().setColor("Color", ColorRGBA.Pink);
               foRC1 = false;
              
          }
                         
      }
     else if (name.equals("ChangeColorCharacterTwo") && keyPressed) { 
          
           if(!foRC2)
          {
           character2.getMatForBody().setColor("Color", ColorRGBA.Cyan);
           foRC2 = true;
           
          }
           else
          {
               character2.getMatForBody().setColor("Color", ColorRGBA.Green);
               foRC2 = false;
              
          }
                         
      }
          else if (name.equals("ChangeColorCharacterThree") && keyPressed) { 
          
            if(!foRC3)
          {
           character3.getMatForBody().setColor("Color", ColorRGBA.LightGray);
           foRC3 = true;
           
          }
           else
          {
               character3.getMatForBody().setColor("Color", ColorRGBA.Gray);
               foRC3 = false;
              
          }
                         
      }

          

    }
  };
    
      actionListener2 = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {

        
        
      if (name.equals("Rotate1") && keyPressed) { 
          
          if(status1 == 1){
          
          if(ctr1 == null)
          {
              ctr1 = new ControlToRotate();
              
          }
          
          ctr1.setAngle(new Vector3f(0,0,FastMath.DEG_TO_RAD*10));
          ctr1.setSpeed(40);
          character1.getCharacter().addControl(ctr1);
          status1 = 2;
          
          
          }
          
          
          else if (status1 ==2)
          {
              if(ctr1 == null)
              {
                   ctr1 = new ControlToRotate();
                  
                  
              }
               ctr1.setSpeed(40);
               ctr1.setAngle(new Vector3f(0,0,-FastMath.DEG_TO_RAD*10));
              status1 = 3;
              
          }
              else
          {
              
              character1.getCharacter().removeControl(ctr1);
              ctr1 = null;
              status1 = 1;
              
          }
          
         
                         
      }
     else if (name.equals("Rotate2") && keyPressed) { 
         
              if(status2 == 1){
          
          if(ctr2 == null)
          {
              ctr2 = new ControlToRotate();
              
          }
          
          ctr2.setAngle(new Vector3f(FastMath.DEG_TO_RAD*10,0,0));
          ctr2.setSpeed(40);
          character2.getCharacter().addControl(ctr2);
          status2 = 2;
          
          
          }
          
          
          else if (status2 ==2)
          {
              if(ctr2 == null)
              {
                   ctr2 = new ControlToRotate();
                  
                  
              }
               ctr2.setSpeed(40);
               ctr2.setAngle(new Vector3f(-FastMath.DEG_TO_RAD*10,0,0));
               status2 = 3;
              
          }
              else
          {
              
              character2.getCharacter().removeControl(ctr2);
              ctr2 = null;
              status2 = 1;
              
          }
       
         
                         
      }
          else if (name.equals("Rotate3") && keyPressed) { 
          
       
                    if(status3 == 1){
          
          if(ctr3 == null)
          {
              ctr3 = new ControlToRotate();
              
          }
          
          ctr3.setAngle(new Vector3f(0,FastMath.DEG_TO_RAD*10,0));
          ctr3.setSpeed(40);
          character3.getCharacter().addControl(ctr3);
          status3 = 2;
          
          
          }
          
          
          else if (status3 ==2)
          {
              if(ctr3 == null)
              {
                   ctr3 = new ControlToRotate();
                  
                  
              }
               ctr3.setSpeed(40);
               ctr3.setAngle(new Vector3f(0,-FastMath.DEG_TO_RAD*10,0));
               status3 = 3;
              
          }
              else
          {
              
              character3.getCharacter().removeControl(ctr3);
              ctr3 = null;
              status3 = 1;
              
          }
              
      }

          

    }
  };
 
   
   
   
     actionListener3 = new ActionListener() {
         
    public void onAction(String name, boolean keyPressed, float tpf)
    {

        
        if(name.equals("ToPress")&&keyPressed){
            
            
            shiftIsPressed = !shiftIsPressed;
            
        }
        
        else if(name.equals("ToPress")&&!keyPressed)
             {
                 
                 shiftIsPressed = !shiftIsPressed;
                 
             }
        
        
        else if(name.equals("SizeChange1")&&!keyPressed && shiftIsPressed)
             
        {
           
        
            if(css1 ==  null)
            {
                css1 = new ChangeSizeOfSpatial();
                css1.setSpeed(10);
               
               
            }
            if(!check1){
               
            character1.getCharacter().addControl(css1);
            check1 = true;
            }
            else 
            {
                character1.getCharacter().removeControl(css1);
                check1 = false;
            }
            
            
        }
        
        
        else if(name.equals("SizeChange2")&&!keyPressed&&shiftIsPressed)
            
             {
                 
                
            if(css2 ==  null)
            {
                css2 = new ChangeSizeOfSpatial();
                css2.setSpeed(10);
               
               
            }
            if(!check2){
               
            character2.getCharacter().addControl(css2);
            check2 = true;
            }
            else 
            {
                character2.getCharacter().removeControl(css2);
                check2 = false;
            }
                 
                 
             }
        
        else if (name.equals("SizeChange3")&&!keyPressed&&shiftIsPressed)
             {
             
                 
                     if(css3 ==  null)
            {
                css3 = new ChangeSizeOfSpatial();
                css3.setSpeed(10);
               
               
            }
            if(!check3){
               
            character3.getCharacter().addControl(css3);
            check3 = true;
            }
            else 
            {
                character3.getCharacter().removeControl(css3);
                check3 = false;
            }
             
                 
             }
            
        
        


          

    }
    
    
    
  };
   
    actionListener4 = new ActionListener() {
    
            public void onAction(String name, boolean keyPressed, float tpf)
            {
                
                
            
                
                if(name.equals("begin")&&keyPressed)
                {
                    
                  character1.getCharacter().removeControl(ctr1);
                  character1.getCharacter().removeControl(css1);
                  character2.getCharacter().removeControl(ctr2);
                  character2.getCharacter().removeControl(css2);
                  character3.getCharacter().removeControl(ctr3);
                  character3.getCharacter().removeControl(css3);
                  
                   rootNode.detachChild(nodes);
                   nodes.detachAllChildren();
                   initCharacters();
                 
                   rootNode.attachChild(nodes);
                       nodes.attachChild(character1.getCharacter());
                        nodes.attachChild(character2.getCharacter());
                       nodes.attachChild(character3.getCharacter());
        status1 = 1;
        status2 = 1;
        status3 = 1;
        ctr1 = null;
        ctr2 = null;
        ctr3 = null;
        css1 = null;
        css2 = null;
        css3 = null;
                    
                }
        
        
    }
    
    
    
  };
     
   
   actionListener5 = new ActionListener() {
    
            public void onAction(String name, boolean keyPressed, float tpf)
            {
                
                
            
                
                if(name.equals("clickOnHat")&&keyPressed)
                {
                    
                    
        CollisionResults results = new CollisionResults();
     
        Ray ray = new Ray(cam.getLocation(), cam.getDirection());
      
        nodes.collideWith(ray, results);
    
      
        if (results.size() > 0) { 
            
          CollisionResult closest = results.getClosestCollision();
          
           Node hat = closest.getGeometry().getParent();
           hat.getParent().detachChild(hat);
             
                 
        }
 
                    
                    
                    
                    
                
                    
                }
        
        
    }
    
    
    
  };

    
   
     inputManager.addListener(actionListener1, new String[]{"ChangeColorCharacterOne","ChangeColorCharacterTwo","ChangeColorCharacterThree"});
     inputManager.addListener(actionListener2, new String[]{"Rotate1","Rotate2","Rotate3"});
     inputManager.addListener(actionListener3, new String[]{"ToPress","SizeChange1","SizeChange2","SizeChange3"});
     inputManager.addListener(actionListener4, "begin");
       inputManager.addListener(actionListener5, "clickOnHat");
  
    }

                
     protected void initCrossHairs() 
    {
    setDisplayStatView(false);
    guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
    BitmapText ch = new BitmapText(guiFont, false);
    ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
    ch.setText("+"); // crosshairs
    ch.setLocalTranslation( // center
      settings.getWidth() / 2 - ch.getLineWidth()/2,
      settings.getHeight() / 2 + ch.getLineHeight()/2, 0);
    guiNode.attachChild(ch);
  }
           
           
 

    @Override
    public void simpleUpdate(float tpf) {
 
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        
      
        
    }
    
    
}
