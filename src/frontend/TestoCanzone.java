package frontend;


import java.awt.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backend.Song;

public class TestoCanzone extends JFrame{

	private JLabel lblTesto;
	
	private Song song;
	
	public TestoCanzone(Song song) {
		super("Lyrics");
		this.song = song;
		setBounds(500, 100, 500, 600);
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		String testo = song.getLyrics().getLyricsBody();
		lblTesto = new JLabel("<html>" + testo + "</html>");
		lblTesto.setHorizontalAlignment(SwingConstants.LEFT);
		lblTesto.setPreferredSize(new java.awt.Dimension(450, 600));
		lblTesto.setFont(new Font("Arial", Font.BOLD, 18));
		lblTesto.setForeground(Color.WHITE);
		p.setBackground(coloreCasuale());
		p.add(lblTesto, BorderLayout.CENTER);
		add(p, BorderLayout.CENTER);
	}
	
	public static Color coloreCasuale() {
		Random rand = new Random();
		int color = rand.nextInt();
		return new Color(color);
	}
	
}
