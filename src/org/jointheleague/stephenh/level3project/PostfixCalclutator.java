package org.jointheleague.stephenh.level3project;

import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class PostfixCalclutator {
	public static void main(String[] args) {
		new PostfixCalclutator().run();
	}

	private void run() {
		speak("Enter an expression in postfix form");
		String expression = JOptionPane.showInputDialog("Enter an expression");
		System.out.println(expression);
		if (!this.validate(expression)) {
			speak("This expression is not valid.");
			return;
		}
		Stack<Integer> postfixValues = new Stack<Integer>();
		for (String str : expression.split(" +")) {
			if (str.matches("\\d+")) {
				postfixValues.push(Integer.parseInt(str));
			} else if (str.equals("+")) {
				int num = postfixValues.pop();
				int num2 = postfixValues.pop();
				postfixValues.push(num + num2);
			} else if (str.equals("*")) {
				int num = postfixValues.pop();
				int num2 = postfixValues.pop();
				postfixValues.push(num * num2);
			}
		}
		int answer = postfixValues.pop();
		System.out.println("The answer is " + answer);
		speak("The answer is " + answer);
	}
	
	private boolean validate(String expression) {
		if (expression == null) return false;
		if (expression.isEmpty()) return false;
		for (char c : expression.toCharArray()) {
			if (Character.isDigit(c)) {
				continue;
			}
			if (c == '+') {
				continue;
			}
			if (c == '*') {
				continue;
			}
			if (c == ' ') {
				continue;
			}
			return false;
		}
		return true;
	}

	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
