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

            if (command.startsWith("e")) {
                try {
                    String[] commandContent = command.split(" ");

                    list = fileOperations.transferFileDataToDoubleLinkedList(commandContent[1]);
                }catch (FileNotFoundException e){
                    System.out.println("Epa! Arquivo nao encontrado. tente novamente\n");
                }
            }

            if (command.startsWith("w")) {
                String[] commandContent = command.split(" ");

                    if(list == null){
                        System.out.println("Lista ainda nao foi criada utilize o comando (e) primeiro\n");
                    }else {
                        System.out.println("transferindo conteudo da lista encadeada para o arquivo: " + commandContent[1]);

                        list.transferDataToFile(commandContent[1]);
                    }
            }
        }
        System.out.println("\nObrigado por usar nosso programa :)\n");
    }
}