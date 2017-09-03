package pupila;

import javax.swing.JOptionPane;

public class Limpeza {
	LeitorTXT leitura = new LeitorTXT();
	private double[] vetorDif, vetorLimpo,vetorSuave;
	private double media=0,limite;
	private int interv=0;
	public void Limpa() {
		vetorDif = new double[leitura.getQtdDados()-1];
		for (int i=0; i<vetorDif.length-1; i++) {
			vetorDif[i]=Math.abs(leitura.getVetorPupila()[i+1]-leitura.getVetorPupila()[i]);
			media += vetorDif[i];
		}
		media /= (leitura.getQtdDados()-1);
		limite = 3*media;
		
		//limpeza
		vetorLimpo = new double[leitura.getQtdDados()];
		for (int i=0; i<vetorLimpo.length; i++) {
			vetorLimpo[i]=leitura.getVetorPupila()[i];
			if (i < vetorLimpo.length-1) {
				if (vetorDif[i]>limite) {
					vetorLimpo[i+1]=vetorLimpo[i];
					interv++;
				}
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "Foram efetuadas "+interv+" intervenções de eliminação de picos.");
	
		
	}
	public void Suaviza() {
		vetorSuave=new double[vetorLimpo.length];
		vetorSuave[0]=vetorLimpo[0];
		vetorSuave[1]=(vetorLimpo[1]+vetorLimpo[0])/2;
		for (int i=2; i<vetorLimpo.length;i++) {
			vetorSuave[i]=(vetorLimpo[i-2]+vetorLimpo[i-1]+vetorLimpo[i])/3;
		}
	}
	
	public double[] getSuave() {
		return vetorSuave;
	}
	
}
