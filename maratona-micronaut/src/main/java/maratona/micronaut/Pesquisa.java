package maratona.micronaut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pesquisa {
	//O metodo pesquisarLogs recebe um Map da pesquisa no formato String,String, contendo o tipo da pesquisa e o valor pesquisado, respectivamente.
	//Dependendo do tipo de pesquisa, o metodo percorre a lista dos objetos Log salvos e retorna aqueles com o valor correspondente ao pesquisado.
	public static List<Log> pesquisarLogs(Map<String, String> pesq){
		
		ArrayList<String> campoPesq=new ArrayList<String>(pesq.keySet());
		List<Log> resultado = new LinkedList<Log>();
		List<Log> salvos = Application.getLogs();
    	for(String campo:campoPesq) {
    		if (campo.equals("status")) {
    			for (Log log: salvos) {
    				if (log.getStatus().equals(pesq.get("status"))) resultado.add(log);
    			}
    			return resultado;
    		}
    		
    		if (campo.equals("id"))  {
        			for (Log log: salvos) {
        				if (log.getProblem().equals(pesq.get("id"))) resultado.add(log);
        			}
        			return resultado;
        		}
    		if (campo.equals("date"))  {
    			for (Log log: salvos) {
    				if (log.getDatetime().equals(pesq.get("date"))) resultado.add(log);
    			}
    			return resultado;
    		}
    	}
    	return resultado;
	}
	
	
	
}
