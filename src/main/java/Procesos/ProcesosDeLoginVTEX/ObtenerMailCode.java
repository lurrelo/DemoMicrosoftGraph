package Procesos.ProcesosDeLoginVTEX;

import APIsMicrosoftGraph.API_GET_MailAPI_GetMessages;
import APIsMicrosoftGraph.API_POST_GetUserAccessToken;
import org.json.JSONArray;
import org.json.JSONObject;

public class ObtenerMailCode {
    public static String Ejecutar(String TenantID,String ClientID,String ClientSecret,
                                  String userName,String userPassword) throws InterruptedException {
        Thread.sleep(5000); //ESPERAR QUE LLEGUE EL CORREO
        String GraphAccessToken= API_POST_GetUserAccessToken.Ejecutar(TenantID,ClientID,
                ClientSecret,userName,userPassword).getString("access_token");
        JSONObject inboxFull = API_GET_MailAPI_GetMessages.Ejecutar(GraphAccessToken,userName);
        JSONArray arrayMails = inboxFull.getJSONArray("value");
        JSONObject lastMail =arrayMails.getJSONObject(0);
        return lastMail.getString("subject").replace("Your access code is ","");
    }
}
