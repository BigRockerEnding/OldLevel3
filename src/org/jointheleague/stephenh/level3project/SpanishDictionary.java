package org.jointheleague.stephenh.level3project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SpanishDictionary extends JPanel implements Runnable, ActionListener {
	private String[] englishWords = new String[] {
			"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "hello", "yes", "blue", "more", "thanks"
	};
	private String[] spanishWords = new String[] {
			"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "hola", "sí", "azul", "más", "gracias"
	};
	private HashMap<String, String> spainDic = new HashMap<String, String>();
	JLabel spanishWord = new JLabel("Click a Button");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SpanishDictionary());
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("Spanish Dictionary");
		frame.setLayout(new BorderLayout());
		for (int i = 0; i < englishWords.length; i++) {
			JButton b = new JButton(englishWords[i]);
			b.addActionListener(this);
			this.add(b);
			spainDic.put(englishWords[i], spanishWords[i]);
		}
		frame.add(this, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.add(spanishWord);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String bText = b.getText();
		spanishWord.setText(spainDic.get(bText));
	}
}
