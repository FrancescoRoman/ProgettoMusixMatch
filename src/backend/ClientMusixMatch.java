package backend;

import java.util.List;

import javax.swing.JOptionPane;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

public class ClientMusixMatch {

	public Song cercaCanzone(String artista, String titolo, String album) throws MusixMatchException{

		String apiKey = "091ddc29c79733a664dab8ba80ba44b9";
	    MusixMatch musixMatch = new MusixMatch(apiKey);

	    Song song = null;

	    if(!artista.equalsIgnoreCase("") && titolo.equalsIgnoreCase("")) {
	    	JOptionPane.showMessageDialog(null, "Immettere il titolo della canzone desiderata");
	    }

	    if(artista.equalsIgnoreCase("") && !titolo.equalsIgnoreCase("")) {
	    	JOptionPane.showMessageDialog(null, "Immettere l'artista della canzone desiderata");
	    }

	    if(!artista.equalsIgnoreCase("") && !titolo.equalsIgnoreCase("")) {

	        Track track = musixMatch.getMatchingTrack(titolo, artista);
	        TrackData data = track.getTrack();

	        System.out.println("AlbumID : " + data.getAlbumId());
	        System.out.println("Album Name : " + data.getAlbumName());
	        System.out.println("Artist ID : " + data.getArtistId());
	        System.out.println("Album Name : " + data.getArtistName());
	        System.out.println("Track ID : " + data.getTrackId());
	        System.out.println("Track name : " + data.getTrackName());

	        song = new Song(data.getAlbumId(), data.getAlbumName(), data.getArtistId(), data.getArtistName(), data.getTrackId(), data.getTrackName());

	        int trackID = data.getTrackId();

	        Lyrics lyrics = musixMatch.getLyrics(trackID);
	        song.setLyrics(lyrics);

	        System.out.println("Lyrics ID       : " + lyrics.getLyricsId());
	        System.out.println("Lyrics Language : " + lyrics.getLyricsLang());
	        System.out.println("Lyrics Body     : " + lyrics.getLyricsBody());
	        System.out.println("Script-Tracking-URL : " + lyrics.getScriptTrackingURL());
	        System.out.println("Pixel-Tracking-URL : " + lyrics.getPixelTrackingURL());
	        System.out.println("Lyrics Copyright : " + lyrics.getLyricsCopyright());

	        System.out.println("\n\n\n\n\n -------------------");

		}
		return song;
	}

}
