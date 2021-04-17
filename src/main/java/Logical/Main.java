package Logical;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RestClient testing = new RestClient();
        System.out.println("###################################");
        System.out.println("----------CLIENTE REST-------------");
        System.out.println("###################################");

        System.out.println("[1] Listar todos los estudiantes: ");
        /*Hay que jugar comantando las funciones que se quiere probar*/
        testing.listStudents();
        System.out.println("[2] Consultar estudiantes: ");
        testing.getStudent();
        System.out.println("[3] Crear un nuevo estudiante: ");
        testing.addStudent();
        System.out.println("[4] Borrar un estudiante: : ");
        //Retorna true si esta eliminado
        //Fase si no lo esta (Una razon puede ser que el parametro de
        //la matriculo no corresponnda con el registro)
        testing.deleteStudent();
    }

}
