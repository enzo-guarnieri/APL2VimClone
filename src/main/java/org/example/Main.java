package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
    	// list is the principal area for writing 
    	// unmodifiedList is just the fist instance of the text (for the command :q! basically)
    	// transferArea is a list for tranfer data (like commands :v, :y, :c, :p, etc.)
        doubleLinkedList list = null;
        doubleLinkedList unmodifiedList = null;
        doubleLinkedList transferArea = null;

        Scanner input = new Scanner(System.in);
        String command = "i";
        
        while(!command.equals("o")) {
            System.out.println("digite seu comando:");
            command = input.nextLine();

            if (command.startsWith(":e")) {
                try {
                    String[] commandContent = command.split(" ");
                    if(commandContent.length != 1) {
                    	System.out.println("Numero de argumentos diferente do que esperado, utilize o comando \":help \" para mais informações ");
                    	break;
                    }

                    list = fileOperations.transferFileDataToDoubleLinkedList(commandContent[1]);
                }catch (FileNotFoundException e){
                    System.out.println("Epa! Arquivo nao encontrado. tente novamente\n");
                }
            }

            if (command.startsWith(":w")) {
                String[] commandContent = command.split(" ");
                if(commandContent.length != 1) {
                	System.out.println("Numero de argumentos diferente do que esperado, utilize o comando \":help \" para mais informações ");
                	break;
                }

                    if(list == null){
                        System.out.println("Lista ainda nao foi criada utilize o comando (:e) primeiro\n");
                    }else {
                        System.out.println("transferindo conteudo da lista encadeada para o arquivo: " + commandContent[1]);

                        list.transferDataToFile(commandContent[1]);
                    }
            }
        }
        input.close();
        System.out.println("\nObrigado por usar nosso programa :)\n");
    }
}
