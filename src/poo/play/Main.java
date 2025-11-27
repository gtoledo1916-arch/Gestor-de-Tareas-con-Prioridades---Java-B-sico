package poo.play;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int opcion;
      int totalPrioridad = 0;

      do{
          mostrarMenu();
          opcion = leerOpcionMenu(sc);
          totalPrioridad = ejecutarOpcion(opcion, sc, totalPrioridad);
      } while (opcion != 3);

      sc.close();

    }

    public static void mostrarMenu() {
        System.out.println("***Gestor de Tareas***");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Ver Tareas (Pendiente)");
        System.out.println("3. Salir");
    }

    public static int leerOpcionMenu(Scanner sc) {
        System.out.println("Elije una opción: ");
        return sc.nextInt();
    }

    public static int ejecutarOpcion(int opcion , Scanner sc , int totalPrioridad) {
        sc.nextLine();

        switch (opcion) {
            case 1:
                totalPrioridad = agregarTarea(sc, totalPrioridad);
                break;

            case 2:
                System.out.println("Funcionalidad en desarrollo");
                break;

            case 3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opcion incorrecta. Intente nuevamente");
        }
        return totalPrioridad;
    }

    public static int agregarTarea(Scanner sc, int totalPrioridad) {
        System.out.println("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.println("Prioridad (1 a 5): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        if (prioridad >=1 && prioridad <= 5 ){
            totalPrioridad += prioridad;
            System.out.println("Tarea'" + nombre + "´ agregada con prioridad: " + prioridad);
            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
        } else  {
            System.out.println("Prioridad incorrecto. Intente nuevamente");
        }

        return totalPrioridad;
    }
}

