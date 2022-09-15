package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

import controle.ClienteBD;
import modelo.Cliente;

public class TelaClientes extends JFrame {

	protected static final int posicaoPessoa = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private ArrayList<Cliente> listaClientes;
	static Connection conexao;

	private JTable tbClientes;
	private static TelaClientes frame;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaClientes();
					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaClientes() {

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

		ClienteBD clientebd = new ClienteBD();
		listaClientes = clientebd.listarTodosClientes();
		tbClientes = new JTable();
		tbClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "nome", "cpf", "email", "rua", "bairro", "telefone", "cep", "cidade" }));
		scrollPane.setViewportView(tbClientes);

		modelo = (DefaultTableModel) tbClientes.getModel();
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getRua(),c.getBairro(), c.getTelefone(),
					 c.getCep(), c.getCidade() });

		}
		tbClientes.setModel(modelo);

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
					Integer.parseInt(cpf);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um numero valido no campo 'cpf'.");
					textField.setText(nome);
					textField_1.setText("");
					textField_2.setText(email);
					textField_3.setText(rua);
					textField_4.setText(telefone);
					textField_5.setText(bairro);
					textField_6.setText(cep);
					textField_7.setText(cidade);
					try {
						Integer.parseInt(telefone);

					} catch (NumberFormatException ed) {
						textField_4.setText("");
					}
				}

				try {
					Integer.parseInt(telefone);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um numero valido no campo 'telefone'.");
					textField.setText(nome);
					textField_1.setText(cpf);
					textField_2.setText(email);
					textField_3.setText(rua);
					textField_4.setText("");
					textField_5.setText(bairro);
					textField_6.setText(cep);
					textField_7.setText(cidade);
					try {
						Integer.parseInt(cpf);

					} catch (NumberFormatException ed) {
						textField_1.setText("");
					}
				}
				// validar se todos os campos de texto foram realmente preenchidos

				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCpf(Integer.valueOf(cpf));
				cliente.setEmail(email);
				cliente.setRua(rua);
				cliente.setBairro(bairro);
				cliente.setTelefone(Integer.valueOf(telefone));
				cliente.setCep(cep);
				cliente.setCidade(cidade);

				
				ClienteBD bdCliente = new ClienteBD();
				bdCliente.inserirCliente(cliente);

				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_1.setText("");

			

				while (tbClientes.getModel().getRowCount() > 0) {
					((DefaultTableModel) tbClientes.getModel()).removeRow(0);
				}
				
				ClienteBD clientebd = new ClienteBD();
				listaClientes = clientebd.listarTodosClientes();
				tbClientes = new JTable();
				tbClientes.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "ID", "nome", "cpf", "email", "rua", "bairro", "telefone", "cep", "cidade" }));
				scrollPane.setViewportView(tbClientes);

				modelo = (DefaultTableModel) tbClientes.getModel();
				for (int i = 0; i < listaClientes.size(); i++) {
					Cliente c = listaClientes.get(i);
					modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getRua(),c.getBairro(), c.getTelefone(),
							 c.getCep(), c.getCidade() });

				}
				tbClientes.setModel(modelo);

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

		JButton btnNewButton_3 = new JButton("Selecionar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbClientes.getSelectedRow();
				if (posicaoPessoa > -1) {
					Cliente pesoaSelecionada = listaClientes.get(posicaoPessoa);

				}

				if (posicaoPessoa > -1) {

					
					textField.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 1).toString());
					textField_1.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 2).toString());
					textField_2.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 3).toString());
					textField_3.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 4).toString());
					textField_4.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 6).toString());
					textField_5.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 5).toString());
					textField_6.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 7).toString());
					textField_7.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 8).toString());
				} else {
					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
				}
			}
		});

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

		JButton btnNewButton_4 = new JButton("Alterar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cl = listaClientes.get(posicaoPessoa);

				String nome = textField.getText();
				String cpf = textField_1.getText();
				String email = textField_2.getText();
				String rua = textField_3.getText();
				String bairro = textField_5.getText();
				String telefone = textField_4.getText();
				String cep = textField_6.getText();
				String cidade = textField_7.getText();
				cl.setNome(nome);
				cl.setCpf(Integer.valueOf(cpf));
				cl.setEmail(email);
				cl.setRua(rua);
				cl.setBairro(bairro);
				cl.setTelefone(Integer.valueOf(telefone));
				cl.setCep(cep);
				cl.setCidade(cidade);
				
				


				
				
				int result = clientebd.alterarClientes(cl);
			
				listaClientes.set(result, cl);


				while (tbClientes.getModel().getRowCount() > 0) {
					((DefaultTableModel) tbClientes.getModel()).removeRow(0);
				
				}

				ClienteBD clientebd = new ClienteBD();
				listaClientes = clientebd.listarTodosClientes();
				tbClientes = new JTable();
				tbClientes.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "ID", "nome", "cpf", "email", "rua", "bairro", "telefone", "cep", "cidade" }));
				scrollPane.setViewportView(tbClientes);

				modelo = (DefaultTableModel) tbClientes.getModel();
				for (int i = 0; i < listaClientes.size(); i++) {
					Cliente c = listaClientes.get(i);
					modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getRua(),c.getBairro(), c.getTelefone(),
							 c.getCep(), c.getCidade() });

				}
				tbClientes.setModel(modelo);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(259, 652, 109, 35);
		contentPane.add(btnNewButton_4);

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = (tbClientes.getValueAt(tbClientes.getSelectedRow(), 0).toString());
				int x = Integer.parseInt(a);

				Cliente cliente = new Cliente();
				cliente.setId(x);

				ClienteBD bdCliente = new ClienteBD();
				bdCliente.removeCliente(cliente);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				((DefaultTableModel) tbClientes.getModel()).removeRow(tbClientes.getSelectedRow());

			}
		});
		btnNewButton_2.setBounds(14, 652, 109, 35);
		contentPane.add(btnNewButton_2);

		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(811, 652, 148, 35);
		contentPane.add(btnNewButton_3);

	}

}