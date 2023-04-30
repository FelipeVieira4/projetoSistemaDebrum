package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InterfaceGUI extends JFrame{

	private static final long serialVersionUID = 1L;

		
		
	private static final int qtdaItens=6;
	
	private JTextField largutaFileteText, materialText, corteText, camadas, qtdeText; 
	
	private JTextField qtdePecas[]=new JTextField[qtdaItens],
					fileteText[]=new JTextField[qtdaItens],
					marcacoesText[]=new JTextField[qtdaItens];
	private JLabel tamanhoLabels[]=new JLabel[qtdaItens];
	
	
	private JButton debrumBotao;
	
	private JLabel textosLabels[]=new JLabel[5];
	
	
	public InterfaceGUI() {
		
		this.setTitle("DEBRUM");
		this.setSize(800, 400);
		this.setLayout(null);
		
		setTexts();
		setComponents();
		
		debrumBotao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(validacaoComponentes()) {

				}else {
					JOptionPane.showMessageDialog(debrumBotao, "ERRO NA VALIDAÇÃO");
				}
			}
		});
		
		//Adicionar as arrays ao JFrame
		for(byte i=0;i<marcacoesText.length;i++) {
			this.add(marcacoesText[i]);
			this.add(qtdePecas[i]);
			this.add(fileteText[i]);
			this.add(tamanhoLabels[i]);
		}
		
		this.add(qtdeText);
		this.add(debrumBotao);
		
		
		for(byte i=0;i<5;i++){
			this.add(textosLabels[i]);
		}
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	//Setar a posição dos textos na interface
	private void setTexts() {
		
		String arraytextos[]= {"Tamanho","Marcação","QTDA","VEZES","Filets(mts)"};
		for(byte i=0;i<5;i++) {
			textosLabels[i]=new JLabel();
			textosLabels[i].setBounds(60*i,50, 90, 20);
			textosLabels[i].setText(arraytextos[i]);
		}
		
	}
	
	//Setar os campos de preenchimento da Interface
	private void setComponents() {
		
		String arraytextos[]= {"PB","MB","GB","01","02","03"};
		
		for(byte i=0;i<qtdaItens;i++) {
			marcacoesText[i]=new JTextField();
			marcacoesText[i].setBounds(60,70+(i*(20+5)), 40, 20);
			
			qtdePecas[i]=new JTextField();
			qtdePecas[i].setBounds(120,70+(i*(20+5)), 40, 20);
			
			fileteText[i]=new JTextField();
			fileteText[i].setBounds(240,70+(i*(20+5)), 40, 20);
			
			tamanhoLabels[i]=new JLabel();
			tamanhoLabels[i].setBounds(20,70+(i*(20+5)), 40, 20);
			tamanhoLabels[i].setText(arraytextos[i]);
		}
			
		
		
		qtdeText=new JTextField();
		qtdeText.setBounds(180, 70, 30, 20);
		
		debrumBotao = new JButton("DEBRUM");
		debrumBotao.setBounds(0, 0, 100, 20);
		
		
	}
	private boolean validacaoComponentes() {
		return true;
	}
	
	
}
