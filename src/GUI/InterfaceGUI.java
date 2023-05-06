package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.BitSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Sistema.*;

public class InterfaceGUI extends JFrame{

	private static final long serialVersionUID = 1L;
		
	private final static int qtdaItens=6;
	
	//Componentes de input de dados
	private JTextField largutaFileteText, materialText, corteText, camadas, vezesText;
	
	private JTextField qtdePecas[]=new JTextField[qtdaItens],
					fileteText[]=new JTextField[qtdaItens],
					marcacoesText[]=new JTextField[qtdaItens],
					tamanhoText[]=new JTextField[qtdaItens];
	
	
	//Componentes de Textos
	private JLabel textosLabels[]=new JLabel[5];
	private JLabel tamanhoLabels[]=new JLabel[qtdaItens];
	
	private JButton debrumBotao;
	

	
	
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
				ValidarCalcularInterfaceVariables();
			}
		});
		
		//Adicionar as arrays ao JFrame
		for(byte i=0;i<qtdaItens;i++) {
			this.add(tamanhoText[i]);
			this.add(marcacoesText[i]);
			this.add(qtdePecas[i]);
			this.add(fileteText[i]);
			this.add(tamanhoLabels[i]);
		}
		
		for(byte i=0;i<5;i++){
			this.add(textosLabels[i]);
		}
		
		this.add(vezesText);
		this.add(debrumBotao);
				
		
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
			tamanhoText[i]=new JTextField();
			tamanhoText[i].setBounds(0,70+(i*(20+5)), 40, 20);
			tamanhoText[i].setText(arraytextos[i]);
			
			marcacoesText[i]=new JTextField();
			marcacoesText[i].setBounds(60,70+(i*(20+5)), 40, 20);
			
			qtdePecas[i]=new JTextField();
			qtdePecas[i].setBounds(120,70+(i*(20+5)), 40, 20);
			
			fileteText[i]=new JTextField();
			fileteText[i].setBounds(240,70+(i*(20+5)), 40, 20);
			
			tamanhoLabels[i]=new JLabel();
			tamanhoLabels[i].setBounds(300,70+(i*(20+5)), 40, 20);
			tamanhoLabels[i].setText("NULL");
		}
			
		
		
		vezesText=new JTextField();
		vezesText.setBounds(180, 70, 30, 20);
		vezesText.setText("0");
		
		debrumBotao = new JButton("DEBRUM");
		debrumBotao.setBounds(0, 0, 100, 20);
		
		
	}

	public boolean ValidarCalcularInterfaceVariables() {
		
		if(!Validador.validarComponenteInt(vezesText)) {
			JOptionPane.showMessageDialog(null,"ERRO VALOR VEZES INVALIDO","ERRO 0X01", JOptionPane.OK_CANCEL_OPTION);
			return false;
		}
		
		for(byte i=0;i<qtdaItens;i++) {
			
			if(marcacoesText[i].getText().isBlank() && qtdePecas[i].getText().isBlank()) {
				tamanhoLabels[i].setText("VAZIO");
			}
			else if(!marcacoesText[i].getText().isBlank() && !qtdePecas[i].getText().isBlank()) {
				JOptionPane.showMessageDialog(null,"ERRO MARCAÇÃO/Quantidade Peças:"+tamanhoText[i].getText(),"ERRO 0X02", JOptionPane.OK_CANCEL_OPTION);
				tamanhoLabels[i].setText("ERRO");
			}
			else if(!qtdePecas[i].getText().isBlank() && Validador.validarComponenteFloat(qtdePecas[i])){
				
				if(!Validador.validarComponenteFloat(fileteText[i])) {
					JOptionPane.showMessageDialog(null,"ERRO VALOR FILETE:"+tamanhoText[i].getText(),"ERRO 0X03", JOptionPane.OK_CANCEL_OPTION);
					tamanhoLabels[i].setText("ERRO");
					continue;
				}				
				
				float f =(Float.parseFloat(qtdePecas[i].getText())*Integer.parseInt(vezesText.getText()))*Float.parseFloat(fileteText[i].getText());
				tamanhoLabels[i].setText(""+f);
			}
			else if(!marcacoesText[i].getText().isBlank() && Validador.validarComponenteFloat(marcacoesText[i])) {
				
			}
			else {
				tamanhoLabels[i].setText("ERRO");
			}
			
		}
		
		return true;
		
	}
}
