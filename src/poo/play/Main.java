package poo.play;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int totalPrioridad = 0;

    do{
        System.out.println(" == Gestor de Tareas ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas (pendiente)");
        System.out.println("3. Salir");

        System.out.println("Selecciona una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); //limpiar

        switch (opcion){
            case 1:
                System.out.println("Nombre de la tarea: ");
                String nombre = sc.nextLine();

                System.out.println("Prioridad (1 a 5): ");
                int prioridad = sc.nextInt();

               if (prioridad >= 1 && prioridad <= 5){
                   totalPrioridad += prioridad;
                   System.out.println("Tarea '" +  nombre + "' con prioridad " + prioridad + " agregada ");
                   System.out.println("Total acumulado de proridades: " + totalPrioridad);
               } else {
                   System.out.println("Prioridad invalido");
               }
                break;
            case 2:
                System.out.println("Funcionalidad aún no implementada.");
                break;

            case  3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opcion invalida. Intenta de nuevo.");
        }
    } while (opcion != 3);

        sc.close();
    }
}
