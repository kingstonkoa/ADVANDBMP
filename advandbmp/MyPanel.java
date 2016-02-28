//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!
package advandbmp;
import advandbmp.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
    private JList querySelectionJList;
    private JList optimizationTypeJList;
    private JTextArea sqlQueryTextArea;
    private JButton executeButton;
    private JTextField timeTextField;
    private JButton showResultsButton;
    private JLabel querySelectionLabel;
    private JLabel optimizationTypeLabel;
    private JLabel sqlQueryLabel;
    private JButton editButton;
    private String[] querySelectionJListItems;
    private String[] optimizationTypeJListItems;
    private Controller c;
    private ArrayList<Query> queryList;

    public MyPanel(Controller controller) {
        
        this.c = controller;
        this.queryList = c.getQueries();//to be changed
        querySelectionJListItems = new String[queryList.size()+1]; // +1 for "Custom"
        optimizationTypeJListItems = new String[4]; // Temporary 4 Optimization
        
        querySelectionJListItems[0] = "Custom"; // set first choice as Custom
        for(int i = 0; i < queryList.size(); i++) // populate array of description
        {
        querySelectionJListItems[i+1] = queryList.get(i).getDescription();
        }
        optimizationTypeJListItems[0] = "No Optimization";
        optimizationTypeJListItems[1] = "Optimization 1";
        optimizationTypeJListItems[2] = "Optimization 2";
        optimizationTypeJListItems[3] = "Optimization 3";
        //construct preComponents
        //String[] querySelectionJListItems = {"Custom", "Item 1", "Item 2", "Item 3"};
        //String[] optimizationTypeJListItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        querySelectionJList = new JList (querySelectionJListItems);
        optimizationTypeJList = new JList (optimizationTypeJListItems);
        sqlQueryTextArea = new JTextArea (5, 5);
        executeButton = new JButton ("Execute");
        timeTextField = new JTextField (5);
        showResultsButton = new JButton ("Show Results");
        querySelectionLabel = new JLabel ("Query Selection");
        optimizationTypeLabel = new JLabel ("Optimization Type");
        sqlQueryLabel = new JLabel ("SQL Query");
        editButton = new JButton ("Edit");

        //set components properties
        editButton.setToolTipText ("Edit SQL Query");
        sqlQueryTextArea.setEditable(false);

        //adjust size and set layout
        setPreferredSize (new Dimension (1245, 545));
        setLayout (null);

        //add components
        add (querySelectionJList);
        add (optimizationTypeJList);
        add (sqlQueryTextArea);
        add (executeButton);
        add (timeTextField);
        add (showResultsButton);
        add (querySelectionLabel);
        add (optimizationTypeLabel);
        add (sqlQueryLabel);
        add (editButton);

        //set component bounds (only needed by Absolute Positioning)
        querySelectionJList.setBounds (15, 60, 350, 420);
        optimizationTypeJList.setBounds (395, 60, 270, 420);
        sqlQueryTextArea.setBounds (710, 60, 505, 395);
        executeButton.setBounds (710, 480, 150, 50);
        timeTextField.setBounds (885, 480, 170, 50);
        showResultsButton.setBounds (1065, 480, 155, 50);
        querySelectionLabel.setBounds (120, 20, 100, 25);
        optimizationTypeLabel.setBounds (450, 15, 115, 35);
        sqlQueryLabel.setBounds (910, 15, 95, 30);
        editButton.setBounds (1135, 30, 75, 25);
        
        //listeners
        editButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                            sqlQueryTextArea.setEditable(true);
			}
		});
        showResultsButton.addActionListener(new ActionListener()
        {
                public void actionPerformed(ActionEvent e)
                {
                   if(!(sqlQueryTextArea.getText().toString().isEmpty()))
                        c.DisplayResultPanel(sqlQueryTextArea.getText().toString());
                    else
                    System.out.print(sqlQueryTextArea.getText().toString()+"empty");
                }
        });
        executeButton.addActionListener(new ActionListener()
        {
                public void actionPerformed(ActionEvent e)
                {
                   if(!(sqlQueryTextArea.getText().toString().isEmpty()))
                   {
                       long execTime = c.DisplayExecTime(sqlQueryTextArea.getText().toString());
                       timeTextField.setText(String.valueOf(execTime)+ " ms");
                   } 
                   else
                    System.out.print(sqlQueryTextArea.getText().toString()+"empty");
                }
        });
        
        querySelectionJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if(querySelectionJList.getSelectedIndex() == 0)
                    {
                        optimizationTypeJList.setEnabled(false);
                        optimizationTypeJList.clearSelection();
                        sqlQueryTextArea.setText("");
                        sqlQueryTextArea.setEditable(true);
                    }
                    else
                    {
                        optimizationTypeJList.setEnabled(true);
                        sqlQueryTextArea.setEditable(false);
                        optimizationTypeJList.clearSelection();
                        sqlQueryTextArea.setText(queryList.get(querySelectionJList.getSelectedIndex()-1).getQuery());
                    }
                }
                
            }
        });
        
        optimizationTypeJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if(querySelectionJList.getSelectedIndex() != -1 && querySelectionJList.getSelectedIndex() != 0)
                    {
                    queryList.get(querySelectionJList.getSelectedIndex()-1).setOpt(optimizationTypeJList.getSelectedIndex(),querySelectionJList.getSelectedIndex()-1);
                    sqlQueryTextArea.setEditable(false);
                    sqlQueryTextArea.setText(queryList.get(querySelectionJList.getSelectedIndex()-1).getQuery());
                    }
                }
                
            }
        });
    }














}