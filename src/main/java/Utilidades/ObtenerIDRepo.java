package Utilidades;

import APIsAzure.API_GET_RepositoriosDeProyecto;
import org.json.JSONArray;
import org.json.JSONObject;

public class ObtenerIDRepo {
    public static String Obtener(String NombreRepo,String Organizacion,String Proyecto,String TokenAzure)
    {
        String IDRepo = "";
        JSONObject listarepos = API_GET_RepositoriosDeProyecto.Ejecutar(Organizacion,Proyecto,TokenAzure);
        JSONArray lista = listarepos.getJSONArray("value");
        for (int i = 0; i < lista.length(); i++) {
            JSONObject repo = lista.getJSONObject(i);
            if (repo.getString("name").equals(NombreRepo)){
                IDRepo = repo.getString("id");
                break;
            }
        }
        return IDRepo;
    }
}
