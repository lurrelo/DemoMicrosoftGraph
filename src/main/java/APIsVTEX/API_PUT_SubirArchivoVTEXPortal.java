package APIsVTEX;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class API_PUT_SubirArchivoVTEXPortal {
    public static boolean Ejecutar(String cuentaVTEX,String ambienteVTEX,String NombreArchivo,String userID,
                                String cookieVTEX, String contenidoArchivo){
        HttpResponse<JsonNode> response = Unirest.put("https://"+cuentaVTEX+".myvtex.com/api/portal/pvt/sites/"+ambienteVTEX+"/files/"+NombreArchivo+"")
                .header("userId",userID)
                .header("VtexIdclientAutCookie",cookieVTEX)
                .header("Content-Type","application/json")
                .body(contenidoArchivo)
                .asJson();
        return response.isSuccess();
    }
}
