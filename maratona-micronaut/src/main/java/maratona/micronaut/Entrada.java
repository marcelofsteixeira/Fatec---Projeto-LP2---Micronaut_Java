package maratona.micronaut;

public class Entrada {
	private String filename;
	private char problem;
	private String sourcode;
	public Entrada(String filename, char problem, String sourcode) {
		super();
		this.filename = filename;
		this.problem = problem;
		this.sourcode = sourcode;
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

}
