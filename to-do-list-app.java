import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApp extends Frame {
    private List itemList;
    private TextField itemTextField;
    private Button addButton;
    private Button removeButton;
    private ArrayList<String> items;

    public ToDoListApp() {
        items = new ArrayList<String>();

        itemList = new List();
        itemTextField = new TextField(25);
        addButton = new Button("Add");
        removeButton = new Button("Remove");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newItem = itemTextField.getText();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    updateItemList();
                    itemTextField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex != -1) {
                    items.remove(selectedIndex);
                    updateItemList();
                }
            }
        });

        setLayout(new FlowLayout());
        add(itemList);
        add(itemTextField);
        add(addButton);
        add(removeButton);

        setTitle("To-Do List App");
        setSize(300, 300);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void updateItemList() {
        itemList.removeAll();
        for (String item : items) {
            itemList.add(item);
        }
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
