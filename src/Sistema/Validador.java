package Sistema;

import javax.swing.JTextField;

import GUI.InterfaceGUI;

public class Validador {

	
	public static boolean validarComponenteFloat(JTextField Componente) {
		
		try {
			Float.parseFloat(Componente.getText());
		}catch(Exception io) {
			return false;
		}
		
		return true;
		
	}
	
	
	public static boolean validarComponenteInt(JTextField Componente) {
		try {
			Integer.parseInt(Componente.getText());
		}catch(Exception io) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean validar2Componentes(JTextField[] marcador,JTextField[] QTDA) {
		return true;		
	}
}
