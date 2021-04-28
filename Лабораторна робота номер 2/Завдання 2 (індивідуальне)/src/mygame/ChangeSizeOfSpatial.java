/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Home
 */
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;


/**
 *
 * @author Home
 */
public class ChangeSizeOfSpatial extends AbstractControl {
    
    private Vector3f localScale;
     private Vector3f minScale;
     private Vector3f maxScale;
    
    private float speed;
    
    private boolean ud;
    
    private Vector3f addUpTo;
    
      public ChangeSizeOfSpatial(){}
    
        
      
      public void setLocalScale(Vector3f local)
      {
          localScale = local;
      }
      public Vector3f getLocalScale()
      {
          return localScale;
      }
      public void setSpeed(float spd)
      {
          speed = spd;
      }
      public float getSpeed (float spd)
      {
       
          return speed;
      }
         @Override
    protected void controlUpdate(float tpf){
   
             
        if(spatial != null) {
            
            System.out.println(speed+" "+ud+" "+localScale+" "+maxScale+" "+minScale+" "+addUpTo);
            if(ud)
            {
                localScale=localScale.add(addUpTo);
                spatial.setLocalScale(localScale);
                if(vectorEquality(localScale,maxScale))ud = false;
                
                
            }
            else
            { 
               localScale = localScale.subtract(addUpTo);
                spatial.setLocalScale(localScale);
                if(vectorEquality(minScale,localScale))ud = true;
                
                
            }
            
            
            
        }
    }
    
    public boolean vectorEquality(Vector3f fv,Vector3f sv)
    {
        
        return (fv.x)>(sv.x)?(fv.y)>(sv.y)?(fv.z)>(sv.z):false:false;
    }
  @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        if(spatial != null)
        {
            
           localScale = spatial.getLocalScale();
           
           minScale = localScale.clone();
           
           maxScale = minScale.clone().mult(1.5f);
           
           addUpTo = maxScale.clone().subtract(minScale);
           
           addUpTo = addUpTo.divide(speed);
           
           ud = true;
        }
        else
        {
            localScale = null;
            maxScale = null;
            minScale = null;
            addUpTo = null;
            
            
        }
        
        /* Example:
        if (spatial != null){
            // initialize
        }else{
            // cleanup
        }
        */
    }
    @Override
    public ControlToRotate cloneForSpatial(Spatial spatial)
    {
        final ControlToRotate control = new ControlToRotate();
        control.setSpatial(spatial);
        return control;
        
    }
      
      
      
      
      
      
      
     @Override
    protected void controlRender(RenderManager rm, ViewPort vp){
        
    }
    
}
