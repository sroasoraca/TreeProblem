/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian Roa S
 */
public class Tree {

    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void inputData() {

        Scanner input = new Scanner(System.in);
        String TipoConsulta;
        List<String> operation = new ArrayList<String>();
        operation.add("0");

        System.out.println("Ingrese la cantidad de casos: ");
        int amountCases = input.nextInt();
        input.nextLine();

        for (int i = 0; i < amountCases; i++) {

            System.out.println("Comandos : \n agregar X \n distancia X Y \n ancestro U V");
            System.out.println("Ingrese la cantidad de comandos a ejecutar");
            int amountCommands = input.nextInt();
            input.nextLine();

            for (int j = 0; j < amountCommands; j++) {

                System.out.println("Ingrese el comando que desea ejecutar");
                TipoConsulta = input.nextLine();
                
                String tipoConsultaArray[] = Split(TipoConsulta);

                switch (tipoConsultaArray[0]) {
                    case "agregar":
                        //Agrega el nodo

                        add(Integer.parseInt(tipoConsultaArray[1]));

                        break;
                    case "distancia":
                        //Mide la distancia entre dos nodos
                        break;
                    case "ancestro":
                        //Calcula el ancestro
                        break;
                    default:
                        System.out.println("Entrada no valida");
                        j--;
                        break;
                }
            }

        }
    }

    public String[] Split(String TipoConsulta) {

        String tipoConsultaArray[] = TipoConsulta.split(" ");
        return tipoConsultaArray;
    }

}
