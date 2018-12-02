package src.models;

public class User {
	// Attributes
	
	private int id;
	private String name;
	private String email;
	private String userId;
	private String role;
	
	public User (String i, String n, String e, String r) {
		userId = i; name = n; email = e; role = r;
	}
	
	// Apenas para usuário que retorna diretamente do banco
	public User (int i, String n, String e, String ui, String r) {
		id = i; name = n; email = e; userId = ui; role = r;
	}
	
	public int	 getId() {
		return this.id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getUserIdSearch() {
		return "DTAA/" + this.userId;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
	}
}
