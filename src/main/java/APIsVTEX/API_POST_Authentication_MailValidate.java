package APIsVTEX;

import kong.unirest.Unirest;
import org.json.JSONObject;

public class API_POST_Authentication_MailValidate {
    public static JSONObject Ejecutar(String cuentaVTEX,String userMail,String mailCode,String AuthenticationToken)
    {
        String response = Unirest.post("https://"+cuentaVTEX+".myvtex.com/api/vtexid/pub/authentication/accesskey/validate")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("login="+userMail+"&accesskey="+mailCode+"&authenticationToken="+AuthenticationToken+"&method=POST")
                .asString()
                .getBody();
        return new JSONObject(response);
    }
}
