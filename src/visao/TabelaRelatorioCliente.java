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
import modelo.Cliente;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.UsuarioBD;

public class TabelaRelatorioCliente extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbCliente;
	private ArrayList<Cliente> listaClientes;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaRelatorioCliente(TelaRelatorio TR ){
		
		
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
		
		tbCliente = new JTable();
		tbCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "ID","CPF"
			}
			
		));
		scrollPane.setViewportView(tbCliente);
		ClienteBD clienteBD = new ClienteBD();
		listaClientes = clienteBD.listarTodosClientes();
		
		tbCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "ID","CPF"}));
		scrollPane.setViewportView(tbCliente);

		modelo = (DefaultTableModel) tbCliente.getModel();
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente p = listaClientes.get(i);
		modelo.addRow(new Object[] { p.getNome(), p.getId() , p.getCpf()  });

		}
		tbCliente.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbCliente.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					TR.txtCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
					TR.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}
