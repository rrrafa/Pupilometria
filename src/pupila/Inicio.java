package pupila;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Inicio {

	public static void main(String[] args) throws Exception {
		
		try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
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
