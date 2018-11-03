package Echo.bank;

public enum CustomerType {
	COMMON,EXPRESS,VIP;
	
	public String toString()
	{
		switch(this)
		{
		case COMMON:
			return "普通";
		case EXPRESS:
			return "普通";
		case VIP:
			return "普通";
		}
		return null;
	}
}
