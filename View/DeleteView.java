import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
public class DeleteView extends JPanel implements ActionListener {
    protected JTextField nameField;
    private JLabel nameLabel;
    protected JTextField ageField;
    private JLabel ageLabel;
    protected JTextField addressField;
    private JLabel addressLabel;
    protected JTextField seniorityField;
    private JLabel seniorityLabel;
    protected JTextField lastnameField;
    private JLabel lastnameLabel;
    protected JTextField idField;
    private JLabel idLabel;
    protected JTextField pprojectField;
    private JLabel pprojectLabel;
    protected JTextField aprojectField;
    private JLabel aprojectLabel;
    private JLabel emptyLabel;
    protected JButton delete;
    private DefaultTableModel amodel = new DefaultTableModel(0,0);
    protected JTable atable = new JTable(amodel);
    private DefaultTableModel pmodel = new DefaultTableModel(0,0);
    protected JTable ptable = new JTable(pmodel);
    private final static String newline = "\n";
    private static final String solve = "Solve";

    public DeleteView(int id,String name,String lastname,String address,int age,int seniority,List<String> actualProyects,List<String> pastProyects) {
        super(new GridBagLayout());
        Dimension dim= new Dimension(120,120);
        ArrayList<String> elements = new ArrayList<String>();
        String[] acolumnNames = {"Actual projects"};
        amodel.setColumnIdentifiers(acolumnNames);
        for(String row:actualProyects){
            elements.add(row);
            Object[] adata = elements.toArray();
            amodel.addRow(adata);
            elements.clear();
        }
        atable.setModel(amodel);
        JScrollPane jsa=new JScrollPane(atable);
        jsa.setPreferredSize(dim);
        jsa.setVisible(true);
        String[] pcolumnNames = {"Past projects"};
        pmodel.setColumnIdentifiers(pcolumnNames);
        for(String row:pastProyects){
            elements.add(row);
            Object[] pdata = elements.toArray();
            pmodel.addRow(pdata);
            elements.clear();
        }
        ptable.setModel(pmodel);
        JScrollPane jsp=new JScrollPane(ptable);
        jsp.setPreferredSize(dim);
        jsp.setVisible(true);
        idField = new JTextField(20);
        idLabel = new JLabel("Id:");
        emptyLabel = new JLabel("");
        nameField = new JTextField(20);
        nameLabel = new JLabel("Name/s:");
        ageField = new JTextField(20);
        ageLabel = new JLabel("Age:");
        addressField = new JTextField(20);
        addressLabel = new JLabel("Address:");
        seniorityField = new JTextField(20);
        seniorityLabel = new JLabel("Seniority:");
        lastnameField = new JTextField(20);
        lastnameLabel = new JLabel("Lastname/s:");
        delete = new JButton("Delete");
        //Color color= new Color(163,38,56);
        delete.setBackground(new Color(163,38,56));
        delete.addActionListener(this);
        idField.setText(String.valueOf(id));
        nameField.setText(name);
        lastnameField.setText(lastname);
        seniorityField.setText(String.valueOf(seniority));
        ageField.setText(String.valueOf(age));
        addressField.setText(address);
        ptable.setDefaultEditor(Object.class, null);
        atable.setDefaultEditor(Object.class, null);
        idField.setEditable(false);
        nameField.setEditable(false);
        lastnameField.setEditable(false);
        seniorityField.setEditable(false);
        ageField.setEditable(false);
        addressField.setEditable(false);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        add(idLabel,c);
        add(seniorityLabel,c);
        c.gridy=1;
        add(idField,c);
        add(seniorityField,c);
        c.gridy=2;
        add(nameLabel,c);
        add(lastnameLabel,c);
        c.gridy=3;
        add(nameField,c);
        add(lastnameField,c);
        c.gridy=4;
        add(ageLabel,c);
        add(addressLabel,c);
        c.gridy=5;
        add(ageField,c);
        add(addressField,c);
        c.gridy=6;
        add(emptyLabel,c);
        c.gridx=4;
        c.gridy=7;
        add(delete, c);
        c.gridx=3;
        c.gridy=0;
        c.gridheight = 7;
        add(jsa,c);
        c.gridx=4;
        add(jsp,c);
    }
    public void actionPerformed(ActionEvent evt) {
    System.out.println("Exit");

    }
}
