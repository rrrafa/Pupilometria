package pupila;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.awt.Font;

public class Janela {

	private JFrame frmD;
	public JTextField txtKjh;
	private JTextField textField_1;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
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
        
		


		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frmD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() throws Exception{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frmD = new JFrame();
		frmD.setResizable(false);
		frmD.setTitle("Pupilometria - Tratamento de resultados");
		frmD.setBounds(100, 100, 537, 457);
		frmD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmD.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Buscar...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeitorTXT leitura = new LeitorTXT();
				
				try {leitura.LerOlho(0);}catch(Exception e) {}
				txtKjh.setText(leitura.getArq());
								
			}
		});
		btnNewButton.setBounds(304, 34, 77, 23);
		frmD.getContentPane().add(btnNewButton);
		
		txtKjh = new JTextField();
		txtKjh.setText("");
		txtKjh.setEditable(false);
		txtKjh.setBounds(10, 35, 282, 20);
		frmD.getContentPane().add(txtKjh);
		txtKjh.setColumns(10);
		
		JLabel lblLocalDoArquivo = new JLabel("Arquivo de dados original:");
		lblLocalDoArquivo.setBounds(10, 11, 245, 23);
		frmD.getContentPane().add(lblLocalDoArquivo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Olho examinado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(402, 29, 116, 84);
		frmD.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnDireito = new JRadioButton("Direito");
		rdbtnDireito.setSelected(true);
		rdbtnDireito.setBounds(6, 23, 57, 23);
		panel.add(rdbtnDireito);
		
		JRadioButton rdbtnEsquerdo = new JRadioButton("Esquerdo");
		rdbtnEsquerdo.setSelected(false);
		rdbtnEsquerdo.setBounds(6, 54, 71, 23);
		panel.add(rdbtnEsquerdo);
		
		group = new ButtonGroup();
		
		group.add(rdbtnDireito);
		group.add(rdbtnEsquerdo);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 388, 508, 23);
		frmD.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblVetorCorrigidoseparado = new JLabel("Vetor corrigido (separado por tabula\u00E7\u00F5es):");
		lblVetorCorrigidoseparado.setBounds(10, 363, 211, 14);
		frmD.getContentPane().add(lblVetorCorrigidoseparado);
		
		JButton btnExecutar = new JButton("EXECUTAR LIMPEZA");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeitorTXT le = new LeitorTXT();
				Limpeza lim = new Limpeza();
				Grava grv = new Grava();
				le.mediaLargAlt();
				lim.Limpa();
				lim.Suaviza();
				grv.Gravar("vetor",le.getPasta(),lim.getSuave());
				textField_1.setText(grv.getVetorTab());
				textField_1.selectAll();
				textField_1.copy();
			}
		});
		btnExecutar.setBounds(10, 80, 231, 33);
		frmD.getContentPane().add(btnExecutar);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(251, 80, 130, 33);
		frmD.getContentPane().add(btnSalvar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 135, 511, 20);
		frmD.getContentPane().add(separator);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 191, 238, 146);
		frmD.getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(275, 191, 231, 146);
		frmD.getContentPane().add(editorPane_1);
		
		JLabel lblOriginal = new JLabel("ORIGINAL");
		lblOriginal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOriginal.setBounds(10, 166, 77, 14);
		frmD.getContentPane().add(lblOriginal);
		
		JLabel lblCorrigido = new JLabel("CORRIGIDO");
		lblCorrigido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorrigido.setBounds(275, 166, 84, 14);
		frmD.getContentPane().add(lblCorrigido);
	}
	
	public void setTxt(String txt) {
		txtKjh.setText(txt);
		JOptionPane.showMessageDialog(null, txt);
	}
}
