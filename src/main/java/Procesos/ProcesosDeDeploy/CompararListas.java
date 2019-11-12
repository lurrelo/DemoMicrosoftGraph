package Procesos.ProcesosDeDeploy;

import org.json.JSONArray;

public class CompararListas {
    public static void Comparar(JSONArray ListaVTEX,JSONArray ListaAzure)
    {
        for (int i = 1; i < ListaAzure.length(); i++) {
            String ArchivoRepo = ListaAzure.getJSONObject(i).getString("path");
            //VERIFICANDO SI EL ARCHIVO ES UN TEMPLATE HTML
            String TipoDeArchivoRepo = ArchivoRepo.substring(ArchivoRepo.length() - 4);
            //HOMOLOGACION PASO 2: SE VERIFICA EL TIPO DE ARCHIVO Y SE ELIJE A DONDE DEBE SER SUBIDO
            if (TipoDeArchivoRepo.equals("html") || TipoDeArchivoRepo.equals("HTML"))
            {
                //SI EL ARCHIVO ES UN HTML SE SUBE AL CMS
                //TODO SUBIDA A CMS
                System.out.println("ARCHIVO HTML");
            }else {
                //SI EL ARCHIVO NO ES HTML, SE SUBE EN EL OMS
                SubirA_VTEX_OMS.SubirArchivo(ArchivoRepo, ListaVTEX);
            }
        }
    }
}
