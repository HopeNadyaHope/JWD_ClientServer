package by.epam.lobanok.lab02.client.view;

import java.util.Iterator;
import java.util.Set;

import by.epam.lobanok.lab02.bean.elements.TextElement;

public class Printer {
	private static final Printer instance = new Printer();	
	
	public Printer() {}
	
	public static Printer getInstance() {
		return instance;
	}	
	
	public void printTextElement(TextElement text) {
		System.out.print(text.getInfo());
		System.out.println();
	}
	
	public void print(Set<? extends TextElement> elements) {
		Iterator<? extends TextElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getInfo());
		}
	}
	
	public void printCommandHelper() {
		 System.out.println("Write command:\n" + 
     			"ORIGINAL_WORD - to find original word from first sentence\n" +
     			"REPLACE - to change the first and the last word in each sentence\n" + 
     			"EXIT - to exit");
	}
}
