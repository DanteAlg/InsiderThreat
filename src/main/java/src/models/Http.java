package src.models;

import src.models.Activity;

public class Http extends Activity {
	public Http (String aid, String d, String uid, String pc, String a) {
		super(aid, d, uid, pc, a);  
	}
	
	// Apenas para objeto que retorna diretamente do banco
	public Http (int i, String aid, String d, String uid, String pc, String a) {
		super(aid, d, uid, pc, a);
	}
}