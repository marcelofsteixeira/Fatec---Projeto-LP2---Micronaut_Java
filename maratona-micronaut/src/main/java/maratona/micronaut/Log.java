package maratona.micronaut;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private String filename;
	private String problem;
	private String sourcecode;
	private String datetime;
	private String status;
	
	public Log(String filename, String problem, String sourcecode, String status) {
		super();
		this.filename = filename;
		this.problem = problem;
		this.sourcecode = sourcecode;
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-YY:HH:mm");
		this.datetime = df.format(new Date());
		this.status = status;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getSourcecode() {
		return sourcecode;
	}
	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
