package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.RelatorioBD;
import modelo.Perfil;
import modelo.Venda;
import modelo.VendaCompleto;
import java.awt.Color;

public class TelaRelatorio extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public  JTextField txtVendedor;
	private JTable table;
	public JTextField txtCliente;
	private ArrayList<VendaCompleto> listaVenda;
	private ArrayList<VendaCompleto> listarVenda;
	private ArrayList<VendaCompleto> listarVendaCliente;
	private ArrayList<VendaCompleto> listarVendaClienteVendedor;
	private ArrayList<VendaCompleto> listarVendasData;
	
	

	/**
	 * Create the frame.
	 * 
;	 */
	Venda v = new Venda();
	VendaCompleto vc = new VendaCompleto();
 TelaRelatorio(Perfil VA) {
		setTitle("Relatório");
		
		TelaRelatorio TR = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton_4 = new JButton("<-");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio(VA);
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Procurar por:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 1;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtVendedor = new JTextField();
		txtVendedor.setEditable(false);
		txtVendedor.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtVendedor.setText("Vendedor\r\n");
		GridBagConstraints gbc_txtVendedor = new GridBagConstraints();
		gbc_txtVendedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVendedor.gridwidth = 6;
		gbc_txtVendedor.insets = new Insets(0, 0, 5, 5);
		gbc_txtVendedor.gridx = 5;
		gbc_txtVendedor.gridy = 1;
		contentPane.add(txtVendedor, gbc_txtVendedor);
		txtVendedor.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaRelatorioUsuario TVU = new TabelaRelatorioUsuario(TR);
				TVU.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 11;
		gbc_btnNewButton_2.gridy = 1;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ano:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 15;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 16;
		gbc_comboBox_2.gridy = 1;
		contentPane.add(comboBox_2, gbc_comboBox_2);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Data");
		rdbtnNewRadioButton_2.setBackground(new Color(32, 178, 170));
		buttonGroup.add(rdbtnNewRadioButton_2);
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_2.gridwidth = 2;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 2;
		gbc_rdbtnNewRadioButton_2.gridy = 2;
		contentPane.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("cliente");
		rdbtnNewRadioButton_4.setBackground(new Color(32, 178, 170));
		buttonGroup.add(rdbtnNewRadioButton_4);
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 4;
		gbc_rdbtnNewRadioButton_4.gridy = 2;
		contentPane.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setText("Cliente");
		txtCliente.setFont(new Font("Tahoma", Font.ITALIC, 13));
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.gridwidth = 6;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.gridx = 5;
		gbc_txtCliente.gridy = 2;
		contentPane.add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaRelatorioCliente TVC = new TabelaRelatorioCliente(TR);
				TVC.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 11;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mes:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 15;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 16;
		gbc_comboBox_1.gridy = 2;
		contentPane.add(comboBox_1, gbc_comboBox_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Vendedor");
		rdbtnNewRadioButton_3.setBackground(new Color(32, 178, 170));
		buttonGroup.add(rdbtnNewRadioButton_3);
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 2;
		gbc_rdbtnNewRadioButton_3.gridy = 3;
		contentPane.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Vendedor e Cliente");
		rdbtnNewRadioButton_5.setBackground(new Color(32, 178, 170));
		buttonGroup.add(rdbtnNewRadioButton_5);
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 4;
		gbc_rdbtnNewRadioButton_5.gridy = 3;
		contentPane.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("Dia:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 15;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 16;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		
		
		JButton btnNewButton_3 = new JButton("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();
				txtCliente.setText("Cliente");
				txtVendedor.setText("Vendedor");
				while(table.getModel().getRowCount()>0){
					 ((DefaultTableModel) table.getModel()).removeRow(0);
				}
						 
		
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tudo");
		rdbtnNewRadioButton.setBackground(new Color(32, 178, 170));
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 4;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 15;
		gbc_btnNewButton_3.gridy = 6;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 16;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Usuario", "Produto", "Preço", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
	
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 9;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				
				
				
				
				
				
				
				
				
				
				
				
				
				


				
				
				
				
				if(rdbtnNewRadioButton_2.isSelected() == true ) {
					
					if(rdbtnNewRadioButton_2.isSelected() == true ) {
						String dia = (String) comboBox.getSelectedItem();
						String mes = (String) comboBox_1.getSelectedItem();
						String ano = (String) comboBox_2.getSelectedItem();
						String data = ano+"/"+mes+"/"+dia;
						System.out.println(dia);
						System.out.println(mes);
						System.out.println(ano);
						System.out.println(data);
				
						RelatorioBD relatorioBD = new RelatorioBD();
						
						vc.setData(data);
						listarVendasData = relatorioBD.listarVendasData(vc);
						
						table = new JTable();
						table.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Cliente", "Usuario", "Produto", "Preço", "Data"}));
						scrollPane.setViewportView(table);

						modelo = (DefaultTableModel) table.getModel();
						for (int i = 0; i < listarVendasData.size(); i++) {
							VendaCompleto vc = listarVendasData.get(i);
						modelo.addRow(new Object[] {vc.getCadastro(), vc.getUsuario(), vc.getProduto(), vc.getValor(), vc.getData() });
						
						}
						
						
						
						mensagem += "Data";
					}
				}
				
				
				
				
				if(rdbtnNewRadioButton_3.isSelected() == true ) {
					try {
					String id = txtVendedor.getText();
					RelatorioBD relatorioBD = new RelatorioBD();
				
					vc.setId_usuario(Integer.valueOf(id));
					listarVenda = relatorioBD.listarVendaID(vc);
					
					table = new JTable();
					table.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "Cliente", "Usuario", "Produto", "Preço", "Data"}));
					scrollPane.setViewportView(table);

					modelo = (DefaultTableModel) table.getModel();
					for (int i = 0; i < listarVenda.size(); i++) {
						VendaCompleto vc = listarVenda.get(i);
					modelo.addRow(new Object[] {vc.getCadastro(), vc.getUsuario(), vc.getProduto(), vc.getValor(), vc.getData() });
					
					}
					
					mensagem += "vendedor";
					}catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "selecione um usuario");
						return;
					}
					
				}
				
		
				
				if(rdbtnNewRadioButton_4.isSelected() == true  ) {
					try {
					String id = txtCliente.getText();
					RelatorioBD relatorioBD = new RelatorioBD();
				
					vc.setId_cliente(Integer.valueOf(id));
					listarVendaCliente = relatorioBD.listarVendaCliente(vc);
					
					table = new JTable();
					table.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "Cliente", "Usuario", "Produto", "Preço", "Data"}));
					scrollPane.setViewportView(table);

					modelo = (DefaultTableModel) table.getModel();
					for (int i = 0; i < listarVendaCliente.size(); i++) {
						VendaCompleto vc = listarVendaCliente.get(i);
					modelo.addRow(new Object[] {vc.getCadastro(), vc.getUsuario(), vc.getProduto(), vc.getValor(), vc.getData() });
					
					}
					mensagem += "cliente ";
					}catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "selecione um Cliente");
						return;
					}
				}
				
				
				
				
				if(rdbtnNewRadioButton_5.isSelected() == true) {
					try{
					String id = txtCliente.getText();
					String id1 = txtVendedor.getText();
					RelatorioBD relatorioBD = new RelatorioBD();
				
					vc.setId_cliente(Integer.valueOf(id));
					vc.setId_usuario(Integer.valueOf(id1));
					listarVendaClienteVendedor = relatorioBD.listarVendaClienteVendedor(vc);
					
					table = new JTable();
					table.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "Cliente", "Usuario", "Produto", "Preço", "Data"}));
					scrollPane.setViewportView(table);

					modelo = (DefaultTableModel) table.getModel();
					for (int i = 0; i < listarVendaClienteVendedor.size(); i++) {
						VendaCompleto vc = listarVendaClienteVendedor.get(i);
					modelo.addRow(new Object[] {vc.getCadastro(), vc.getUsuario(), vc.getProduto(), vc.getValor(), vc.getData() });
					
					}
					
					mensagem += "vendedor e cliente ";
					}catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "selecione um Cliente e um vendedor");
						return;
					}
				}
				
				
				
				if(rdbtnNewRadioButton.isSelected() == true) {
					try{
					
					RelatorioBD relatorioBD = new RelatorioBD();
				
					
					listaVenda = relatorioBD.listarTodasVendas(vc);
					
					table = new JTable();
					table.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "Cliente", "Usuario", "Produto", "Preço", "Data"}));
					scrollPane.setViewportView(table);

					modelo = (DefaultTableModel) table.getModel();
					for (int i = 0; i < listaVenda.size(); i++) {
						VendaCompleto vc = listaVenda.get(i);
					modelo.addRow(new Object[] {vc.getCadastro(), vc.getUsuario(), vc.getProduto(), vc.getValor(), vc.getData() });
					
					}
					
					mensagem += "Todas as vendas ";
					}catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "selecione um Cliente e um vendedor");
						return;
					}
				}
			
			
				lblNewLabel_1.setText(mensagem);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	
}
