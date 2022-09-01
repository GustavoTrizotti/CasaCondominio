package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.Casa;
import bean.Condominio;
import dao.CasaDAO;
import dao.CondominioDAO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PrincipalCasaCond extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumero;
	private JTextField textFieldNomeProp;
	private JTextField textFieldNomeCondominio;
	private JTextField textFieldResultCasa;
	private JTextField textFieldNome;
	private JTextField textFieldQtdCasas;
	private JTextField textFieldCidade;
	private JTextField textFieldResult;
	private JTable tableCondominio;
	private JTable tableCasa;
	
	public ArrayList<String> nomeCondominios = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCasaCond frame = new PrincipalCasaCond();
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
	public PrincipalCasaCond() {
		CondominioDAO condDAO = new CondominioDAO();
		
		for (int l = 0; l < condDAO.getLista().size(); l++) {
			nomeCondominios.add(condDAO.getLista().get(l).getNome());
		}
		
		setResizable(false);
		setTitle("CondCasa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 626, 310);
		contentPane.add(tabbedPane);
		
		JPanel panelCondominio = new JPanel();
		tabbedPane.addTab("Condom\u00EDnio", null, panelCondominio, null);
		panelCondominio.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 186, 13);
		panelCondominio.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(10, 29, 229, 30);
		panelCondominio.add(textFieldNome);
		
		JLabel lblQuantidadeDeCasas = new JLabel("Quantidade de Casas:");
		lblQuantidadeDeCasas.setBounds(10, 69, 186, 13);
		panelCondominio.add(lblQuantidadeDeCasas);
		
		textFieldQtdCasas = new JTextField();
		textFieldQtdCasas.setColumns(10);
		textFieldQtdCasas.setBounds(10, 92, 229, 30);
		panelCondominio.add(textFieldQtdCasas);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 134, 186, 13);
		panelCondominio.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(10, 157, 229, 30);
		panelCondominio.add(textFieldCidade);
		
		JButton btnAdicionarCond = new JButton("Adicionar");
		btnAdicionarCond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condominio cond = new Condominio();
				CondominioDAO condDAO = new CondominioDAO();
				
				textFieldResult.setText("");
				
				ArrayList<Condominio> listaCondominio = condDAO.getLista();
				boolean achou = false;
				
				
				if (textFieldNome.getText().equals("") || textFieldQtdCasas.getText().equals("") || textFieldCidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					
					String nome = textFieldNome.getText();
					int qtdCasas = Integer.parseInt(textFieldQtdCasas.getText());
					String cidade = textFieldCidade.getText();
					
					DefaultTableModel modelCondominio = (DefaultTableModel) tableCondominio.getModel();
					modelCondominio = (DefaultTableModel) tableCondominio.getModel();
					
					cond.setNome(nome);
					cond.setQtdCasas(qtdCasas);
					cond.setCidade(cidade);
					
					if (listaCondominio.size() == 0) {
						condDAO.Inserir(cond);
						textFieldResult.setText("Condomínio inserido com sucesso!");
					}
					
					if (listaCondominio.size() > 0) {
						for (int i = 0; i < listaCondominio.size(); i++) {
							if (listaCondominio.get(i).getNome().equals(nome)) {
								achou = true;
								break;
							} else {
								achou = false;
								break;
							}
						}
					}
					
					if (achou) {
						textFieldResult.setText("Erro!");
						JOptionPane.showMessageDialog(null, "Este condomínio já existe!");
					} else {
						condDAO.Inserir(cond);
						textFieldResult.setText("Inserido!");
						JOptionPane.showMessageDialog(null, "Condomínio cadastrado!");
						modelCondominio.addRow(new Object [] {nome, qtdCasas, cidade});
						nomeCondominios.add(nome);
						System.out.println(nomeCondominios);
					}
					
					textFieldNome.setText("");
					textFieldQtdCasas.setText("");
					textFieldCidade.setText("");
				}
			}
		});
		btnAdicionarCond.setBounds(10, 218, 118, 31);
		panelCondominio.add(btnAdicionarCond);
		
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(138, 219, 101, 30);
		panelCondominio.add(textFieldResult);
		
		JScrollPane scrollPaneCondominio = new JScrollPane();
		scrollPaneCondominio.setBounds(248, 10, 363, 252);
		panelCondominio.add(scrollPaneCondominio);
		
		tableCondominio = new JTable();
		scrollPaneCondominio.setViewportView(tableCondominio);
		tableCondominio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Qtd. Casas", "Cidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel panelCasa = new JPanel();
		tabbedPane.addTab("Casa", null, panelCasa, null);
		panelCasa.setLayout(null);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(10, 28, 229, 30);
		panelCasa.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldNomeProp = new JTextField();
		textFieldNomeProp.setColumns(10);
		textFieldNomeProp.setBounds(10, 91, 229, 30);
		panelCasa.add(textFieldNomeProp);
		
		textFieldNomeCondominio = new JTextField();
		textFieldNomeCondominio.setColumns(10);
		textFieldNomeCondominio.setBounds(10, 156, 229, 30);
		panelCasa.add(textFieldNomeCondominio);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero:");
		lblNewLabel.setBounds(10, 10, 186, 13);
		panelCasa.add(lblNewLabel);
		
		JLabel lblNomeDoProprietrio = new JLabel("Nome do Propriet\u00E1rio:");
		lblNomeDoProprietrio.setBounds(10, 68, 186, 13);
		panelCasa.add(lblNomeDoProprietrio);
		
		JLabel lblNmeroDoCondomnio = new JLabel("Nome do Condom\u00EDnio:");
		lblNmeroDoCondomnio.setBounds(10, 133, 186, 13);
		panelCasa.add(lblNmeroDoCondomnio);
		
		JButton btnAdicionarCasa = new JButton("Adicionar");
		btnAdicionarCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casa c = new Casa();
				Condominio cond = new Condominio();
				CasaDAO casaDAO = new CasaDAO();
				
				textFieldResultCasa.setText("");
				DefaultTableModel modelCasa = (DefaultTableModel) tableCasa.getModel();
				modelCasa = (DefaultTableModel) tableCasa.getModel();
				
				ArrayList<Casa> listaCasa = casaDAO.getLista();
				int contador = 0;
				boolean achou = false;
				boolean verificou = false;
				
				if (textFieldNumero.getText().equals("") || textFieldNomeProp.getText().equals("") || textFieldNomeCondominio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					
					int numero = Integer.parseInt(textFieldNumero.getText());
					String nomeProp = textFieldNomeProp.getText();
					String nomeCond = textFieldNomeCondominio.getText();
					
					c.setNumero(numero);
					c.setNomeProp(nomeProp);
					c.setNomeCond(nomeCond);
					
					if (listaCasa.size() == 0) {
						if (contador <= cond.getQtdCasas()) {
							casaDAO.Inserir(c);
							textFieldResultCasa.setText("Casa inserida com sucesso!");
							contador++;
						} else {
							textFieldResult.setText("Erro!");
							JOptionPane.showMessageDialog(null, "Limite de casas atingido no condomínio " + nomeCond + "!");
						}
					}
					
					if (listaCasa.size() > 0) {
						for (int i = 0; i < listaCasa.size(); i++) {
							if (listaCasa.get(i).getNumero() == numero) {
								achou = true;
								break;
							} else {
								achou = false;
							}
						}
						
						for (int k = 0; k < nomeCondominios.size(); k++) {
							if (nomeCondominios.get(k).equals(nomeCond)) {
								verificou = true;
								break;
							} else {
								verificou = false;
							}
						}
					}
					
					System.out.println(achou);
					System.out.println(verificou);
					
					if (achou) {
						textFieldResultCasa.setText("Erro!");
						JOptionPane.showMessageDialog(null, "Esta casa já existe!");
					} else {
						if (verificou) {
							if (contador <= cond.getQtdCasas()) {
								casaDAO.Inserir(c);
								textFieldResult.setText("Inserido!");
								JOptionPane.showMessageDialog(null, "Casa cadastrada!");
								modelCasa.addRow(new Object [] {numero, nomeProp, nomeCond});
								contador++;
							} else {
								textFieldResult.setText("Erro!");
								JOptionPane.showMessageDialog(null, "Limite de casas atingido no condomínio " + nomeCond + "!");
							}
							
						} else {
							textFieldResult.setText("Erro!");
							JOptionPane.showMessageDialog(null, "Condomínio inválido!");
						}
						
					}
					
					textFieldNumero.setText("");
					textFieldNomeProp.setText("");
					textFieldNomeCondominio.setText("");
				}
			}
		});
		btnAdicionarCasa.setBounds(10, 217, 118, 31);
		panelCasa.add(btnAdicionarCasa);
		
		textFieldResultCasa = new JTextField();
		textFieldResultCasa.setEditable(false);
		textFieldResultCasa.setBounds(138, 218, 101, 30);
		panelCasa.add(textFieldResultCasa);
		textFieldResultCasa.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 9, 363, 253);
		panelCasa.add(scrollPane);
		
		tableCasa = new JTable();
		scrollPane.setViewportView(tableCasa);
		tableCasa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAmero", "Nome Prop.", "Nome Cond."
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
}
