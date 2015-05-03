package org.jointheleague.stephenh.level3project;

//Copyright The League of Amazing Programmers, 2015

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

@SuppressWarnings("serial")
public class IPodShuffle extends JPanel implements Runnable, ActionListener {
	ArrayList<Song> songs = new ArrayList<Song>();
	JButton btnSurprise;
	JButton btnStop;
	
	public static void main(String[] args) throws IOException, JavaLayerException {
		Song aSong = new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=JuYeHPFR3f0&h=7a4c6a17d1895c021c434429859feaa0&r=1422754756900.1436681755&s=101948");
		aSong.play();
		new IPodShuffle().run();
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("iPod Shuffle");
		frame.add(this);
		loadSongs();
		btnSurprise = new JButton("Surprise Me!");
		btnSurprise.addActionListener(this);
		this.add(btnSurprise);
		btnStop = new JButton("Stop All");
		btnStop.addActionListener(this);
		this.add(btnStop);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 6. Congratulations on completing the sound check!
	 * 
	 * Now we want to make an iPod Shuffle that plays random music.
	 * 
	 * Create an ArrayList of Songs and a "Surprise Me!" button that will play a random song when it is clicked.
	 * 
	 * If you're really cool, you can stop all the songs, before playing a new one on subsequent button clicks.
	 */
	private void loadSongs() {
		songs.add(new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=JuYeHPFR3f0&h=7a4c6a17d1895c021c434429859feaa0&r=1422754756900.1436681755&s=101948"));
		songs.add(new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=sTSA_sWGM44&h=e08d5d904bc9132e3dd1a0e8cf510918&r=1422754933225.1455097378&s=159877"));
		songs.add(new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=wELMFhuQHXU&h=fb9de95bc878199eee3007837fbbd522&r=1422755320117.1502479959&s=175645"));
		songs.add(new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=Y3x8PjIuTxU&h=ed1f725c508ba2a00d7e4963c7ac3d0d&r=1422755582874.1515783810&s=3364"));
		songs.add(new Song("http://www.youtube-mp3.org/get?"
				+ "ab=128&video_id=aUHEH48xCpk&h=4f017a9915f0605625ef8a5c256111ef&r=1422755959635.1429931581&s=33875"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Song song2Stop : songs) {
			song2Stop.stop();
		}
		if (arg0.getSource() == btnSurprise) {
			Song aSong = songs.get(new Random().nextInt(songs.size()));
			aSong.play();
		}
	}
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}



