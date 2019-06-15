package PythonTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Pyexe {
	Process pypr;
	BufferedReader pybuffreader;
	BufferedWriter pybuffwriter;
	public Pyexe(String filecmd) throws IOException{
		String python_path= System.getenv("PYTHON_PATH");
		System.out.println(System.getenv("PYTHON_PATH"));
	    pypr=Runtime.getRuntime().exec("cmd /c "+ python_path+" "+filecmd);
	    pybuffreader=new BufferedReader(new InputStreamReader(pypr.getInputStream()));
	    pybuffwriter=new BufferedWriter(new OutputStreamWriter(pypr.getOutputStream()));

	}
	public void Pyend(){
	    this.pypr.destroy();
	}

}
