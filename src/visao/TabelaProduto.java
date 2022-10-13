package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.CadastroProdutos;
import modelo.Usuario;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoBD;
import controle.UsuarioBD;

public class TabelaProduto extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbProduto;
	private ArrayList<CadastroProdutos> listaProdutos;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaProduto(TelaVenda TV ){
		 UsuarioBD usuarioBd = new UsuarioBD();
		
			System.out.println(conexao);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Modelo", "Valor", "tamanho", "Marca"
			}
			
		));
		scrollPane.setViewportView(tbProduto);
		ProdutoBD produtoBD = new ProdutoBD();
		listaProdutos = produtoBD.listarTodosProdutos();
		
		tbProduto.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID",  "Modelo", "Valor", "tamanho", "Marca"}));
		scrollPane.setViewportView(tbProduto);

		modelo = (DefaultTableModel) tbProduto.getModel();
		for (int i = 0; i < listaProdutos.size(); i++) {
			CadastroProdutos p = listaProdutos.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getModelo(),  p.getPreco(), p.getTamanho(), p.getMarca() });

		}
		tbProduto.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbProduto.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					TV.textField_1.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 0).toString());
					TV.txtNomeProd.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 1).toString());
					TV.txtPrecoProd.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 2).toString());
					TV.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}