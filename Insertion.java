import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Insertion extends JPanel{
    JFrame frame = new JFrame();
    public int quantity[] = {32,6,31,44,27,45,33,11,46,34,21,28,47,4,35,22,48,12,18,36,23,5,49,13,37,50,24,19,9,51,38,25,7,52,20,39,14,53,26,8,54,40,30,55,3,15,56,1,57,16,58,41,59,2,60,17,61,29,62,42,10,63,43};// 63 in total
    public ArrayList <Integer> quan = new ArrayList<Integer>();
    public int index = 0; // The wall
    public final int width_frame = 500;
    public final int height_frame = 650;
    public int width_rectangle = 5;
    public int height_rectangle = 2;
    public int scanner = 0 ;
    public int sortSpeed = 2;


    public static void main(String args[]) throws InterruptedException{
        
        Insertion graph = new Insertion();

    }

    public Insertion() throws InterruptedException{
        frame.setSize(width_frame,height_frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        for(int i = 0 ; i < quantity.length; i++){ // initialize Arraylist
            quan.add(quantity[i]);
        }
        insertionSort();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle f = new Rectangle (width_frame, height_frame);
        g2d.setColor(Color.black);
        g2d.fill(f);

        Rectangle temp = new Rectangle(width_rectangle,height_rectangle);
        g2d.setColor(Color.white);
        for(int i = 0 ; i < quan.size() ; i++){ //第幾筆資料
            if(i == scanner){g2d.setColor(Color.RED);}
            if(i == index){g2d.setColor(Color.green);}
            for(int j = 0 ; j < quan.get(i) * 5; j++){ //第幾個 rec
                temp.setLocation( (i + 1) * 6  + 20, height_frame - (height_rectangle * j));
                g2d.fill(temp);
            } 
            g2d.setColor(Color.white);
        }
        

        
    }

    public void insertionSort() throws InterruptedException{
        
        for(int i = 0 ; i < quan.size(); i++){
            index = i;
            for(int j = 0 ; j < i ; j++){
                scanner = j;
                repaint();
                Thread.sleep(sortSpeed);
                if(quan.get(i)<quan.get(j)){
                    int tmp = quan.get(i);
                    quan.remove(i);
                    quan.add(j, tmp);
                    break;
                }
            }
            repaint();
            Thread.sleep(sortSpeed);
        
        }

    }
}
