package APIsMicrosoftGraph;

import kong.unirest.Unirest;
import org.json.JSONObject;

public class API_POST_GetUserAccessToken {
    public static JSONObject Ejecutar(String TenantID,String ClientID,String ClientSecret,
                                      String userName,String userPassword)
    {
        String rawBody = "grant_type=password" +
                "&client_id="+ClientID+
                "&client_secret="+ClientSecret+
                "&scope=https://graph.microsoft.com/.default"+
                "&userName="+userName+
                "&password="+userPassword;
        String response = Unirest.post("https://login.microsoftonline.com/"+TenantID+"/oauth2/v2.0/token")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("SdkVersion","postman-graph/v1.0")
                .body(rawBody)
                .asString()
                .getBody();
        return new JSONObject(response);
    }
}
