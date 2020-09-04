package by.epam.lobanok.lab02.client;

import java.io.*;
import java.net.*;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.bean.transfer.TransferObject;
import by.epam.lobanok.lab02.client.view.Printer;

public class ClientController {
	
	private final static int PORT = 2796;
	private final static String HOST = "127.0.0.1";

	private static Socket clientSocket; 
    private static BufferedReader keyboard;
    private static  ObjectInputStream in;
    private static  ObjectOutputStream out;
    
    private static Printer printer = Printer.getInstance();
    
	public static void main(String[] args) throws IOException {
		try {
			clientSocket = new Socket(HOST,PORT);
			System.out.println("Client socket created");

			out = new  ObjectOutputStream(clientSocket.getOutputStream());
			keyboard = new BufferedReader(new InputStreamReader(System.in));

	        System.out.println("Write file path: ");
	        String path;
			path = keyboard.readLine();
				 	
			out.writeUTF(path);
			out.flush();
			
			in = new  ObjectInputStream(clientSocket.getInputStream());	                
			
			Text text;
			text = (Text) in.readObject();
	        printer.printTextElement(text);
	        
	        printer.printCommandHelper();

	        String command;
	        command = keyboard.readLine();
	 
	        while(!command.equalsIgnoreCase("EXIT")) {
	        	sentRequest(text,command);
	        	getResponse();
	        	
			    printer.printCommandHelper();			   
			    command = keyboard.readLine();
	        }
		    System.out.println("Exit...");
			
		} catch (Exception x) {
			x.printStackTrace();
		}
		finally {
			clientSocket.close();
		}
	}
	
	private static void sentRequest(Text text, String command) throws IOException {
    	TransferObject request = new TransferObject();
        request.setText(text);
		request.setCommand(command);		
		out.writeObject(request);
		out.flush();
	}
	
	private static void getResponse() throws ClassNotFoundException, IOException {
		TextElement textElement = (TextElement)in.readObject();
	    printer.printTextElement(textElement);
	}
}