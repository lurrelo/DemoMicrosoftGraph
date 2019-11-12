package APIsMicrosoftGraph;

import kong.unirest.Unirest;
import org.json.JSONObject;

public class API_GET_MailAPI_GetMessages {
    public static JSONObject Ejecutar(String AccessToken,String MailDir)
    {
        String response = Unirest.get("https://graph.microsoft.com/v1.0/me/mailfolders/inbox/messages")
                .queryString("$select","subject,from,receivedDateTime")
                .queryString("$top",1)
                .header("Accept","application/json")
                .header("Authorization","Bearer "+AccessToken)
                .header("X-AnchorMailbox",MailDir)
                .asString()
                .getBody();
        return new JSONObject(response);
    }
}
