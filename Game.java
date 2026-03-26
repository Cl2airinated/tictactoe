import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;




public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{


   
    private BufferedImage back;
    private int key;
    private int row, column;
	private Board board;
    boolean rowWin, columnWin, zwin, twin, win;
    boolean turn;
   
    public Game() {
        new Thread(this).start();  
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        key =-1;
		board = new Board();
    
        rowWin = false;
        columnWin = false;
        zwin = false;
        twin = false;
        turn = true;
   
    }







    public void run()
       {
        try
        {
            while(true)
            {
               Thread.currentThread().sleep(5);
                repaint();
             }
          }
            catch(Exception e)
          {
          }
        }
   


   
   
   
    public void paint(Graphics g){
       
        Graphics2D twoDgraph = (Graphics2D) g;
        if( back ==null)
            back=(BufferedImage)( (createImage(getWidth(), getHeight())));
       


        Graphics g2d = back.createGraphics();
   
        g2d.clearRect(0,0,getSize().width, getSize().height);
   
        g2d.setFont( new Font("Broadway", Font.BOLD, 50));
       
        if(win){
		g2d.clearRect(0,0,getSize().width, getSize().height);
            g2d.drawString("win detected", 50,50);
        }
       
        board.drawGrid(g2d);
   
        twoDgraph.drawImage(back, null, 0, 0);


    }


   


   
       
    public void play(int i, int j){
       
   
                    if(turn){
                        board.setCell(i, j, "X");

                }else{
                        board.setCell(i, j, "O");
                }
if(checkWin()){
win=true;
}
turn = !turn;
            }
public boolean checkWin() {
    for (int i = 0; i < 3; i++) {
        if (!board.getCell(i,0).equals(".") &&
            board.getCell(i,0).equals(board.getCell(i,1)) &&
            board.getCell(i,1).equals(board.getCell(i,2))) {
            rowWin = true;
            return true;
        }
    }
    for (int j = 0; j < 3; j++) {
        if (!board.getCell(0,j).equals(".") &&
            board.getCell(0,j).equals(board.getCell(1,j)) &&
            board.getCell(1,j).equals(board.getCell(2,j))) {
            columnWin = true;
            return true;
        }
    }
    if (!board.getCell(0,0).equals(".") &&
        board.getCell(0,0).equals(board.getCell(1,1)) &&
        board.getCell(1,1).equals(board.getCell(2,2))) {
        zwin = true;
        return true;
    }
    if (!board.getCell(0,2).equals(".") &&
        board.getCell(0,2).equals(board.getCell(1,1)) &&
        board.getCell(1,1).equals(board.getCell(2,0))) {
        twin = true;
        return true;
    }


    return false;
}


   


   


 
    //DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
       
    }








//DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
       
        key= e.getKeyCode();
        System.out.println(key);
       
        if (key == 81){
            play(0,0);      }


        if (key == 65){
            play(1,0);
        }


        if (key == 90){
            play(2,0);
        }


        if (key == 87){
            play(0,1);


        }
       
        if (key == 83){
            play(1,1);


        }


        if (key == 88){
            play(2,1);


        }


        if (key == 69){
            play(0,2);


        }


        if (key == 68){
            play(1,2);


        }


        if (key == 67){
            play(2,2);


        }
       
   
    }




    //DO NOT DELETE
    @Override
    public void keyReleased(KeyEvent e) {
       
       
       
       
    }






    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
       
    }






    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
       
    }






    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
       
    }






    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("entered");
    }






    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("exited");
    }






    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
       
        System.out.println("you clicked at"+ arg0.getY());
       
       
    }






    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
       
    }
   
   
   


   
}
