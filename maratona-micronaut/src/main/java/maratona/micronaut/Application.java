package maratona.micronaut;

import java.util.LinkedList;
import java.util.List;

import io.micronaut.runtime.Micronaut;

//Em sistemas windows, a aplicacao é iniciada executando o arquivo gradlew, localizado no diretorio do projeto. Por padrao, o servidor roda na porta 8181. 
//Antes da execucao do codigo, e necessaria a configuracao de uma variavel de ambiente PYTHON_PATH, que aponta para o executavel do interpretador Python do sistema
//A classe Application possui uma lista de objetos Log, que reunem informacoes sobre cada execucao de codigo python
public class Application {
private static List<Log> logs = new LinkedList<Log>();
	
	public static List<Log> getLogs() {
		return logs;
	}
	
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
