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
import java.awt.Font;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(83, 118, 67, 14);
		contentPane.add(lblSenha);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(85, 73, 82, 14);
		contentPane.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBackground(Color.WHITE);
		textUsuario.setBounds(177, 70, 106, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(20);

		JButton btnEntar = new JButton("Entrar");
		btnEntar.setBackground(UIManager.getColor("Tree.selectionBackground"));
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
						TelaInicio telaInicio = new TelaInicio();
						telaInicio.setVisible(true);
						setVisible(false);
					}
				}else {
					JOptionPane.showMessageDialog(null, "senha ou login invalido");
				}
				

			}

		});
		btnEntar.setBounds(177, 208, 89, 23);
		contentPane.add(btnEntar);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 118, 106, 20);
		contentPane.add(passwordField);
	}
}
