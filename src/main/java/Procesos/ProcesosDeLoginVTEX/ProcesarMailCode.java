package Procesos.ProcesosDeLoginVTEX;

import APIsVTEX.API_POST_AuthenticationSTART;
import APIsVTEX.API_POST_Authentication_MailValidate;
import APIsVTEX.API_POST_Authentication_SendMailCode;
import Procesos.Deploy;
import org.json.JSONObject;

public class ProcesarMailCode {
    public static JSONObject EnviarMail(String TenantID,String ClientID,String ClientSecret,
                                  String userEmail,String userPassword) throws InterruptedException
    {
        String AuthenticationToken = API_POST_AuthenticationSTART.Ejecutar(Deploy.CUENTAVTEX);
        JSONObject resp;
        if(API_POST_Authentication_SendMailCode.Ejecutar(Deploy.CUENTAVTEX,AuthenticationToken,userEmail)==200)
        {
            String MailCode = ObtenerMailCode.Ejecutar(TenantID,ClientID,ClientSecret,userEmail,userPassword);
            //OBTENIDO EL CODIGO QUE SE ENVIA AL MAIL, SE PROCEDE A EJECUTAR EL LOGIN VALIDATE DE VTEX
            resp = API_POST_Authentication_MailValidate.Ejecutar(Deploy.CUENTAVTEX,userEmail,MailCode,AuthenticationToken);
        }else{
            System.out.println("ERROR EN LA CONSULTA");
            resp = new JSONObject("{}");
        }
        return resp;
    }
}
