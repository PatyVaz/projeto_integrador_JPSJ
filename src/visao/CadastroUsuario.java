package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.UsuarioBD;
import modelo.Perfil;
import modelo.Usuario;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static Connection conexao;

	
	/**
	 * Create the frame.
	 */
	public CadastroUsuario(Perfil VA) {
		setForeground(new Color(32, 178, 170));
		setBackground(new Color(32, 178, 170));
		setTitle("Cadastro de Usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1329, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrador administrador = new Administrador(VA);
				administrador.setVisible(true);;
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 64, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(463, 144, 84, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(463, 207, 84, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(463, 268, 84, 31);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(567, 148, 274, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(567, 212, 274, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(567, 272, 274, 31);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String nome= textField.getText();
			String login = textField_1.getText();
			String senha = textField_2.getText();
			
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			
			UsuarioBD usuariobd = new UsuarioBD();
			usuariobd.inserirUsuario(usuario);
			

			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(608, 626, 175, 41);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(32, 178, 170));
		panel_4.setBounds(441, 54, 434, 29);
		contentPane.add(panel_4);
		
		JLabel lblCadastroDeUsurio = new JLabel("CADASTRO DE USUÁRIOS");
		lblCadastroDeUsurio.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		panel_4.add(lblCadastroDeUsurio);
	}
}