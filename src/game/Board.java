package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import physics.*;

public class Board extends Observable{
    private int width = HadiCezmi.BOARD_WIDTH;
    private int height = HadiCezmi.BOARD_HEIGHT;
    private Color color = new Color(0, 0, 255);
    private Ball ball;
    private Engel engel;
    private Cezmi cezmi1;
    private Cezmi cezmi2;
    private GizmoFactory gizmoFactory;
    private ArrayList<Gizmo> gizmoArrayList;
    private double gravity;
    private double friction;
    private int level;


    public Board(int level) {
        super();
        ball = new Ball();
        engel = new Engel();
        cezmi1 = new Cezmi(110, 500, level);
        cezmi2 = new Cezmi(350, 500, level);
        gizmoFactory = GizmoFactory.getInstance();
        gizmoArrayList = new ArrayList<Gizmo>();
        gravity = 20;
        friction = level;
        this.level = level;
    }

    public Ball getBall() {
        return ball;
    }

    public Engel getEngel() {
        return engel;
    }

    public Cezmi getCezmi1() {
        return cezmi1;
    }

    public Cezmi getCezmi2() {
        return cezmi2;
    }

    public ArrayList<Gizmo> getGizmoArrayList() {
        return gizmoArrayList;
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

    public void changeBallPosition(double x, double y) {
        ball.setX(x);
        ball.setY(y);
    }

    public void changeBallVelocity(double vx, double vy) {
        ball.setVx(vx);
        ball.setVy(vy);
    }

    public void changeCezmiPosition(int i, double x) {
        if (i == 1) {
            cezmi1.setX(x);
        } else if (i == 2) {
            cezmi2.setX(x);
        }
    }

    public void changeCezmiPosition(int i, double x, double y) {
        if (i == 1) {
            cezmi1.setX(x);
            cezmi1.setY(y);
        } else if (i == 2) {
            cezmi2.setX(x);
            cezmi2.setY(y);
        }
    }

    public void moveCezmi(int cezmiNumber, String direction) {
        if (cezmiNumber == 1) {
            if (direction.equalsIgnoreCase("left")) {
                cezmi1.moveLeft();
            } else if (direction.equalsIgnoreCase("right")) {
                cezmi1.moveRight();
            }
        } else if (cezmiNumber == 2) {
            if (direction.equalsIgnoreCase("left")) {
                cezmi2.moveLeft();
            } else if (direction.equalsIgnoreCase("right")) {
                cezmi2.moveRight();
            }
        }
    }

    public void addGizmo(String type, int x, int y) {
        boolean valid = true;
        for (int i = 0; i < gizmoArrayList.size(); i++) {
            Gizmo element = gizmoArrayList.get(i);
            if (element.getX() == x && element.getY() == y) {
                valid = false;
            }
        }
        if (valid) {
            Gizmo g = gizmoFactory.getGizmo(type, x, y);
            gizmoArrayList.add(g);
        }
    }

    public void addGizmo(String type, int x, int y, int orientation) {
        boolean valid = true;
        for (int i = 0; i < gizmoArrayList.size(); i++) {
            Gizmo element = gizmoArrayList.get(i);
            if (element.getX() == x && element.getY() == y) {
                valid = false;
            }
        }
        if (valid) {
            Gizmo g = gizmoFactory.getGizmo(type, x, y, orientation);
            gizmoArrayList.add(g);
        }
    }
    
    /*public void addGizmo(String type, int x, int y, double time) {
    	boolean valid = true;
    	for (int i = 0; i < gizmoArrayList.size(); i++) {
    		Gizmo element = gizmoArrayList.get(i);
    		if (element.getX() == x && element.getY() == y) {
    			valid = false;
    		}
    	}
    	if (valid) {
    		Gizmo g = gizmoFactory.getGizmo(type, x, y, time);
    		gizmoArrayList.add(g);
    	}
    }*/

    public void rotateGizmo(int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() == x && element.getY() == y) {
                element.rotate();
            }
        }

    }

    public void deleteGizmo(int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() < x && x < (element.getX() + width)
                    && element.getY() < y && y < (element.getY() + height)) {
                gizmoArrayList.remove(element);
            }
        }
    }

    public void moveGizmo(int oldX, int oldY, int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() < oldX && oldX < (element.getX() + width)
                    && element.getY() < oldY && oldY < (element.getY() + height)) {
                element.setX(x);
                element.setY(x);
            }
        }
    }

    public boolean verifyGizmo(int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() < x && x < (element.getX() + width)
                    && element.getY() < y && y < (element.getY() + height)) {
                return true;
            }
        }
        return false;
    }

    public void rotateTokat(String type) {

        for (Gizmo g : gizmoArrayList) {

            if ((g instanceof LeftTokat) && type.equalsIgnoreCase("left")) {

                g.rotate();

            } else if ((g instanceof RightTokat) && type.equalsIgnoreCase("right")) {

                g.rotate();

            }

        }

    }


    public void checkCollision(boolean leftPressed, boolean rightPressed) {

        //ball related vectors
        Circle ballCircle = new Circle(ball.getX(), ball.getY(), ball.getRadius());
        Vect ballVelocity = new Vect(ball.getVx(), ball.getVy());
        Vect ballVector = new Vect(ball.getX(), ball.getX());

        //cezmi1 related vectors
        Circle cezmiCircle1 = new Circle(cezmi1.getX(), cezmi1.getY(), cezmi1.getRadius());
        Vect cezmiVector1 = new Vect(cezmi1.getX(), cezmi1.getY());

        //cezmi2 related vectors
        Circle cezmiCircle2 = new Circle(cezmi2.getX(), cezmi2.getY(), cezmi2.getRadius());
        Vect cezmiVector2 = new Vect(cezmi2.getX(), cezmi2.getY());

        //engel related vectors
        Vect engelTopLeftCorner = new Vect(engel.getX(), engel.getY());
        Circle engelTopLeftCircle = new Circle(engelTopLeftCorner.x(), engelTopLeftCorner.y(), 1);
        Vect engelTopRightCorner = new Vect((engel.getX() + engel.getWidth()), engel.getY());
        Circle engelTopRightCircle = new Circle(engelTopRightCorner.x(), engelTopRightCorner.y(), 1);
        Vect engelBottomLeftCorner = new Vect(engel.getX(), (engel.getY() + engel.getHeight()));
        Circle engelBottomLeftCircle = new Circle(engelBottomLeftCorner.x(), engelBottomLeftCorner.y(), 1);
        Vect engelBottomRightCorner = new Vect((engel.getX() + engel.getWidth()), (engel.getY() + engel.getHeight()));
        Circle engelBottomRightCircle = new Circle(engelBottomRightCorner.x(), engelBottomRightCorner.y(), 1);

        LineSegment engelTopLine = new LineSegment(engelTopLeftCorner, engelTopRightCorner);
        LineSegment engelRightLine = new LineSegment(engelTopRightCorner, engelBottomRightCorner);
        LineSegment engelBottomLine = new LineSegment(engelBottomLeftCorner, engelBottomRightCorner);
        LineSegment engelLeftLine = new LineSegment(engelTopLeftCorner, engelBottomLeftCorner);

        //duvar vectors
        Vect boardTopLeftCorner = new Vect(0, 0);
        Circle boardTopLeftCircle = new Circle(boardTopLeftCorner.x(), boardTopLeftCorner.y(), 1);
        Vect boardTopRightCorner = new Vect(width, 0);
        Circle boardTopRightCircle = new Circle(boardTopRightCorner.x(), boardTopRightCorner.y(), 1);
        Vect boardBottomLeftCorner = new Vect(0, height);
        Circle boardBottomLeftCircle = new Circle(boardBottomLeftCorner.x(), boardBottomLeftCorner.y(), 1);
        Vect boardBottomRightCorner = new Vect(width, height);
        Circle boardBottomRightCircle = new Circle(boardBottomRightCorner.x(), boardBottomRightCorner.y(), 1);

        LineSegment boardTopLine = new LineSegment(boardTopLeftCorner, boardTopRightCorner);
        LineSegment boardRightLine = new LineSegment(boardTopRightCorner, boardBottomRightCorner);
        LineSegment boardBottomLine = new LineSegment(boardBottomLeftCorner, boardBottomRightCorner);
        LineSegment boardLeftLine = new LineSegment(boardTopLeftCorner, boardBottomLeftCorner);


        //duvar collision
        if (Geometry.timeUntilWallCollision(boardTopLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(boardTopLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(boardRightLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(boardRightLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(boardBottomLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelBottomLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            String score = "left";
            if(ball.getX()<engel.getX()){
            	score= "right";
            }
            System.out.println("carpisma var");
            setChanged();
            notifyObservers(score);
        } else if (Geometry.timeUntilWallCollision(boardLeftLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelLeftLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(boardTopLeftCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(boardTopLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());


        } else if (Geometry.timeUntilCircleCollision(boardTopRightCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(boardTopRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(boardBottomLeftCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(boardBottomLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(boardBottomRightCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(boardBottomRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        }

        //cezmi1 collision
        if (Geometry.timeUntilCircleCollision(cezmiCircle1, ballCircle, ballVelocity) == 0) {
            System.out.println("cezmi1");
            Vect returnedVector = Geometry.reflectCircle(cezmiVector1, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        }

        //cezmi2 collision
        if (Geometry.timeUntilCircleCollision(cezmiCircle2, ballCircle, ballVelocity) == 0) {
            System.out.println("cezmi2");

            Vect returnedVector = Geometry.reflectCircle(cezmiVector2, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        }

        //engel collision
        if (Geometry.timeUntilWallCollision(engelTopLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelTopLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(engelRightLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelRightLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(engelBottomLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelBottomLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(engelLeftLine, ballCircle, ballVelocity) <= 0.01) {
            Vect returnedVector = Geometry.reflectWall(engelLeftLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(engelTopLeftCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(engelTopLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());


        } else if (Geometry.timeUntilCircleCollision(engelTopRightCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(engelTopRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(engelBottomLeftCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(engelBottomLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(engelBottomRightCircle, ballCircle, ballVelocity) == 0) {

            Vect returnedVector = Geometry.reflectCircle(engelBottomRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        }

        //takozlar

        for (int i = 0; i < gizmoArrayList.size(); i++) {
            Gizmo gizmo = gizmoArrayList.get(i);

            if ((gizmo instanceof SquareTakoz) || (gizmo instanceof Tokat)) {

                Gizmo temp = (Gizmo) gizmo;
                Vect p1 = temp.getPoints()[0];
                Vect p2 = temp.getPoints()[1];
                Vect p3 = temp.getPoints()[2];
                Vect p4 = temp.getPoints()[3];

                Circle topLeftCircle = new Circle(p1.x(), p1.y(), 1);
                Circle topRightCircle = new Circle(p2.x(), p2.y(), 1);
                Circle bottomLeftCircle = new Circle(p3.x(), p3.y(), 1);
                Circle bottomRightCircle = new Circle(p4.x(), p4.y(), 1);

                LineSegment topLine = new LineSegment(p1, p2);
                LineSegment rightLine = new LineSegment(p2, p3);
                LineSegment bottomLine = new LineSegment(p4, p1);
                LineSegment leftLine = new LineSegment(p1, p4);

                if (Geometry.timeUntilWallCollision(topLine, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(topLine, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilWallCollision(rightLine, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(rightLine, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilWallCollision(bottomLine, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(bottomLine, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilWallCollision(leftLine, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(leftLine, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());

                } else if (Geometry.timeUntilCircleCollision(topLeftCircle, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p1, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());


                } else if (Geometry.timeUntilCircleCollision(topRightCircle, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p2, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());

                } else if (Geometry.timeUntilCircleCollision(bottomLeftCircle, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p4, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());

                } else if (Geometry.timeUntilCircleCollision(bottomRightCircle, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p3, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                }

            } else if (gizmo instanceof TriangleTakoz) {

                TriangleTakoz temp = (TriangleTakoz) gizmo;
                Vect p1 = temp.getPoints()[0];
                Vect p2 = temp.getPoints()[1];
                Vect p3 = temp.getPoints()[2];

                Circle circle1 = new Circle(p1.x(), p1.y(), 1);
                Circle circle2 = new Circle(p2.x(), p2.y(), 1);
                Circle circle3 = new Circle(p3.x(), p3.y(), 1);

                LineSegment line1 = new LineSegment(p1, p2);
                LineSegment line2 = new LineSegment(p2, p3);
                LineSegment line3 = new LineSegment(p3, p1);

                if (Geometry.timeUntilWallCollision(line1, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(line1, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilWallCollision(line2, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(line2, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilWallCollision(line3, ballCircle, ballVelocity) <= 0.01) {
                    Vect returnedVector = Geometry.reflectWall(line3, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());
                } else if (Geometry.timeUntilCircleCollision(circle1, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p1, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());


                } else if (Geometry.timeUntilCircleCollision(circle2, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p2, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());

                } else if (Geometry.timeUntilCircleCollision(circle3, ballCircle, ballVelocity) == 0) {

                    Vect returnedVector = Geometry.reflectCircle(p3, ballVector, ballVelocity);
                    ball.setVx(returnedVector.x());
                    ball.setVy(returnedVector.y());

                }
            }


        }
        for (Gizmo g : gizmoArrayList) {
            if (g instanceof Firildak) {
                g.rotate();
            } else if (g instanceof TriangleTakoz) {
                //g.rotate();
            } else if (g instanceof LeftTokat){
            	LeftTokat sample = (LeftTokat) g;
            	sample.rotate(leftPressed);
            	
            } else if (g instanceof RightTokat){
            	RightTokat sample = (RightTokat) g;
            	sample.rotate(rightPressed);
            	
            }
        }

        ball.move();

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double d) {
        this.gravity = d;
    }

    public double getFriction() {
        return friction;
    }

    public void setFriction(double friction) {
        this.friction = friction;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setEngel(Engel engel) {
        this.engel = engel;
    }

    public void setCezmi1(Cezmi cezmi1) {
        this.cezmi1 = cezmi1;
    }

    public void setCezmi2(Cezmi cezmi2) {
        this.cezmi2 = cezmi2;
    }

    public void setGizmoArrayList(ArrayList<Gizmo> gizmoArrayList) {
        this.gizmoArrayList = gizmoArrayList;
    }

    @Override
    public String toString() {
        return "Board [\n width=" + width + "\n height=" + height + "\n color=" + color + "\n ball=" + ball + "\n engel="
                + engel + "\n cezmi1=" + cezmi1 + "\n cezmi2=" + cezmi2
                + "\n gizmoArrayList=" + gizmoArrayList + "\n gravity=" + gravity + "\n friction=" + friction + "\n level="
                + level + "]";
    }


}