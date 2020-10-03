package _03_To_Do_List;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("add task");
	JButton button1 = new JButton("view tasks");
	JButton button2 = new JButton("remove task");
	JButton button3 = new JButton("save list");
	JButton button4 = new JButton("load list");
	JLabel label = new JLabel();
	ArrayList<String> taskList = new ArrayList<String>();
		
	public static void main(String[] args) {
		ToDoList todolist = new ToDoList();
		todolist.tasks();
	}
	
	public void tasks() {
		frame.setVisible(true);
		panel.setVisible(true);
		
		frame.add(panel);
		frame.add(button);
		
	}
}
