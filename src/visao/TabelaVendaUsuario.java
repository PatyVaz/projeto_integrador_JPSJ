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

import controle.UsuarioBD;
import modelo.Usuario;
import java.awt.Color;

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
		contentPane.setBackground(Color.LIGHT_GRAY);
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
				"ID vendedor", "Login", "Nome"
			}
			
		));
		scrollPane.setViewportView(tbUsuario);
		UsuarioBD usuarioBD = new UsuarioBD();
		listaUsuarios = usuarioBD.buscarUsuarios();
		
		tbUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID vendedor", "Login", "nome"}));
		scrollPane.setViewportView(tbUsuario);

		modelo = (DefaultTableModel) tbUsuario.getModel();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario p = listaUsuarios.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getLogin(), p.getNome() });

		}
		tbUsuario.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbUsuario.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					TV.textField.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString());
					TV.textField_2.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 2).toString());
					
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
