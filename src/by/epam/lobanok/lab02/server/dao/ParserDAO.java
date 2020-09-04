package by.epam.lobanok.lab02.server.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import by.epam.lobanok.lab02.server.dao.exception.DAOException;

public class ParserDAO {
	private static final ParserDAO instance = new ParserDAO();
	private final Properties property = new Properties();
	
	ParserDAO(){}
	
	public static ParserDAO getInstance() {
		return instance;
	}
	
	public String getRegex(String nameOfProperty) throws DAOException {
		FileInputStream fis;
		String regex = "";
		String path;
		path = ".\\resources\\properties.txt";

	    try {
	        fis = new FileInputStream(path);
	        property.load(fis);
	        regex = property.getProperty(nameOfProperty);
	    } catch (IOException e) {
	        throw new DAOException(e);
	    }
		return regex;		
	}
}
