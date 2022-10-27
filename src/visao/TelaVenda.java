package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import controle.ClienteBD;
import controle.FornecedorBD;
import controle.ProdutoBD;
import controle.UsuarioBD;
import controle.VendaBD;
import modelo.CadastroProdutos;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Produto;
import modelo.Usuario;
import modelo.Venda;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomeProd;
	public JTextField textField_1;
	public JTextField textField;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField txtPrecoProd;
	public JTextField txtQuantidadeProd;
	private JTable tbProdutosCarrinho;
	private DefaultTableModel model;
	String teste;
	private ArrayList<CadastroProdutos> listarProdutos;
	static Connection conexao;
	private ArrayList<Produto> produtos = new ArrayList<>();

	ProdutoBD produtoBD = new ProdutoBD();
	UsuarioBD  usuarioBD = new  UsuarioBD();
	 ClienteBD  clienteBD = new  ClienteBD();
	 
	CadastroProdutos Cp = new CadastroProdutos();
	Usuario u = new Usuario();
	Cliente c = new Cliente();
	
	
	public TelaVenda() {
		
	
	TelaVenda TV = this;
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendas:");
		lblNewLabel.setBounds(41, 5, 126, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("modelo:");
		lblNewLabel_2.setBounds(379, 149, 99, 14);
		contentPane.add(lblNewLabel_2);

		txtNomeProd = new JTextField();
		txtNomeProd.setEditable(false);
		txtNomeProd.setBounds(464, 146, 417, 20);
		contentPane.add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(698, 404, 138, 14);
		contentPane.add(lblNewLabel_1);
		
		txtQuantidadeProd = new JTextField();
		txtQuantidadeProd.setBounds(698, 220, 54, 20);
		contentPane.add(txtQuantidadeProd);
		txtQuantidadeProd.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				produtoBD = new ProdutoBD();
				CadastroProdutos Cp1 = new CadastroProdutos();
				String id= textField_1.getText();
				
				Cp1.setId(Integer.valueOf(id));
				Cp1 = produtoBD.listarquantidadeID(Cp1);
				
				int quantidade1 = Cp1.getQuantidade();
				String quantidadeVendido = txtQuantidadeProd.getText();
				int quantidadeVendida = Integer.valueOf(quantidadeVendido);
				int total =quantidade1 - quantidadeVendida;
				if(quantidade1 > quantidadeVendida) {	
				
				if (!txtQuantidadeProd.getText().isEmpty()) {
					model = (DefaultTableModel) tbProdutosCarrinho.getModel();
					
					Integer qtdProdutos = Integer.valueOf(txtQuantidadeProd.getText());
					textField_1.setText("");
					txtNomeProd.setText("");
					txtPrecoProd.setText("");
					 
					for (int i = 0; i < qtdProdutos; i++) {

						model.addRow(new Object[] { Cp.getId(), Cp.getModelo(), Cp.getPreco() });
					}
					btnNewButton_2.setEnabled(false);
					
					
					
					Cp1.setQuantidade(total);
					Cp1.setId(Integer.valueOf(id));
					Cp1 = produtoBD.baixaNoEstoque(Cp1);
					
				}
			}else
				if(quantidadeVendida > quantidade1) {
					JOptionPane.showMessageDialog(null, "estoque insuficiente");
				}
				double somaTotal=0;
				
			    for(int i=0; i<model.getRowCount();i++)
			        somaTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
			    lblNewLabel_1.setText(String.valueOf(somaTotal));
			    
			    txtQuantidadeProd.setText("");
			}
		});
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 produtoBD = new ProdutoBD();
				 Cp = new CadastroProdutos();
				String id= textField_1.getText();
				
				Cp.setId(Integer.valueOf(id));
				Cp = produtoBD.listarProdutosID(Cp);
				 
					String modelo = Cp.getModelo();
					Double preco = Cp.getPreco();
					txtNomeProd.setText(modelo);
					txtPrecoProd.setText(String.valueOf(preco));
					
				btnNewButton_2.setEnabled(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Finalizar Venda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  for(int i=0; i<model.getRowCount();i++) { 
					 String id_cadastro = textField_3.getText();
						String id_usuario = textField.getText();
						String id_produto = (tbProdutosCarrinho.getValueAt(tbProdutosCarrinho.getAutoResizeMode(), 0).toString());
						String preco = (tbProdutosCarrinho.getValueAt(tbProdutosCarrinho.getAutoResizeMode(), 2).toString());
						DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				        String h =(dtf5.format(LocalDateTime.now()));
				  
						Venda venda = new Venda();
						
						    venda.setCadastro(Integer.valueOf(id_cadastro));
						    venda.setUsuario(Integer.valueOf(id_usuario));
						    venda.setProduto(Integer.valueOf(id_produto));
						    venda.setValor(Double.valueOf(preco));
						    venda.setData(h);
						

						
						VendaBD bdVenda = new VendaBD();
						bdVenda.inserirVenda(venda);
				  }
				  while(tbProdutosCarrinho.getModel().getRowCount()>0){
						 ((DefaultTableModel) tbProdutosCarrinho.getModel()).removeRow(0);
					}
						textField.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
				 
				
				
				 
			        
			}
		});
		btnNewButton_1.setBounds(278, 456, 125, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo Cadastral: ");
		lblNewLabel_3.setBounds(488, 81, 139, 14);
		contentPane.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_F1) {
					TabelaProduto TP = new TabelaProduto(TV);
					TP.setVisible(true);
					setVisible(false);
				}
			}
		});
		textField_1.setBounds(603, 78, 57, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor:");
		lblNewLabel_4.setBounds(379, 177, 54, 14);
		contentPane.add(lblNewLabel_4);

		txtPrecoProd = new JTextField();
		txtPrecoProd.setEditable(false);
		txtPrecoProd.setBounds(464, 174, 86, 20);
		contentPane.add(txtPrecoProd);
		txtPrecoProd.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Quantidade:");
		lblNewLabel_5.setBounds(591, 223, 97, 14);
		contentPane.add(lblNewLabel_5);

		

		JLabel lblNewLabel_6 = new JLabel(" Produtos da compra:");
		lblNewLabel_6.setBounds(425, 248, 161, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Valor Total:");
		lblNewLabel_7.setBounds(628, 404, 86, 14);
		contentPane.add(lblNewLabel_7);

		tbProdutosCarrinho = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 273, 500, 120);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(tbProdutosCarrinho);

		model = (DefaultTableModel) tbProdutosCarrinho.getModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preco");

	
		
		btnNewButton_2.setBounds(774, 219, 105, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Remover Produto");
		btnNewButton_3.setEnabled(false);
		JButton btnNewButton_6 = new JButton("selecionar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbProdutosCarrinho.getSelectedRow();
				
			 if(posicaoPessoa > -1) {
				btnNewButton_3.setEnabled(true);
				 teste = tbProdutosCarrinho.getValueAt(tbProdutosCarrinho.getSelectedRow(), 0).toString();
					
			}else {
				JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			
				((DefaultTableModel) tbProdutosCarrinho.getModel()).removeRow(tbProdutosCarrinho.getSelectedRow());
			
				
				CadastroProdutos Cp1 = new CadastroProdutos();
				String id= (teste);
				
				Cp1.setId(Integer.valueOf(id));
				Cp1 = produtoBD.listarquantidadeID(Cp1);
				int total = Cp1.getQuantidade() + 1;
				
				 Cp1.setQuantidade(total);
				 Cp1.setId(Integer.valueOf(id));
				 Cp1 = produtoBD.baixaNoEstoque(Cp1);
				
				double somaTotal=0;
			    for(int i=0; i<model.getRowCount();i++)
			        somaTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
			    lblNewLabel_1.setText(String.valueOf(somaTotal));
			    btnNewButton_3.setEnabled(false);
			}
		});
		btnNewButton_3.setBounds(471, 400, 147, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Buscar(f1)");
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProduto TP = new TabelaProduto(TV);
				TP.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(776, 77, 103, 22);
		contentPane.add(btnNewButton_4);
		
	
		btnNewButton_5.setBounds(677, 77, 89, 23);
		contentPane.add(btnNewButton_5);
		

		btnNewButton_6.setBounds(348, 400, 105, 22);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("Vendedor:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(30, 81, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Código do vendedor:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(30, 117, 137, 14);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(158, 115, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 usuarioBD = new  UsuarioBD();
				 u = new Usuario();
				String id= textField.getText();
				
				u.setId(Integer.valueOf(id));
				u = usuarioBD.listarUsuariosID(u);
					String nome = u.getNome();
					
					textField_2.setText(nome);
					
			}
		});
		btnNewButton.setBounds(214, 114, 54, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_7 = new JButton("Buscar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaVendaUsuario TVU = new TabelaVendaUsuario(TV);
				TVU.setVisible(true);
				
			}
		});
		btnNewButton_7.setBounds(278, 114, 99, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_11 = new JLabel("Usuario:");
		lblNewLabel_11.setBounds(30, 160, 57, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(86, 157, 262, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Cliente:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(30, 212, 86, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Código do cliente:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_1.setBounds(30, 248, 137, 14);
		contentPane.add(lblNewLabel_9_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 245, 46, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("OK");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 clienteBD = new   ClienteBD();
				 c = new Cliente();
				String id1= textField_3.getText();
				
				c.setId(Integer.valueOf(id1));
				c = clienteBD.listarClientesID(c);
					String nome1 = c.getNome();
					
					textField_4.setText(nome1);
			}
		});
		btnNewButton_8.setBounds(214, 244, 54, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Buscar");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendaCliente TVC = new TelaVendaCliente(TV);
				TVC.setVisible(true);
				
			}
		});
		btnNewButton_9.setBounds(278, 244, 99, 23);
		contentPane.add(btnNewButton_9);
		
		JLabel lblNewLabel_12 = new JLabel("Nome:");
		lblNewLabel_12.setBounds(30, 285, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(86, 282, 262, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_10 = new JButton("<-");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio();
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_10.setBounds(10, 456, 54, 23);
		contentPane.add(btnNewButton_10);
		
		
	}
}
