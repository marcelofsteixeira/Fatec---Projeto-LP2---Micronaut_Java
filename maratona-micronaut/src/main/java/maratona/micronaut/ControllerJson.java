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
	    public Single<String> helloGet() {
	        return Single.just("Chamado Get");
	    }
	    
	    @Post("/maratona")
	     public Single<Saida> verifCod(@Size (max=2048) @Body Entrada entro ) throws IOException, InterruptedException {
	    	ProcPython pro = new ProcPython(entro);
	        return Single.just(pro.validarCod());
	    }
	
	
}
