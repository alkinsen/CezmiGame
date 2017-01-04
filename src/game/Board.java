package game;

import java.awt.Color;
import java.util.*;

import physics.*;

public class Board extends Observable{
    private int width = HadiCezmi.BOARD_WIDTH;
    private int height = HadiCezmi.BOARD_HEIGHT;
    private Color color = new Color(0, 0, 255);
    private Ball ball;
    private Ball ball2;
    private Engel engel;
    private Cezmi cezmi1;
    private Cezmi cezmi2;
    private GizmoFactory gizmoFactory;
    private ArrayList<Gizmo> gizmoArrayList;
    private boolean[] cezeryeSpecialEffect;
    private double gravity;
    private double friction;
    private int level;
    private double mu = 0.005/(double)200;
    private double mu2 = 0.005/(double)200;
    private int delta_t;

    private double maxVel = 0.0;
    
    private boolean cezeryeAppear = false;
    private int countdown = -1;


    public Board(int level) {
        super();
        ball = new Ball();
        ball2 = new Ball();
        ball2.setColor(new Color(5,100,100));
        engel = new Engel();
        cezmi1 = new Cezmi(HadiCezmi.UNIT_LENGTH*4, HadiCezmi.UNIT_LENGTH*25, level);
        cezmi2 = new Cezmi(HadiCezmi.UNIT_LENGTH*15, HadiCezmi.UNIT_LENGTH*25, level);
        gizmoFactory = GizmoFactory.getInstance();
        gizmoArrayList = new ArrayList<Gizmo>();
        addGizmo("Cezerye", 1000, 1000);
        cezeryeSpecialEffect = new boolean[3];
        gravity = 20;
        this.level = level;
        delta_t = level;
    }

    public Ball getBall() {
        return ball;
    }

    public Ball getBall2() {
        return ball2;
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


    public void changeBallPosition(double x, double y) {
        ball.setX(x);
        ball.setY(y);
    }

    public void changeBallVelocity(double vx, double vy) {
        ball.setVx(vx);
        ball.setVy(vy);
    }

    public void changeBall2Velocity(double vx, double vy) {
        ball2.setVx(vx);
        ball2.setVy(vy);
    }
    public void changeBall2Position(double x, double y) {

        ball2.setX(x);
        ball2.setY(y);
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
            Gizmo g = gizmoFactory. getGizmo(type, x, y);
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
    
    

    public void rotateGizmo(int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() == x && element.getY() == y) {
                element.rotate();
            }
        }

    }

    public void deleteGizmo(int x, int y) {
    	Iterator<Gizmo> iter = gizmoArrayList.iterator();
        while (iter.hasNext()){
        	Gizmo element = iter.next();
            if (element.getX() <= x && x <= (element.getX() + width)
                    && element.getY() <= y && y <= (element.getY() + height)) {
                iter.remove();
                gizmoArrayList.remove(element);
            }
        }
    }

