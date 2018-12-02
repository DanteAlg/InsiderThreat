package src.models;

public class Activity {
	protected int id;
	protected String activityId;
	protected String date;
	protected String userId;
	protected String pcId;
	protected String action;
	
	public Activity (String aid, String d, String uid, String pc, String a) {
		activityId = aid; date = d; userId = uid; pcId = pc; action = a;  
	}
	
	// Apenas para atividades que retorna diretamente do banco
	public Activity (int i, String aid, String d, String uid, String pc, String a) {
		id = i; activityId = aid; date = d; userId = uid; pcId = pc; action = a;
	}
}
