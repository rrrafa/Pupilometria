package pupila;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Grava {
	private String vetorTab="",arquivo;
	public void Gravar(String nome,String arq, double[] suave) {

		

		for (int i=0; i<suave.length; i++) {
			if (i<(suave.length-1)) {
				vetorTab += suave[i]+"\t";
			}else {
				vetorTab += suave[i];
			}
		}
		arquivo = arq+"\\"+nome+".txt";
		
		try {
			File f = new File(arquivo);
			FileWriter fw = new FileWriter(f,false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(vetorTab);
			bw.flush();
			bw.close();
			JOptionPane.showMessageDialog(null, "Vetor tratado salvo como:\n"+arquivo,"Processo finalizado",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public String getVetorTab() {
		return vetorTab;
	}
}
