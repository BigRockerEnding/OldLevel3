package org.jointheleague.stephenh.level3project;

import java.util.Stack;

import javax.swing.JOptionPane;

public class NameReverser {
	public static void main(String[] args) {
		new NameReverser().run();
	}

	private void run() {
		speak("What is your name?");
		String name = JOptionPane.showInputDialog(null, "Enter your name", "Name", JOptionPane.QUESTION_MESSAGE);
		System.out.println("Your name is " + name);
		speak("Right. Your name is " + name);
		Stack<Character> nameReverseStack = new Stack<Character>();
		for (Character c : name.toCharArray()) {
			nameReverseStack.push(c);
		}
		String reversedName = "";
		while (!nameReverseStack.empty()) {
			reversedName += nameReverseStack.pop();
		}
		System.out.println("Your name backwards is " + reversedName);
		speak("Your name backwards is " + reversedName);
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
