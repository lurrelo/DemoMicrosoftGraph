package APIsVTEX;

import kong.unirest.Unirest;
import org.json.JSONArray;

public class API_GET_ObtenerArchivosPortal {
    public static JSONArray Ejecutar(String cuentaVTEX,String ambienteVTEX,String userID,String cookieVTEX)
    {
        String Lista = Unirest.get("https://"+cuentaVTEX+".myvtex.com/api/portal/pvt/sites/"+ambienteVTEX+"/files")
                .header("userId",userID)
                .header("VtexIdclientAutCookie",cookieVTEX)
                .asString()
                .getBody();
        return new JSONArray(Lista);
    }
}
