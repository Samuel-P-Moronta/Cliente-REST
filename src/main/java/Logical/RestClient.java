package Logical;

import com.google.gson.JsonObject;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
/*
    Autor: Samuel Peña M
*/

public class RestClient {
    static String url = "http://localhost:7000/api/estudiante/";
    static String urlMat = "http://localhost:7000/api/estudiante/{matricula}";
    static String param = "matricula";
    static String content = "Content-Type";
    static String appJson = "application/json";

    public static void addStudent(int mat, String name, String career) {
        JsonObject st = new JsonObject();
        st.addProperty("nombre", name);
        st.addProperty("matricula", mat);
        st.addProperty("carrera", career);
        HttpResponse<JsonNode> r1 = Unirest.post(url).header(content, appJson).body(st).asJson();
        System.out.println("Status: " + r1.getStatus());
        System.out.println(r1.getBody());
    }

    public static void getStudent(int mat) {
        HttpResponse<String> r1 = Unirest.get(urlMat).routeParam(param, String.valueOf(mat)).asString();
        System.out.println("Status: " + r1.getStatus());
        if (r1.getBody().equals("Internal server error")) {
            System.out.println(r1.getBody());
            System.out.println("[Error] la Matricula " + "[" + mat + "]" + " es posible que no exista");
        } else {
            System.out.println("[Success] Estudiante con matricula " + "[" + mat + "]" + " se ha encontrado");
            System.out.println(r1.getBody());
        }
    }

    public static void listStudents() {
        HttpResponse<String> r1 = Unirest.get(url).asString();
        System.out.println("Status: " + r1.getStatus());
        System.out.println("Datos recolectados: ");
        System.out.println(r1.getBody());
    }

    public void deleteStudent(int mat) {
        HttpResponse<String> r1 = Unirest.delete(urlMat).routeParam(param, String.valueOf(mat)).asString();
        System.out.println("Status: " + r1.getStatus());
        if (r1.getBody().equals("true")) {
            System.out.println("\nEl estudiante con matricula: " + mat + " se ha elimando correctamente!");
        } else if (r1.getBody().equals("false")) {
            System.out.println("\n[Error] no se pudo eliminar");
        }
    }
}
