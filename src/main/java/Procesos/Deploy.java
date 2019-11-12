package Procesos;

import APIsAzure.API_GET_ListaArchivosRepo;
import APIsVTEX.API_GET_ObtenerArchivosPortal;
import Procesos.ProcesosDeDeploy.CompararListas;
import Procesos.ProcesosDeLoginVTEX.ProcesarMailCode;
import Utilidades.AzureTokenBase64;
import Utilidades.ObtenerIDRepo;
import org.json.JSONArray;
import org.json.JSONObject;

public class Deploy {
    public static String CUENTAVTEX;
    public static String AMBIENTEVTEX;

    public static String USERID;
    public static String VTEXAUTHCOOKIE;

    public static String ORGANIZACION;
    public static String PROYECTO;
    public static String IDREPOSITORIO;
    public static String RAMA;
    public static String TOKENAZURE;

    public static void main(String []args) throws InterruptedException {
        //HOMOLOGACION PASO 0: OBTENER DATOS PARA SCRIPT

        //VTEX DATA
        CUENTAVTEX=args[0];
        AMBIENTEVTEX=args[1];

        //MICROSOFT GRAPH DATA
        String TenantID = args[2];
        String ClientID = args[3];
        String ClientSecret = args[4];
        String userName = args[5];
        String userPassword = args[6];

        JSONObject LoginMailDAta = ProcesarMailCode.EnviarMail(TenantID,ClientID,ClientSecret,userName,userPassword);

        USERID=LoginMailDAta.getString("userId");
        VTEXAUTHCOOKIE=LoginMailDAta.getJSONObject("authCookie").getString("Value");

        //AZURE DEVOPS DATA
        ORGANIZACION=args[7];
        PROYECTO=args[8];
        TOKENAZURE= AzureTokenBase64.Codificar(args[9]);

        //AZURE REPO DATA
        IDREPOSITORIO = ObtenerIDRepo.Obtener(args[10],ORGANIZACION,PROYECTO,TOKENAZURE);
        RAMA=args[11];

        System.out.println("------INICIANDO PROCESO DE HOMOLOGACION------");
        System.out.println("DESDE RAMA: "+RAMA);
        System.out.println("DEL REPOSITORIO: "+args[10]);
        System.out.println("A AMBIENTE VTEX: "+AMBIENTEVTEX);
        System.out.println("DE LA CUENTA: "+CUENTAVTEX);
        System.out.println("---------------------------------------------");

        //HOMOLOGACION PASO 1: LISTAR ARCHIVOS DE VTEX Y DE REPO AZURE
        JSONArray ListaVTEX = API_GET_ObtenerArchivosPortal.Ejecutar(CUENTAVTEX,AMBIENTEVTEX,USERID,VTEXAUTHCOOKIE);
        JSONArray ListaAzure = API_GET_ListaArchivosRepo.Ejecutar(ORGANIZACION,PROYECTO,IDREPOSITORIO,RAMA,"dev/files/",TOKENAZURE).getJSONArray("value");
        CompararListas.Comparar(ListaVTEX,ListaAzure);
    }
}
