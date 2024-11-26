package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class project{
	private String projectName,status,createdBy;
	private int teamSize;
	private project() {}
	public project(String projectName,String createdBy,String status,int teamSize) {
		super();
		this.projectName=projectName;
		this.createdBy=createdBy;
		this.status=status;
		this.teamSize=teamSize;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
}
public class Run1_jacksonSerTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		project pobj=new project("sccl", "shabber", "Created", 0);
		ObjectMapper objm=new ObjectMapper();
		objm.writeValue(new File("./project.json"), pobj);
		System.out.println("end");
	}

}
