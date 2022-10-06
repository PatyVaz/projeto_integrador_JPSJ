package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import java.awt.Color;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomeProd;
	public JTextField textField_1;
	public JTextField txtPrecoProd;
	public JTextField txtQuantidadeProd;
	public JTextField textField_4;
	private JTable tbProdutosCarrinho;
	private DefaultTableModel model;

	private ArrayList<Produto> produtos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {

		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Scarpin");
		produto.setPreco(50);
		produtos.add(produto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendas:");
		lblNewLabel.setBounds(41, 5, 126, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Limpar Campos");
		btnNewButton.setBounds(425, 446, 125, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Produto:");
		lblNewLabel_2.setBounds(379, 149, 99, 14);
		contentPane.add(lblNewLabel_2);

		txtNomeProd = new JTextField();
		txtNomeProd.setEditable(false);
		txtNomeProd.setBounds(462, 146, 417, 20);
		contentPane.add(txtNomeProd);
		txtNomeProd.setColumns(10);

		JButton btnNewButton_1 = new JButton("Finalizar Venda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(587, 446, 125, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo Cadastral: ");
		lblNewLabel_3.setBounds(488, 81, 139, 14);
		contentPane.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(655, 78, 57, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor:");
		lblNewLabel_4.setBounds(379, 177, 54, 14);
		contentPane.add(lblNewLabel_4);

		txtPrecoProd = new JTextField();
		txtPrecoProd.setEditable(false);
		txtPrecoProd.setBounds(464, 174, 86, 20);
		contentPane.add(txtPrecoProd);
		txtPrecoProd.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Quantidade:");
		lblNewLabel_5.setBounds(591, 223, 97, 14);
		contentPane.add(lblNewLabel_5);

		txtQuantidadeProd = new JTextField();
		txtQuantidadeProd.setBounds(698, 220, 54, 20);
		contentPane.add(txtQuantidadeProd);
		txtQuantidadeProd.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel(" Produtos da compra:");
		lblNewLabel_6.setBounds(425, 248, 161, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Valor Total:");
		lblNewLabel_7.setBounds(628, 404, 86, 14);
		contentPane.add(lblNewLabel_7);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(740, 401, 105, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		tbProdutosCarrinho = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 273, 500, 120);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(tbProdutosCarrinho);

		model = (DefaultTableModel) tbProdutosCarrinho.getModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preco");

		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtQuantidadeProd.getText().isEmpty()) {
					model = (DefaultTableModel) tbProdutosCarrinho.getModel();
					model.setRowCount(0);
					Integer qtdProdutos = Integer.valueOf(txtQuantidadeProd.getText());
					for (int i = 0; i < qtdProdutos; i++) {

						model.addRow(new Object[] { produto.getId(), produto.getNome(), produto.getPreco() });
					}
				}

			}
		});
		btnNewButton_2.setBounds(774, 219, 105, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Remover Produto");
		btnNewButton_3.setBounds(471, 400, 147, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Buscar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Produto prod : produtos) {
					if (prod.getId() == produto.getId()) {
						txtNomeProd.setText(prod.getNome());
						txtPrecoProd.setText(String.valueOf(prod.getPreco()));
					}
				}
			}
		});
		btnNewButton_4.setBounds(760, 75, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
