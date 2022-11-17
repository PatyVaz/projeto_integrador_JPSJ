package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.UsuarioBD;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TabelaAquisicao extends JFrame {
	public TabelaAquisicao() {
	}

	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbAquisicao;
	private ArrayList<Usuario> listaUsuarios;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaAquisicao( ProdutosFornecedores pf ){
		setTitle("Vendas do Usuário");
		
		
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
		
		tbAquisicao = new JTable();
		tbAquisicao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Modelo", "Cor", "Tamanho", "Marca"
			}
			
		));
		scrollPane.setViewportView(tbAquisicao);
		UsuarioBD usuarioBD = new UsuarioBD();
		listaUsuarios = usuarioBD.buscarUsuarios();
		
		tbAquisicao.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"ID", "Modelo", "Cor", "Tamanho", "Marca"}));
		scrollPane.setViewportView(tbAquisicao);

		modelo = (DefaultTableModel) tbAquisicao.getModel();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario p = listaUsuarios.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getLogin(), p.getNome() });

		}
		tbAquisicao.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbAquisicao.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					pf.textField.setText(tbAquisicao.getValueAt(tbAquisicao.getSelectedRow(), 0).toString());
					
					
					pf.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}
