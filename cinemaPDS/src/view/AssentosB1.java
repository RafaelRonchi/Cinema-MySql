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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class AssentosB1 extends JFrame {

	private JPanel contentPane;
	private JButton[][] assentos;
	public static boolean cor;
	public static boolean[][] assentosOcupados = new boolean[5][6];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssentosB1 frame = new AssentosB1();
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
	public AssentosB1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AssentosA1.class.getResource("/Images/0609b1d7-4a7d-41be-bd18-081ecb35eb9e.png")));
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 500);
		

		contentPane = new JPanel();
	    contentPane.setBackground(new Color(0, 0, 64));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(new MigLayout("", "[47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow][47px,grow]", "[49px,grow][49px,grow][49px,grow][49px,grow][49px,grow][49px,grow][49px,grow][49px,grow][49px,grow]"));
		
		ImageIcon imageIcon1 = new ImageIcon(SelecionarFilme.class.getResource("/Images/perfil.png"));

		// Ajusta o tamanho do JLabel para corresponder ao tamanho da imagem redimensionada
		Image img = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon imageResized = new ImageIcon(img);

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
	    
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha tela atual
				SelecionarSala2 selctSala = new SelecionarSala2();
				selctSala.setExtendedState(JFrame.MAXIMIZED_BOTH);
				selctSala.setVisible(true);
			}
		});
		
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton, "cell 0 0,alignx left,aligny top");
		
	 // Profiller
		JLabel imgLogin = new JLabel("");
		contentPane.add(imgLogin, "cell 13 0,alignx right,aligny top");
		imgLogin.setIcon(imageIcon1);
		imgLogin.setIcon(imageResized);
		imgLogin.setSize(80, 80);
		
				// Listener para exibir o menu ao clicar no ícone
				imgLogin.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				        popupMenu.show(imgLogin, 0, imgLogin.getHeight());
				    }
		
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				        popupMenu.setVisible(false);
				    }
				});
		
		JLabel lblAssentosA = new JLabel("Assentos B1");
		lblAssentosA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssentosA.setForeground(Color.WHITE);
		lblAssentosA.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 47));
		contentPane.add(lblAssentosA, "cell 0 1 14 1,grow");
		
		// Crie a matriz de botões
				assentos = new JButton[5][6];

				for (int row = 0; row < 5; row++) {
					for (int col = 0; col < 6; col++) {
						final int finalRow = row;
						final int finalCol = col;

						JButton btn = new JButton("");
						btn.setIcon(new ImageIcon(AssentosA1.class.getResource("/Images/24868_redmensioned.jpeg")));
						btn.setBackground(assentosOcupados[row][col] ? Color.RED : Color.WHITE);
						assentos[row][col] = btn;
						contentPane.add(btn, "cell " + (4 + col) + " " + (3 + row) + ",grow");

						btn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								CadastroAssentosB1 selctSala = new CadastroAssentosB1(finalRow, finalCol);
								dispose();
								selctSala.setExtendedState(JFrame.MAXIMIZED_BOTH);
								selctSala.setVisible(true);

								selctSala.assento = finalRow;
								selctSala.assento1 = finalCol;
							}
						});
					}

				}
				;
	}
}
