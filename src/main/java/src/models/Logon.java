package src.models;
/**
 * 
 * @author Andrecio Costa / Dante Alighieri
 *
 */
import src.models.Activity;

public class Logon extends Activity{
	public Logon (String aid, String d, String uid, String pc, String a) {
		super(aid, d, uid, pc, a);  
	}
	
	// Apenas para objeto que retorna diretamente do banco
	public Logon (int i, String aid, String d, String uid, String pc, String a) {
		super(aid, d, uid, pc, a);
	}
}
