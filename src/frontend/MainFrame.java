package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.ClientMusixMatch;
import backend.Song;
import org.jmusixmatch.MusixMatchException;

public class MainFrame extends JFrame implements ActionListener {

	private JTextField txtAutore;
	private JTextField txtTitolo;
	private JTextField txtAlbum;

	private JLabel lblAutore;
	private JLabel lblTitolo;
	private JLabel lblAlbum;

	private JButton btnCerca;

	private Canzone canzone;

	public MainFrame() {
		super("Cerca canzoni");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		pack();
		setLocationRelativeTo(null); // Centra la finestra
	}

	public JTextField getTxtAutore() {
		return txtAutore;
	}

	public JTextField getTxtTitolo() {
		return txtTitolo;
	}

	public JTextField getTxtAlbum() {
		return txtAlbum;
	}

	private void initComponents() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		lblAutore = new JLabel("Autore");
		lblAutore.setFont(new Font("SansSerif Bold", Font.BOLD, 14));
		formPanel.add(lblAutore);

		txtAutore = new JTextField(20);
		formPanel.add(txtAutore);

		lblTitolo = new JLabel("Titolo");
		lblTitolo.setFont(new Font("", Font.BOLD, 14));
		formPanel.add(lblTitolo);

		txtTitolo = new JTextField(20);
		formPanel.add(txtTitolo);

		lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("SansSerif Bold", Font.BOLD, 14));
		formPanel.add(lblAlbum);

		txtAlbum = new JTextField(20);
		formPanel.add(txtAlbum);

		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(this);
		btnCerca.setPreferredSize(new Dimension(100, 30));
		btnCerca.setBackground(new Color(0, 123, 255));
		btnCerca.setForeground(Color.BLUE);
		btnCerca.setFocusPainted(false);
		formPanel.add(btnCerca);

		panel.add(formPanel, BorderLayout.CENTER);

		getContentPane().add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCerca)) {

			ClientMusixMatch clientMM = new ClientMusixMatch();
			Song song = null;
			try {
				song = clientMM.cercaCanzone(txtAutore.getText(), txtTitolo.getText(), txtAlbum.getText());
			} catch (MusixMatchException e1) {
				e1.printStackTrace();
			}

			canzone = new Canzone(song);
			canzone.setVisible(true);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				// Utilizzare il look and feel di sistema
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}

			MainFrame m = new MainFrame();
			m.setVisible(true);
		});
	}
}