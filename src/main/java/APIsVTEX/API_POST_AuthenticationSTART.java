package APIsVTEX;

import kong.unirest.Unirest;
import org.json.JSONObject;

public class API_POST_AuthenticationSTART {
    public static String Ejecutar(String cuentaVTEX){
        String Response = Unirest.post("https://"+cuentaVTEX+".myvtex.com/api/vtexid/pub/authentication/start")
                .body("callbackUrl=https%3A%2F%2F"+
                        cuentaVTEX+".myvtex.com%2Fapi%2Fvtexid%2Fpub%2Fauthentication%2Ffinish&user=&locale=es-ES&accountName="+
                        cuentaVTEX+"&returnUrl=https%3A%2F%2F"+
                        cuentaVTEX+".vtexcommercestable.com.br%2Fadmin%2FSite%2FHelp.aspx&appStart=true&method=POST")
                .asString()
                .getBody();
        JSONObject auth = new JSONObject(Response);
        return auth.getString("authenticationToken");
    }
}
