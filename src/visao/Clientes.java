package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Color;
public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	static Connection conexao;
	
	
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			 conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemodb", "root", "sasalegal123");
			 
		}catch(SQLException e)
		{
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		 try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemodb", "root", "sasalegal123");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		setMinimumSize(new Dimension(10, 10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Dados Pessoais:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 42, 274, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 106, 68, 14);
		contentPane.add(lblNewLabel_1);

		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 167, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 233, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rua:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 311, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Bairro:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 445, 74, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(10, 382, 89, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CEP:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 522, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cidade:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(10, 575, 142, 34);
		contentPane.add(lblNewLabel_9);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(437, 11, 923, 598);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","nome", "cpf", "email", "rua", "bairro", "telefone", "cep", "cidade"
			}
		));
		
		
	
		scrollPane.setViewportView(table);
	
		try {
			
			
			
			
			 PreparedStatement ps = conexao.prepareStatement ("select * from cadastro order by nome");
		    ResultSet rs = ps.executeQuery();
		    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		     while( rs.next() ){
		    
		    	modelo.addRow(new Object[] {rs.getString("id_cadastro"),rs.getString("nome"),rs.getString("cpf"),rs.getString("email"),rs.getString("rua"),rs.getString("telefone"),rs.getString("bairro"),rs.getString("cep"),rs.getString("cidade")});
		    	 
		            		          
		        }
		    
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nome = textField.getText();
				String cpf = textField_1.getText();
				String email = textField_2.getText();
				String rua = textField_3.getText();
				String bairro = textField_5.getText();
				String telefone = textField_4.getText();
				String cep = textField_6.getText();
				String cidade = textField_7.getText();
				
				try {
					
					  PreparedStatement ps = conexao.prepareStatement("insert into cadastro (nome, cpf, email, rua,bairro, telefone, cep, cidade) values(?,?,?,?,?,?,?,?)");
					
					ps.setString(1,nome);
					ps.setString(2,cpf);
					ps.setString(3,email);
					ps.setString(4,rua);
					ps.setString(5,bairro);
					ps.setString(6,telefone);
					ps.setString(7,cep);
					ps.setString(8,cidade);
					ps.executeUpdate();
				
					
					}catch(SQLException e1)
					{
						System.out.println("Erro ao conectar ï¿½ base de dados.");
					}
				
				
	
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_1.setText("");
				
				 try{
		             Integer.parseInt(cpf);
		            
		        }catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null,"Digite um numero valido no campo 'cpf'.");
		        	textField.setText(nome);
					textField_1.setText("");
					textField_2.setText(email);
					textField_3.setText(rua);
					textField_4.setText(telefone);
					textField_5.setText(bairro);
					textField_6.setText(cep);
					textField_7.setText(cidade);
					 try{
			             Integer.parseInt(telefone);
			            
			        }catch (NumberFormatException ed) {
			        	textField_4.setText("");
			        }
		        }
				
				 try{
		             Integer.parseInt(telefone);
		            
		        }catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null,"Digite um numero valido no campo 'telefone'.");
		        	textField.setText(nome);
					textField_1.setText(cpf);
					textField_2.setText(email);
					textField_3.setText(rua);
					textField_4.setText("");
					textField_5.setText(bairro);
					textField_6.setText(cep);
					textField_7.setText(cidade);
					 try{
			             Integer.parseInt(cpf);
			            
			        }catch (NumberFormatException ed) {
			        	textField_1.setText("");
			        }
		        }
				 
				while(table.getModel().getRowCount()>0){
			 ((DefaultTableModel) table.getModel()).removeRow(0);
		}
				 
			
				try {
					
					
					
					
					 PreparedStatement ps = conexao.prepareStatement ("select * from cadastro order by nome");
				    ResultSet rs = ps.executeQuery();
				    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				     while( rs.next() ){
				    	 
				    	modelo.addRow(new Object[] {rs.getString("id_cadastro"), rs.getString("nome"),rs.getString("cpf"),rs.getString("email"),rs.getString("rua"),rs.getString("bairro"),rs.getString("telefone"),rs.getString("cep"),rs.getString("cidade")});
				    	 
				            		          
				        }
				    
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
			
			}
		});
		btnNewButton_1.setBounds(133, 652, 116, 35);
		contentPane.add(btnNewButton_1);
		
		
		textField = new JTextField();
		textField.setBounds(122, 99, 236, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 160, 236, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 226, 236, 34);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 304, 236, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 375, 236, 34);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(122, 444, 236, 34);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(122, 515, 236, 34);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(122, 575, 236, 34);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("â†�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					TelaInicio telainicio = new TelaInicio();
					telainicio.setVisible(true);
					setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 61, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setEnabled(false);
		JButton btnNewButton_4 = new JButton("Alterar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setEnabled(false);
				btnNewButton_4.setEnabled(false);
				btnNewButton_1.setEnabled(true);
				 try {
					 String nome = textField.getText();
						String cpf = textField_1.getText();
						String email = textField_2.getText();
						String rua = textField_3.getText();
						String bairro = textField_5.getText();
						String telefone = textField_4.getText();
						String cep = textField_6.getText();
						String cidade = textField_7.getText();
						
						 
						String y= (table.getValueAt(table.getSelectedRow(), 0).toString());
						 int x = Integer.parseInt(y);
					 PreparedStatement	ps = conexao.prepareStatement("update cadastro set nome=? where id_cadastro = ?");
						ps.setString(1,nome);
						ps.setInt(2, x);
						ps.executeUpdate();
						
						ps.executeUpdate();
						ps = conexao.prepareStatement("update cadastro set email=? where id_cadastro = ?");
						ps.setString(1,email);
						ps.setInt(2, x);
						ps.executeUpdate();
						
						ps = conexao.prepareStatement("update cadastro set cpf=? where id_cadastro = ?");
						ps.setString(1,cpf);
						ps.setInt(2, x);
						ps.executeUpdate();
						
						ps = conexao.prepareStatement("update cadastro set rua=? where id_cadastro = ?");
						ps.setString(1,rua);
						ps.setInt(2, x);
						ps.executeUpdate();
						ps = conexao.prepareStatement("update cadastro set bairro=? where id_cadastro = ?");
						ps.setString(1,bairro);
						ps.setInt(2, x);
						ps.executeUpdate();
						ps = conexao.prepareStatement("update cadastro set telefone=? where id_cadastro = ?");
						ps.setString(1,telefone);
						ps.setInt(2, x);
						ps.executeUpdate();
						ps = conexao.prepareStatement("update cadastro set cep=? where id_cadastro = ?");
						ps.setString(1,cep);
						ps.setInt(2, x);
						ps.executeUpdate();
						ps = conexao.prepareStatement("update cadastro set cidade=? where id_cadastro = ?");
						ps.setString(1,cidade);
						ps.setInt(2, x);
						ps.executeUpdate();
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					while(table.getModel().getRowCount()>0){
						 ((DefaultTableModel) table.getModel()).removeRow(0);
					}
							 
						
							try {
								
								
								

								 PreparedStatement ps = conexao.prepareStatement ("select * from cadastro");
							    ResultSet rs = ps.executeQuery();
							    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
							     while( rs.next() ){
							    	 
							    	modelo.addRow(new Object[] {rs.getString("id_cadastro"),rs.getString("nome"),rs.getString("cpf"),rs.getString("email"),rs.getString("rua"),rs.getString("telefone"),rs.getString("bairro"),rs.getString("cep"),rs.getString("cidade")});
							    	 
							            		          
							        }
							    
							} catch (SQLException e2) {
								
								e2.printStackTrace();
							}
							
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							btnNewButton_2.setEnabled(false);
							btnNewButton_4.setEnabled(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBounds(259, 652, 109, 35);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String a = textField_1.getText();
				 int x = Integer.parseInt(a);
				try {
					
					  PreparedStatement ps = conexao.prepareStatement("delete from cadastro where cpf=?");
				        ps.setInt(1,x);
				        ps.executeUpdate();
					
					}catch(SQLException e1)
					{
						System.out.println("Erro ao conectar ï¿½ base de dados.");
					}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				 ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
			btnNewButton_2.setEnabled(false);
			btnNewButton_4.setEnabled(false);
			btnNewButton_1.setEnabled(true);
			}
		});
		btnNewButton_2.setBounds(14, 652, 109, 35);
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("Selecionar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = table.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					btnNewButton_2.setEnabled(true);
					btnNewButton_4.setEnabled(true);
					btnNewButton_1.setEnabled(false);
					textField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_1.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textField_2.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					textField_3.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					textField_4.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
					textField_5.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
					textField_6.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
					textField_7.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
				}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(811, 652, 148, 35);
		contentPane.add(btnNewButton_3);
		
		
		
	
	
		
		
				
		
	
		
		
		
		
	
		
			
		
		

	}
}
