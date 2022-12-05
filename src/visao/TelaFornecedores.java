package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.KeyboardFocusManager;
import controle.FornecedorBD;
import modelo.Fornecedor;
import modelo.Perfil;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
public class TelaFornecedores extends JFrame {
	protected static final int posicaoPessoa = 0;
	private JPanel contentPane;
	private JTable tbfornecedor;
	private JTextField textField;
	private JFormattedTextField textField_1;
	private JFormattedTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel modelo;
	private ArrayList<Fornecedor> listaFornecedor;
	static Connection conexao;
	String id;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaFornecedores(Perfil VA) {
		setTitle("Fornecedores");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedores:");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 37, 180, 59);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(563, 0, 807, 599);
		contentPane.add(scrollPane);
		
		FornecedorBD fornecedorbd = new FornecedorBD();
		listaFornecedor = fornecedorbd.listarTodosFornecedor();
		tbfornecedor = new JTable();
		tbfornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Nome", "CNPJ", "Telefone", "E-mail"
			}
		));
		scrollPane.setViewportView(tbfornecedor);
		
		modelo = (DefaultTableModel) tbfornecedor.getModel();
		for (int i = 0; i < listaFornecedor.size(); i++) {
			Fornecedor f = listaFornecedor.get(i);
			modelo.addRow(new Object[] { f.getId(), f.getNome(), f.getCnpj(), f.getTelefone(), f.getEmail() });

		}
		tbfornecedor.setModel(modelo);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 110, 76, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 160, 76, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONE:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 210, 106, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-MAIL:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 260, 106, 25);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(132, 110, 232, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JFormattedTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 160, 232, 25);
		contentPane.add(textField_1);
		
		MaskFormatter maskDataCNPJ;
		try {
			maskDataCNPJ = new MaskFormatter("##.###.###/####-##");
			maskDataCNPJ.install(textField_1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_2 = new JFormattedTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 210, 232, 25);
		contentPane.add(textField_2);
		
		MaskFormatter maskDataFone;
		try {
			maskDataFone = new MaskFormatter("(##) #####-####");
			maskDataFone.install(textField_2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 260, 232, 25);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Cadastrar Fornecedor");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				String nome = textField.getText();
				String cnpj = textField_1.getText();
				String telefone = textField_2.getText();
				String email = textField_3.getText();
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(nome);
				fornecedor.setCnpj(cnpj);
				fornecedor.setEmail(email);
				fornecedor.setTelefone(telefone);
				

				
				FornecedorBD bdFornecedor = new FornecedorBD();
				bdFornecedor.inserirFornecedor(fornecedor);
				
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_1.setText("");
				
				while(tbfornecedor.getModel().getRowCount()>0){
					 ((DefaultTableModel) tbfornecedor.getModel()).removeRow(0);
				}
						 
					
				FornecedorBD fornecedorbd = new FornecedorBD();
				listaFornecedor = fornecedorbd.listarTodosFornecedor();
				tbfornecedor = new JTable();
				tbfornecedor.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "ID","NOME", "CNPJ", "TELEFONE", "E-MAIL" }));
				scrollPane.setViewportView(tbfornecedor);

				modelo = (DefaultTableModel) tbfornecedor.getModel();
				for (int i = 0; i < listaFornecedor.size(); i++) {
					Fornecedor f = listaFornecedor.get(i);
					modelo.addRow(new Object[] { f.getId(), f.getNome(), f.getCnpj(), f.getTelefone(), f.getEmail() });

				}
				tbfornecedor.setModel(modelo);
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}
		});
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
        .addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                if(event.getID() == KeyEvent.KEY_RELEASED 
		&& event.getKeyCode() == KeyEvent.VK_ENTER){
                	String nome = textField.getText();
    				String cnpj = textField_1.getText();
    				String telefone = textField_2.getText();
    				String email = textField_3.getText();
    				
    				Fornecedor fornecedor = new Fornecedor();
    				fornecedor.setNome(nome);
    				fornecedor.setCnpj(cnpj);
    				fornecedor.setEmail(email);
    				fornecedor.setTelefone(telefone);
    				

    				
    				FornecedorBD bdFornecedor = new FornecedorBD();
    				bdFornecedor.inserirFornecedor(fornecedor);
    				
    				textField.setText("");
    				textField_2.setText("");
    				textField_3.setText("");
    				textField_1.setText("");
    				
    				while(tbfornecedor.getModel().getRowCount()>0){
    					 ((DefaultTableModel) tbfornecedor.getModel()).removeRow(0);
    				}
    						 
    					
    				FornecedorBD fornecedorbd = new FornecedorBD();
    				listaFornecedor = fornecedorbd.listarTodosFornecedor();
    				tbfornecedor = new JTable();
    				tbfornecedor.setModel(new DefaultTableModel(new Object[][] {},
    						new String[] { "ID","NOME", "CNPJ", "TELEFONE", "E-MAIL" }));
    				scrollPane.setViewportView(tbfornecedor);

    				modelo = (DefaultTableModel) tbfornecedor.getModel();
    				for (int i = 0; i < listaFornecedor.size(); i++) {
    					Fornecedor f = listaFornecedor.get(i);
    					modelo.addRow(new Object[] { f.getId(), f.getNome(), f.getCnpj(), f.getTelefone(), f.getEmail() });

    				}
    				tbfornecedor.setModel(modelo);
    				return true;
                }
                return false;
            }
           
            });
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(18, 640, 172, 33);
		contentPane.add(btnNewButton);
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setForeground(new Color(255, 255, 255));
		btnAlterarDados.setBackground(new Color(0, 0, 0));
		btnAlterarDados.setEnabled(false);
		
		JButton btnExcluirFornecedor = new JButton("Excluir Fornecedor");
		btnExcluirFornecedor.setForeground(new Color(255, 255, 255));
		btnExcluirFornecedor.setBackground(new Color(0, 0, 0));
		btnExcluirFornecedor.setEnabled(false);
		btnExcluirFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = (tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 0).toString());
				int x = Integer.parseInt(a);

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(x);

				FornecedorBD fornecedorbd = new FornecedorBD();
				fornecedorbd.removeFornecedor(fornecedor);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				btnExcluirFornecedor.setEnabled(false);
				btnAlterarDados.setEnabled(false);
				 ((DefaultTableModel) tbfornecedor.getModel()).removeRow(tbfornecedor.getSelectedRow());
				 
				 btnExcluirFornecedor.setEnabled(false);
				 btnAlterarDados.setEnabled(false);
				 btnNewButton.setEnabled(true);
				 
				 JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");
			
			}
			
		});
		btnExcluirFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluirFornecedor.setBounds(392, 640, 147, 33);
		contentPane.add(btnExcluirFornecedor);
		
		
	    btnAlterarDados.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				String nome = textField.getText();
				String cnpj = textField_1.getText();
				String telefone = textField_2.getText();
				String email = textField_3.getText();
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(nome);
				fornecedor.setCnpj(cnpj);
				fornecedor.setEmail(email);
				fornecedor.setTelefone(telefone);
				fornecedor.setId(Integer.valueOf(id));

				
				FornecedorBD bdFornecedor = new FornecedorBD();
				bdFornecedor.alterarFornecedor(fornecedor);


				while (tbfornecedor.getModel().getRowCount() > 0) {
					((DefaultTableModel) tbfornecedor.getModel()).removeRow(0);
				
				}

				FornecedorBD fornecedorbd = new FornecedorBD();
				listaFornecedor = fornecedorbd.listarTodosFornecedor();
				tbfornecedor = new JTable();
				tbfornecedor.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "ID","NOME", "CNPJ", "TELEFONE", "E-MAIL" }));
				scrollPane.setViewportView(tbfornecedor);

				modelo = (DefaultTableModel) tbfornecedor.getModel();
				for (int i = 0; i < listaFornecedor.size(); i++) {
					Fornecedor f = listaFornecedor.get(i);
					modelo.addRow(new Object[] { f.getId(), f.getNome(), f.getCnpj(),  f.getTelefone(), f.getEmail() });

				}
				tbfornecedor.setModel(modelo);
				
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								btnExcluirFornecedor.setEnabled(false);
								btnAlterarDados.setEnabled(false);
								btnNewButton.setEnabled(true);
		      
					
								JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
				
			}
			
		});
		btnAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterarDados.setBounds(217, 640, 147, 33);
		contentPane.add(btnAlterarDados);
	
		
		
	
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio telainicio = new TelaInicio(VA);
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 3, 86, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbfornecedor.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					btnAlterarDados.setEnabled(true);
					btnExcluirFornecedor.setEnabled(true);
					btnNewButton.setEnabled(false);
					Fornecedor pessoaSelecionada = listaFornecedor.get(posicaoPessoa);
					id=(tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 0).toString());
					textField.setText(tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 1).toString());
					textField_1.setText(tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 2).toString());
					textField_2.setText(tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 3).toString());
					textField_3.setText(tbfornecedor.getValueAt(tbfornecedor.getSelectedRow(), 4).toString());
				}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
		});
		btnNewButton_2.setBounds(956, 610, 141, 33);
		contentPane.add(btnNewButton_2);
		
		
		
		ImageIcon imageIcon = new ImageIcon(TelaFornecedores.class.getResource("/img/logo.png"));
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(imageIcon);
		lblNewLabel_5.setBounds(1231, 599, 435, 139);
		contentPane.add(lblNewLabel_5);
            }
        }
		
	

