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

    public Node inputData() {
        boolean existsU;
        boolean existsV;

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

                String inputArray[] = Split(TipoConsulta);
                
                switch (inputArray[0]) {
                    case "agregar":
                        //add the node

                        add(Integer.parseInt(inputArray[1]));

                        break;
                    case "distancia":
                        //calculate the distance between two nodes
                        existsU = containsNode(Integer.parseInt(inputArray[1]));
                        existsV = containsNode(Integer.parseInt(inputArray[2]));

                        System.out.println(inputArray[1] + " " + inputArray[2] + " " + root.value);

                        if (existsU && existsV) {
                            int ancestro = Ancestor(root, Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
                            int distance = distance(root, Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]), ancestro);
                            System.out.println("distancia : " + distance);
                        } else {
                            System.out.println("-1");
                        }
                        break;
                    case "ancestro":
                        //calculate the ancestor
                        existsU = containsNode(Integer.parseInt(inputArray[1]));
                        existsV = containsNode(Integer.parseInt(inputArray[2]));
                        
                        if (existsU && existsV) {
                            int ancestor = Ancestor(root, Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
                            System.out.println("ancestro : " + ancestor);
                        } else {
                            System.out.println("-1");
                        }

                        break;
                    default:
                        System.out.println("Entrada no valida");
                        j--;
                        break;
                }
            }

        }

        return root;
    }

    public String[] Split(String TipoConsulta) {

        String tipoConsultaArray[] = TipoConsulta.split(" ");
        return tipoConsultaArray;
    }

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

    public int distance(Node tree, int u, int v, int ancestor) {
        int distance = 0;

        while (tree.value != ancestor && tree != null) {
            if (ancestor > tree.value) {
                return distance(tree.right, u, v, ancestor);
            } else {
                return distance(tree.left, u, v, ancestor);
            }
        }

        int uNodes = containsNodeRecursive(tree, u, distance);
        int vNodes = containsNodeRecursive(tree, v, distance);
        distance = uNodes + vNodes;

        return distance;
    }

    public int Ancestor(Node tree, int u, int v) {
        int ancestor = 0;

        ancestor = lookUpAncestor(tree, u, v, tree.value);

        return ancestor;
    }

    public int lookUpAncestor(Node tree, int u, int v, int value) {
        value = tree.value;
        
        if (u > tree.value && v > tree.value) {
            value = lookUpAncestor(tree.right, u, v, value);
        } else if (u < tree.value && v < tree.value) {
            value = lookUpAncestor(tree.left, u, v, value);
        } else {
            return value;
        }

        return value;

    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    private int containsNodeRecursive(Node current, int value, int count) {
                
        if (current == null) {
            return count;
        }
        if (value < current.value) {
            count++;
            count = containsNodeRecursive(current.left, value, count);
            return count;
        } else if (value > current.value){
            count++;
            count = containsNodeRecursive(current.right, value, count);
            return count;
        }

        return count;
    }

}
