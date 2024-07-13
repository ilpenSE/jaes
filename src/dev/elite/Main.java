package dev.elite;

import java.util.Scanner;
import static dev.elite.AESKeyGenerator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("JAVA AES EXAMPLE");
        System.out.println("PLEASE SELECT AN OPERATION: ");
        System.out.println("1: ENCRYPT\n2: DECRYPT");
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        if (operation.isEmpty() || operation.isBlank()) {
            System.out.println("[ERROR] Operation was not provided");
            return;
        }
        String clientId = "user123";
        if (operation.equals("1")) {
            System.out.println("Type a text to hash: ");
            String txt = sc.nextLine();
            System.out.println("ENCRYPTED TEXT: " +
                    AES.encrypt(txt, generateKeyFromSample(clientId), generateIvFromSample(clientId)));
        } else if (operation.equals("2")) {
            System.out.println("Type your hash: ");
            String hash = sc.nextLine();
            System.out.println("PLAIN TEXT: " +
                    AES.decrypt(hash, generateKeyFromSample(clientId), generateIvFromSample(clientId)));
        } else {
            System.out.println("[ERROR] Please enter a valid number");
        }

    }
}
