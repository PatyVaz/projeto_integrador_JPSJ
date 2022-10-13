package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import modelo.Usuario;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.UsuarioBD;

public class TabelaVendaUsuario extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbUsuario;
	private ArrayList<Usuario> listaUsuarios;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaVendaUsuario(TelaVenda TV ){
		
		
			System.out.println(conexao);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tbUsuario = new JTable();
		tbUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID vendedor", "Login"
			}
			
		));
		scrollPane.setViewportView(tbUsuario);
		UsuarioBD usuarioBD = new UsuarioBD();
		listaUsuarios = usuarioBD.buscarUsuarios();
		
		tbUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID vendedor", "Login"}));
		scrollPane.setViewportView(tbUsuario);

		modelo = (DefaultTableModel) tbUsuario.getModel();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario p = listaUsuarios.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getLogin() });

		}
		tbUsuario.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbUsuario.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					TV.textField_1.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString());
					TV.txtNomeProd.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 1).toString());
					TV.txtPrecoProd.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 2).toString());
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
