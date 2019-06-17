package maratona.micronaut;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;
import io.micronaut.http.annotation.Controller;




@Controller("/application/Json") 
public class ControllerJson {
	
	    @Get("/maratona{?pesq*}")
	    public List<Log> pesq (Map<String, String> pesq) {
	    	return Pesquisa.pesquisarLogs(pesq);
	    }
	    
	    //Chamado que recebe um Json com os mesmos atributos de um objeto Entrada no caminho "/application/Json/maratona"
	    //O metodo do chamado cria um objeto Entrada com os mesmos atributos do Json, e executa o codigo python e as verificacoes em um objeto ProcPython.
	    //O chamado retorna um objeto Saida com o status da verificacao do codigo, que é convertido para Json pelo framework.
	    @Post("/maratona")
	     public Single<Saida> verifCod(@Size (max=2048) @Body Entrada entro ) throws IOException, InterruptedException {
	    	ProcPython pro = new ProcPython(entro);
	        return Single.just(pro.validarCod());
	    }
	
	
}
