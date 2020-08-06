import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikhil
 */
public class MoveCursor extends JFrame {
 
    private JPanel contentPane, panel;
    private JLabel label;
    private final JButton button1;
    private JButton button;
    private int moveState, startState;
    
    static private MoveCursor frame;
    static Timer timer;
    static TimerTask timerTask;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        frame = new MoveCursor();
        frame.setVisible(true);   
        
    }
 
    /**
     * Create the frame.
     */
    public MoveCursor() {
        
        moveState = 0;
        startState = 0;
        
        setTitle("Move Cursor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel();		
        label.setText("Little Surrounding Move");
        label.setBounds(10, 10, 100, 100);
        
        // Create JButton
        button = new JButton("Start");
        button1 = new JButton("Toggle Move");
        
        //Create JPanel
        panel = new JPanel();

        // Add button to JPanel
        panel.add(label);
        panel.add(button);
        panel.add(button1);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);
        
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(startState == 0){
                    timerTask = new TimerClass();
                    TimerClass.setState(moveState);   
                    timer = new Timer();
                    timer.schedule(timerTask, 0, 5000);
                    button.setText("Pause");
                }
                else{
                    button.setText("Resume");
                    timer.cancel();
                }
                startState = (startState+1)%2;
            }
        });
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                moveState = (moveState+1)%2;
                TimerClass.setState(moveState);
                //timer.cancel();
                if(moveState == 1){
                    label.setText("Random Move");
                }
                else{
                    label.setText("Little Surrounding Move");
                }
                //timer.schedule(timerTask, 0, 1000);
            }
        });
    }
}