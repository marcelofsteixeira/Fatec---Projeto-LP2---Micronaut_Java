package PythonTest;

import java.io.IOException;

public class RunPy {

	public static void main(String[] args) throws InterruptedException, IOException {

		// TODO Auto-generated method stub
		try {
			
			Pyexe pyexe=new Pyexe("mergulho.py >s5.txt");
		    pyexe.pybuffwriter.write("5 3\n1 2 3");
		    pyexe.pybuffwriter.flush();
		    
			
		} catch (Exception e) {
			System.out.println("Erro de compilação");
		}

	}
}