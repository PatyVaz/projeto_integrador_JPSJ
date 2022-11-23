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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
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

		modelo = (DefaultTableModel) table.getModel();
		for (int i = 0; i < listaEstoque.size(); i++) {
			Estoque e = listaEstoque.get(i);
			modelo.addRow(new Object[] { e.getId_estoque(), e.getFornecedor(), e.getProduto(), e.getQuantidade(), e.getValor(), e.getData() });
	}
	}
}
