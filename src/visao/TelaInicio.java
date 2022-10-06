package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
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
		setMinimumSize(new Dimension(450, 300));
		setMaximumSize(new Dimension(460, 300));
		setSize(new Dimension(450, 300));
		setTitle("Bem Vindo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(450, 300));
		contentPane.setForeground(Color.BLACK);
		contentPane.setMaximumSize(new Dimension(450, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 30, 123, 231);
		contentPane.add(panel1);
		panel1.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel1.add(panel);
		panel1.setVisible(false);
		JButton btnNewButton_6 = new JButton("Administrador");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Administrador administrador = new Administrador();
				 administrador.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnNewButton_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel1.add(panel_1);
		
				JButton btnNewButton_8 = new JButton("Sair da conta");
				btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel_1.add(btnNewButton_8);
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login();
						login.setVisible(true);
						setVisible(false);
					}
				});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel1.add(panel_2);
		
				JButton btnNewButton_9 = new JButton("Fechar Sistema");
				btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel_2.add(btnNewButton_9);
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});

		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TelaClientes clientes = new TelaClientes();
				 clientes.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(42, 73, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Vendas");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vendas vendas = new Vendas();
				// vendas.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(262, 122, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Cadastro de Produtos");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto cadastroProdutos = new TelaCadastroProduto();
				cadastroProdutos.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(86, 122, 163, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Fornecedor");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TelaFornecedores fornecedor = new TelaFornecedores();
				 fornecedor.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(141, 73, 108, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Estoque");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Estoque estoque = new Estoque();
				// estoque.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5.setBounds(262, 73, 113, 23);
		contentPane.add(btnNewButton_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.setBounds(0, 0, 434, 32);
		contentPane.add(panel_4);

		JButton btnNewButton = new JButton("...");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel1.isVisible()) {
					panel1.setVisible(false);
					btnNewButton_4.setVisible(true);
					btnNewButton_1.setVisible(true);
					btnNewButton_2.setVisible(true);
					btnNewButton_3.setVisible(true);
					btnNewButton_5.setVisible(true);
				} else {
					panel1.setVisible(true);
					btnNewButton_4.setVisible(false);
					btnNewButton_1.setVisible(false);
					btnNewButton_2.setVisible(false);
					btnNewButton_3.setVisible(false);
					btnNewButton_5.setVisible(false);
				}
			}
		});

	}
}
