package application;

import application.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println("Employee #" + i);

            System.out.print("ID: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            System.out.println();

            Employee fun = new Employee(id, name, salary);
            employee.add(fun);
        }

        System.out.print("The employee ID that will have salary increase : ");
        int numId = sc.nextInt();

        //Lista do nome de referencia da lista de baixo nao tem conexao com a de cima.
        Employee fun = employee.stream().filter(x -> x.getId() == numId).findFirst().orElse(null);
        /* Buscando na lista usando employee.stream"forma especial de tranformar sua lista em uma stream".filter()
        "atende oque voce colocar dentro dos parentes
        EX: Eu vou querer somentes os elementos X tal que x.getID() == numID".
        (findFirst)E pega o primeiro. orElse(null) Se tentar buscar o primeiro e nao existir retorna null */

        if (fun == null) {
            System.out.println("This ID does not exist!");
            System.out.println();
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            fun.increaseSalary(percent);
            System.out.println();
        }

        for (Employee e : employee) { //MOSTRA A LISTA
            System.out.print(e);
        }

        sc.close();
    }
}
