package Logical;

import java.util.Scanner;

public class Main {
    static RestClient testing = new RestClient();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("###################################");
            System.out.println("----------CLIENTE REST-------------");
            System.out.println("###################################");

            System.out.println("[1] Listar todos los estudiantes: ");
            System.out.println("[2] Consultar estudiantes: ");
            System.out.println("[3] Crear un nuevo estudiante: ");
            System.out.println("[4] Borrar un estudiante : ");
            System.out.println("[5] Salir!! ");

            boolean valited = false;
            while (!valited) {
                System.out.println("[x] Digite una opcion: ");
                if (sc.hasNext()) {
                    String ok = sc.next();
                    if (isInteger(ok)) {
                        choice = Integer.parseInt(ok);
                        if (choice >= 1 && choice <= 5) {
                            valited = true;
                        } else {
                            valited = false;
                        }
                    }
                }
            }
            System.out.println("[x] Eleccion digitada: " + choice);
            option(choice);
        }
    }

    private static boolean isInteger(String ok) {
        return ok.matches("-?\\d+");
    }

    private static int option(int x) {
        int mat;
        String name;
        String carrera;
        switch (x) {
            case 1:
                System.out.println("\n Listando estudiantes...");
                testing.listStudents();
                break;
            case 2:
                System.out.println("\n Consultando estudiante...");
                System.out.println("\nDigite su matricula:");
                mat = sc.nextInt();
                testing.getStudent(mat);
                break;
            case 3:
                System.out.println("\nDigite su matricula:");
                mat = sc.nextInt();
                System.out.println("\nDigite su nombre:");
                name = sc.next();
                System.out.println("\nDigite su carrera:");
                carrera = sc.next().toUpperCase();
                System.out.println("\n Creando estudiante...");

                testing.addStudent(mat, name, carrera);
                break;
            case 4:
                System.out.println("\nDigite su matricula:");
                mat = sc.nextInt();
                System.out.println("\n Eliminando estudiante...");
                testing.deleteStudent(mat);
                break;
            case 5:
                System.out.println("\n Saliendo...");
                break;
            default:
                System.out.println("\n Elija una opcion correcta");
        }
        return x;
    }
}
