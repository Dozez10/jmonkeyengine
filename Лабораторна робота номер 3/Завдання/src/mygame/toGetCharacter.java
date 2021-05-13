/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Torus;
import java.util.List;

/**
 *
 * @author Ivan
 */
class toGetCharacter {

  Material matForBodyElements ;
  Material mathForHatElements ;
  Vector3f originPos;
 private Node bodyelements;
  private Node hat;
  private Node bodyParts;
  private Spatial head;
    public toGetCharacter(Vector3f originPos,Material mfbe,Material mfhe)
    {
    
        this.matForBodyElements = mfbe;
        this.mathForHatElements = mfhe;
        this.originPos = originPos;
        this.bodyParts = new Node("Bodyparts");
        this.bodyelements = new Node("BodyElements");
        this.hat = new Node("hat");
       
        
    }
      public Material getMatForBody()
  {
      return this.matForBodyElements;
  }
      public Material getMatForHat()
      {
      return this.mathForHatElements;
      
      }
    public Node getBody()
    {
        return this.bodyelements;
    } 
    public Node getHat()
    {
        return this.hat;
    }
    public void createABody()
    {
    
    this.bodyParts.setLocalTranslation(this.originPos);
    
    Geometry body = new Geometry("body",new Cylinder(10,10,0.5f,1f,true));
    
     body.rotate(FastMath.DEG_TO_RAD*90, 0, 0);
     this.head = new Geometry("head",new Sphere(10,10,0.35f));
     head.move(0,0.85f,0);
    Geometry rightArm = new Geometry("rightarm",new Cylinder(10,10,0.2f,0.7f,true));
    
    rightArm.move(0.9f,0,0);
    rightArm.rotate(FastMath.DEG_TO_RAD*90, 0, FastMath.DEG_TO_RAD*45);
       
    
    Geometry leftArm = new Geometry("leftarm",new Cylinder(10,10,0.2f,0.7f,true));
    
         leftArm.move(-0.9f,0,0);
         leftArm.rotate(FastMath.DEG_TO_RAD*90, 0, -FastMath.DEG_TO_RAD*45);
         
    Geometry leftLeg = new Geometry("leftleg",new Cylinder(10,10,0.28f,0.8f,true));
    
    leftLeg.move(-0.35f,-1,0);

       leftLeg.rotate(FastMath.DEG_TO_RAD*90,0,0);
       
    Geometry rightLeg = new Geometry("rightleg",new Cylinder(10,10,0.28f,0.8f,true));
    
     rightLeg.move(0.35f,-1,0);
   
     rightLeg.rotate(FastMath.DEG_TO_RAD*90,0,0);
    this.bodyelements.attachChild(body);
      this.bodyelements.attachChild(head);
        this.bodyelements.attachChild(leftArm);
         this.bodyelements.attachChild(rightArm);
            this.bodyelements.attachChild(leftLeg);
              this.bodyelements.attachChild(rightLeg);
            
           List<Spatial> bparts =   this.bodyelements.getChildren();
           for(Spatial part : bparts)
           {
                 if(part instanceof Geometry)
                 {
                     ((Geometry)part).setMaterial(this.matForBodyElements);
                 }
               
               
           }
   
   
    
    Geometry headGear = new Geometry("headgear",new Torus(10,10,0.15f,0.4f));
    Geometry headCylinder = new Geometry("headcylinder",new Cylinder(10,10,0.2f,0.5f,true));
   
    this.hat.attachChild(headGear);
    this.hat.attachChild(headCylinder);
    this.hat.rotate(-FastMath.DEG_TO_RAD*90,0,0);
    this.hat.move(0,1.3f,0);
    this.hat.setMaterial(this.mathForHatElements);
    headCylinder.move(0,0,0.4f);
    this.bodyParts.attachChild( this.bodyelements);
    this.bodyParts.attachChild( this.hat);
    
    }
    public Node  getCharacter()
    {
   
    
    return this.bodyParts;
         
    }
    
    public void setHead(Spatial modelOfHead)
    {
        
        this.bodyelements.detachChild(this.head);
        this.head = modelOfHead;
        this.head.setLocalTranslation(Vector3f.ZERO);
        this.head.move(0,0.53f,0);
        this.bodyelements.attachChild(this.head);
    }


}