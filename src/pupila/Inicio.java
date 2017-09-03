package pupila;

public class Inicio {

	public static void main(String[] args) throws Exception {
		LeitorTXT ler = new LeitorTXT();
		Limpeza limpa = new Limpeza();
		Grava salvar = new Grava();

		ler.LerOlho(0);
		ler.mediaLargAlt();
		limpa.Limpa();
		limpa.Suaviza();
		salvar.Gravar("vetor",ler.getPasta(),limpa.getSuave());
		
	}

}
