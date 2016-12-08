package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import physics.*;

public class Board {
	private int width = HadiCezmi.BOARD_WIDTH;
	private int height = HadiCezmi.BOARD_HEIGHT;
	private Color color = new Color(0, 0, 255);
	private Ball ball;
	private Engel engel;
	private Cezmi cezmi1;
	private Cezmi cezmi2;
	private GizmoFactory gizmoFactory;
	private ArrayList<Gizmo> gizmoArrayList;
	
	
	public Board() {
		super();
		ball = new Ball();
		engel = new Engel();
		cezmi1 = new Cezmi(110, 500);
		cezmi2 = new Cezmi(350, 500);
		gizmoFactory = GizmoFactory.getInstance();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void paint(Graphics g) {
	    // modifies: the Graphics object <g>.
	    // effects: paints a circle on <g> reflecting the current position
	    // of the ball.

	    // the "clip rectangle" is the area of the screen that needs to be
	    // modified
	    Rectangle clipRect = g.getClipBounds();

	    // For this tiny program, testing whether we need to redraw is
	    // kind of silly.  But when there are lots of objects all over the
	    // screen this is a very important performance optimization
	    if (clipRect.intersects(this.boundingBox())) {
	      g.setColor(color);
	      g.fillRect(0, 0, width, height);
	    }
	  }
  
  public Rectangle boundingBox() {
	    // effect: Returns the smallest rectangle that completely covers the
	    //         current position of the ball.

	    // a Rectangle is the x,y for the upper left corner and then the
	    // width and height
	    return new Rectangle(0, 0, width, height);
	  }
  
  public void changeBallPosition(double x, double y){
	  ball.setX(x);
	  ball.setY(y);
  }
  
  public void changeBallVelocity(double vx, double vy){
	  ball.setVx(vx);
	  ball.setVy(vy);
  }
  
  public void changeCezmiPosition(int i, int x, int y){
	  if(i == 1){
		  cezmi1.setX(x);
		  cezmi2.setY(y);
	  } else if(i == 2) {
		  cezmi2.setX(x);
		  cezmi2.setY(y);  
	  }
  }
  
  public void moveCezmi(int cezmiNumber, String direction){
	  if(cezmiNumber == 1){
		  if (direction == "left"){
			  cezmi1.moveLeft();
		  }
		  else if (direction == "right"){
			  cezmi1.moveRight();
		  }
	  }
	  else if(cezmiNumber == 2){
		  if (direction == "left"){
			  cezmi1.moveLeft();
		  }
		  else if (direction == "right"){
			  cezmi1.moveRight();
		  }
	  }
  }
  
  public void addGizmo(String type, int x, int y){
	  boolean valid = true;
	  for(Gizmo element: gizmoArrayList){
		  if (element.getX() == x && element.getY() == y){
			  valid = false;
		  }
	  }
	  if (valid){
		  Gizmo g = gizmoFactory.createGizmo(type, x, y);
		  gizmoArrayList.add(g);
	  }
}
  
  public void rotateGizmo(int x, int y){
	  for(Gizmo element: gizmoArrayList){
		  if (element.getX() == x && element.getY() == y){
			  element.rotate();
		  }
	  }
	 
  }
  
  public void deleteGizmo(int x, int y){
	  for(Gizmo element: gizmoArrayList){
		  if (element.getX() < x && x < (element.getX() + width)
				  && element.getY() < y && y < (element.getY() + height)){
			  gizmoArrayList.remove(element);
		  }
	  }
  }
  
  public void moveGizmo(int oldX, int oldY, int x, int y){
	  for(Gizmo element: gizmoArrayList){
		  if (element.getX() < oldX && oldX < (element.getX() + width)
				  && element.getY() < oldY && oldY < (element.getY() + height)){
			  element.setX(x);
			  element.setY(x);
		  }
	  }
  }
  
  public boolean verifyGizmo(int x, int y){
	  for(Gizmo element: gizmoArrayList){
		  if (element.getX() < oldX && oldX < (element.getX() + width)
				  && element.getY() < oldY && oldY < (element.getY() + height)){
			  return true;
		  }
	  }
	  return false;
  }
  
  
  
  
  public void checkCollision(){
	  	
	  	Circle ballCircle = new Circle(ball.getX(),ball.getY(),ball.getRadius());
		Vect ballVelocity = new Vect(ball.getVx(),ball.getVy());
		Circle cezmiCircle1 = new Circle(cezmi1.getX(), cezmi1.getY(),cezmi1.getRadius());
		Circle cezmiCircle2 = new Circle(cezmi2.getX(), cezmi2.getY(),cezmi2.getRadius());
		Vect ballVector = new Vect(ball.getX(),ball.getX());
		Vect cezmiVector1 = new Vect(cezmi1.getX(), cezmi1.getY());
		Vect cezmiVector2 = new Vect(cezmi2.getX(), cezmi2.getY());
		
		if(Geometry.timeUntilCircleCollision(cezmiCircle1, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(cezmiVector1, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());

		}
		
		if(Geometry.timeUntilCircleCollision(cezmiCircle2, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(cezmiVector2, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());

		}
		
		//takozlar

      for (int i=0; i<gizmoArrayList.size(); i++ ) {
      	Gizmo gizmo = gizmoArrayList.get(i);
          
      	Vect topLeftCorner = new Vect(gizmo.getX(),gizmo.getY());
          Circle topLeftCircle = new Circle(topLeftCorner.x(),topLeftCorner.y(), 1);
          Vect topRightCorner = new Vect((gizmo.getX()+gizmo.getRadius()),gizmo.getY());
          Circle topRightCircle = new Circle(topRightCorner.x(),topRightCorner.y(), 1);
          Vect bottomLeftCorner = new Vect(gizmo.getX(),(gizmo.getY()+gizmo.getRadius()));
          Circle bottomLeftCircle = new Circle(bottomLeftCorner.x(),bottomLeftCorner.y(), 1);
          Vect bottomRightCorner = new Vect((gizmo.getX()+gizmo.getRadius()),(gizmo.getY()+gizmo.getRadius()));
          Circle bottomRightCircle = new Circle(bottomRightCorner.x(),bottomRightCorner.y(), 1);

          LineSegment topLine = new LineSegment(topLeftCorner, topRightCorner);
          LineSegment rightLine = new LineSegment(topRightCorner, bottomRightCorner);
          LineSegment bottomLine = new LineSegment(bottomLeftCorner, bottomRightCorner);
          LineSegment leftLine = new LineSegment(topLeftCorner, bottomLeftCorner);

          if(Geometry.timeUntilWallCollision(topLine, ballCircle, ballVelocity) <= 0.01){
              Vect returnedVector =Geometry.reflectWall(topLine,ballVelocity);
              ball.setVx(returnedVector.x());
  			ball.setVy(returnedVector.y());
          }else if(Geometry.timeUntilWallCollision(rightLine, ballCircle, ballVelocity) <=0.01){
              Vect returnedVector =Geometry.reflectWall(rightLine,ballVelocity);
              ball.setVx(returnedVector.x());
  			ball.setVy(returnedVector.y());
          }else if(Geometry.timeUntilWallCollision(bottomLine, ballCircle, ballVelocity) <=0.01){
              Vect returnedVector =Geometry.reflectWall(bottomLine,ballVelocity);
              ball.setVx(returnedVector.x());
  			ball.setVy(returnedVector.y());
          }else if(Geometry.timeUntilWallCollision(leftLine, ballCircle, ballVelocity) <= 0.01){
              Vect returnedVector =Geometry.reflectWall(leftLine,ballVelocity);
              ball.setVx(returnedVector.x());
  			ball.setVy(returnedVector.y());
  			
      }else if(Geometry.timeUntilCircleCollision(topLeftCircle, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(topLeftCorner, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());
			
			
		}else if(Geometry.timeUntilCircleCollision(topRightCircle, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(topRightCorner, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());
			
		}else if(Geometry.timeUntilCircleCollision(bottomLeftCircle, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(bottomLeftCorner, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());
			
		}else if(Geometry.timeUntilCircleCollision(bottomRightCircle, ballCircle, ballVelocity) == 0){

			Vect returnedVector = Geometry.reflectCircle(bottomRightCorner, ballVector, ballVelocity);
			ball.setVx(returnedVector.x());
			ball.setVy(returnedVector.y());
		}
         ball.move();
	}

  }
  
  

  
  
  
  
  
  
  
  
  
	
	
	
}
