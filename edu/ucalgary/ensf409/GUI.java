/**
@author JamesPlatt 
UCID: 30130627
@version 1.0 April, 5, 2022
@since 1.0 April, 5, 2022
**/
package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class GUI extends JFrame implements ActionListener, MouseListener{
    private String numAdultMale;
    private String numAdultFemale;
    private String numChildOver8;
    private String numChildUnder8;
    private JLabel instructions;
    private JLabel maleLabel;
    private JLabel femaleLabel;
    private JLabel childUnderLabel;
    private JLabel cOverLabel;
    private JTextField mInput;
    private JTextField fInput;
    private JTextField cOInput;
    private JTextField cUInput;
    private JButton submit;
    private JButton addHamper;
    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    public GUI(){
        super("Create a order");
        setupGUI();
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    private void setupGUI(){
        //setting labels.
        instructions = new JLabel("this is a test build, instructions will be added later.");
        maleLabel = new JLabel("Number of males in digit form:");
        femaleLabel = new JLabel("Number of females in digit form:");
        childUnderLabel = new JLabel("Number of children under 8 in digit form:");
        cOverLabel = new JLabel("Number of children over 8 in digit form:");

        //setting test fields.
        mInput = new JTextField("eg 3");
        fInput = new JTextField("eg 2");
        cOInput = new JTextField("eg 1");
        cUInput = new JTextField("eg 0");

        //setting listeners.
        mInput.addMouseListener(this);
        fInput.addMouseListener(this);
        cOInput.addMouseListener(this);
        cUInput.addMouseListener(this);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        addHamper = new JButton("addToHamperList");
        addHamper.addActionListener(this);

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        header.add(instructions);
        infoPanel.add(mInput);
        infoPanel.add(fInput);
        infoPanel.add(cOInput);
        infoPanel.add(cUInput);
        submitPanel.add(submit);
        submitPanel.add(addHamper);

        this.add(header, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(mInput))
            mInput.setText("");

        if(event.getSource().equals(fInput))
             fInput.setText("");

        if(event.getSource().equals(cOInput))
            cOInput.setText("");

        if(event.getSource().equals(cUInput))
            cUInput.setText("");
                
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == submit ){
            JOptionPane.showMessageDialog(this, "The Hampers have been submitted and are being processed.");
        }
        else if(event.getSource() == addHamper){
            numAdultMale = mInput.getText();
            numAdultFemale = fInput.getText();
            numChildOver8 = cOInput.getText();
            numChildUnder8 = cUInput.getText();
            JOptionPane.showMessageDialog(this, "the inputs have been accepted.");
        }
    }
}
