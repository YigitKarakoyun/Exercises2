import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TreeAnimation {
   public static final int SIZE_X = 1680;
   public static final int SIZE_Y = 1050;
   public static void main(String[] args) {
    
    PFrame pframe = new PFrame();      
    pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
    PCanvas c = new PCanvas((int)pframe.getBounds().getWidth(),(int)pframe.getBounds().getHeight());
    pframe.add(c);
    pframe.setVisible(true);
    }
}
class PFrame extends JFrame {  
  PFrame() {
    setUndecorated(true);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
    Action escapeAction = new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
      System.exit(0);
      }
    };
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke,"ESCAPE");
    getRootPane().getActionMap().put("ESCAPE", escapeAction);
  }
}
class PCanvas extends Canvas {
  public static final double TRIM_FACTOR = 0.80;
  public static int SIZE_X;
  public static int SIZE_Y;
  public static final double INITIAL_LENGTH = 180;
  public static final double EXIT_LENGTH = 10;
  public static final double BRANCH_ANGLE = Math.PI / 9.0;
  public static final int WAIT = 15;
  public void paint(Graphics g) {
    drawLine2(g, SIZE_X / 2, 0, INITIAL_LENGTH, Math.PI / 2);
  }
  PCanvas(int sizex, int sizey) {
    SIZE_X = sizex;
    SIZE_Y = sizey - sizey / 20;
    setBackground(Color.black);
    setForeground(Color.white);
  }  
  public void drawLine2(Graphics g, double x1, double y1, double l, double theta) {
    
    if (l < EXIT_LENGTH) {
      return;
    }
    double x2 = x1 + l * Math.cos(theta);
    double y2 = y1 + l * Math.sin(theta);
    
    
    g.drawLine((int)x1, (int)(SIZE_Y - y1), (int)x2, (int)(SIZE_Y - y2));
    drawLine2(g, x2, y2, l * TRIM_FACTOR, theta - BRANCH_ANGLE);
    drawLine2(g, x2, y2, l * TRIM_FACTOR, theta + BRANCH_ANGLE);
  }
  
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
public class Diwali {
  public static void main(String[] args) {
    Sounds.load();
    PFrame pframe = new PFrame();
    Animate a = new Animate(pframe.getCanvas());
    a.start();
  }
}
class PFrame extends JFrame {
  private PCanvas canvas;  
  PFrame() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0,0,screenSize.width, screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    setUndecorated(true);
    canvas = new PCanvas(screenSize.width, screenSize.height);
    add(canvas);
    setVisible(true);  
      this.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
          Animate.getRunner().interrupt();
        }
      }
    });  
  }
  
  public PCanvas getCanvas() {
    return canvas;
  }
}
class PCanvas extends Canvas {
  private float x;
  private float y;
  public static float NUM_BALLS = 2;
  public static float SIZE_X;
  public static float SIZE_Y;
  private ArrayList<Ball> balls;
  private Random rnd;
  
