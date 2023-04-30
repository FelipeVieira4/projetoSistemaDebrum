package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JButton button = new JButton("DEBRUM");
	private JTextField text = new JTextField();
	private JTextField tamanho = new JTextField();;
	
	public Main() {
		this.setTitle("DEBRUM-0.01");
		this.setLayout(null);
		
		button.setBounds(0, 0, 90, 20);
		text.setBounds(0,20,50,20);
		tamanho.setBounds(0, 50, 50,20);
		
		//Si botão for pressionado
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hello World\n");
				JOptionPane.showMessageDialog(button,"O botão foi pressionado\n"+text.getText()+"\n"+tamanho.getText());
				Float j;
				
				try {
					j=Float.parseFloat(tamanho.getText());
				}catch(Exception io) {
					j=0.0f;
					System.out.println("TextoInvalido");
					JOptionPane.showMessageDialog(button,"Ocorreu ERRO 0x01\nCAUSAS:\n1-USO DE LETRAS\n2-USO DE ','\n3-ESPAÇO EM BRANCO");
				}
				
				System.out.println(j);
			}
		});
	
		
		this.add(button);
		this.add(text);
		this.add(tamanho);
		
		this.setSize(800,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		
		System.out.print("Hello World!");
		new Main();
		
		return;
	}
}
