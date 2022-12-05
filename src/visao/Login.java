package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controle.UsuarioBD;
import modelo.Usuario;
import modelo.Perfil;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Login extends JFrame {

	
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		
		Perfil VA = new Perfil() ;
		setBackground(new Color(128, 128, 128));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 329);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				JButton btnEntar = new JButton("Entrar");
				btnEntar.setForeground(Color.WHITE);
				btnEntar.setBackground(Color.BLACK);
				btnEntar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String usuario = textUsuario.getText();
						String senha = passwordField.getText();
						
						try {
							
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "senha invalida");
							return;
						}
						
						
						Usuario u = new Usuario();
						u.setLogin(usuario);
						u.setSenha(senha);
						
						UsuarioBD loginbd = new UsuarioBD();
						Usuario usuarioLogado = loginbd.efetuarLogin(u);
						
						if(usuarioLogado != null ) {
							if(usuarioLogado.getLogin().equals(u.getLogin()) && usuarioLogado.getSenha().equals(u.getSenha())) {
								
								
								VA.setNome(usuario);
								
								TelaInicio telaInicio = new TelaInicio(VA);
								telaInicio.setVisible(true);
								setVisible(false);
							}
						}else {
							JOptionPane.showMessageDialog(null, "senha ou login invalido");
						}
						

					}

				});
				btnEntar.setBounds(177, 175, 106, 23);
				contentPane.add(btnEntar);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(85, 121, 67, 14);
		contentPane.add(lblSenha);

		JLabel lblUsuario = new JLabel("USUÁRIO:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(85, 73, 82, 14);
		contentPane.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBackground(Color.WHITE);
		textUsuario.setBounds(177, 70, 106, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(20);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 118, 106, 20);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblLogin.setBounds(199, 11, 112, 22);
		contentPane.add(lblLogin);
		
		ImageIcon imageIcon = new ImageIcon(Login.class.getResource("/img/logo.png"));
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(291, 175, 130, 115);
		contentPane.add(lblNewLabel);
		
		
	}
}
