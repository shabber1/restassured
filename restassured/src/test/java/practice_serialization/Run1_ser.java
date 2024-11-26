package practice_serialization;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class NFSGame implements Serializable{
	String name;
	int level,life;
	long score;
	public NFSGame(String name, int level, long score , int life) {
		super();
		this.name=name;     this.level=level;    
		this.life=life;		this.score=score;
	}
}
public class Run1_ser {
	public static void main(String[] args) throws Throwable {
		NFSGame user1obj=new NFSGame("shabber", 16, 60000, 1);
		FileOutputStream fis=new FileOutputStream("./f.txt");		
		ObjectOutputStream obj=new ObjectOutputStream(fis);
		obj.writeObject(user1obj);
		System.out.println("end");
	}
}
