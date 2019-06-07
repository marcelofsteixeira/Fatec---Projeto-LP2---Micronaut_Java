package maratona.micronaut;

public class Saida {
	private String filename;
	private char problem;
	private String status;
	public Saida(String filename, char problem, String status) {
		super();
		this.filename = filename;
		this.problem = problem;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
