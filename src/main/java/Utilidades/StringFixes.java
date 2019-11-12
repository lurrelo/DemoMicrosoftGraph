package Utilidades;

public class StringFixes {
    public static String FIXNombreRepo(String RepoPath)
    {
        return RepoPath.replace("refs/heads/","");
    }

    public static String FIXNombreProyecto(String Proyecto)
    {
        return Proyecto.replaceAll("\\s","%20");
    }

    public static String FIXNombreRama(String RamaPath)
    {
        return RamaPath.replace("refs/heads/","");
    }

    public static String FIXNombreArchivo(String NombreArchivo)
    {
        return NombreArchivo.replace("/dev/files/","");
    }

    public static String FIXContenidoArchivo(String Contenido)
    {
        String textNoEscape = Contenido.replace("\\","\\\\");
        String textNoComilla = textNoEscape.replace("\"","\\\"");
        String textNoNextLine = textNoComilla.replaceAll("[\\\n]","\\\\n");
        return textNoNextLine.replaceAll("[\\\t]","\\\\t");
    }

}
