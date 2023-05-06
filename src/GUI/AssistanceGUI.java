package GUI;

import java.awt.Color;


import javax.swing.JFrame;


public class AssistanceGUI extends JFrame{

	private static final long serialVersionUID = 1L;

	public AssistanceGUI() {
		this.setTitle("AssistanceGUI");
		this.setSize(400,200);

		
		this.setBackground(Color.BLACK);

		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
