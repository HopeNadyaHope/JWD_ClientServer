package by.epam.lobanok.lab02.bean.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextElement{
	
	private static final long serialVersionUID = 1L;
	private List<SentenceElement> elements;
	private String sign;

	public Sentence() {
		this.elements = new ArrayList<SentenceElement>();
	}
	
	public Sentence(List<SentenceElement> elements, String sign){
		this.elements = new ArrayList<SentenceElement>(elements);
		this.sign = sign;
	}

	public List<SentenceElement> getElements() {
		return elements;
	}

	public String getSign() {
		return sign;
	}


	public void setElements(List<SentenceElement> elements) {
		this.elements = elements;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void addSentenceElement(SentenceElement element) {
		this.elements.add(element);
	}
	
	@Override
	public String getInfo() {
		String result;
		result = "";
		for(SentenceElement element : this.elements) {
			result += element.getInfo();
		}
		result += this.sign; 
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
		result = prime * result + ((sign == null) ? 0 : sign.hashCode());
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
		Sentence other = (Sentence) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [elements=" + elements + ", sign=" + sign + "]";
	}
}