package poo.play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Tarea> ListaTareas = new ArrayList<>();
    private static final HashMap<String, Tarea> mapaTareas = new HashMap<>();
    private static int acumuladorPrioridades = 0;

    public static void main(String[] args) {
      int opcion;
      do{
          mostrarMenu();
          opcion = Integer.parseInt(sc.nextLine());
          switch (opcion) {
              case 1 -> agregarTarea();
              case 2 -> ListarTareas();
              case 3 -> buscarTarea();
              case 4 -> eliminarTarea();
              case 5 -> mostrarAcumulador();
              case 6 -> System.out.println("Saliendo del programa");
              default -> System.out.println("Opcion invalida");
          }
      } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("***Gestor de Tareas***");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Buscar tarea por ID");
        System.out.println("4. Eliminar tarea por ID");
        System.out.println("5. Ver total acmulado de prioridades");
        System.out.println("6. Salir");
        System.out.println("Elije una opcion: ");
    }


    public static void agregarTarea(){
        System.out.print("ID de la tarea: ");
        String id = sc.nextLine();

        if  (mapaTareas.containsKey(id)){
            System.out.println("Ya existe una tarea con el mismo ID.");
            return;
        }

        System.out.print("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        int prioridad = Integer.parseInt(sc.nextLine());

        if (prioridad < 1 || prioridad > 5){
            System.out.println("Prioridad no valida");
        }

        Tarea nueva = new Tarea(nombre, prioridad);
        ListaTareas.add(nueva);
        mapaTareas.put(id, nueva);
        acumuladorPrioridades += prioridad;

        System.out.println("Tarea agregada con éxito");
        System.out.println("Total acmulado de prioridades: " + acumuladorPrioridades);

    }

    private static void ListarTareas(){
        if (mapaTareas.isEmpty()){
            System.out.println("Tareas no encontrados");
        }

        System.out.println("\n ===Tareas encontradas=== ");
        for(Map.Entry<String, Tarea> entrada : mapaTareas.entrySet()){
            System.out.println("ID:" + entrada.getKey() + " - ");
            entrada.getValue().ejecutar(); //polimorfismo

        }
    }

    private static void buscarTarea(){
        System.out.print("ID de la terea a buscar: ");
        String id = sc.nextLine();

        Tarea t = mapaTareas.get(id);
        if (t != null){
            System.out.println("Tarea encontrada: ");
            t.ejecutar();
        } else {
            System.out.println("No se encontró ninguna tarea con ese ID.: ");
        }
    }

    private static void eliminarTarea(){
        System.out.print("ID de la terea a eliminar: ");
        String id = sc.nextLine();

        Tarea eliminada = mapaTareas.remove(id);
        if (eliminada != null){
            ListaTareas.remove(eliminada);
            acumuladorPrioridades -= eliminada.getPrioridad();
            System.out.println("Tarea eliminada correctamente");
            System.out.println("Total acmulado actualizado: " + acumuladorPrioridades);
        } else {
            System.out.println("No se encontro ninguna tarea con ese ID.");
        }
    }

    private static void mostrarAcumulador(){
        System.out.println("Acumulador de prioridades: " + acumuladorPrioridades);
    }
}