  PCanvas(float sizex, float sizey) {    
    SIZE_X = sizex;
    SIZE_Y = sizey;
    rnd = new Random();
    balls = new ArrayList<Ball>();
    for (int i = 1 ; i <= NUM_BALLS ; ++i) {
      float angle = rnd.nextInt(180);
      float x_init = 0.0f;
      if (angle > 90) {
        x_init = SIZE_X - rnd.nextInt(10);
      } else {
        x_init = rnd.nextInt(10);
      }
      
      float vel = 30+rnd.nextInt(10);
      balls.add(new Ball(i,
                rnd.nextInt(10),
                x_init,
                angle,
                vel
                ));
    }
    setBackground(Color.black);
    setForeground(Color.white);
  }
  public void paint(Graphics g) {    
    for (Ball ball : balls) {
      ball.draw(g);
      ball.updatePosition();      
    }
    checkBounds();
  }
  public void checkBounds() {
    ArrayList<Ball> newBalls = null;
    for (Ball ball : balls) {      
      if (ball.getDeltaY() < 1 && ball.getID() < 100) {
        newBalls = new ArrayList<>();
        Sounds.playExplode();
        for (int i=1;i<=50+rnd.nextInt(400);++i) {
          float angle = rnd.nextInt(360);
          float vel = 10+rnd.nextInt(40);          
          newBalls.add(new Ball(i*100,
                  ball.getX(),
                  ball.getY(),
                  angle,
                  vel
                  ));
            
        }        
        ball.setDeleted();
      }
    }
    if (newBalls!=null && newBalls.size() > 0) {
      balls.addAll(newBalls);
    }
    
    
    
    Iterator<Ball> ballIterator = balls.iterator();
    while (ballIterator.hasNext()){
      Ball ball = ballIterator.next();
      if (ball.getY() < 10) {
        ball.setDeleted();
      }
      if (ball.isDeleted()) ballIterator.remove();
    }
  }  
  public ArrayList<Ball> getBalls() {
    return this.balls;
  }
  public void addBall() {
      float angle = rnd.nextInt(180);
      float x_init = 0.0f;
      if (angle > 90) {
        x_init = SIZE_X - rnd.nextInt(10);
      } else {
        x_init = rnd.nextInt(10);
      }
      
      float vel = 20+rnd.nextInt(20);
      balls.add(new Ball(1,
                x_init,
                0,
                angle,
                vel,
                10));
    
  }
}
class Ball {
  float x;
  float y;
  float theta;
  float size = DEFAULT_SIZE;
  float vel;
  int id;
  boolean deleted;
  public static final float DEFAULT_SIZE = 6;
  private float delta_x;
  private float delta_y;
  Ball(int id, float x,float y, float theta, float vel) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.theta = theta;    
    this.vel = vel;
    this.delta_x = vel * (float)Math.cos(Math.toRadians(theta));
    this.delta_y = vel * (float)Math.sin(Math.toRadians(theta));
    if (id < 100)  Sounds.playRocket();
  }
  Ball(int id, float x,float y, float theta, float vel, float size) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.theta = theta;    
    this.vel = vel;
    this.delta_x = vel * (float)Math.cos(Math.toRadians(theta));
    this.delta_y = vel * (float)Math.sin(Math.toRadians(theta));
    this.size = size;
    if (id < 100)  Sounds.playRocket();
  }
  public void updatePosition() {        
    x = x + delta_x;
    delta_y = delta_y - 1f;
    y = y + delta_y;
  }
  public float getX() {
    return x;
  }
  public float getY() {
    return y;
  }
  public void setTheta(float theta) {
    this.theta = theta;
    this.delta_x = vel * (float)Math.cos(Math.toRadians(theta));
    this.delta_y = vel * (float)Math.sin(Math.toRadians(theta));
  }
  public float getTheta() {
    return theta;
  }
  public void draw(Graphics g) {
    g.fillOval((int)x, (int)(PCanvas.SIZE_Y - y), (int)size, (int)size);
  }
  public String toString() {
    return String.format("id=%d x =%d y = %d vel = %d theta = %d deltaY = %f" ,id, x, y, vel, theta, delta_y);
  }
  public void setDeltaY(float delta_y) {
    this.delta_y = delta_y;
  }
  public float getDeltaY() {
    return delta_y;
  }
  public void setDeltaX(float delta_x) {
    this.delta_x = delta_x;
  }
  public float getDeltaX() {
    return delta_x;
  }
  public float getVel() {
    return vel;
  }
  public float getSize() {
    return size;
  }
  public int getID() {
    return id;
  }
  public void setDeleted() {
    this.deleted = true;
  }
  public boolean isDeleted() {
    return this.deleted;
  }
}
class Animate implements Runnable {
  private PCanvas canvas;
  static Thread runner;
  Animate(PCanvas canvas) {
    this.canvas = canvas;
    runner = new Thread(this);
  }
  public void run () {    
    while(!Thread.interrupted()) {
      if (canvas.getBalls().isEmpty()) {
        canvas.addBall();
        canvas.addBall();
      }
      
      canvas.repaint();
      try {
        Thread.sleep(20);
      }
      catch(InterruptedException e) {              
        System.exit(0);        
      }
    }    
  }
  public void start() {
    runner.start();
  }
  public static Thread getRunner() {
    return runner;
  }
}
class Sounds {
  
