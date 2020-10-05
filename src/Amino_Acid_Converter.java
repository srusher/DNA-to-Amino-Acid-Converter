import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class hwk3_1 {


    public static void main(String[] args){

        DNA codongen = new DNA(); // instantiating the DNA class in codongen

        Scanner scanner1 = new Scanner(System.in); // creating scanner class
        System.out.println("Please enter the file name of the DNA sequence: "); //prompting user for file name
        try {
            File myFile = new File(scanner1.nextLine()); //instantiating File class from the user's input
            Scanner scanner2 = new Scanner(myFile); //scanner is reading myFile
            while (scanner2.hasNextLine()){ //while loop is using scanner2 and hasNextLine() method to read through each line in the file, if there are no more lines, the loop terminates
                codongen.dnaseq = scanner2.nextLine();
            }
            scanner2.close(); //closing scanenr
        }
        catch (FileNotFoundException e) { //catch block is looking for the FileNotFoundException, it will display the appropriate error message if the exception occurs
            System.out.println("ERROR: The file you entered does not exist in the current directory.");
            e.printStackTrace();
        }

        codongen.codon2aa(codongen.dnaseq); //calling codon2aa() method from the DNA class, with the dnaseq field as the parameter


    }
}
