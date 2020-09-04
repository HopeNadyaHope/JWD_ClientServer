package by.epam.lobanok.lab02.server.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.lobanok.lab02.server.controller.command.impl.NoSuchCommand;
import by.epam.lobanok.lab02.server.controller.command.impl.OriginalWordCommand;
import by.epam.lobanok.lab02.server.controller.command.impl.ReplaceCommand;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		commands.put(CommandName.ORIGINAL_WORD, new OriginalWordCommand());
		commands.put(CommandName.REPLACE, new ReplaceCommand());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
	}
	
	public Command takeCommand(String command) {
		CommandName commandName;
		try {
			commandName = CommandName.valueOf(command.toUpperCase());
		}catch(Exception e) {
			commandName = CommandName.NO_SUCH_COMMAND;
		}
		Command currentCommand;
		currentCommand = commands.get(commandName);
		return currentCommand;		
	}
}
