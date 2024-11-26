package practice_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run2_Deserilization {

	public static void main(String[] args) throws Throwable {
		FileInputStream input= new FileInputStream("./f.txt");
		
		ObjectInputStream obj=new ObjectInputStream(input);
		NFSGame user1obj = (NFSGame) obj.readObject();
		
		System.out.println(user1obj.name);
		System.out.println(user1obj.level);
		System.out.println(user1obj.score);
		System.out.println(user1obj.life);

	}

}
