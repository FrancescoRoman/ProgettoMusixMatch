package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import backend.Song;

public class Canzone extends JFrame implements ActionListener {

	private TestoCanzone testoCanzone;
	private Song song;

	private JLabel lblAutore;
	private JLabel lblTitolo;
	private JLabel lblAlbum;
	private JButton testo;
	private JButton backButton; // Aggiunto il nuovo bottone

	private String strAutore;
	private String strTitolo;
	private String strAlbum;

	public Canzone(Song song) {
		super("Canzone");
		this.song = song;
		setBounds(400, 280, 700, 150); // Ridimensiona la finestra

		this.strAutore = song.getArtistName();
		this.strTitolo = song.getTrackName();
		this.strAlbum = song.getAlbumName();

		initComponents();

		backButton = new JButton("Indietro"); // Crea il bottone
		backButton.addActionListener(this); // Aggiungi un'azione
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Posiziona il bottone a destra
		buttonPanel.add(backButton);
		add(buttonPanel, BorderLayout.SOUTH); // Aggiungi il bottone al pannello inferiore
	}

	private void initComponents() {
		setLayout(new BorderLayout()); // Usa il BorderLayout per il pannello principale

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		panel.setBackground(Color.BLACK);

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setBackground(Color.BLACK);

		ImageIcon iconLogo = new ImageIcon("Image/image.jpg");
		Image image = iconLogo.getImage();
		Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconLogoScaled = new ImageIcon(newImage);
		JLabel lblLogo = new JLabel(iconLogo);
		lblLogo.setIcon(iconLogoScaled);
		lblLogo.setBackground(Color.BLACK);
		p.add(lblLogo);
		panel.add(p);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 1));
		p1.setBackground(Color.BLACK);

		lblTitolo = new JLabel();
		lblTitolo.setText(strTitolo);
		lblTitolo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitolo.setForeground(Color.WHITE);

		lblAutore = new JLabel();
		lblAutore.setText(strAutore);
		lblAutore.setFont(new Font("Arial", Font.ITALIC, 10));
		lblAutore.setForeground(Color.WHITE);
		p1.add(lblTitolo);
		p1.add(lblAutore);
		panel.add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.BLACK);

		ImageIcon iconLogo1 = new ImageIcon("Image/img.png");
		Image image1 = iconLogo1.getImage();
		Image newImage1 = image1.getScaledInstance(264, 40, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconLogoScaled1 = new ImageIcon(newImage1);
		JLabel lblLogo1 = new JLabel();
		lblLogo1.setIcon(iconLogoScaled1);
		lblLogo1.setHorizontalAlignment(JLabel.CENTER);
		lblLogo1.setBackground(Color.BLACK);
		p2.add(lblLogo1);
		panel.add(p2);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setBackground(Color.BLACK);

		lblAlbum = new JLabel();
		lblAlbum.setText(strAlbum);
		lblAlbum.setFont(new Font("Arial", Font.BOLD, 14));
		lblAlbum.setVerticalAlignment(JLabel.CENTER);
		lblAlbum.setForeground(Color.WHITE);
		p3.add(lblAlbum);
		panel.add(p3);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.BLACK);

		testo = new JButton("lyrics");
		testo.addActionListener(this);
		testo.setBackground(Color.BLACK);
		testo.setForeground(Color.WHITE);
		testo.setFont(new Font("Arial", Font.BOLD, 14));
		p4.add(testo);
		panel.add(p4);

		add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(testo)) {
			testoCanzone = new TestoCanzone(song);
			testoCanzone.setVisible(true);
		} else if (e.getSource().equals(backButton)) { // Gestisci il click del bottone indietro
			dispose(); // Chiudi la finestra corrente
		}
	}


}
