package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import main.Main;
import modelo.RoundedPopopMenu;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class SelecionarSala2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarSala2 frame = new SelecionarSala2();
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
	public SelecionarSala2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarSala2.class.getResource("/Images/0609b1d7-4a7d-41be-bd18-081ecb35eb9e.png")));
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 612);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[91.00,grow][278px,grow][grow 50][278px,grow][11px,grow][80px]", "[20.00px,grow][31.00][24.00][35.00px][150px,grow][51.00,grow]"));
		
		JLabel lblSelecioneUmaSala = new JLabel("Selecione uma Sala");
		lblSelecioneUmaSala.setForeground(Color.WHITE);
		lblSelecioneUmaSala.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 46));
		contentPane.add(lblSelecioneUmaSala, "cell 0 1 5 1,alignx center,aligny bottom");
		
		JLabel lblSalaB = new JLabel("10:50 - Sala B1");
		lblSalaB.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaB.setForeground(Color.LIGHT_GRAY);
		lblSalaB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		contentPane.add(lblSalaB, "cell 1 3,growx,aligny center");
		
		JButton BtnSalaB1 = new JButton("");
		BtnSalaB1.setBackground(new Color(255, 255, 255));
		BtnSalaB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				dispose(); // fecha tela atual
				AssentosB1 b1  = new AssentosB1 ();

				b1.setExtendedState(JFrame.MAXIMIZED_BOTH);
				b1.setVisible(true);
			}
		});
		
		JLabel lblSalaB_2 = new JLabel("15:20 - Sala B2");
		lblSalaB_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaB_2.setForeground(Color.LIGHT_GRAY);
		lblSalaB_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		contentPane.add(lblSalaB_2, "cell 3 3,growx,aligny center");
		BtnSalaB1.setIcon(new ImageIcon(SelecionarSala2.class.getResource("/Images/Sala_resized.jpeg")));
		contentPane.add(BtnSalaB1, "cell 1 4,grow");
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha tela atual
				SelecionarFilme selctFilm = new SelecionarFilme();
				selctFilm.setVisible(true);
				selctFilm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton, "cell 0 0,alignx left,aligny top");
		
		JButton BtnSalaB2 = new JButton("");
		BtnSalaB2.setBackground(new Color(255, 255, 255));
		BtnSalaB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha tela atual
				AssentosB2 b2  = new AssentosB2 ();

				b2.setExtendedState(JFrame.MAXIMIZED_BOTH);
				b2.setVisible(true);
			
			}
		});
		BtnSalaB2.setIcon(new ImageIcon(SelecionarSala2.class.getResource("/Images/Sala_resized.jpeg")));
		contentPane.add(BtnSalaB2, "cell 3 4,grow");
		// Profiller
					JLabel imgLogin = new JLabel("");
					contentPane.add(imgLogin, "cell 5 0,alignx right,aligny top");
					
					ImageIcon imageIcon1 = new ImageIcon(SelecionarFilme.class.getResource("/Images/perfil.png"));
					imgLogin.setIcon(imageIcon1);
			
					// Ajusta o tamanho do JLabel para corresponder ao tamanho da imagem redimensionada
					Image img = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
					ImageIcon imageResized = new ImageIcon(img);
					imgLogin.setIcon(imageResized);
					imgLogin.setSize(80, 80);
			
					// Criação do JPopupMenu
					JPopupMenu popupMenu = new RoundedPopopMenu();
			
					// Obtém os dados do usuário (substitua os valores abaixo pelos dados reais
					String nomeUsuario = Main.getFuncionarioLogado().getNome();
					
					// CPF mascara
					StringBuilder cpfFormatado = new StringBuilder();
					String numeros = String.valueOf(Main.getFuncionarioLogado().getCpf());
					cpfFormatado.append(numeros.substring(0, 3));
					cpfFormatado.append(".");
					cpfFormatado.append(numeros.substring(3, 6));
					cpfFormatado.append(".");
					cpfFormatado.append(numeros.substring(6, 9));
					cpfFormatado.append("-");
					cpfFormatado.append(numeros.substring(9, 11));

					cpfFormatado.toString();
					String cpfUsuario = String.valueOf(cpfFormatado);
					double valorVendas = Main.getFuncionarioLogado().getVendasDouble();
			
					// Criação dos JLabels para exibir as informações
					JLabel labelNome = new JLabel("Nome: " + nomeUsuario);
					JLabel labelCPF = new JLabel("CPF: " + cpfUsuario);
					JLabel labelVendas = new JLabel("Valor total de vendas: R$" + valorVendas);
			
					// Configurações visuais
					Font labelFont = new Font("Yu Gothic UI Light", Font.BOLD, 20);
					
					Color labelColor = new Color(50, 50, 50);
					Color verde = new Color(0, 128, 0); // R:0, G:128, B:0
					Color roxo = new Color(128, 0, 128); // R:128, G:0, B:128
					Color azul = new Color(0, 0, 255); // R:0, G:0, B:255
			
					
					
					
					// Define o espaçamento interno (padding) desejado
					int padding = 10;
			
					// Cria um objeto EmptyBorder com o padding especificado
					Border emptyBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
			
					// Define o border do JPopupMenu com o EmptyBorder
					popupMenu.setBorder(emptyBorder);
					
					// Aplica as configurações visuais aos JLabels
					labelNome.setFont(labelFont);
					labelCPF.setFont(labelFont);
					labelVendas.setFont(labelFont);
					labelNome.setForeground(roxo);
					labelCPF.setForeground(azul);
					labelVendas.setForeground(verde);
					labelNome.setPreferredSize(new Dimension(300, 100));
					labelCPF.setPreferredSize(new Dimension(300, 100));
					labelVendas.setPreferredSize(new Dimension(300, 100));
			
					// Adiciona os JLabels ao JPopupMenu
					popupMenu.add(new JLabel("Olá funcionário!"));
					popupMenu.addSeparator();
					popupMenu.add(labelNome);
					popupMenu.add(labelCPF);
					popupMenu.add(labelVendas);
			
					// Configura a aparência dos itens do menu
					for (Component menuItem : popupMenu.getComponents()) {
					    if (menuItem instanceof JLabel) {
					        ((JLabel) menuItem).setFont(labelFont);
					        ((JLabel) menuItem).setForeground(labelColor);
					    }
					}
			
					// Define a cor de fundo do JPopupMenu
					popupMenu.setBackground(Color.WHITE);
			
					// Listener para exibir o menu ao clicar no ícone
					imgLogin.addMouseListener(new java.awt.event.MouseAdapter() {
					    public void mouseEntered(java.awt.event.MouseEvent evt) {
					        popupMenu.show(imgLogin, 0, imgLogin.getHeight());
					    }
			
					    public void mouseExited(java.awt.event.MouseEvent evt) {
					        popupMenu.setVisible(false);
					    }
					});
	}

}
