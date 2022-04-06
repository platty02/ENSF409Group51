/**
@author Carlos Morera Pinilla 
UCID: 30113818
@version 1.1 April, 5, 2022
@since 1.0 April, 5, 2022
*/

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
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    private void setupGUI(){
        //setting labels.
        instructions = new JLabel("Please enter the number of people in your family that fits the following categories: ");
        maleLabel = new JLabel("Number of males:");
        femaleLabel = new JLabel("Number of females:");
        childUnderLabel = new JLabel("Number of children under 8:");
        cOverLabel = new JLabel("Number of children over 8:");

        //setting test fields.
        mInput = new JTextField("e.g. 1");
        fInput = new JTextField("e.g. 1");
        cOInput = new JTextField("e.g. 2");
        cUInput = new JTextField("e.g. 8");

        //setting listeners.
        mInput.addMouseListener(this);
        fInput.addMouseListener(this);
        cOInput.addMouseListener(this);
        cUInput.addMouseListener(this);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        addHamper = new JButton("Add a Hamper");
        addHamper.addActionListener(this);

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        header.add(instructions);
		infoPanel.add(maleLabel);
		infoPanel.add(mInput);
		infoPanel.add(femaleLabel);
        infoPanel.add(fInput);
		infoPanel.add(childUnderLabel);
		infoPanel.add(cUInput);
		infoPanel.add(cOverLabel);
        infoPanel.add(cOInput);
        submitPanel.add(submit);
        submitPanel.add(addHamper);

        this.add(header, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(mInput)) 
            mInput.setText(this.numAdultMale);

        if(event.getSource().equals(fInput))
            fInput.setText(this.numAdultFemale);

        if(event.getSource().equals(cUInput))
            cUInput.setText(this.numChildUnder8);

        if(event.getSource().equals(cOInput))
            cOInput.setText(this.numChildOver8);
                
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
			numAdultMale = mInput.getText();
            numAdultFemale = fInput.getText();
            numChildOver8 = cOInput.getText();
            numChildUnder8 = cUInput.getText();
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
