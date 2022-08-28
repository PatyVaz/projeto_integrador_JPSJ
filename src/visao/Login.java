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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("scrollbar"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(83, 118, 67, 14);
		contentPane.add(lblSenha);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(85, 73, 82, 14);
		contentPane.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(245, 245, 220));
		textUsuario.setBounds(177, 70, 106, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(20);

		JButton btnEntar = new JButton("ENTRAR");
		btnEntar.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnEntar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textUsuario.getText();
				String senha = passwordField.getText();
				MD5 cifragem = new MD5();
				String senhacifrada = cifragem.getMd5(senha);

				if (usuario.equals("Admin") && senhacifrada.equals("202cb962ac59075b964b07152d234b70")) {

					TelaInicio a = new TelaInicio();
					a.setVisible(true);

					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "senha ou email invalida");
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
