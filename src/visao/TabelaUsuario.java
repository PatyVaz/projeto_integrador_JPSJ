package visao;

import java.awt.EventQueue;
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

import controle.UsuarioBD;
import modelo.Cliente;
import modelo.Perfil;
import modelo.Usuario;
import java.awt.Color;
import java.awt.Font;

public class TabelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Usuario> listaUsuarios;
	static Connection conexao;
	

	/**
	 * Create the frame.
	 */
	public TabelaUsuario(Perfil VA) {
		setTitle("Excluir Usuários");
		 UsuarioBD usuarioBd = new UsuarioBD();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 34, 412, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				 int posicaoPessoa = table.getSelectedRow();
					

					if (posicaoPessoa > -1) {
						 Usuario u=listaUsuarios.get(posicaoPessoa);
						 int result = usuarioBd.removerUsuario(u);
					
					
						 ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
						 
						 JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
					}
				
			}
		});
		btnNewButton.setBounds(179, 238, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrador administrador = new Administrador(VA);
				administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 0, 58, 23);
		contentPane.add(btnNewButton_1);
		
			
			
			
			
			
			 listaUsuarios = usuarioBd.buscarUsuarios();
		    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		     for (Usuario usuario : listaUsuarios) {
				modelo.addRow(new Object[] {usuario.getNome()});
			}
		    
			    	
		     
		    
	
	}
}
