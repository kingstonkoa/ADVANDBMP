/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandbmp;

import advandbmp.Controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author Kingston
 */
public class ADVANDB_MP
{
    private JFrame frame;
    private JPanel panel;


    public ADVANDB_MP()
    {
        this.frame = new JFrame("ADVANDB MP");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
    }

    public void setPanel(JPanel panel)
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().add (panel);
        frame.pack();
        frame.setVisible (true);
        
        frame.revalidate();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
       ADVANDB_MP mp = new ADVANDB_MP();
       Controller controller = new Controller();
       controller.setMP(mp);

       
       MyPanel myPanel = new MyPanel(controller);
       mp.setPanel(myPanel);
       controller.setMainPanel(myPanel);
       
       
    }
    
}
