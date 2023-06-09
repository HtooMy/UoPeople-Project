package SpellChecker;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.JFileChooser;

public class SpellChecker {
    public static void main(String[] args) {
        try {
            // Reading the words.txt file
            Scanner filein = new Scanner(new File("/Users/htoomyataung/Desktop/words.txt"));

            // Creating the new dictionary data structure
            HashSet<String> hash = new HashSet<>();
            while (filein.hasNext()) {
                String tk = filein.next();

                // Adding works into dictionary from the file "words.txt"
                hash.add(tk.toLowerCase());
            }

            Scanner userFile = new Scanner(getInputFileNameFromUser());
            userFile.useDelimiter("[^a-zA-Z]+");

            while (userFile.hasNext()) {
                String two = userFile.next();
                String two1 = two.toLowerCase();
                if (!hash.contains(two1)) {
                    System.out.println(two1 + ":" + corrections(two1, hash));
                }
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }

    static TreeSet corrections(String badWord, HashSet dictionary) {
        TreeSet<String> tree = new TreeSet<>();

        // Deleting any one of the letters from the misspelled word, then check if exist
        // in the disctionary
        for (int i = 0; i < badWord.length(); i++) {
            String s = badWord.substring(0, i) + badWord.substring(i + 1);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }

        // Chaning any letter in the misspelled word to any other letter, then check if
        // exist in the disctionary
        for (int i = 0; i < badWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = badWord.substring(0, i) + ch + badWord.substring(i + 1);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }

        // Inserting any letter at any point in the misspelled word, them check if exist
        // in the dictionary
        for (int i = 0; i <= badWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = badWord.substring(0, i) + ch + badWord.substring(i);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }

        // Swapping any two neighboring characters in the misspelled word, then check if
        // exist in the dictionary
        for (int i = 0; i < badWord.length() - 1; i++) {
            String s = badWord.substring(0, i) + badWord.substring(i + 1, i + 2) + badWord.substring(i, i + 1)
                    + badWord.substring(i + 2);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }

        // Inserting a space at any point in the misspelled word (and check that both of
        // the words that are produced are in the dictionary
        for (int i = 1; i < badWord.length(); i++) {
            String stringInput = badWord.substring(0, i) + " " + badWord.substring(i);
            String tempString = "";

            // Breaking a string into tokens and add it to the tempWords
            StringTokenizer tempWords = new StringTokenizer(stringInput);

            // :ooping over all the words in the tempWords
            while (tempWords.hasMoreTokens()) {
                // Store each word in a tem string
                String stringWord1 = tempWords.nextToken();
                String stringWord2 = tempWords.nextToken();

                // Chech if temp words exist in dictinoary otherwise break
                if (dictionary.contains(stringWord1) && dictionary.contains(stringWord2)) {
                    tempString = stringWord1 + " " + stringWord2;
                } else {
                    break;
                }
                tree.add(tempString);
            }
        }

        if (tree.isEmpty()) {
            tree.add("no suggestions");
        }
        return tree;

    }

    /**
     * Lets the user select an input file using a standard file
     * selection dialog box. If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    }
}