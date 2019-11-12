package Procesos.ProcesosDeDeploy;

import APIsVTEX.API_PUT_SubirArchivoVTEXPortal;
import Procesos.Deploy;
import Utilidades.StringFixes;
import org.json.JSONArray;

public class SubirA_VTEX_OMS {
    public static void SubirArchivo(String ArchivoRepo, JSONArray ListaVTEX){
        for (int i = 0; i < ListaVTEX.length(); i++)
        {
            if (ListaVTEX.getString(i).equals(StringFixes.FIXNombreArchivo(ArchivoRepo)))
            {
                //HOMOLOGACION PASO 3: SI EL ARCHIVO DE REPO, ESTA EN VTEX, SE OBTIENE Y ADAPTA SU CONTENIDO
                String contenido = AdaptarContenidoArchivo.ParaOMS(ArchivoRepo);
                //Y SE PROCEDE A SUBIRLO A VTEX
                if (API_PUT_SubirArchivoVTEXPortal.Ejecutar(Deploy.CUENTAVTEX, Deploy.AMBIENTEVTEX,
                        StringFixes.FIXNombreArchivo(ArchivoRepo), Deploy.USERID, Deploy.VTEXAUTHCOOKIE,contenido))
                {
                    System.out.println("Archivo "+ArchivoRepo+" Actualizado correctamente");
                    break;
                }else{
                    System.out.println("ERROR al actualizar el archivo");
                    break;
                }
            }else{
                //HOMOLOGACION PASO 4: SI EL ARCHIVO DE REPO, NO ESTA EN VTEX, SE OBTIENE Y SE ADAPTA SU CONTENIDO
                if (i==ListaVTEX.length()-1){
                    System.out.println("Archivo "+ArchivoRepo+" no existe en VTEX");
                    System.out.println("Creando...");
                    String contenido = AdaptarContenidoArchivo.ParaOMS(ArchivoRepo);
                    //Y SE PROCEDE A CREARLO EN VTEX
                    if (API_PUT_SubirArchivoVTEXPortal.Ejecutar(Deploy.CUENTAVTEX, Deploy.AMBIENTEVTEX,
                            StringFixes.FIXNombreArchivo(ArchivoRepo), Deploy.USERID, Deploy.VTEXAUTHCOOKIE,contenido))
                    {
                        System.out.println("Archivo "+ArchivoRepo+" Creado correctamente");
                        break;
                    }else{
                        System.out.println("ERROR en la creacion de archivo");
                        break;
                    }
                }
            }
        }
    }

}
