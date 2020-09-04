package by.epam.lobanok.lab02.server.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.server.dao.TextDAO;
import by.epam.lobanok.lab02.server.dao.exception.DAOException;
import by.epam.lobanok.lab02.server.dao.parser.ParserFactory;
import by.epam.lobanok.lab02.server.dao.parser.TextElementParser;

public class TextDAOImpl implements TextDAO {
	
	public Text createText(String path) throws DAOException {
		//String path;		
		//path = "resources\\text.txt";

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(path));	
		}catch (FileNotFoundException e){
			throw new DAOException(e);
		}
		
		String line;		
		StringBuffer allText;
		allText = new StringBuffer("");
		
		try {
			while((line = reader.readLine()) != null) {
				allText.append(line).append("\n");
			}
		}catch( IOException e) {
			throw new DAOException(e);
		}finally {
			if(reader != null) {
				try {
					reader.close();
				}catch (IOException e) {
					//log-err
					System.err.println(e);
				}
			}		
		}
		ParserFactory parserFactory = ParserFactory.getInstance();
		TextElementParser textElementParser = parserFactory.getTextElementParser();
		Text text; 
		text = textElementParser.getText(allText.toString());
		
		return text;
	}
}