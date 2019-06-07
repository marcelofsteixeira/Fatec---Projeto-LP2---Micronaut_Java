package maratona.micronaut;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Single;



@Controller("/application/Json") 
public class ControllerJson {
	
	    @Get("/maratona")
	    public Single<String> helloGet(String name) {
	        return Single.just("Chamado Get");
	    }
	    
	    @Post("/maratona")
	    public Single<String> helloPost(String name) {
	        return Single.just("Chamado Post");
	    }
	
	
}
