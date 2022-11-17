package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoBD;
import modelo.CadastroProdutos;
import modelo.Perfil;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaCadastroProduto extends JFrame {
	protected static final int posicaoPessoa = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel modelo;
	private ArrayList<CadastroProdutos> listaProdutos;
	static Connection conexao;
	private JTable tbProduto;
	private JTextField textField_4;
	private JTextField textField_5;
	String id;
	private JTextField textField_6;


	/**
	 * Create the frame.
	 */
	public TelaCadastroProduto(Perfil VA) {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();

		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Modelo", "Cor", "Tamanho", "Marca", "Preco", "Quantidade","Fornecedor" }));
		scrollPane.setViewportView(tbProduto);

		ProdutoBD produtoBD = new ProdutoBD();
		listaProdutos = produtoBD.listarTodosProdutos();
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Modelo", "Cor", "Tamanho", "Marca", "Preco", "Quantidade","Fornecedor" }));
		scrollPane.setViewportView(tbProduto);

		modelo = (DefaultTableModel) tbProduto.getModel();
		for (int i = 0; i < listaProdutos.size(); i++) {
			CadastroProdutos p = listaProdutos.get(i);
			modelo.addRow(new Object[] { p.getId(), p.getModelo(), p.getCor(), p.getTamanho(), p.getMarca(),
					p.getPreco(), p.getQuantidade(),p.getIdfornecedor() });

		}
		tbProduto.setModel(modelo);

		JButton btnVoltarTela = new JButton("<-");
		btnVoltarTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio ti = new TelaInicio(VA);
				ti.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnVoltarTela = new GridBagConstraints();
		gbc_btnVoltarTela.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoltarTela.gridx = 0;
		gbc_btnVoltarTela.gridy = 0;
		contentPane.add(btnVoltarTela, gbc_btnVoltarTela);

		JLabel lblNewLabel = new JLabel("Cadastro Produtos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tamanho:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cor:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Marca:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Preço:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			
		});
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 4;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 4;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fornecedor:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 5;
		contentPane.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("Produtos cadastrados:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		contentPane.add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(tbProduto);

		JButton btnSelecionar = new JButton("Selecionar");
		GridBagConstraints gbc_btnSelecionar = new GridBagConstraints();
		gbc_btnSelecionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelecionar.gridx = 0;
		gbc_btnSelecionar.gridy = 12;
		contentPane.add(btnSelecionar, gbc_btnSelecionar);

		JButton btnAdicionar = new JButton("Adicionar Produto");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modelo1 = textField.getText();
				String cor = textField_2.getText();
				String tamanho = textField_1.getText();
				String marca = textField_3.getText();
				String preco = textField_4.getText();
				String quantidade1 = textField_5.getText();
				String fornecedor = textField_6.getText();

				CadastroProdutos cadastroProdutos = new CadastroProdutos();
				cadastroProdutos.setModelo(modelo1);
				cadastroProdutos.setCor(cor);
				cadastroProdutos.setTamanho(Integer.valueOf(tamanho));
				cadastroProdutos.setMarca(marca);
				cadastroProdutos.setPreco(Double.valueOf(preco));
				cadastroProdutos.setQuantidade(Integer.valueOf(quantidade1));
				cadastroProdutos.setIdfornecedor(Integer.valueOf(fornecedor));
				
				ProdutoBD bdProduto = new ProdutoBD();
				bdProduto.inserirProduto(cadastroProdutos);

				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_1.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				while (tbProduto.getModel().getRowCount() > 0) {
					((DefaultTableModel) tbProduto.getModel()).removeRow(0);
				}

				ProdutoBD produtoBD = new ProdutoBD();
				listaProdutos = produtoBD.listarTodosProdutos();
				tbProduto = new JTable();
				tbProduto.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Id", "Modelo", "Cor", "Tamanho", "Marca", "Preco", "Quantidade","Fornecedor" }));
				scrollPane.setViewportView(tbProduto);

				modelo = (DefaultTableModel) tbProduto.getModel();
				for (int i = 0; i < listaProdutos.size(); i++) {
					CadastroProdutos p = listaProdutos.get(i);
					modelo.addRow(new Object[] { p.getId(), p.getModelo(), p.getCor(), p.getTamanho(), p.getMarca(),
							p.getPreco(), p.getQuantidade(),p.getIdfornecedor() });

				}
				tbProduto.setModel(modelo);

			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 1;
		gbc_btnAdicionar.gridy = 12;
		contentPane.add(btnAdicionar, gbc_btnAdicionar);

		JButton btnAlterar = new JButton("Alterar");
		JButton btnExcluir = new JButton("Excluir Produto");

		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (tbProduto.getValueAt(tbProduto.getSelectedRow(), 0).toString());
				int x = Integer.parseInt(a);

				CadastroProdutos produtos = new CadastroProdutos();
				produtos.setId(x);

				ProdutoBD produtobd = new ProdutoBD();
				produtobd.removeProduto(produtos);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				((DefaultTableModel) tbProduto.getModel()).removeRow(tbProduto.getSelectedRow());
				btnExcluir.setEnabled(false);
				btnAlterar.setEnabled(false);
				btnAdicionar.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 12;
		contentPane.add(btnExcluir, gbc_btnExcluir);

		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modelo1 = textField.getText();
				String cor = textField_2.getText();
				String tamanho = textField_1.getText();
				String marca = textField_3.getText();
				String preco = textField_4.getText();
				String quantidade1 = textField_5.getText();

				CadastroProdutos cadastroProdutos = new CadastroProdutos();
				cadastroProdutos.setId(Integer.valueOf(id));
				cadastroProdutos.setModelo(modelo1);
				cadastroProdutos.setCor(cor);
				cadastroProdutos.setTamanho(Integer.valueOf(tamanho));
				cadastroProdutos.setMarca(marca);
				cadastroProdutos.setPreco(Double.valueOf(preco));
				cadastroProdutos.setQuantidade(Integer.valueOf(quantidade1));
				ProdutoBD bdProduto = new ProdutoBD();
				bdProduto.alterarProduto(cadastroProdutos);

				while (tbProduto.getModel().getRowCount() > 0) {
					((DefaultTableModel) tbProduto.getModel()).removeRow(0);

				}

				ProdutoBD produtoBD = new ProdutoBD();
				listaProdutos = produtoBD.listarTodosProdutos();
				tbProduto = new JTable();
				tbProduto.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Id", "Modelo", "Cor", "Tamanho", "Marca", "Preco", "Quantidade","Fornecedor" }));
				scrollPane.setViewportView(tbProduto);

				modelo = (DefaultTableModel) tbProduto.getModel();
				for (int i = 0; i < listaProdutos.size(); i++) {
					CadastroProdutos p = listaProdutos.get(i);
					modelo.addRow(new Object[] { p.getId(), p.getModelo(), p.getCor(), p.getTamanho(), p.getMarca(),
							p.getPreco(), p.getQuantidade(),p.getIdfornecedor() });

				}
				tbProduto.setModel(modelo);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				btnExcluir.setEnabled(false);
				btnAlterar.setEnabled(false);
				btnAdicionar.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAlterar.gridx = 2;
		gbc_btnAlterar.gridy = 12;
		contentPane.add(btnAlterar, gbc_btnAlterar);

		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbProduto.getSelectedRow();

				if (posicaoPessoa > -1) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnAdicionar.setEnabled(false);
					CadastroProdutos pessoaSelecionada = listaProdutos.get(posicaoPessoa);
					id = (tbProduto.getValueAt(tbProduto.getSelectedRow(), 0).toString());
					textField.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 1).toString());
					textField_2.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 2).toString());
					textField_1.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 3).toString());
					textField_3.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 4).toString());
					textField_4.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 5).toString());
					textField_5.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 6).toString());
					textField_6.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 7).toString());
				} else {
					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
				}
			}
		});

	}

}