import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String texto = JOptionPane.showInputDialog("Informe um texto:");
		
		try {
			grava(texto);
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel gravar o arquivo no SO.");
		} catch (TextoInvalidoException e) {
			e.printStackTrace();
		}
		
	}

	private static void grava(String texto) throws IOException, TextoInvalidoException {
		
		if (texto == null || texto.trim().equals("") || texto.length() < 5) {
			throw new TextoInvalidoException("Texto inv�lido para a a��o.");
		}
		
		FileWriter arquivo = new FileWriter(new File("exemplo.txt"));
		
		arquivo.write(texto);
		
		arquivo.close();
		
	}
	
}
