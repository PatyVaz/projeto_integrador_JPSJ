package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 30, 104, 231);
		contentPane.add(panel1);
		panel1.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel1.add(panel);
		panel1.setVisible(false);
		JButton btnNewButton_6 = new JButton("Administrador");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Administrador administrador = new Administrador();
				// administrador.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnNewButton_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel1.add(panel_1);

		JButton btnNewButton_7 = new JButton("Trocar de Conta");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TrocarConta trocarconta = new TrocarConta();
				// trocarconta.setVisible(true);
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel1.add(panel_2);

		JButton btnNewButton_8 = new JButton("Sair da conta");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
		panel_2.add(btnNewButton_8);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel1.add(panel_3);

		JButton btnNewButton_9 = new JButton("Fechar Sistema");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_3.add(btnNewButton_9);

		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clientes clientes = new Clientes();
				// clientes.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(63, 73, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Vendas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vendas vendas = new Vendas();
				// vendas.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(162, 73, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Cadastro de Produtos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CadastroProdutos cadastroProdutos = new CadastroProdutos();
				// cadastroprodutos.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(261, 73, 163, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Fornecedor");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fornecedor fornecedor = new Fornecedor();
				// fornecedor.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(114, 122, 89, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Estoque");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Estoque estoque = new Estoque();
				// estoque.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5.setBounds(232, 122, 89, 23);
		contentPane.add(btnNewButton_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.setBounds(0, 0, 434, 32);
		contentPane.add(panel_4);

		JButton btnNewButton = new JButton("...");
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel1.isVisible()) {
					panel1.setVisible(false);
				} else {
					panel1.setVisible(true);
				}
			}
		});

	}
}
