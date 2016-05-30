public class ShoppingList {
	private int idshoppinglist;
	private int iduser;
	private String shoppinglistname;
	
	public ShoppingList(){};
	
	public ShoppingList(int iduser, String shoppinglistname) {
		this.iduser = iduser;
		this.shoppinglistname = shoppinglistname;
	}

	public int getIdshoppinglist() {
		return idshoppinglist;
	}

	public void setIdshoppinglist(int idshoppinglist) {
		this.idshoppinglist = idshoppinglist;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getShoppinglistname() {
		return shoppinglistname;
	}

	public void setShoppinglistname(String shoppinglistname) {
		this.shoppinglistname = shoppinglistname;
	}

	@Override
	public String toString() {
		return "ShoppingList [idshoppinglist=" + idshoppinglist + ", iduser=" + iduser + ", shoppinglistname="
				+ shoppinglistname + "]";
	}
}
