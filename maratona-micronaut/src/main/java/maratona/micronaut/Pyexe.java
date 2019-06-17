package maratona.micronaut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Classe que contem um processo de arquivo Python com buffers de input e output. O processo Pyrun insere uma String de imputs para o processo e o finaliza.
public class Pyexe {
	Process pypr;
	BufferedReader pybuffreader;
	BufferedWriter pybuffwriter;
	public Pyexe(String filecmd) throws IOException{
		//A classe necessita do caminho do interpretador Python no sistema. Nesse caso, o caminho foi acessado por uma variavel de ambiente de nome PYTHON_PATH
		String python_path= System.getenv("PYTHON_PATH");
	    pypr=Runtime.getRuntime().exec("cmd /c "+ python_path+" "+filecmd);
	    pybuffreader=new BufferedReader(new InputStreamReader(pypr.getInputStream()));
	    pybuffwriter=new BufferedWriter(new OutputStreamWriter(pypr.getOutputStream()));

	}
	
	
	public void Pyrun (String entrada) throws InterruptedException, IOException {
		pybuffwriter.write(entrada);
		pybuffwriter.flush();
		pybuffwriter.close();
		pypr.waitFor();
		Pyend();
	
	}
	
	
	public void Pyend(){
	    this.pypr.destroy();
	}

}
