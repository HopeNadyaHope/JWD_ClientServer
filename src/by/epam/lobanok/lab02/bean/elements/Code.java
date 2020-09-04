package by.epam.lobanok.lab02.bean.elements;

public class Code implements TextElement{

	private static final long serialVersionUID = 1L;	
	private String code;
	
	public Code(String code){
		this.code = code;
	}
	
	@Override
	public String getInfo() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Code other = (Code) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Code [code=" + code + "]";
	}
}
