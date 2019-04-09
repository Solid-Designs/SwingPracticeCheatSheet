package gui;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private PersonTableModel tableModel;
    private JTable table;

    public TablePanel(){
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(table, BorderLayout.CENTER);
    }

    public void setData(List<Person> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }
}
