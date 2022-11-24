package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.EstoqueBD;
import controle.ProdutoBD;
import modelo.CadastroProdutos;
import modelo.Cliente;
import modelo.Estoque;
import modelo.Perfil;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ProdutosFornecedores extends JFrame {
	public JTextField textField;
	private JTextField textField_1;
	public JTextField textField_2;
	
	CadastroProdutos Cp = new CadastroProdutos();
	ProdutoBD produtoBD = new ProdutoBD();
	private JTextField textField_3;

	public ProdutosFornecedores(Perfil VA) {
		setExtendedState(MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		 ProdutosFornecedores pf = this;
		setTitle("Produtos e aquisição:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 349);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnvoltar = new JButton("<-");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio(VA);
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnvoltar = new GridBagConstraints();
		gbc_btnvoltar.insets = new Insets(0, 0, 5, 5);
		gbc_btnvoltar.gridx = 0;
		gbc_btnvoltar.gridy = 0;
		getContentPane().add(btnvoltar, gbc_btnvoltar);
		
		JLabel lblNewLabel = new JLabel("Fornecedor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaFornecedor TF = new TabelaFornecedor(pf);
				TF.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 2;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 7;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 8;
		gbc_textField_1.gridy = 2;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProduto = new JLabel("Modelo do produto:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 4;
		getContentPane().add(lblProduto, gbc_lblProduto);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 7;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaAquisicao TA = new TabelaAquisicao(pf);
				TA.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoBD = new ProdutoBD();
				Cp = new CadastroProdutos();
				String id= textField_2.getText();
				
				Cp.setId(Integer.valueOf(id));
				Cp = produtoBD.listarProdutosID(Cp);
				
				int quantidade = Cp.getQuantidade();
			
				String id1 = textField_2.getText();
				String quantidade1 = textField_1.getText();
				
			int quantidade2 = Integer.valueOf(quantidade1);
				
				int somaTotal = quantidade + quantidade2;
			
				
				  Cp = new CadastroProdutos();
				Cp.setId(Integer.valueOf(id1));
				Cp.setQuantidade(somaTotal);
			
				 
				 produtoBD = new ProdutoBD();
				 produtoBD.alterarQuantidade(Cp);
				 
				 	String fornecedor = textField.getText();
					String quantidade3 = textField_1.getText();
					String produto = textField_2.getText();
					String valor = textField_3.getText();
					DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					String data = (dtf5.format(LocalDateTime.now()));

				
					

					Estoque estoque = new Estoque();
					estoque.setFornecedor(Integer.parseInt(fornecedor));
					estoque.setProduto(Integer.parseInt(produto));
					estoque.setQuantidade(Integer.parseInt(quantidade3));
					estoque.setValor(valor);
					estoque.setData(data);
					
					
					
					EstoqueBD bdestoque = new EstoqueBD();
					bdestoque.inserirEstoque(estoque);
				 
				 
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 7;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 11;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Histórico");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoCompra hc = new HistoricoCompra();
				hc.setVisible(true);
				setVisible(false);
				}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 11;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 7;
		gbc_lblNewLabel_1.gridy = 13;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

}
