package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
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
	JButton button = new JButton();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	
	ArrayList<String> taskList = new ArrayList<String>();
	
	public static void main(String[] args) {
		ToDoList todolist = new ToDoList();
		todolist.tasks();
	}
	
	public void tasks() {
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.setText("add task");
		button1.setText("view tasks");
		button2.setText("remove task");
		button3.setText("save list");
		button4.setText("load list");
		
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.pack();
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		frame.setTitle("Do stuff with tasks");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			String task = JOptionPane.showInputDialog("Write your task homie");
			
			taskList.add(task);
		}
		else if(e.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "here are all the tasks rn: " + taskList);
		}
		else if(e.getSource() == button2) {
			String toBeRemoved = JOptionPane.showInputDialog("which task do you wanna remove? (have view tasks open and spell it correctly)");
			taskList.remove(toBeRemoved);
		}
		else if(e.getSource() == button3) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDoList.txt", true);
				
				fw.write("\n" + taskList);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == button4) {
			JFileChooser jfc = new JFileChooser();
			int ret = jfc.showOpenDialog(null);
			if(ret == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
				String line = br.readLine();
				System.out.println("Your tasks 4 today are: ");
				while(line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.err.print("Error: Could not find it :P");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
