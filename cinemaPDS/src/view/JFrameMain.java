package view;

import java.awt.EventQueue;
import main.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.FuncionarioDAO;
import modelo.Funcionario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JLabel imgLogin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// LAF Windows não encontrado, usar o LAF padrão do sistema
				}
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		 FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstancia();
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JFrameMain.class.getResource("/Images/0609b1d7-4a7d-41be-bd18-081ecb35eb9e.png")));
		setBackground(Color.WHITE);
		setTitle("Sistema de Cinema");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[133.00px,grow 50][60.00][][97.00px][][grow 34][134px,grow][60.00][115px,grow 50]", "[grow][66px,grow][68.00px][87.00px][87.00px][grow][36.00][grow][36.00][66px,grow]"));

		JLabel lblNewLabel = new JLabel("Abrir sistema");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 66));
		contentPane.add(lblNewLabel, "cell 1 1 7 2,growx,aligny center");
		
		imgLogin = new JLabel("");
		contentPane.add(imgLogin, "cell 1 3");
		// IMG 1
					JLabel imgLogin = new JLabel();
					imgLogin.setForeground(new Color(255, 255, 255));
					contentPane.add(imgLogin, "cell 1 3,width 60px!,alignx right,height 60px!,aligny center");
			
					ImageIcon imageIcon1 = new ImageIcon(JFrameMain.class.getResource("/Images/perfil.png"));
					imgLogin.setIcon(new ImageIcon(JFrameMain.class.getResource("/Images/perfil.png")));
			
					// Ajusta o tamanho do JLabel para corresponder ao tamanho da imagem redimensionada
					Image img = imageIcon1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					ImageIcon imageResized = new ImageIcon(img);
					imgLogin.setIcon(imageResized);
					imgLogin.setSize(60, 60);

				// IMG 2
					JLabel imgSenha = new JLabel("");
					contentPane.add(imgSenha, "cell 1 4,alignx right,aligny center");

					ImageIcon imageIcon2 = new ImageIcon(JFrameMain.class.getResource("/Images/chave.png"));
					imgSenha.setIcon(imageIcon2);

					// Ajusta o tamanho do JLabel para corresponder ao tamanho da imagem redimensionada
					Image img2 = imageIcon2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					ImageIcon imageResized2 = new ImageIcon(img2);
					imgSenha.setIcon(imageResized2);
					imgSenha.setSize(60, 60);

		
		

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1, "cell 3 3,growx,aligny center");
		
		txtUsuario = new JTextField();
		contentPane.add(txtUsuario, "cell 5 3 2 1,growx,aligny center");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cpf:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1_1, "cell 3 4,growx,aligny center");

		MaskFormatter cpfFormatter = null;
		try {
			cpfFormatter = new MaskFormatter("###.###.###-##");

			// cpfFormatter.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtSenha = new JFormattedTextField(cpfFormatter);

		txtSenha.setColumns(10);
		contentPane.add(txtSenha, "cell 5 4 2 1,growx,aligny center");
		
				JButton btnLimpar = new JButton("Área do funcionário");
				btnLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); // fecha tela atual
						FuncionarioArea frame = new FuncionarioArea();
						frame = new FuncionarioArea();
						frame.setVisible(true);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

					}
				});
				
						JButton btnLogin = new JButton("Login");
						btnLogin.setBackground(Color.WHITE);
						btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
						btnLogin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
 
								String user = txtUsuario.getText();
								String cpf = txtSenha.getText();
								cpf = cpf.replace(".", "");
								cpf = cpf.replace("-", "");
								cpf = cpf.trim();
								long cpf1 = Long.parseLong(cpf);

								Funcionario nFuncionario = new Funcionario(cpf1, user);

								if(funcionarioDAO.verificarLogin(nFuncionario)) {
									
									Main.setFuncionarioLogado(nFuncionario);
									SelecionarFilme sf = new SelecionarFilme();
									dispose(); // fecha tela atual
									sf.setVisible(true);
									sf.setExtendedState(JFrame.MAXIMIZED_BOTH);
								} else {
									
									JOptionPane.showMessageDialog(null, "Nome ou CPF incorretos ou não cadastrado!");
									txtUsuario.setText(null);
									txtSenha.setText(null);
								}
									
			

							}
						});
						contentPane.add(btnLogin, "cell 1 6 6 1,alignx center,growy");
				btnLimpar.setBackground(Color.WHITE);
				btnLimpar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
				contentPane.add(btnLimpar, "cell 1 8 6 1,alignx center,growy");
	}
}
