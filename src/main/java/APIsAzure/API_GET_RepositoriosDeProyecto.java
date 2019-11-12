package APIsAzure;

import kong.unirest.Unirest;
import org.json.JSONObject;

import static OtrasClases.ConstantesGenerales.AZURE_INSTANCIA;
import static OtrasClases.ConstantesGenerales.VERSION_API;

public class API_GET_RepositoriosDeProyecto {
    public static JSONObject Ejecutar(String Organizacion,String Proyecto,String tokenAzure)
    {
        String Response = Unirest.get(AZURE_INSTANCIA+Organizacion+"/"+Proyecto+"/_apis/git/repositories")
                .queryString("api-version",VERSION_API)
                .header("Authorization",tokenAzure)
                .asString()
                .getBody();
        return new JSONObject(Response);
    }
}
