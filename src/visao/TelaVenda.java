package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

import controle.ClienteBD;
import controle.ProdutoBD;
import controle.UsuarioBD;
import controle.VendaBD;
import modelo.CadastroProdutos;
import modelo.Cliente;
import modelo.Perfil;
import modelo.Produto;

import modelo.Usuario;
import modelo.Venda;

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
	private ArrayList<CadastroProdutos> listarProdutos = new ArrayList<CadastroProdutos>();
	static Connection conexao;
	private ArrayList<Produto> produtos = new ArrayList<>();

	ProdutoBD produtoBD = new ProdutoBD();
	UsuarioBD  usuarioBD = new  UsuarioBD();
	 ClienteBD  clienteBD = new  ClienteBD();
	 
	CadastroProdutos Cp = new CadastroProdutos();
	Usuario u = new Usuario();
	Cliente c = new Cliente();
	
	
	public TelaVenda(Perfil VA) {
		setTitle("Venda");
		setExtendedState(MAXIMIZED_BOTH);
	
	TelaVenda TV = this;
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("OK");
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBackground(Color.BLACK);
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
		btnNewButton_8.setBounds(299, 245, 54, 23);
		contentPane.add(btnNewButton_8);

		JLabel lblNewLabel = new JLabel("Vendas:");
		lblNewLabel.setBounds(86, 12, 161, 35);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(123, 404, 69, 14);
		contentPane.add(lblNewLabel_2);

		txtNomeProd = new JTextField();
		txtNomeProd.setEditable(false);
		txtNomeProd.setBounds(211, 401, 262, 20);
		contentPane.add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(873, 404, 183, 14);
		contentPane.add(lblNewLabel_1);
		
		txtQuantidadeProd = new JTextField();
		txtQuantidadeProd.setBounds(211, 464, 54, 20);
		contentPane.add(txtQuantidadeProd);
		txtQuantidadeProd.setColumns(10);
		
		tbProdutosCarrinho = new JTable();
		tbProdutosCarrinho.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(567, 117, 772, 352);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(tbProdutosCarrinho);

		model = (DefaultTableModel) tbProdutosCarrinho.getModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preco");

		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
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
				if(quantidade1 >= quantidadeVendida) {	
				
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
			    lblNewLabel_1.setText("Valor Total: "+String.valueOf(somaTotal));
			    
			    txtQuantidadeProd.setText("");
			}
			
			
		});
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setForeground(Color.WHITE);
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
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( textField_2.getText().isEmpty() ||  textField_4.getText().isEmpty() || tbProdutosCarrinho.getRowCount() ==0) {
					JOptionPane.showMessageDialog(null, "Prencha todos os campos");
				}else
					if(  textField_2.getText()!="" && textField_4.getText()!="") {
				
				  for(int i=0; i<tbProdutosCarrinho.getRowCount();i++) { 
					 
					 String id_cadastro = textField_3.getText();
						String id_usuario = textField.getText();

						 String id_produto = (tbProdutosCarrinho.getValueAt(i, 0).toString());
						String preco = (tbProdutosCarrinho.getValueAt(i, 2).toString());
						DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				        String h =(dtf5.format(LocalDateTime.now()));
				  
						Venda venda = new Venda();
						
						    venda.setCadastro(Integer.valueOf(id_cadastro));
						    venda.setUsuario(Integer.valueOf(id_usuario));
							 venda.setId_produto(Integer.valueOf(id_produto));
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
				
						lblNewLabel_1.setText("Valor Total: ");
				
			}
			}
		});
		btnNewButton_1.setBounds(637, 596, 193, 58);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo Cadastral: ");
		lblNewLabel_3.setBounds(67, 365, 125, 14);
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
		textField_1.setBounds(215, 362, 57, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor:");
		lblNewLabel_4.setBounds(123, 435, 54, 14);
		contentPane.add(lblNewLabel_4);

		txtPrecoProd = new JTextField();
		txtPrecoProd.setEditable(false);
		txtPrecoProd.setBounds(211, 432, 86, 20);
		contentPane.add(txtPrecoProd);
		txtPrecoProd.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Quantidade:");
		lblNewLabel_5.setBounds(123, 467, 97, 14);
		contentPane.add(lblNewLabel_5);

		

		JLabel lblNewLabel_6 = new JLabel(" Produtos da compra:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(555, 78, 161, 14);
		contentPane.add(lblNewLabel_6);

		

		
		

	
		
		btnNewButton_2.setBounds(368, 463, 105, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Remover Produto");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setEnabled(false);
		JButton btnNewButton_6 = new JButton("Selecionar");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(Color.BLACK);
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
			    lblNewLabel_1.setText("Valor Total: "+String.valueOf(somaTotal));
			    btnNewButton_3.setEnabled(false);
			}
		});
		btnNewButton_3.setBounds(723, 480, 161, 34);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Buscar(f1)");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.BLACK);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProduto TP = new TabelaProduto(TV);
				TP.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(374, 361, 103, 22);
		contentPane.add(btnNewButton_4);
		
	
		btnNewButton_5.setBounds(299, 361, 54, 23);
		contentPane.add(btnNewButton_5);
		

		btnNewButton_6.setBounds(567, 478, 146, 36);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("Vendedor:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(67, 78, 97, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("C??digo do vendedor:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(79, 117, 137, 14);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(226, 115, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
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
		btnNewButton.setBounds(299, 114, 54, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_7 = new JButton("Buscar");
		btnNewButton_7.setBackground(Color.BLACK);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaVendaUsuario TVU = new TabelaVendaUsuario(TV);
				TVU.setVisible(true);
				
			}
		});
		btnNewButton_7.setBounds(374, 114, 99, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_11 = new JLabel("Usu??rio:");
		lblNewLabel_11.setBounds(130, 149, 57, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(211, 146, 262, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Cliente:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(67, 221, 86, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9_1 = new JLabel("C??digo do cliente:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1.setBounds(79, 249, 119, 14);
		contentPane.add(lblNewLabel_9_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(226, 246, 46, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Buscar");
		btnNewButton_9.setBackground(Color.BLACK);
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendaCliente TVC = new TelaVendaCliente(TV);
				TVC.setVisible(true);
				
			}
		});
		btnNewButton_9.setBounds(374, 245, 99, 23);
		contentPane.add(btnNewButton_9);
		
		JLabel lblNewLabel_12 = new JLabel("Nome:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(130, 285, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(211, 282, 262, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_10 = new JButton("<-");
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setBackground(Color.BLACK);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio(VA);
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_10.setBounds(10, 11, 54, 23);
		contentPane.add(btnNewButton_10);
		
	
		
		ImageIcon imageIcon = new ImageIcon(TelaVenda.class.getResource("/img/logo.png"));
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setIcon(imageIcon);
		lblNewLabel_13.setBounds(1220, 550, 922, 137);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_10_1 = new JLabel("Produto:");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1.setBounds(67, 330, 86, 14);
		contentPane.add(lblNewLabel_10_1);
		
	
		
		
		
	}
}
