package poo.play;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int opcion;
      int totalPrioridad = 0;
      Actividad ultimaTarea = null;

      do{
          mostrarMenu();
          opcion = leerOpcionMenu(sc);
          Resultado resultado = ejecutarOpcion(opcion, sc, totalPrioridad, ultimaTarea);
          totalPrioridad = resultado.totalPrioridad;
          ultimaTarea = resultado.tarea;
      } while (opcion != 3);

      sc.close();

    }

    public static void mostrarMenu() {
        System.out.println("***Gestor de Tareas***");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Ver ultima tarea");
        System.out.println("3. Salir");
    }

    public static int leerOpcionMenu(Scanner sc) {
        System.out.println("Elije una opción: ");
        return sc.nextInt();
    }

    public static Resultado ejecutarOpcion(int opcion , Scanner sc , int totalPrioridad, Actividad ultimaTarea) {
        sc.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                return agregarTarea(sc, totalPrioridad);

            case 2:
                if (ultimaTarea != null){
                    ultimaTarea.ejecutar(); //polimorfismo
                } else {
                    System.out.println("Tarea no existe");
                }
                break;
            case 3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opcion incorrecta. Intente nuevamente");
        }
        return new Resultado(totalPrioridad, ultimaTarea);
    }

    public static Resultado agregarTarea(Scanner sc, int totalPrioridad) {
        System.out.println("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.println("Prioridad (1 a 5): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        if (prioridad >=1 && prioridad <= 5 ){
            totalPrioridad += prioridad;
            Tarea nueva =  new Tarea(nombre, prioridad);
            System.out.println("Tarea'" + nombre + "´ agregada con prioridad: " + prioridad);
            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
            return new Resultado(totalPrioridad, nueva);
        } else  {
            System.out.println("Prioridad incorrecto. Intente nuevamente");
            return new Resultado(totalPrioridad, null);
        }
    }

    // clase auxiliar para retornar múltiples valores
    public static class Resultado {
        int totalPrioridad;
        Actividad tarea;


        public  Resultado(int totalPrioridad, Actividad tarea){
            this.totalPrioridad = totalPrioridad;
            this.tarea = tarea;
        }
    }
}

