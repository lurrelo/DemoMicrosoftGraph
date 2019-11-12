package APIsVTEX;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class API_POST_Authentication_SendMailCode {
    public static Integer Ejecutar(String cuentaVTEX,String AuthenticationToken,String email)
    {
        HttpResponse<JsonNode> response =Unirest.post("https://"+cuentaVTEX+".myvtex.com/api/vtexid/pub/authentication/accesskey/send")
                .header("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("accept","*/*")
                .body("recaptcha=&authenticationToken="+AuthenticationToken+"&email="+email+"&locale=es-ES&method=POST")
                .asJson();
        return response.getStatus();
    }
}
