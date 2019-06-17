package maratona.micronaut;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Size;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;
import io.micronaut.http.annotation.Controller;

/* Este controller aceita os seguintes chamados REST:
	
	get - application/Json/maratona?pesquisa=valor
	
	Retorna uma lista de Jsons de uma pesquisa entre todos os Logs de execucao de cada codigo Python enviado. O campo pesquisa deve ser status, id ou date, com o valor sendo:
	id: A ou B
	status: SUCCESS ou FAIL
	date: data no formato dd-mm-aa:hh:mm
	
	Somente um valor pode ser pesquisado por vez, e se mais de um valor é pesquisado, o chamado retorna uma lista com apenas o primeiro valor pesquisado.
	
	Exemplo de retorno:
	
	[
    	{
        "filename": "mergulho.py",
        "problem": "B",
        "sourcecode": "TiwgUiA9IFtpbnQoeCkgZm9yIHggaW4gaW5wdXQoKS5zcGxpdCgpXQplbnZpYWRvcyA9IGlucHV0KCkuc3BsaXQoKQppZiBOPT1SOgogICAgcHJpbnQoIioiKQplbHNlOgogICAgblJldG9ybmFkb3M9W10KICAgIGZvciBjIGluIHJhbmdlICgxLE4rMSk6CiAgICAgICAgaWYgc3RyKGMpIG5vdCBpbiBlbnZpYWRvczoKICAgICAgICAgICAgblJldG9ybmFkb3MuYXBwZW5kKHN0cihjKSkKICAgIHN0clJldG9yPSIgIi5qb2luKG5SZXRvcm5hZG9zKSsiICIKICAgIHByaW50KHN0clJldG9yKQ==",
        "datetime": "17-06-19:16:38",
        "status": "SUCCESS"
   	 }
	]
	
	
	
	post - application/Json/maratona
	
	Chamado que envia um json contendo um codigo fonte Python em base64, o tipo de problema (A ou B) e o nome do arquivo .py a ser criado. 
	
	Exemplo de Json de entrada:
	
	{
	"filename": "mergulho.py",
	"problem":"B",
	"sourcecode":"TiwgUiA9IFtpbnQoeCkgZm9yIHggaW4gaW5wdXQoKS5zcGxpdCgpXQplbnZpYWRvcyA9IGlucHV0KCkuc3BsaXQoKQppZiBOPT1SOgogICAgcHJpbnQoIioiKQplbHNlOgogICAgblJldG9ybmFkb3M9W10KICAgIGZvciBjIGluIHJhbmdlICgxLE4rMSk6CiAgICAgICAgaWYgc3RyKGMpIG5vdCBpbiBlbnZpYWRvczoKICAgICAgICAgICAgblJldG9ybmFkb3MuYXBwZW5kKHN0cihjKSkKICAgIHN0clJldG9yPSIgIi5qb2luKG5SZXRvcm5hZG9zKSsiICIKICAgIHByaW50KHN0clJldG9yKQ=="
	}
	
	O sistema roda o codigo fonte e valida os resultados. Se forem os esperados retorna uma mensagem de sucesso ou falha. 
	
	Exemplo de Json de saida:


	{
   	"filename": "mergulho.py",
    	"problem": "B",
   	"status": "SUCCESS"
	}



*/


@Controller("/application/Json") 
public class ControllerJson {
	
	    //Chamado que recebe parametros de pesquisa que realizam uma busca pela lista de objetos Log contidos na classe Application (os logs de envio de cada codigo Python) processado no sistema
	    //Os valores pesquisados são recebidos como um Map<String,String> e o processamento da pesquisa é realizado pela classe Pesquisa
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
