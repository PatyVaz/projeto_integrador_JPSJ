package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.EstoqueBD;
import modelo.Cliente;
import modelo.Estoque;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class HistoricoCompra extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Estoque> listaEstoque;
	private DefaultTableModel modelo;
	
	public HistoricoCompra() {
		setTitle("Histórico de Compras de Mercadorias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblHistricoDeCompras = new JLabel("HISTÓRICO DE COMPRA DE MERCADORIAS");
		lblHistricoDeCompras.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		GridBagConstraints gbc_lblHistricoDeCompras = new GridBagConstraints();
		gbc_lblHistricoDeCompras.insets = new Insets(0, 0, 5, 0);
		gbc_lblHistricoDeCompras.gridx = 0;
		gbc_lblHistricoDeCompras.gridy = 0;
		contentPane.add(lblHistricoDeCompras, gbc_lblHistricoDeCompras);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fornecedor", "Produto", "Quantidade", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
		EstoqueBD estoquebd = new EstoqueBD();
		listaEstoque = estoquebd.listarTodosEstoque();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Fornecedor", "Produto", "Quantidade", "Valor", "Data" }));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutosFornecedores pf = new ProdutosFornecedores(null);
				pf.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		modelo = (DefaultTableModel) table.getModel();
		for (int i = 0; i < listaEstoque.size(); i++) {
			Estoque e = listaEstoque.get(i);
			modelo.addRow(new Object[] { e.getId_estoque(), e.getFornecedor(), e.getProduto(), e.getQuantidade(), e.getValor(), e.getData() });
	}
	}
}
