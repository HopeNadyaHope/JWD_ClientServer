package by.epam.lobanok.lab02.bean.transfer;

import java.io.Serializable;

import by.epam.lobanok.lab02.bean.elements.Text;

public class TransferObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Text text;
	private String command;
	
	public TransferObject() {}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferObject other = (TransferObject) obj;

		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransferObject [text=" + text + ", command=" + command + "]";
	}
}