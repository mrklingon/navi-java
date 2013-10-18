//Master UTA Dictionary class

package udict;
import java.io.*;

public class uDict {
	static String[] language ={
	"", "",
	}; 

    // send out message that we loaded the language
    public void main(String[] args){
	int wcount = this.language.length/2;
	System.out.println ("Language contains " + wcount + " words.");
    }


    // simple find out if the word is in the English half of the dictionary
    public  boolean isEng(String word){
	boolean found = false;
	for (int i=0; i < this.language.length;){
	    String gal = this.language[i++];
	    String eng = this.language[i++];
	    if ( eng.equalsIgnoreCase(word)){
		found = true;
	    }
	}
	return found;
    }

    // Return the English meaning if word is Galactic
    public  String toEng(String word){
	String  found = "";
	for (int i=0; i < this.language.length;){
	    String gal = this.language[i++];
	    String eng = this.language[i++];
	    if ( gal.equalsIgnoreCase(word)){
		found = eng;
		i = this.language.length; //quit checking.
	    }
	}
	return found;
    }

    // simple find out if the word is in the Galactic half of the dictionary
    public  boolean isGal(String word){
	boolean found = false;
	for (int i=0; i < this.language.length;){
	    String gal = this.language[i++];
	    String eng = this.language[i++];
	    if ( gal.equalsIgnoreCase(word)){
		found = true;
	    }
	}
	return found;
    }


    // Return the Galactic word if word is English
    public String toGal(String word){
	String  found = "";
	for (int i=0; i < this.language.length;){
	    String gal = this.language[i++];
	    String eng = this.language[i++];
	    if ( eng.equalsIgnoreCase(word)){
		found = gal;
		i = this.language.length; //quit checking.
	    }
	}
	return found;
    }

    // Return the Dictionary entry word if word found
    public String lookupGal(String word){
	String  found = "";
	for (int i=0; i < this.language.length;){
	    String gal = this.language[i++];
	    String gals = gal.toLowerCase();
	    String eng = this.language[i++];
	    String engs = eng.toLowerCase();
	    if (( engs.indexOf(word.toLowerCase()) >= 0)||
		( gals.indexOf(word.toLowerCase()) >= 0)){
		found = found + gal + " \n\t" + eng + "\n***\n\n"; ;
	    }
	}
	return found;
    }

    public String tranString(String inText) {

	// parse each word with English meaning

	String outText = "";
	
	// find each word.

	java.util.StringTokenizer st = new java.util.StringTokenizer(inText,"\",.<>?/;:`1234567890= \\~!@#$%^&*()_+|[]\n");
	while (st.hasMoreTokens()){

	    String word = st.nextToken();
	    outText = outText + "\n" + word + ":\n";

	    for (int i=0; i < this.language.length;){
		String gal = this.language[i++];
		String eng = this.language[i++];
		if ( word.indexOf(gal)>=0){
		    outText = outText + " " + gal + ":" + "\t" + eng + "\n";;
		}
	    }

	}
	return outText;
    }

}














