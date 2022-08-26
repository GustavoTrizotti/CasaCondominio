package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalCasaCond extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

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
		setResizable(false);
		setTitle("CondCasa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 435, 299);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Casa", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 229, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 91, 229, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 156, 229, 30);
		panel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero:");
		lblNewLabel.setBounds(10, 10, 186, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoProprietrio = new JLabel("Nome do Propriet\u00E1rio:");
		lblNomeDoProprietrio.setBounds(10, 68, 186, 13);
		panel.add(lblNomeDoProprietrio);
		
		JLabel lblNmeroDoCondomnio = new JLabel("N\u00FAmero do Condom\u00EDnio:");
		lblNmeroDoCondomnio.setBounds(10, 133, 186, 13);
		panel.add(lblNmeroDoCondomnio);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(10, 217, 118, 31);
		panel.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(138, 218, 101, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 9, 171, 253);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAmero", "N\u00FAmero Cond.", "Nome Prop."
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Condom\u00EDnio", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Associa\u00E7\u00E3o", null, panel_2, null);
	}
}
