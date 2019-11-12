package APIsAzure;

import kong.unirest.Unirest;
import org.json.JSONObject;

import static OtrasClases.ConstantesGenerales.*;

public class API_GET_ListaArchivosRepo {
    public static JSONObject Ejecutar(String organizacion,String proyecto,String repoId,String rama,String path, String token)
    {
        String AzureResp = Unirest.get(AZURE_INSTANCIA+organizacion+"/"+proyecto+"/_apis/git/repositories/"+repoId+"/items")
                .queryString("scopePath", path)
                .queryString("recursionLevel","Full" )
                .queryString("versionDescriptor.versionType","branch")
                .queryString("versionDescriptor.version",rama)
                .queryString("api-version", VERSION_API)
                .header("Authorization", token)
                .asString()
                .getBody();
        return new JSONObject(AzureResp);
    }
}
