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
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TabelaAquisicao extends JFrame {
	
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
	public TabelaAquisicao(ProdutosFornecedores pf){
		setTitle("Produtos");
		 UsuarioBD usuarioBd = new UsuarioBD();
		
			
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
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
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(32, 178, 170));
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbProduto.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					pf.textField_2.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 0).toString());
					pf.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
