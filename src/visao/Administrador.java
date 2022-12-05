package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Perfil;

public class Administrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Administrador(Perfil VA) {
		setTitle("Administrador");
		setBackground(new Color(0, 0, 255));
		setMaximumSize(new Dimension(450, 300));
		setMinimumSize(new Dimension(450, 300));
		setSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(32, 178, 170));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(10, 0, 62, 29);
		panel_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicio telainicio = new TelaInicio(VA);
				telainicio.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(32, 178, 170));
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(32, 178, 170));
		panel_1.add(panel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Cadastrar Usuários");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUsuario cadastroUsuario= new CadastroUsuario(VA);
				cadastroUsuario.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//ImageIcon imageIcon = new ImageIcon(TelaInicio.class.getResource("/img/logo.png"));
		//Image image = imageIcon.getImage(); 
		//Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		//imageIcon = new ImageIcon(newimg);
		
		//JLabel lblNewLabel_1 = new JLabel();
		//lblNewLabel_1.setIcon(imageIcon);
		//lblNewLabel_1.setBounds(1200, 520, 640, 203);
		///contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton_1 = new JButton("Excluir Usuário");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaUsuario tabelaUsuario= new TabelaUsuario(VA);
				tabelaUsuario.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton_1);
	}
}
