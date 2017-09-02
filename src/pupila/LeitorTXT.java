package pupila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LeitorTXT {
	
	private String arq, linhaObtida, primeiraColuna;
	private String[] linhaDados, separaColunas;
	private int i=0;
	private static double[][] tabelaDados;
	private static int qtdDados=0;
	
	public void LerOlho(int olho) throws Exception{
		JFileChooser selArq = new JFileChooser();
		selArq.setCurrentDirectory(new File ("C:\\"));
		selArq.setSelectedFile(new File (""));
		selArq.setDialogTitle("Abrir arquivo de dados.");
		
		int result = selArq.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			arq = selArq.getSelectedFile().getPath();
			JOptionPane.showMessageDialog(null, "Abrindo arquivo em: \n" + arq);
		}else if (result ==JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Operação cancelada.");
			System.exit(1);
		}else if (result == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo de dados.");
		}
		
		//Primeira leitura para definir o tamanho do vetor de dados (linhas com primeira coluna = 10)
		BufferedReader leitor = new BufferedReader(new FileReader(arq));
		while((linhaObtida=leitor.readLine())!=null) {
			linhaObtida=leitor.readLine();
			if (linhaObtida!=null) {
				primeiraColuna=linhaObtida.substring(0,2);
			}
			if (primeiraColuna.equals("10")) {
				i++;
				qtdDados++;
			}
		}
		leitor.close();
		
		linhaDados = new String[i];
		i=0;
		
		//Segunda leitura, agora com o vetor de dados definido, para incluir as linhas de dados no vetor linhaDados[]
		BufferedReader leitor1 = new BufferedReader(new FileReader(arq));
		while((linhaObtida=leitor1.readLine())!=null) {
			linhaObtida=leitor1.readLine();
			if (linhaObtida!=null) {
				primeiraColuna=linhaObtida.substring(0,2);
				if (primeiraColuna.equals("10")) {
					linhaDados[i]=linhaObtida;
					i++;
				}
			}
		}
		leitor1.close();
		
		tabelaDados = new double[linhaDados.length][2];
		
		for (int i=0;i<linhaDados.length;i++) {
			separaColunas=linhaDados[i].split("\\t");
			tabelaDados[i][0]=Double.parseDouble(separaColunas[olho+8]);
			tabelaDados[i][1]=Double.parseDouble(separaColunas[olho+9]);
		}
	
		
	}
	
	public double[][] getTabelaDados(){
		return tabelaDados;
	}
	
	public int getQtdDados() {
		return qtdDados;
	}

}
