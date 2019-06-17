package maratona.micronaut;

import java.util.LinkedList;
import java.util.List;

import io.micronaut.runtime.Micronaut;

public class Application {
private static List<Log> logs = new LinkedList<Log>();
	
	public static List<Log> getLogs() {
		return logs;
	}
	
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
