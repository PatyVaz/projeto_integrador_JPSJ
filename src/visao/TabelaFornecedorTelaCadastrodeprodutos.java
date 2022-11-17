package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FornecedorBD;
import modelo.Fornecedor;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TabelaFornecedorTelaCadastrodeprodutos extends JFrame {
	public TabelaFornecedorTelaCadastrodeprodutos() {
	}

	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbFornecedor;
	private ArrayList<Fornecedor> listaFornecedor;
	
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaFornecedorTelaCadastrodeprodutos( TelaCadastroProduto tcp){
		
		
		
			
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tbFornecedor = new JTable();
		tbFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Nome", "Cnpj"
			}
			
		));
		scrollPane.setViewportView(tbFornecedor);
		FornecedorBD fornecedorBD = new FornecedorBD();
		listaFornecedor = fornecedorBD.listarTodosFornecedor();
		
		tbFornecedor.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID","Nome", "CNPJ"}));
		scrollPane.setViewportView(tbFornecedor);

		modelo = (DefaultTableModel) tbFornecedor.getModel();
		for (int i = 0; i < listaFornecedor.size(); i++) {
			Fornecedor f = listaFornecedor.get(i);
		modelo.addRow(new Object[] { f.getId(), f.getNome(), f.getCnpj() });

		}
		tbFornecedor.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbFornecedor.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					tcp.textField_6.setText(tbFornecedor.getValueAt(tbFornecedor.getSelectedRow(), 0).toString());
					
					
					tcp.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}
