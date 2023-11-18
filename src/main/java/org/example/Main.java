package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        doubleLinkedList list = null;

        Scanner input = new Scanner(System.in);
        String command = "i";
        while(!command.equals("o")) {
            System.out.println("digite seu comando:");
            command = input.nextLine();

            if (command.startsWith(":e")) {
                try {
                    String[] commandContent = command.split(" ");

                    list = fileOperations.transferFileDataToDoubleLinkedList(commandContent[1]);
                }catch (FileNotFoundException e){
                    System.out.println("Epa! Arquivo nao encontrado. tente novamente\n");
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Epa digite um arquivo por favor\n");
                }
            }

            if (command.startsWith(":w")) {
                String[] commandContent = command.split(" ");

                    if(list == null){
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    }else {
                        System.out.println("transferindo conteudo da lista encadeada para o arquivo: " + commandContent[1]);

                        list.transferDataToFile(commandContent[1]);
                    }
            }
            if (command.startsWith(":x")) {
                String[] commandContent = command.split(" ");
                if(list == null){
                    System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                }else {
                    list.remove(Integer.parseInt(commandContent[1]));

                    System.out.println("Lista atual e"+list.toString());
                }
            }
            if (command.startsWith(":xG")) {
                String[] commandContent = command.split(" ");
                if(list == null){
                    System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                }else {
                    int length = list.getCount();
                    for (int i = Integer.parseInt(commandContent[1]); i <= length; i++) {
                        list.remove(i);
                    }

                    System.out.println("Lista atual e"+list.toString());
                }
            }
            if (command.startsWith(":XG")) {
                String[] commandContent = command.split(" ");
                if(list == null){
                    System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                }else {
                    int length = list.getCount();
                    for (int i = 0; i <= Integer.parseInt(commandContent[1]); i++) {
                        list.remove(i);
                    }

                    System.out.println("Lista atual e"+list.toString());
                }
            }
            if (command.startsWith(":s")) {
                if (list == null) {
                    System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                } else {
                    Node current = list.getHead();
                    int i =1;
                    do {
                        for (int j = 1; j <= 10; j++) {

                            System.out.println(i + ". " + current.getData());
                            current = current.getRight();
                            if(current == list.getHead()){break;}
                            i++;
                        }
                        System.out.println("\n");
                    }
                    while (current != list.getHead());
                }
            }
        }
        System.out.println("\nObrigado por usar nosso programa :)\n");
    }
}