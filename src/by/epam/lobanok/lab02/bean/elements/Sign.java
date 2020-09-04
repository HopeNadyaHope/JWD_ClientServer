package by.epam.lobanok.lab02.bean.elements;

public class Sign extends SentenceElement{
	
	private static final long serialVersionUID = 1L;
	private String sign;
	
	public Sign(String sign) {
		this.sign = sign;
	}
	
	
	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}


	@Override
	public String getInfo() {
		return sign;
	}
	
	////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Sign other = (Sign) obj;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [sign=" + sign + "]";
	}	
}