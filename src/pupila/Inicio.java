package pupila;

public class Inicio {

	public static void main(String[] args) throws Exception {
		System.out.println("width \t height");
		LeitorTXT ler = new LeitorTXT();
		int tamanho;

		ler.LerOlho(0);
		tamanho=ler.getQtdDados();
		
		//apenas teste
		for (int i=0; i<tamanho;i++) {
			
			System.out.print(ler.getTabelaDados()[i][0]+"\t");
			System.out.print(ler.getTabelaDados()[i][1]+"\n");
			
		}

	}

}
