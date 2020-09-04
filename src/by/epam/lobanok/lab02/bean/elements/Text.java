package by.epam.lobanok.lab02.bean.elements;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement {
	
	private static final long serialVersionUID = 1L;
	private List<TextElement> elements;
	
	public Text() {
		this.elements = new ArrayList<TextElement>();
	}
	
	public void add(TextElement elem) {
		this.elements.add(elem);
	}
	
	public List<TextElement> getElements() {
		return this.elements;
	}

	public void setElements(List<TextElement> elements) {
		this.elements = elements;
	}

	@Override
	public String getInfo() {
		String result;
		result = "";
		for(TextElement element : this.elements) {
			result += element.getInfo();
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
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
		Text other = (Text) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [elements=" + elements + "]";
	}	
}
