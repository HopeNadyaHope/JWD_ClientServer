package by.epam.lobanok.lab02.server.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.bean.transfer.TransferObject;
import by.epam.lobanok.lab02.server.controller.command.Command;
import by.epam.lobanok.lab02.server.controller.command.CommandProvider;
import by.epam.lobanok.lab02.server.service.ServiceFactory;
import by.epam.lobanok.lab02.server.service.TextCreatorService;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;


public class ServerController {
	private static int PORT = 2796;
	
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	
	
	public static void main(String[] arg){		
		try {
			connection();
			String path = in.readUTF();
			createText(path);
           
			CommandProvider commandProvider = new CommandProvider();
			
			TransferObject request;
			TextElement response;
			String command;
			Command currentCommand;
			
            while(true) {
            	try{
            		request = (TransferObject) in.readObject();
            		command = request.getCommand().toUpperCase();
            		currentCommand = commandProvider.takeCommand(command);
            		response = currentCommand.execute((request.getText()));    			

            		out.writeObject(response);
            		out.flush();
            	}catch(Exception e) {
            		break;
            	}
            }
		}catch(Exception x) { 
			x.printStackTrace(); 
		}finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				}catch (IOException e) {
					//log-err
					System.err.println(e);
				}
			}	
		}
	}

	
	private static void createText(String path) throws ServiceException, IOException {
		ServiceFactory factory = ServiceFactory.getInstance();			
		TextCreatorService textCreatorService = factory.getTextCreatorService();
		
		Text text;
		text = textCreatorService.create(path);
		System.out.println("Text created");	
		out.writeObject(text);
        out.flush();		
	}
	
	
	private static void connection() throws IOException {
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server started");

		clientSocket = serverSocket.accept();
		System.out.println("Got a client");
		System.out.println();

		in = new ObjectInputStream(clientSocket.getInputStream());
		out = new ObjectOutputStream(clientSocket.getOutputStream());
	}
}