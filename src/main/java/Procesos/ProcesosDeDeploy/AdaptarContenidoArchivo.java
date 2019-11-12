package Procesos.ProcesosDeDeploy;

import APIsAzure.API_GET_ContenidoArchivo;
import Procesos.Deploy;
import Utilidades.StringFixes;

public class AdaptarContenidoArchivo {
    public static String ParaOMS(String PathArchivo)
    {
        String contenidoEnBruto = API_GET_ContenidoArchivo.Ejecutar(Deploy.ORGANIZACION, Deploy.PROYECTO,
                Deploy.IDREPOSITORIO,PathArchivo, Deploy.RAMA, Deploy.TOKENAZURE);
        return "{\"path\":\""+ StringFixes.FIXNombreArchivo(PathArchivo) +"\",\"text\":\""+ StringFixes.FIXContenidoArchivo(contenidoEnBruto)+"\"}";
    }
}