  private static Clip clipExplode;
  private static final String path = "";
  public static ArrayList<Clip> clips = new ArrayList<>();
  public static void load() {
    try {
      File audioFile = new File(path + "rocket.wav");
      AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);  
      AudioFormat audioFormat = stream.getFormat();
      byte[] sound = new byte[50000];
      stream.read(sound);      
      DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
      for (int i=1; i <= 2; ++i) {
        Clip clipRocket = (Clip) AudioSystem.getLine(info);
        clipRocket.open(audioFormat, sound, 0, sound.length);
        clips.add(clipRocket);
      }
      audioFile = new File(path + "explode.wav");
      stream = AudioSystem.getAudioInputStream(audioFile);  
      audioFormat = stream.getFormat();
      sound = new byte[500000];
      stream.read(sound);      
      info = new DataLine.Info(Clip.class, audioFormat);
      clipExplode = (Clip) AudioSystem.getLine(info);
      clipExplode.open(audioFormat, sound, 0, sound.length);
      
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void playRocket() {
    try
    {      
      new Thread(new Runnable(){
        public void run() {
          try {
          Clip clip = getRocketClip();
          clip.start();
          Thread.sleep(500);
          clip.stop();
          clip.setFramePosition(0);
          }
          catch(Exception e){}
          
        }
      
      }).start();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public static Clip getRocketClip() {  
    
    for (Clip clip : clips) {
      
      if (!clip.isRunning()) return clip;
    }    
    return clips.get(0);
  }
  public static void playExplode() {
    try
    {      
      new Thread(new Runnable(){
        public void run() {
          try {
          clipExplode.start();
          Thread.sleep(300);
          clipExplode.stop();
          clipExplode.setFramePosition(0);
          }
          catch(Exception e){}
          
        }
      
      }).start();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
public class Spiro {
  public static void main(String[] args) {
    PFrame pframe = new PFrame();
  }
}
class PFrame extends JFrame {
  private PCanvas canvas;  
  PFrame() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0,0,screenSize.width, screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    setUndecorated(true);
    canvas = new PCanvas(screenSize.width, screenSize.height);
    add(canvas);
    setVisible(true);  
    this.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
      }
    });  
  }
  
  public PCanvas getCanvas() {
    return canvas;
  }
}
class PCanvas extends Canvas {
  private int x;
  private int y;
  public static int SIZE_X;
  public static int SIZE_Y;
  
  private double R1 = 257;
  private double R2 = 111;
  private double R3 = 123;
  
  private double RA1 = 133;
  private double RA2 = 246;
  
  private BufferedImage img;
  PCanvas(int sizex, int sizey) {
    SIZE_X = sizex;
    SIZE_Y = sizey;
    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
    setCursor(blankCursor);
    setBackground(Color.black);    
    setForeground(Color.white);  
    
  }
  public void paint(Graphics g) {    
  
  for (double theta1 = 0 ; theta1 < 360; theta1+=.001) {
      double theta2=RA1 * theta1;
      double theta3=RA2 * theta1;
      
      
      
      g.fillOval(SIZE_X/2 - (int)(R1 * Math.cos(Math.toRadians(theta1)) 
                    - R2 * Math.cos(Math.toRadians(theta2)))                    
                    
                    
            ,SIZE_Y/2 - (int)(R1 * Math.sin(Math.toRadians(theta1)) 
                    - R2 * Math.sin(Math.toRadians(theta2)))
                    
                    
            ,1 
            ,1);
    }
  
  }
  
}
