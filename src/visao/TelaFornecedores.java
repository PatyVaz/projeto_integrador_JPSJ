package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.sql.*;
public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static Connection conexao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			 conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemodb", "root", "sasalegal123");
		}catch(SQLException e)
		{
			System.out.println("Erro ao conectar � base de dados.");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedores frame = new TelaFornecedores();
					frame.setVisible(true);
					frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFornecedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedores:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 37, 180, 59);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(563, 0, 807, 599);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "CNPJ", "TELEFONE", "E-MAIL"
			}
		));
		scrollPane.setViewportView(table);
		try {
			
			
			
			
			 PreparedStatement ps = conexao.prepareStatement ("select * from fornecedor");
		    ResultSet rs = ps.executeQuery();
		    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		     while( rs.next() ){
		    
			    	modelo.addRow(new Object[] {rs.getString("nome"),rs.getString("cnpj"),rs.getString("telefone"),rs.getString("email")});
		    	 
		            		          
		        }
		    
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 110, 76, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 160, 76, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONE:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 210, 106, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-MAIL:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 260, 106, 25);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(132, 110, 232, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 160, 232, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 210, 232, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 260, 232, 25);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Cadastrar Fornecedor");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				String nome = textField.getText();
				String cnpj = textField_1.getText();
				String telefone = textField_2.getText();
				String email = textField_3.getText();
				 
				try {
					
					  PreparedStatement ps = conexao.prepareStatement("insert into fornecedor(nome,cnpj,telefone,email) values(?,?,?,?)");
					
					ps.setString(1,nome);
					
					 ps.setString(2,cnpj);
					ps.setString(3,telefone);
					ps.setString(4,email);
				
					ps.executeUpdate();
				
					
					}catch(SQLException e1)
					{
						System.out.println("Erro ao conectar � base de dados.");
					}
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_1.setText("");
				 try{
		             Integer.parseInt(cnpj);
		            
		        }catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null,"Digite um numero valido no campo 'cnpj'.");
		        	textField.setText(nome);
		        	textField_1.setText("");
					textField_2.setText(telefone);
					textField_3.setText(email);
		        }
				
				 try{
		             Integer.parseInt(telefone);
		            
		        }catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null,"Digite um numero valido no campo 'telefone'.");
		        	textField.setText(nome);
					textField_1.setText(cnpj);
					textField_2.setText("");
					textField_3.setText(email);
		        }
				while(table.getModel().getRowCount()>0){
					 ((DefaultTableModel) table.getModel()).removeRow(0);
				}
						 
					
						try {
							
							
							
							
							 PreparedStatement ps = conexao.prepareStatement ("select * from fornecedor");
						    ResultSet rs = ps.executeQuery();
						    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
						     while( rs.next() ){
						    	 
						    	modelo.addRow(new Object[] {rs.getString("nome"),rs.getString("cnpj"),rs.getString("telefone"),rs.getString("email")});
						    	 
						            		          
						        }
						    
						} catch (SQLException e2) {
							
							e2.printStackTrace();
						}
						
						
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(18, 640, 172, 33);
		contentPane.add(btnNewButton);
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setEnabled(false);
		
		JButton btnExcluirFornecedor = new JButton("Excluir Fornecedor");
		btnExcluirFornecedor.setEnabled(false);
		btnExcluirFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 String a = textField_1.getText();
				 int x = Integer.parseInt(a);
				try {
					
					  PreparedStatement ps = conexao.prepareStatement("delete from fornecedor where cnpj=?");
				        ps.setInt(1,x);
				        ps.executeUpdate();
					
					}catch(SQLException e1)
					{
						System.out.println("Erro ao conectar � base de dados.");
					}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				btnExcluirFornecedor.setEnabled(false);
				btnAlterarDados.setEnabled(false);
				 ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
				 
			
			}
			
		});
		btnExcluirFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluirFornecedor.setBounds(392, 640, 147, 33);
		contentPane.add(btnExcluirFornecedor);
		
		
	    btnAlterarDados.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
					 try {
							String nome = textField.getText();
							String cnpj = textField_1.getText();
							String telefone = textField_2.getText();
							String email = textField_3.getText();
							 int x = Integer.parseInt(cnpj);
						 PreparedStatement	ps = conexao.prepareStatement("update fornecedor set nome=? where cnpj = ?");
							ps.setString(1,nome);
							ps.setInt(2, x);
							ps.executeUpdate();
							ps = conexao.prepareStatement("update fornecedor set telefone=? where cnpj = ?");
							ps.setString(1,telefone);
							ps.setInt(2, x);
							ps.executeUpdate();
							ps = conexao.prepareStatement("update fornecedor set email=? where cnpj = ?");
							ps.setString(1,email);
							ps.setInt(2, x);
							ps.executeUpdate();
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
						while(table.getModel().getRowCount()>0){
							 ((DefaultTableModel) table.getModel()).removeRow(0);
						}
								 
							
								try {
									
									
									
									
									 PreparedStatement ps = conexao.prepareStatement ("select * from fornecedor");
								    ResultSet rs = ps.executeQuery();
								    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
								     while( rs.next() ){
								    	 
								    	modelo.addRow(new Object[] {rs.getString("nome"),rs.getString("cnpj"),rs.getString("telefone"),rs.getString("email")});
								    	 
								            		          
								        }
								    
								} catch (SQLException e2) {
									
									e2.printStackTrace();
								}
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								btnExcluirFornecedor.setEnabled(false);
								btnAlterarDados.setEnabled(false);
						
		      
					
					
				
			}
			
		});
		btnAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterarDados.setBounds(217, 640, 147, 33);
		contentPane.add(btnAlterarDados);
	
		
		
	
		JButton btnNewButton_1 = new JButton("←");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio();
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 3, 61, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("selecionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = table.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					btnAlterarDados.setEnabled(true);
					btnExcluirFornecedor.setEnabled(true);
					textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textField_1.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textField_3.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
		});
		btnNewButton_2.setBounds(956, 610, 141, 33);
		contentPane.add(btnNewButton_2);
	}
}
