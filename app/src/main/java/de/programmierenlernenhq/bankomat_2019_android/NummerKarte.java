package de.programmierenlernenhq.bankomat_2019_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NummerKarte extends AppCompatActivity {


    TextView nummerKarteTextView;
    EditText nummerKarteEditText;
    TextView deutsch_englishTextView;

    Button btnWeiterNummerKarte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        nummerKarteTextView = (TextView) findViewById(R.id.nummerKarteTextView);
        nummerKarteEditText = (EditText) findViewById(R.id.nummerKarteEditText);


        deutsch_englishTextView = (TextView) findViewById(R.id.deutschTextView);

        super.onCreate(savedInstanceState);

        btnWeiterNummerKarte = (Button) findViewById(R.id.btnWeiterNummerKarte);

        setContentView(R.layout.activity_nummerKarte);
        String laguage = getIntent().getExtras().getString("languages");

        do
        {
            if (language.equals("1")){
                System.out.println ("");
                System.out.println (" Enter the card number. Only 16 digits");
            }
            else if (language.equals("2"))												    // wenn 2 ist, dann_____
            {
                System.out.println ("");
                System.out.println(" Ausfüllen_Drücken Nummer die Karte. Nur 16 Ziffern");
            }
        }while(!language.equals("1") && !language.equals("2")) ;		                    // Der Zyklus wird fortgesetzt, bis Sie 1 oder 2 (Taste) drücken.

        //  System.out.println ("");
        //  System.out.println(" Ausfüllen_Drücken Nummer die Karte. Nur 16 Ziffern");

        boolean cardNumberMatches = false;	                                   // wir gehen sofort als wahr, deshalb setzen wir falsch (false)

        do
        {
            cardNumber=String.valueOf(reader.readLine());					 // Es ermöglicht die Eingabe (einer Kartennummer eingeben_eintippen)
            cardNumberMatches = cardNumber.matches("[0-9]{16}");             // && (cardNumber.length() == 16);
            if (!cardNumberMatches) 										 //  Es wird ständig vergleichen, bis es 16 entspricht
            {
                System.out.println (" ");
                System.out.println (" Die Kreditkartennummer darf nur aus 16 Ziffern bestehen.\n Wiederholen Bitte !!! ");
            }
        }while (!cardNumberMatches);         //  Es wird ständig ausgegeben, um die Karteneingabe zu wiederholen


    }

}
