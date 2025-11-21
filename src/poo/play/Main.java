package poo.play;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalPrioridad = 0;

        System.out.println(" == Gestor de Tareas ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas (pendiente)");
        System.out.println("3. Salir");

        System.out.println("Selecciona una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); //limpiar

        // Validamos que este entre 1 y 3

        if (opcion >= 1 && opcion <= 3) {
            if (opcion == 1) {
                System.out.println("Nombre de la tarea: ");
                String nombreTarea = sc.nextLine();

                System.out.println("Prioridad (1 a 5): ");
                int prioridad = sc.nextInt();

                //Validación básica con operador lógico
                boolean esValida = prioridad >= 1 && prioridad <= 5;
                System.out.println("¿Prioridad es válida?" + esValida);

                //Operación aritmética: suma prioridades
                totalPrioridad += prioridad;

                System.out.println("Tarea agregada: " + nombreTarea + "(Prioridad: " + prioridad + ")");
                System.out.println("Suma total de Prioridades: " + totalPrioridad);
            } else if (opcion == 2) {
                System.out.println("Función para 'ver tareas' aun no implementada.");
            } else {
                System.out.println("!Hasta luego¡");
            }
        }else {
            System.out.println("Opcion incorrecta");
        }

        sc.close();
    }
}
