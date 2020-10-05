import java.lang.*;
import java.util.*;


public class DNA {

    String dnaseq; //creating dnaseq field to store dna string

    public static void codon2aa(String dna){ //creating codon2aa method -- this method a modified version of the method above

        Dictionary aa_dict = new Hashtable(); //instantiating the dictionary class

        //adding the key-value pairs for each codon and the amino acid it codes for to the aa_dict dictionary

        aa_dict.put("GCT","A"); aa_dict.put("GCC","A"); aa_dict.put("GCA","A"); aa_dict.put("GCG","A"); aa_dict.put("CGT","R"); aa_dict.put("CGC","R"); aa_dict.put("CGA","R"); aa_dict.put("CGC","R"); aa_dict.put("CGG","R");
        aa_dict.put("AGA","R"); aa_dict.put("AGG","R"); aa_dict.put("AAT","N"); aa_dict.put("AAC","N"); aa_dict.put("GAT","D"); aa_dict.put("GAC","D"); aa_dict.put("TGT","C"); aa_dict.put("TGC","C"); aa_dict.put("CAA","Q");
        aa_dict.put("CAG","Q"); aa_dict.put("GAA","E"); aa_dict.put("GAG","E"); aa_dict.put("GGT","G"); aa_dict.put("GGC","G"); aa_dict.put("GGA","G"); aa_dict.put("GGG","G"); aa_dict.put("CAT","H"); aa_dict.put("CAC","H"); aa_dict.put("ATG","M"); aa_dict.put("ATT","I"); aa_dict.put("ATC","I");
        aa_dict.put("ATA","I"); aa_dict.put("CTT","L"); aa_dict.put("CTC","L"); aa_dict.put("CTA","L"); aa_dict.put("CTG","L"); aa_dict.put("TTA","L"); aa_dict.put("TTG","L"); aa_dict.put("AAA","K"); aa_dict.put("AAG","K"); aa_dict.put("TTT","F");aa_dict.put("TTC","F"); aa_dict.put("CCT","P");
        aa_dict.put("CCC","P");aa_dict.put("CCA","P"); aa_dict.put("CCG","P"); aa_dict.put("TCT","S");aa_dict.put("TCC","S"); aa_dict.put("TCA","S"); aa_dict.put("TCG","S");aa_dict.put("AGT","S"); aa_dict.put("AGC","S"); aa_dict.put("ACT","T");aa_dict.put("ACC","T"); aa_dict.put("ACA","T");
        aa_dict.put("ACG","T");aa_dict.put("TGG","W"); aa_dict.put("TAT","Y"); aa_dict.put("TAC","Y");aa_dict.put("GTT","V"); aa_dict.put("GTC","V"); aa_dict.put("GTA","V");aa_dict.put("GTG","V"); aa_dict.put("TAA","*"); aa_dict.put("TGA","*");aa_dict.put("TAG","*");



        System.out.println("\nThe DNA sequence is:\n"+dna);
        
        //
        //The segment below will find orf1
        //

        int count = 0; //creating count variable
        String orf1 = ""; //creating empty orf1 string to store each codon
        for (int i = 0; i < dna.length();i++){ //for loop iterates through the length of the dna string
                if (count == 0) { //this if statement is needed so that the elif statement below isn't evaluated to true at count = 0
                    orf1 += dna.charAt(i); //appending the char at the specified index
                    count++; // incrementing count
                }
                else if (count%3 == 0){ //checking to see if count is divisible by 3 with remainder 0
                    if ((dna.length()-count) < 3){ //checking to see if there are less than 3 nucleotides after the previous codon
                        break; //breaking the loop if above is true
                    }
                    orf1 += " "; // adding a whitespace to the string to separate codons in the orf1 string
                    orf1 += dna.charAt(i); //adding nucleotide to orf1
                    count++; // incrementing count
                }

                else {
                    orf1 += dna.charAt(i); //adding nucleotide to orf1
                    count++; // incrementing count
                }
        }
        System.out.print("\nReading Frame #1 codons are:\n"+orf1+"\n"); //printing orf1 with appropriate messa
        
        //The segment below will determine the codons associated with orf1
        
        String codon = ""; //creating an empty codon string variable
        String aaChain1 = ""; //creating empty aaChain1 string variable
        for(int i = 0; i < orf1.length();i = i + 4){ //iterating the length of orf1 but incrementing i by 4 each time (to skip over the whitespace)
            codon += orf1.charAt(i); //appending char at index i to codon string (1st base of codon)
            codon += orf1.charAt(i+1); //appending char at index i+1 to codon string (2nd base of codon)
            codon += orf1.charAt(i+2); //appending char at index i+2 to codon string (3rd base of codon)

            aaChain1 += aa_dict.get(codon); //appending the returned value of the codon key in the aa_dict dictionary
            aaChain1 += "   "; //adding 3 spaces for formatting
            codon = ""; //reassigning an empty string to codon for future iterations

            }
        System.out.print(aaChain1); //printing aaChain1 below the orf1 codons
        
        //
        //The segment below will find orf2
        //
        
        count = 0; //reassigning count value to 0
        String orf2 = ""; //creating orf2 string
        for (int i = 1; i < dna.length();i++){ //for orf2, we are starting at i = 1
            if (count == 0) {
                orf2 += dna.charAt(i);
                count++;
            }
            else if (count%3 == 0){
                if ((dna.length()-count) < 3){
                    break;
                }
                orf2 += " ";
                orf2 += dna.charAt(i);;
                count++;
            }

            else {
                orf2 += dna.charAt(i);
                count++;
            }
        }
        System.out.print("\n\nReading Frame #2 codons are:\n"+orf2+"\n");

        //same process as aaChain1 loop

        String codon2 = "";
        String aaChain2 = "";
        for(int i = 0; i < orf2.length();i = i + 4){
            codon2 += orf2.charAt(i);
            codon2 += orf2.charAt(i+1);
            codon2 += orf2.charAt(i+2);

            aaChain2 += aa_dict.get(codon2);
            aaChain2 += "   ";
            codon2 = "";

        }
        System.out.print(aaChain2);
        
        //
        //The segment below will find orf3
        //

        count = 0; //reassigning count value to 0
        String orf3 = ""; //creating orf3 string
        for (int i = 2; i < dna.length();i++){ //for orf3, we are starting at i = 2
            if (count == 0) {
                orf3 += dna.charAt(i);
                count++;
            }
            else if (count%3 == 0){
                if ((dna.length()-count) < 3){
                    break;
                }
                orf3 += " ";
                orf3 += dna.charAt(i);;
                count++;
            }

            else {
                orf3 += dna.charAt(i);
                count++;
            }
        }
        System.out.print("\n\nReading Frame #3 codons are:\n"+orf3+"\n");

        //same process as aaChain1 loop

        String codon3 = "";
        String aaChain3 = "";
        for(int i = 0; i < orf3.length();i = i + 4){
            codon3 += orf3.charAt(i);
            codon3 += orf3.charAt(i+1);
            codon3 += orf3.charAt(i+2);

            aaChain3 += aa_dict.get(codon3);
            aaChain3 += "   ";
            codon3 = "";

        }
        System.out.print(aaChain3);

    }

}
