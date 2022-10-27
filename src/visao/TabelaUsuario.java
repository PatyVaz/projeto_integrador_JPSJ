package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.UsuarioBD;
import modelo.Usuario;

public class TabelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Usuario> listaUsuarios;
	static Connection conexao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaUsuario frame = new TabelaUsuario();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TabelaUsuario() {
		 UsuarioBD usuarioBd = new UsuarioBD();
		
		System.out.println(conexao);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 205);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				 int posicaoPessoa = table.getSelectedRow();
				 Usuario u=listaUsuarios.get(posicaoPessoa);
				 int result = usuarioBd.removerUsuario(u);
			
			
				 ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnNewButton.setBounds(179, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("â†�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrador administrador = new Administrador();
				administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 238, 43, 23);
		contentPane.add(btnNewButton_1);
		
			
			
			
			
			
			 listaUsuarios = usuarioBd.buscarUsuarios();
		    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		     for (Usuario usuario : listaUsuarios) {
				modelo.addRow(new Object[] {usuario.getNome()});
			}
		    
			    	
		     
		    
	
	}
}
