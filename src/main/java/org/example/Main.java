package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
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
                    System.out.println("Criando Lista\n");
                    list.print();
                    System.out.println("\nLista criada :)\n");
                }catch (FileNotFoundException e){
                    System.out.println("Epa! Arquivo nao encontrado. tente novamente\n");
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Epa digite um arquivo por favor\n");
                }
            }

            if (command.startsWith(":w")) {
                try {
                    String[] commandContent = command.split(" ");

                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {
                        System.out.println("transferindo conteudo da lista encadeada para o arquivo: " + commandContent[1]);

                        list.transferDataToFile(commandContent[1]);
                    }
                }catch (ArrayIndexOutOfBoundsException exception){
                    System.out.println("Epa! informe o arquivo em que deseja escrever\n");
                }
            }
            if (command.startsWith(":x")) {
                try {
                    String[] commandContent = command.split(" ");
                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {
                        list.remove(Integer.parseInt(commandContent[1]));

                        System.out.println("Lista atual : \n");
                        list.reList();
                        list.print();
                    }
                }catch (Exception exception){
                    System.out.println("Epa algo deu errado tente novamente\n");
                }
            }
            if (command.startsWith(":xG")) {
                try {
                    String[] commandContent = command.split(" ");
                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {
                        int length = list.getCount();
                        for (int i = Integer.parseInt(commandContent[1]); i <= length + 1; i++) {
                            list.remove(i);
                        }

                        System.out.println("Lista atual : \n");
                        list.print();
                    }
                }catch (Exception exception){
                    System.out.println("Epa algo deu errado tente novamente\n");
                }
            }
            if (command.startsWith(":XG")) {
                try {
                    String[] commandContent = command.split(" ");
                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {

                        for (int i = 1; i <= Integer.parseInt(commandContent[1]); i++) {
                            list.remove(i);
                        }

                        System.out.println("Lista atual : \n");
                        list.reList();
                        list.print();
                    }
                }catch (Exception exception){
                    System.out.println("Epa algo deu errado tente novamente\n");
                }
            }
            if (command.startsWith(":s")) {
                try {
                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {
                        Node current = list.getHead();
                        int i = 1;
                        do {
                            for (int j = 1; j <= 10; j++) {

                                System.out.println(i + ". " + current.getData());
                                current = current.getRight();
                                if (current == list.getHead()) {
                                    break;
                                }
                                i++;
                            }
                            System.out.println("\n");
                        }
                        while (current != list.getHead());
                    }
                }catch (Exception exception){
                    System.out.println("Epa algo deu errado tente novamente\n");
                }
            }
            if (command.startsWith(":/")) {
                try {
                    String[] commandContent = command.split(" ");
                    if (list == null) {
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    } else {
                        String element = commandContent[1];
                        if(commandContent.length == 2){
                        System.out.println("Procurando pelo elemento: " + element);
                        Node current = list.getHead();
                        int line = 1;
                        int found = 0;
                        do {
                            if (Objects.equals(current.getData(), element)) {
                                System.out.println(line + ". " + current.getData());
                                found = 1;
                            }
                            current = current.getRight();
                            line++;
                        } while (current != list.getHead());
                        if (current == list.getHead() && found == 0) {
                            System.out.println(element + " nao encontrado");
                        }
                    }if (commandContent.length == 3){
                            String elem = commandContent[1];
                            String elemTroca = commandContent[2];
                            System.out.println("Procurando pelo elemento: " + elem + " para substituir por: " + elemTroca);
                            Node current = list.getHead();
                            int line = 1;
                            do {
                                if (Objects.equals(current.getData(), elem)){
                                    current.setData(current.getData().replace(elem, elemTroca));
                                    System.out.println("Elemento substituído na linha " + line + ". " + current.getData());
                                }
                                current = current.getRight();
                                line++;
                            } while (current != list.getHead());
                        }

                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Epa algo deu errado tente novamente por favor\n");
                }
            }
        }
        System.out.println("\nObrigado por usar nosso programa :)\n");
    }
}