package maratona.micronaut;

import java.util.LinkedList;
import java.util.List;

import io.micronaut.runtime.Micronaut;

public class Application {
private List<Log> logs = new LinkedList<Log>();
	
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}