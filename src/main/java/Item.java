public class Item {
	private int iditem;
	private int idshoppinglist;
	private String name;
	private String brand;
	private String additionalinfo;
	private String unit;
	private String quantity;
	private boolean strikethrough;
	
	public Item(){};
	
	public int getIditem() {
		return iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public int getIdshoppinglist() {
		return idshoppinglist;
	}

	public void setIdshoppinglist(int idshoppinglist) {
		this.idshoppinglist = idshoppinglist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getAdditionalinfo() {
		return additionalinfo;
	}

	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public boolean isStrikethrough() {
		return strikethrough;
	}

	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}

	@Override
	public String toString() {
		return "Item [iditem=" + iditem + ", idshoppinglist=" + idshoppinglist + ", name=" + name + ", brand=" + brand
				+ ", additionalinfo=" + additionalinfo + ", unit=" + unit + ", quantity=" + quantity
				+ ", strikethrough=" + strikethrough + "]";
	}
	
}
