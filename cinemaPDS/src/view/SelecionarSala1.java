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

import control.SalaDAO;
import main.Main;
import modelo.RoundedPopopMenu;
import modelo.Sala;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.security.interfaces.DSAKey;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class SelecionarSala1 extends JFrame {

	private JPanel contentPane;
	private SalaDAO salaDAO = SalaDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarSala1 frame = new SelecionarSala1();
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
	public SelecionarSala1() {
		ArrayList<Sala> salasLista = salaDAO.verSala();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarSala1.class.getResource("/Images/0609b1d7-4a7d-41be-bd18-081ecb35eb9e.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1107, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[91.00,grow][278px,grow][grow 50][278px,grow][11px,grow][80px]", "[20.00px,grow][10.00][31.00][24.00][][150px,grow][51.00,grow]"));
		
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
		
		JLabel lblSelecioneUmaSala = new JLabel("Selecione uma Sala");
		lblSelecioneUmaSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUmaSala.setForeground(Color.WHITE);
		lblSelecioneUmaSala.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 46));
		contentPane.add(lblSelecioneUmaSala, "cell 0 2 6 1,growx,aligny center");
		
		JButton BtnSalaA1 = new JButton("");
		BtnSalaA1.setBackground(new Color(255, 255, 255));
		BtnSalaA1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				dispose(); // fecha tela atual
				AssentosA1 a1  = new AssentosA1 ();

				a1.setExtendedState(JFrame.MAXIMIZED_BOTH);
				a1.setVisible(true);
			}
		});
		
		JLabel lblNewLabel1 = new JLabel(salasLista.get(0).getTime() +" "+ salasLista.get(0).getNome());
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		contentPane.add(lblNewLabel1, "cell 1 4,growx,aligny center");
		
		//2
		JLabel lblNewLabel = new JLabel(salasLista.get(1).getTime() +" "+ salasLista.get(1).getNome());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		contentPane.add(lblNewLabel, "cell 3 4,alignx center,aligny center");
		
		BtnSalaA1.setIcon(new ImageIcon(SelecionarSala1.class.getResource("/Images/Sala_resized.jpeg")));
		contentPane.add(BtnSalaA1, "cell 1 5,grow");
		
		JButton BtnSalaA2 = new JButton("");
		BtnSalaA2.setBackground(new Color(255, 255, 255));
		BtnSalaA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
						dispose(); // fecha tela atual
						AssentosA2 a2  = new AssentosA2 ();

						a2.setExtendedState(JFrame.MAXIMIZED_BOTH);
						a2.setVisible(true);
			}
		});
		BtnSalaA2.setIcon(new ImageIcon(SelecionarSala1.class.getResource("/Images/Sala_resized.jpeg")));
		contentPane.add(BtnSalaA2, "cell 3 5,grow");
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
