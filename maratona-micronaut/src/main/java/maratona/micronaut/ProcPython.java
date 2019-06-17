package maratona.micronaut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Vector;

public class ProcPython {
	private Entrada entrada;

	public ProcPython(Entrada entrada) {
		this.entrada = entrada;
	}
	
	public String ProcA(String pyPath, String folderPath) throws IOException, InterruptedException {
		String result;
		runPy(pyPath, folderPath, "SA1.txt", "A1.txt");
		runPy(pyPath, folderPath, "SA2.txt", "A2.txt");
		runPy(pyPath, folderPath, "SA3.txt", "A3.txt");
		if (verifResult(folderPath, "SA1.txt", "A1.txt")
			&&verifResult(folderPath, "SA2.txt", "A2.txt")
			&&verifResult(folderPath, "SA3.txt", "A3.txt")) 
			result = "SUCCESS";
		else result = "FAIL"; 
		return result;		
	};
	
	public String ProcB(String pyPath, String folderPath) throws IOException, InterruptedException {
		String result;
		runPy(pyPath, folderPath, "SB1.txt", "B1.txt");
		runPy(pyPath, folderPath, "SB2.txt", "B2.txt");
		if (verifResult(folderPath, "SB1.txt", "B1.txt")
			&&verifResult(folderPath, "SB2.txt", "B2.txt")) 
			result = "SUCCESS";
		else result = "FAIL"; 
		return result;		
	};
	
	
	public void runPy(String pyPath, String folderPath, String arqSaida, String inputFile) throws IOException, InterruptedException {
		String input = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+File.separator+"InputsPython"+File.separator+inputFile)), StandardCharsets.UTF_8);
		Pyexe pyexe=new Pyexe(pyPath+" >"+folderPath+File.separator+arqSaida);
		pyexe.Pyrun(input);
	}
	
	public boolean verifResult(String folderPath, String criado, String esperado) throws IOException {
		Vector<String> resultCriado = new Vector <String>();
		Vector<String> resultEsperado = new Vector<String>();
		try {
			BufferedReader leitorCriado = new BufferedReader(new InputStreamReader(new FileInputStream(folderPath+File.separator+criado)));
			BufferedReader leitorEsperado = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+File.separator+"SaidasEsperadas"+File.separator+esperado)));
		while (leitorCriado.ready() && leitorEsperado.ready())
		{
			resultCriado.add(leitorCriado.readLine());
			resultEsperado.add(leitorEsperado.readLine());
			}
		if (resultCriado.size()==0) return false;
		for (int i = 0; i < resultCriado.size(); i++) {
			if (!(resultCriado.get(i).equals(resultEsperado.get(i)))) {
				return false;
				}	
			}
		leitorCriado.close();
		leitorEsperado.close();
		return true;
		}
		catch (Exception e) {
			System.out.println("File not found");
			return false;
		}
		
	
	}
	
	
	public Saida validarCod() throws IOException, InterruptedException {
		String timeSig = Long.toString(System.currentTimeMillis());
		String folderPath= System.getProperty("user.dir")+File.separator+"Run"+entrada.getProblem()+timeSig;
		String pyPath=null;
		if(new File(folderPath).mkdirs()) pyPath = folderPath+File.separator+"run.py";;
		String source = new String(Base64.getDecoder().decode(entrada.getSourcecode()));
		Writer sourceWriter= new PrintWriter(pyPath);
		sourceWriter.write(source);
		sourceWriter.close();
		String resul = null;
		if (entrada.getProblem().equals("A")) resul=ProcA(pyPath, folderPath);
		if (entrada.getProblem().equals("B")) resul=ProcB(pyPath, folderPath);
		return new Saida(entrada.getFilename(), entrada.getProblem(), resul);
	}
	
}
