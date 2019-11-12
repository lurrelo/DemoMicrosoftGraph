package APIsAzure;

import kong.unirest.Unirest;

import static OtrasClases.ConstantesGenerales.*;

public class API_GET_ContenidoArchivo {
    public static String Ejecutar(String organizacion,String proyecto,String repoId,String pathFile,String rama,String token)
    {
        String Response = Unirest.get(AZURE_INSTANCIA+organizacion+"/"+proyecto+"/_apis/git/repositories/"+repoId+"/items")
                .queryString("path",pathFile)
                .queryString("versionDescriptor.versionType","branch")
                .queryString("versionDescriptor.version",rama)
                .queryString("api-version",VERSION_API)
                .header("Authorization",token)
                .asString()
                .getBody();
        return Response;
    }
}