    public void moveGizmo(int oldX, int oldY, int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() < oldX && oldX < (element.getX() + width)
                    && element.getY() < oldY && oldY < (element.getY() + height)) {
                element.setX(x);
                element.setY(y);
            }
        }
    }

    public boolean verifyGizmo(int x, int y) {
        for (Gizmo element : gizmoArrayList) {
            if (element.getX() < x && x < (element.getX() + element.getWidth())
                    && element.getY() < y && y < (element.getY() + element.getHeight())) {
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


    public void checkCollision( boolean leftPressed, boolean rightPressed){
        checkCollisionAndReflectBall(getBall(), leftPressed, rightPressed);
        if(getLevel() == 2.0) {
            checkCollisionAndReflectBall(getBall2(), leftPressed, rightPressed);
        }
        //ball related vectors
        Circle ballCircle = new Circle(ball.getX(), ball.getY(), ball.getRadius());
        Vect ballVelocity = new Vect(ball.getVx(), ball.getVy());
        Vect ballVector = new Vect(ball.getX(), ball.getX());

        //ball2 related vectors
        Circle ball2Circle = new Circle(ball2.getX(), ball2.getY(), ball2.getRadius());
        Vect ball2Velocity = new Vect(ball2.getVx(), ball2.getVy());
        Vect ball2Vector = new Vect(ball2.getX(), ball2.getX());

        if(getLevel() == 2 && Geometry.timeUntilBallBallCollision(ballCircle, ballVelocity, ball2Circle, ball2Velocity) <= 0){
            System.out.println("ball to ball2");
            Vect returnVectBall = Geometry.reflectCircle(ballVector, ball2Vector, ballVelocity);
            Vect returnVectBall2 = Geometry.reflectCircle(ball2Vector, ballVector, ball2Velocity);
            changeBallVelocity(returnVectBall.x(), returnVectBall.y());
            changeBall2Velocity(returnVectBall2.x(), returnVectBall2.y());

        }
        
      //check the situation of cezerye
        if(!cezeryeAppear && countdown == -1){
        	countdown = (int) (1000 + Math.random()*200*25);
        }else if(!cezeryeAppear && countdown == 0){
        	int xLoc = (int)(Math.random()*24.0) * 20;
        	int yLoc = (int)(Math.random()*18.0) * 20  + 40;
        	boolean validity = this.verifyGizmo(xLoc, yLoc);
        	while(validity){
                xLoc = (int)(Math.random()*24.0) * 20;
                yLoc = (int)(Math.random()*12.0) * 20  + 120;
            	validity = this.verifyGizmo(xLoc, yLoc);
        	}

            getCezerye().setX(xLoc);
            getCezerye().setY(yLoc);
        	cezeryeAppear=true;
            getCezerye().setCezeryeAppear(cezeryeAppear);
        	countdown=1000;
        }else if(!cezeryeAppear && countdown>0){
        	countdown--;
        }else if(cezeryeAppear && countdown >0){
        	countdown--;
        }else if(cezeryeAppear && countdown == 0){
        	cezeryeAppear=false;
            getCezerye().setCezeryeAppear(cezeryeAppear);
            getCezerye().setX(1000);
            getCezerye().setY(1000);
            countdown = (int) (1000 + Math.random()*200*25);
        }
    }
    public void checkCollisionAndReflectBall(Ball ball, boolean leftPressed, boolean rightPressed) {
        Double[] score = new Double[2];

    	//apply the friction
    	Vect ballVel = new Vect(ball.getVx(),ball.getVy());
    	friction = (double)1-mu*(double)delta_t-mu2*ballVel.length()*(double)delta_t;
    	double velLength = ballVel.length()*friction;
    	ballVel = new Vect(ballVel.angle(),velLength);
    	ball.setVx(ballVel.x());
        ball.setVy(ballVel.y());

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

        //duvar vectors
        Vect boardTopLeftCorner = new Vect(0, 0);
        Circle boardTopLeftCircle = new Circle(boardTopLeftCorner.x(), boardTopLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect boardTopRightCorner = new Vect(width, 0);
        Circle boardTopRightCircle = new Circle(boardTopRightCorner.x(), boardTopRightCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect boardBottomLeftCorner = new Vect(0, height);
        Circle boardBottomLeftCircle = new Circle(boardBottomLeftCorner.x(), boardBottomLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect boardBottomRightCorner = new Vect(width, height);
        Circle boardBottomRightCircle = new Circle(boardBottomRightCorner.x(), boardBottomRightCorner.y(), HadiCezmi.CORNER_RADIUS);

        LineSegment boardTopLine = new LineSegment(boardTopLeftCorner, boardTopRightCorner);
        LineSegment boardRightLine = new LineSegment(boardTopRightCorner, boardBottomRightCorner);
        LineSegment boardBottomLine = new LineSegment(boardBottomLeftCorner, boardBottomRightCorner);
        LineSegment boardLeftLine = new LineSegment(boardTopLeftCorner, boardBottomLeftCorner);

        //duvar collision
        if (Geometry.timeUntilWallCollision(boardTopLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(boardTopLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            if(ball.getState().equals("Cezmi")){
                score[0] = ball.getPlayer();
                score[1] = 0.5;
                setChanged();
                notifyObservers(score);
            }
        } else if (Geometry.timeUntilWallCollision(boardRightLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(boardRightLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        } else if (Geometry.timeUntilWallCollision(boardBottomLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(boardBottomLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            double player = 1;
            if(ball.getX()<engel.getX()){
            	player = 2;
            }
            score[0] = player;
            score[1] = ball.getScore();
            setChanged();
            notifyObservers(score);
        } else if (Geometry.timeUntilWallCollision(boardLeftLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(boardLeftLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        }
        else if (Geometry.timeUntilCircleCollision(boardTopLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(boardTopLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());


        } else if (Geometry.timeUntilCircleCollision(boardTopRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(boardTopRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(boardBottomLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(boardBottomLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());

        } else if (Geometry.timeUntilCircleCollision(boardBottomRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(boardBottomRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
        }

        //cezmi1 collision
        if (Geometry.timeUntilCircleCollision(cezmiCircle1, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectCircle(cezmiVector1, ballVector, ballVelocity);

            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            ball.setState("Cezmi");
            ball.setPlayer(2.0);

        }

        //cezmi2 collision
        if (Geometry.timeUntilCircleCollision(cezmiCircle2, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectCircle(cezmiVector2, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            ball.setState("Cezmi");
            ball.setPlayer(1.0);

        }

        //engel collision
        if(engelCollision(engel, ball, ballCircle, ballVelocity, ballVector)){
            if(!ball.getState().equals("Reset") && ball.getPlayer() != 0) {
                score[0] = ball.getPlayer();
                score[1] = 0.5;
                setChanged();
                notifyObservers(score);
                ball.setState("Reset");
            }
        }

        //takozlar
        for (int i = 0; i < gizmoArrayList.size(); i++) {
            Gizmo gizmo = gizmoArrayList.get(i);

            if (gizmo instanceof SquareTakoz) {
                if(quadrilateralCollision(gizmo, ball, ballCircle, ballVelocity, ballVector)) {
                    ball.setState("SquareTakoz");
                }

            }else if(gizmo instanceof  Tokat){
                if( quadrilateralCollision(gizmo, ball, ballCircle, ballVelocity, ballVector)){
                    ball.setScore(2.0);
                    ball.setState("Tokat");
                    ball.setTokatCounter(2000);
                }
            } else if (gizmo instanceof TriangleTakoz) {
                if(triangularCollision(gizmo, ball, ballCircle,ballVelocity, ballVector)) {
                    ball.setState("TriangularTakoz");
                }
            }else if (gizmo instanceof Cezerye && cezeryeAppear){
                if(checkCezeryeCollision(gizmo, ball, ballCircle, ballVelocity, ballVector)){
                    countdown = (int) (1000 + Math.random()*200*25);
                    cezeryeAppear=false;
                    getCezerye().setCezeryeAppear(cezeryeAppear);
                    getCezerye().setX(1000);
                    getCezerye().setY(1000);
                    countdown = (int) (1000 + Math.random()*200*25);

                    Random rand = new Random();
                    int specialEffectNumber = rand.nextInt(3);
                    resetSpecialEffect();

                    switch (specialEffectNumber) {
                        case 0:
                            if(ball.getPlayer() == 2){
                                halveRightSideGizmos();
                            }else if( ball.getPlayer() == 1){
                                halveLeftSideGizmos();
                            }
                            cezeryeSpecialEffect[0] = true;

                            break;
                        case 1:
                            if(ball.getPlayer() == 2){
                                doubleLeftSideGizmos();
                            }else if( ball.getPlayer() == 1){
                                doubleRightSideGizmos();
                            }
                            cezeryeSpecialEffect[1] = true;
                            break;
                        case 2:
                            if(ball.getPlayer() == 2){
                                cezmi2.setVx(0);
                            }else if( ball.getPlayer() == 1){
                                cezmi1.setVx(0);
                            }
                            cezeryeSpecialEffect[2] = true;
                            break;
                    }

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

        cezmi1.resetVx();
        cezmi2.resetVx();

        ball.move();

    }

    private void resetSpecialEffect() {
        if(cezeryeSpecialEffect[0] || cezeryeSpecialEffect[1]){
            for (Gizmo gizmo : gizmoArrayList) {
                gizmo.reset();
            }
            cezeryeSpecialEffect[0] = false;
            cezeryeSpecialEffect[1] = false;
        }
        if(cezeryeSpecialEffect[2]){
            resetCezmiVelocities();
            cezeryeSpecialEffect[2] = false;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        this.cezmi1.setCezmiLevel(level);
        this.cezmi2.setCezmiLevel(level);
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


    public void resetBallPositions() {
        Random random = new Random();
        if(getLevel() == 1){
            int x = random.nextInt(400)+50;
            int y = random.nextInt(200)+50;
            changeBallPosition(x,y);
            while(verifyGizmo(x,y)){
                x = random.nextInt(400)+50;
                y = random.nextInt(200)+50;
                changeBallPosition(x,y);
            }
        }else if(getLevel() == 2){
            int x = random.nextInt(400)+50;
            int y = random.nextInt(200)+50;
            changeBallPosition(x,y);
            x =random.nextInt(400)+50;
            y = random.nextInt(200)+50;
            changeBall2Position(x,y);
            while(verifyGizmo(x,y)){
                x =random.nextInt(400)+50;
                y = random.nextInt(200)+50;
                changeBallPosition(x,y);
            }
            while(verifyGizmo(x,y)){
                x =random.nextInt(400)+50;
                y = random.nextInt(200)+50;
                changeBall2Position(x,y);
                changeBall2Position(x,y);
            }
        }
        ball.setState("Reset");
        ball.setScore(1.0);
        ball.setPlayer(0);
        ball2.setState("Reset");
        ball2.setScore(1.0);
        ball2.setPlayer(0);
    }

    public void resetBallVelocities(){
        Random random = new Random();
        if(getLevel() == 1){
            double vx = random.nextDouble()*2 - 1.0;
            double vy = 0.0;
            changeBallVelocity(vx, vy);
        }else if(getLevel() == 2){
            double vx = random.nextDouble()*2 - 1.0;
            double vy = 0.0;
            changeBallVelocity(vx, vy);
            vx = random.nextDouble();
            changeBall2Velocity(vx, vy);
        }
    }

    public boolean quadrilateralCollision(Gizmo gizmo, Ball ball, Circle ballCircle, Vect ballVelocity, Vect ballVector){
        boolean result = false;
        Gizmo temp = (Gizmo) gizmo;
        Vect p1 = temp.getPoints()[0];
        Vect p2 = temp.getPoints()[1];
        Vect p3 = temp.getPoints()[2];
        Vect p4 = temp.getPoints()[3];

        Circle topLeftCircle = new Circle(p1.x(), p1.y(), HadiCezmi.CORNER_RADIUS);
        Circle topRightCircle = new Circle(p2.x(), p2.y(), HadiCezmi.CORNER_RADIUS);
        Circle bottomLeftCircle = new Circle(p3.x(), p3.y(), HadiCezmi.CORNER_RADIUS);
        Circle bottomRightCircle = new Circle(p4.x(), p4.y(), HadiCezmi.CORNER_RADIUS);

        LineSegment topLine = new LineSegment(p1, p2);
        LineSegment rightLine = new LineSegment(p2, p3);
        LineSegment bottomLine = new LineSegment(p4, p1);
        LineSegment leftLine = new LineSegment(p1, p4);

        if (Geometry.timeUntilWallCollision(topLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(topLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(rightLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(rightLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(bottomLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(bottomLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(leftLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(leftLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        }
        else if (Geometry.timeUntilCircleCollision(topLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p1, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;


        } else if (Geometry.timeUntilCircleCollision(topRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p2, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        } else if (Geometry.timeUntilCircleCollision(bottomLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p4, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        } else if (Geometry.timeUntilCircleCollision(bottomRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p3, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        }


        return result;
    }
    public boolean triangularCollision(Gizmo gizmo, Ball ball,  Circle ballCircle, Vect ballVelocity, Vect ballVector){
        boolean result = false;
        TriangleTakoz temp = (TriangleTakoz) gizmo;
        Vect p1 = temp.getPoints()[0];
        Vect p2 = temp.getPoints()[1];
        Vect p3 = temp.getPoints()[2];

        Circle circle1 = new Circle(p1.x(), p1.y(), HadiCezmi.CORNER_RADIUS);
        Circle circle2 = new Circle(p2.x(), p2.y(), HadiCezmi.CORNER_RADIUS);
        Circle circle3 = new Circle(p3.x(), p3.y(), HadiCezmi.CORNER_RADIUS);

        LineSegment line1 = new LineSegment(p1, p2);
        LineSegment line2 = new LineSegment(p2, p3);
        LineSegment line3 = new LineSegment(p3, p1);

        if (Geometry.timeUntilWallCollision(line1, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(line1, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(line2, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(line2, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(line3, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(line3, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        }
        else if (Geometry.timeUntilCircleCollision(circle1, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p1, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;


        } else if (Geometry.timeUntilCircleCollision(circle2, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p2, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        } else if (Geometry.timeUntilCircleCollision(circle3, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(p3, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        }
        return result;
    }
    public boolean engelCollision(Engel engel, Ball ball,  Circle ballCircle, Vect ballVelocity, Vect ballVector){
        boolean result = false;

        Vect engelTopLeftCorner = new Vect(engel.getX(), engel.getY());
        Circle engelTopLeftCircle = new Circle(engelTopLeftCorner.x(), engelTopLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect engelTopRightCorner = new Vect((engel.getX() + engel.getWidth()), engel.getY());
        Circle engelTopRightCircle = new Circle(engelTopRightCorner.x(), engelTopRightCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect engelBottomLeftCorner = new Vect(engel.getX(), (engel.getY() + engel.getHeight()));
        Circle engelBottomLeftCircle = new Circle(engelBottomLeftCorner.x(), engelBottomLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect engelBottomRightCorner = new Vect((engel.getX() + engel.getWidth()), (engel.getY() + engel.getHeight()));
        Circle engelBottomRightCircle = new Circle(engelBottomRightCorner.x(), engelBottomRightCorner.y(), HadiCezmi.CORNER_RADIUS);


        LineSegment engelTopLine = new LineSegment(engelTopLeftCorner, engelTopRightCorner);
        LineSegment engelRightLine = new LineSegment(engelTopRightCorner, engelBottomRightCorner);
        LineSegment engelBottomLine = new LineSegment(engelBottomLeftCorner, engelBottomRightCorner);
        LineSegment engelLeftLine = new LineSegment(engelTopLeftCorner, engelBottomLeftCorner);

        if (Geometry.timeUntilWallCollision(engelTopLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(engelTopLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(engelRightLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(engelRightLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(engelBottomLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(engelBottomLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        } else if (Geometry.timeUntilWallCollision(engelLeftLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            Vect returnedVector = Geometry.reflectWall(engelLeftLine, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;
        }
        else if (Geometry.timeUntilCircleCollision(engelTopLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(engelTopLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;


        } else if (Geometry.timeUntilCircleCollision(engelTopRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(engelTopRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        } else if (Geometry.timeUntilCircleCollision(engelBottomLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(engelBottomLeftCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        } else if (Geometry.timeUntilCircleCollision(engelBottomRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {

            Vect returnedVector = Geometry.reflectCircle(engelBottomRightCorner, ballVector, ballVelocity);
            ball.setVx(returnedVector.x());
            ball.setVy(returnedVector.y());
            result = true;

        }

        return result;

    }

    public boolean checkCezeryeCollision(Gizmo cezerye, Ball ball, Circle ballCircle, Vect ballVelocity, Vect ballVector){
        boolean result = false;

        Vect cezeryeTopLeftCorner = new Vect(cezerye.getX(), cezerye.getY());
        Circle cezeryeTopLeftCircle = new Circle(cezeryeTopLeftCorner.x(), cezeryeTopLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect cezeryeTopRightCorner = new Vect((cezerye.getX() + cezerye.getWidth()), cezerye.getY());
        Circle cezeryeTopRightCircle = new Circle(cezeryeTopRightCorner.x(), cezeryeTopRightCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect cezeryeBottomLeftCorner = new Vect(cezerye.getX(), (cezerye.getY() + cezerye.getHeight()));
        Circle cezeryeBottomLeftCircle = new Circle(cezeryeBottomLeftCorner.x(), cezeryeBottomLeftCorner.y(), HadiCezmi.CORNER_RADIUS);
        Vect cezeryeBottomRightCorner = new Vect((cezerye.getX() + cezerye.getWidth()), (cezerye.getY() + cezerye.getHeight()));
        Circle cezeryeBottomRightCircle = new Circle(cezeryeBottomRightCorner.x(), cezeryeBottomRightCorner.y(), HadiCezmi.CORNER_RADIUS);


        LineSegment cezeryeTopLine = new LineSegment(cezeryeTopLeftCorner, cezeryeTopRightCorner);
        LineSegment cezeryeRightLine = new LineSegment(cezeryeTopRightCorner, cezeryeBottomRightCorner);
        LineSegment cezeryeBottomLine = new LineSegment(cezeryeBottomLeftCorner, cezeryeBottomRightCorner);
        LineSegment cezeryeLeftLine = new LineSegment(cezeryeTopLeftCorner, cezeryeBottomLeftCorner);


        if (Geometry.timeUntilWallCollision(cezeryeTopLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilWallCollision(cezeryeRightLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilWallCollision(cezeryeBottomLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilWallCollision(cezeryeLeftLine, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilCircleCollision(cezeryeTopLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilCircleCollision(cezeryeTopRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilCircleCollision(cezeryeBottomLeftCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        } else if (Geometry.timeUntilCircleCollision(cezeryeBottomRightCircle, ballCircle, ballVelocity) <= HadiCezmi.TIME_COLLISION) {
            result = true;
        }

        return result;

    }
    public void doubleLeftSideGizmos(){
        for (Gizmo gizmo : gizmoArrayList) {
            if(gizmo.getX() < HadiCezmi.BOARD_WIDTH/2){
                gizmo.setHeight(gizmo.getHeight()*2);
                gizmo.setWidth(gizmo.getWidth()*2);
            }
        }
    }
    public void doubleRightSideGizmos(){
        for (Gizmo gizmo : gizmoArrayList) {
            if(gizmo.getX() > HadiCezmi.BOARD_WIDTH/2){
                gizmo.setHeight(gizmo.getHeight()*2);
                gizmo.setWidth(gizmo.getWidth()*2);
            }
        }
    }
    public void halveLeftSideGizmos(){
        for (Gizmo gizmo : gizmoArrayList) {
            if(gizmo.getX() < HadiCezmi.BOARD_WIDTH/2){
                gizmo.setHeight(gizmo.getHeight()/2);
                gizmo.setWidth(gizmo.getWidth()/2);
            }
        }
    }
    public void halveRightSideGizmos(){
        for (Gizmo gizmo : gizmoArrayList) {
            if(gizmo.getX() > HadiCezmi.BOARD_WIDTH/2){
                gizmo.setHeight(gizmo.getHeight()/2);
                gizmo.setWidth(gizmo.getWidth()/2);
            }
        }
    }

    public void changeBallDiameters(double score1, double score2) {
        if(((score1 + score2) % 2.0) == 0){
            if(ball.getRadius() > HadiCezmi.UNIT_LENGTH/5) {
                ball.setRadius(ball.getRadius() - HadiCezmi.UNIT_LENGTH / 10);
                ball2.setRadius(ball2.getRadius() - HadiCezmi.UNIT_LENGTH / 10);
            }
        }

    }

    public Cezerye getCezerye() {

        for (Gizmo gizmo : gizmoArrayList) {
            if(gizmo instanceof Cezerye){
                return (Cezerye) gizmo;
            }
        }
        return null;
    }

    public void resetCezmiVelocities() {
        cezmi1.resetVx();
        cezmi2.resetVx();
    }
}