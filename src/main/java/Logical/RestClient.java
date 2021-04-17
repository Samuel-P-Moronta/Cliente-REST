package Logical;

import com.google.gson.JsonObject;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class RestClient {
    static String url = "http://localhost:7000/api/estudiante/";
    public static void addStudent() {
        //Parametros
        String name = "Samuel Peña";
        int mat = 20170570;
        String career = "ITT";
        //instanciando el objeto JsonObject
        JsonObject st = new JsonObject();
        //Agregando los paramtros
        st.addProperty("nombre", name);
        st.addProperty("matricula", mat);
        st.addProperty("carrera", career);

        HttpResponse<JsonNode> r1 = Unirest.post(url).header("Content-Type", "application/json").body(st).asJson();
        System.out.println("*****************************************************************************************");
        //Obteniendo respuestas
        System.out.println("Status: " + r1.getStatus());
        System.out.println(r1.getBody());
    }
    //Consultando un estudiante por matricula
    public static void getStudent(){
        int mat = 20170570;
        HttpResponse<String> r1 = Unirest.get("http://localhost:7000/api/estudiante/{matricula}").routeParam("matricula", String.valueOf(mat)).asString();
        System.out.println("*****************************************************************************************");
        System.out.println("Status: " + r1.getStatus());
        System.out.println(r1.getBody());
    }
    //Listando todos los estudiantes
    public static void listStudents() {
        System.out.println("*****************************************************************************************");
        HttpResponse<String> r1 = Unirest.get(url).asString();
        System.out.println("Status: " + r1.getStatus());
        System.out.println(r1.getBody());
    }
    //Eliminando un estudiante por matricula
    public void deleteStudent() {
        System.out.println("*****************************************************************************************");
        int matDelete = 20170570;
        HttpResponse<String> r1 = Unirest.delete("http://localhost:7000/api/estudiante/{matricula}").routeParam("matricula", String.valueOf(matDelete)).asString();
        System.out.println("Status: " + r1.getStatus());
        System.out.println(r1.getBody());
    }
}
