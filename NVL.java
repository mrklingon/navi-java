import java.awt.*;

import udict.uDict;
import udict.uDNVlang;


public class NVL extends java.applet.Applet {
    static uDict GALang = new uDNVlang();
    TextArea InText = new TextArea("",1,80,1);
    Button GalBt = new Button ("Lookup");
    Button CLRBt = new Button ("Clear Input");
    TextArea OutText = new TextArea("",10,80,1);
    GridBagConstraints constraints = new GridBagConstraints(  );

    public void init () {
	setLayout(new GridBagLayout());
	addGB(InText,1,0);
	InText.setText("Hello");
	addGB(GalBt,2,0);
	addGB(CLRBt,2,2);
	addGB(OutText,1,1);
	OutText.setText("");
	OutText.setEditable(false);
    }

    public boolean action (Event evt, Object arg) {
	if (evt.target instanceof Button) {
	    String lab1 = (String)arg;

	    if (lab1.equals("Lookup")) {
		String inbound =InText.getText();
		if (inbound.length() < 3){
		    OutText.setText("ghobe'!  \n\tThree letters or more!\n\nghobe'!  \n\tThree letters or more!\n\n");
		}else{
		    OutText.setText(GALang.lookupGal(InText.getText()));
		}
	    }

	    if (lab1.equals("Clear Input")) {
			InText.setText("");
		}


	}
    return true;
    }

    // translate a full string
    public static String tranString(String inText) {
	String outText = "";
	java.util.StringTokenizer st = new java.util.StringTokenizer(inText,"\",.<>?/;:`1234567890= \\~!@#$%^&*()_+|[]");
	while (st.hasMoreTokens()){
	    String word = st.nextToken();
	    if (GALang.isGal(word)){
		outText = outText + " " + GALang.toEng(word);
	    }else {
		if (GALang.isEng(word)){
		    outText = outText + " " + GALang.toGal(word);
		}else{
		    outText = outText + " [" + word + "]";
		}
	    }
	}
	return outText;
    }
    void addGB(Component component, int x, int y) {
	constraints.gridx = x;
	constraints.gridy = y;
	add(component, constraints);
    }

}
