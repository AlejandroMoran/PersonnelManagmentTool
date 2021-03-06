package src.View;

import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu panel class
 */
public class MenuView extends JPanel implements ActionListener {
    /**
     * Create button
     */
    protected JButton create;
    /**
     * Read button
     */
    protected JButton read;
    /**
     * Update button
     */
    protected JButton update;
    /**
     * Delete button
     */
    protected JButton delete;
    /**
     * Exit button
     */
    protected JButton exit;

    /**
     * Allocates a MenuView object and initializes it
     */
    public MenuView() {
        super(new GridBagLayout());
        create = new JButton("Create");
        create.addActionListener(this);
        read = new JButton("Read");
        read.addActionListener(this);
        update = new JButton("Update");
        update.addActionListener(this);
        delete = new JButton("Delete");
        delete.addActionListener(this);
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBackground(new Color(163,38,56));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 10, 4, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=2;
        c.weighty=1;
        add(create,c);
        add(read,c);
        c.gridy=1;
        add(update,c);
        add(delete,c);
        c.gridy=2;
        c.gridx=0;
        c.gridwidth=2;
        add(exit,c);
    }

    /**
     * If the exit button is pressed, ends the application
     * If the create button is pressed, removes the menu view and calls the CreateV method of the controller
     * If the read button is pressed, removes the menu view, sets the controller state to 'r' and calls the SearchV method of the controller
     * If the update button is pressed, removes the menu view, sets the controller state to 'u' and calls the SearchV method of the controller
     * If the delete button is pressed, removes the menu view, sets the controller state to 'd' and calls the SearchV method of the controller
     * @param evt The press of any button
     */
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == exit) {
            System.out.println("Exit");
            System.exit(0);
        }
        if(evt.getSource()==create){
            super.setVisible(false);
            super.remove(this);
            Controller.state='c';
            Controller.CreateV();
        }
        if(evt.getSource()==read){
            super.setVisible(false);
            super.remove(this);
            Controller.state='r';
            Controller.SearchV();
        }
        if(evt.getSource()==update){
            super.setVisible(false);
            super.remove(this);
            Controller.state='u';
            Controller.SearchV();
        }
        if(evt.getSource()==delete){
            super.setVisible(false);
            super.remove(this);
            Controller.state='d';
            Controller.SearchV();
        }
    }
}
