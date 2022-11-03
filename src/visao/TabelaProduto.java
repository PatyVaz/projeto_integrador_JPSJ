package visao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoBD;
import controle.UsuarioBD;
import modelo.CadastroProdutos;
import java.awt.Color;

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
		setTitle("Produtos");
		 UsuarioBD usuarioBd = new UsuarioBD();
		
			System.out.println(conexao);
			
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
		
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Modelo", "Valor", "Tamanho", "Marca"
			}
			
		));
		scrollPane.setViewportView(tbProduto);
		ProdutoBD produtoBD = new ProdutoBD();
		listaProdutos = produtoBD.listarTodosProdutos();
		
		tbProduto.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID",  "Modelo", "Valor", "Tamanho", "Marca"}));
		scrollPane.setViewportView(tbProduto);

		modelo = (DefaultTableModel) tbProduto.getModel();
		for (int i = 0; i < listaProdutos.size(); i++) {
			CadastroProdutos p = listaProdutos.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getModelo(),  p.getPreco(), p.getTamanho(), p.getMarca() });

		}
		tbProduto.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
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
