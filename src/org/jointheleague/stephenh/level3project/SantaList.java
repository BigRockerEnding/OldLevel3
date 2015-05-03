package org.jointheleague.stephenh.level3project;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SantaList extends JPanel implements Runnable {
	List<String> imageUrls = new ArrayList<String>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SantaList());
	}
	
	@Override
	public void run() {
		JFrame frame = new JFrame("Santa List");
		frame.add(this);
		addUrls();
		String url = imageUrls.get(new Random().nextInt(imageUrls.size()));
		JLabel image = loadImageFromTheInternet(url);
		frame.add(image);
		this.setPreferredSize(new Dimension(750, 750));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addUrls() {
		imageUrls.add("https://lh4.ggpht.com/b4nj4quRTRjbi_1QRY8h0MhhuHVaYcdaSi3sKBOemPea3PedTXaquxzetKgoSM8qMG0=h900");
		imageUrls.add("http://infinityinquirer.com/wp-content/uploads/2014/07/15423671_201407180706.jpg");
		imageUrls.add("http://www.toysrus.com/graphics/tru_prod_images/Skylanders-Trap-Team-Triple-Pack---pTRU1-19357104dt.jpg");
	}
	
	private JLabel loadImageFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			return new JLabel(icon);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
		}

private JLabel loadImageFromJavaProject(String fileName) {
   	 URL imageURL = getClass().getResource(fileName);
   	 Icon icon = new ImageIcon(imageURL);
   	 return new JLabel(icon);
    }
}
