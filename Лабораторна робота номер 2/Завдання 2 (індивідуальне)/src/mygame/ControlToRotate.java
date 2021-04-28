/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

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
public class ControlToRotate extends AbstractControl {
    
    private Vector3f angle;
    
    private float speed;
    
      public ControlToRotate(){}
    
        public ControlToRotate(Vector3f angleToRotate,float spd){
            angle = angleToRotate;
            speed = spd;
        }
      
      
      public void setAngle(Vector3f angleToRotate)
      {
          angle = angleToRotate;
      }
      public Vector3f getAngle()
      {
          return angle;
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
            spatial.rotate(angle.x*tpf*speed,angle.y*tpf*speed,angle.z*tpf*speed);
        }
    }
  @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
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
        final ControlToRotate control = new ControlToRotate(angle,speed);
        control.setSpatial(spatial);
        return control;
        
    }
      
      
      
      
      
      
      
     @Override
    protected void controlRender(RenderManager rm, ViewPort vp){
        
    }
    
}
