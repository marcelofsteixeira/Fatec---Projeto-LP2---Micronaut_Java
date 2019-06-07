package maratona.micronaut;

import java.util.Date;

public class Log {
	private String filename;
	private char problem;
	private String sourcode;
	private Date datetime;
	private String status;
	
	public Log(String filename, char problem, String sourcode, Date datetime, String status) {
		super();
		this.filename = filename;
		this.problem = problem;
		this.sourcode = sourcode;
		this.datetime = datetime;
		this.status = status;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public char getProblem() {
		return problem;
	}
	public void setProblem(char problem) {
		this.problem = problem;
	}
	public String getSourcode() {
		return sourcode;
	}
	public void setSourcode(String sourcode) {
		this.sourcode = sourcode;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
