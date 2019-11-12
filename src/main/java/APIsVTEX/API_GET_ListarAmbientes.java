package APIsVTEX;

import kong.unirest.Unirest;
import org.json.JSONArray;

public class API_GET_ListarAmbientes {
    public static JSONArray Ejecutar(String CuentaVTEX,String userID,String cookieVTEX)
    {
        String Response = Unirest.get("https://"+CuentaVTEX+".myvtex.com/api/portal/pvt/sites")
                .header("userId",userID)
                .header("VtexIdclientAutCookie",cookieVTEX)
                .asString()
                .getBody();
        return new JSONArray(Response);
    }
}
