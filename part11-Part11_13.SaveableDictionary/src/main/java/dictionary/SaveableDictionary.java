/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author ensia
 */
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String fileName;

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.fileName = file;
    }
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }

    public boolean load() {
        try (Scanner scan = new Scanner(Paths.get(this.fileName))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String part[] = line.split(":");
                this.add(part[0], part[1]);
            }
        } catch (IOException exe) {
            System.out.println("Error: " + exe.getMessage());
            return false;
        }
        return true;
    }

    public void add(String words, String translation) {

        this.dictionary.putIfAbsent(words, translation);
    }
    
    public boolean save() {
        try(PrintWriter write = new PrintWriter(this.fileName)){
            for(String key : this.dictionary.keySet())
            write.println(key + ":" + this.dictionary.get(key));
           
        }catch(Exception exe) {
            System.out.println(exe.getMessage());
            return false;
        }
        return true;
    }

    public String translate(String word) {
        String translation = null;

        if (this.dictionary.containsKey(word)) {
            translation = this.dictionary.get(word);
        }

        if (this.dictionary.containsValue(word)) {
            for (String words : this.dictionary.keySet()) {
                if (this.dictionary.get(words).contains(word)) {
                    translation = words;
                }
            }
        }
        return translation;
    }

    public void delete(String word) {
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        }
        if (this.dictionary.containsValue(word)) {
            String deleteKey = null;
            for (String key : this.dictionary.keySet()) {
                if (this.dictionary.get(key).contains(word)) {
                    deleteKey = key;
                }
            }
            this.dictionary.remove(deleteKey, word);
        }
    }
}
