/**
* @author  Dylan Madisetti
* @version 1.0, Nov 20, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.PrintWriter;

public class RPGPlayer{

    //  Init my scanner
    private Scanner file = new Scanner(System.in);
    private HashMap<String,Parser> Reflection = new HashMap<String, Parser>();
    private FileReader fileReader;
    private BufferedReader br;
    private Reflection reflection = new Reflection();
    public String name = "You should probably use getName() instead. Publics are bad mmkay?";

    // Pseudo generic/ reflection. It hurts my soul
    public class Parser{
        private Pattern pattern;
        private boolean isDouble;
        private boolean isInt;
        private String sValue;
        private double dValue;
        private int iValue;

        Parser(String regex, boolean doubled, boolean inted){
            pattern = Pattern.compile(regex);
            isDouble = doubled;
            isInt    = inted;
        }

        public void setInt(int number){
            iValue = number;
        }

        public void setDouble(double number){
            dValue = number;
        }


        public void setString(String line){
            sValue = line;
        }

        public double getDouble(){
            if(isDouble){
                return dValue;
            }
            return 0;
        }

        public String getString(){
            if(!isDouble){
                return sValue;
            }
            return "";
        }

        public int getInt(){
            if(isInt){
                return iValue;
            }
            return 0;
        }

        public boolean match(String line){
            Matcher match = pattern.matcher(line);
            if(match.matches()){
                if (isDouble){
                    dValue = Double.parseDouble(match.group(1));
                }else if(isInt){
                    iValue = Integer.parseInt(match.group(1));
                }else{
                    sValue = match.group(1);
                }
                return true;
            }
            return false;
        }
    }

    // Set up Hashmap for lookups
    // Ideally make this a class extending Hashmap instead of following hack 
    private class Reflection{
        private HashMap<String,Parser> reflect = new HashMap<String,Parser>();
        public Reflection(){
            // Set up attributes
            reflect.put("name",new Parser("^Name (.*)$",false,false));
            reflect.put("hp",new Parser("^HP (.*)$",false,true));
            reflect.put("strength",new Parser("^Strength (.*)$",false,true));
            reflect.put("speed",new Parser("^Speed (.*)$",true,false));
            reflect.put("weapon",new Parser("^Weapon (.*)$",false,false));
        }
        public Parser get(String key){
            return reflect.get(key);
        }
        public void set(String key,String value){
            reflect.get(key).setString(value);
        }
        public void set(String key,int value){
            reflect.get(key).setInt(value);
        }
        public void set(String key,Double value){
            reflect.get(key).setDouble(value);
        }
    }

    // Constructors are constructorful
    public RPGPlayer(String filename){
        readPlayerFile(filename);
    }

    public RPGPlayer(){
        this("Bob",100,1,1.0,"Thing");
    }

    public RPGPlayer(String name, int hp, int strength, double speed, String weapon){
        reflection.get("name").setString(name);
        reflection.get("hp").setInt(hp);
        reflection.get("strength").setInt(strength);
        reflection.get("speed").setDouble(speed);
        reflection.get("weapon").setString(weapon);
    }

    // Read player file
    private void readPlayerFile(String filename){
        try {
            fileReader = new FileReader(new File(filename));
            br = new BufferedReader(fileReader);
            String line = null;
            String lookup;
            // if no more lines the readLine() returns null
            while ((line = br.readLine()) != null) {
                lookup = line.split(" ")[0].toLowerCase();
                Reflection.get(lookup).match(line);
            }
        } catch (IOException ex) {
            return;
        }
    }

    // Spit out details
    private String getDeets(){
        return "Name " + reflection.get("name").getString() +
        "\nHP " + reflection.get("hp").getInt() +
        "\nStrength " + reflection.get("strength").getInt() +
        "\nSpeed " + reflection.get("speed").getDouble() +
        "\nWeapon " + reflection.get("weapon").getString();
    }

    // Write details to file
    public void writePlayerFile(String file){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file, "UTF-8");
            writer.print(getDeets());
            writer.close();
        } catch (IOException ex) {
            // report
        }
    }

    // Print details
    public void printInfo(){
        System.out.print(getDeets());
    }

    // Setters
    public void setName(String value){
        reflection.set("name",value); 
    }
    public void setHP(int value){
        reflection.set("hp",value); 
    }
    public void setStrength(int value){
        reflection.set("strength",value); 
    }
    public void setSpeed(double value){
        reflection.set("speed",value); 
    }
    public void setWeapon(String value){
        reflection.set("weapon",value); 
    }

    // Getters
    public String getName(){
        return reflection.get("name").getString(); 
    }
    public int getHP(){
        return reflection.get("hp").getInt(); 
    }
    public int getStrength(){
        return reflection.get("strength").getInt(); 
    }
    public double getSpeed(){
        return reflection.get("speed").getDouble(); 
    }
    public String getWeapon(){
        return reflection.get("weapon").getString(); 
    }
}