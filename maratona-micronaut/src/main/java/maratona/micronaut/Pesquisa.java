package maratona.micronaut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pesquisa {
	
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
