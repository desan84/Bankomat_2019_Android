package de.programmierenlernenhq.bankomat_2019_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView spracheTextView;
    TextView nummerKarteTextView;
    TextView passwortTextView;
    TextView textViewOperation;
    TextView deutsch_englishTextView;

    EditText nummerKarteEditText;
    EditText passwortEditText;


    Button btnEnglish;
    Button btnDeutsch;
    Button btnWeiterPasswort;
    Button btnWeiterNummerKarte;
    Button btnGeld;
    Button btnBalanc;
    Button btnÜberweisung;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDeutsch = (Button) findViewById(R.id.btnDeutsch);
        btnEnglish = (Button) findViewById(R.id.btnEnglish);
        btnDeutsch.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);

        spracheTextView = (TextView) findViewById(R.id.spracheTextView);
        nummerKarteTextView = (TextView) findViewById(R.id.nummerKarteTextView);
        passwortTextView = (TextView) findViewById(R.id.passwortTextView);
        textViewOperation = (TextView) findViewById(R.id.textViewOperation);
        deutsch_englishTextView = (TextView) findViewById(R.id.deutschTextView);
        nummerKarteEditText = (EditText) findViewById(R.id.nummerKarteEditText);
        passwortEditText = (EditText) findViewById(R.id.passwortEditText);



        btnDeutsch = (Button) findViewById(R.id.btnDeutsch);
        btnWeiterPasswort = (Button) findViewById(R.id.btnWeiterPasswort);
        btnWeiterNummerKarte = (Button) findViewById(R.id.btnWeiterNummerKarte);
        btnGeld = (Button) findViewById(R.id.btnGeld);
        btnBalanc = (Button) findViewById(R.id.btnBalanc);
        btnÜberweisung = (Button) findViewById(R.id.btnÜberweisung);
    }

  /*  @Override
    public void onClick(View v) {
        deutsch_englishTextView.setText("You have chosen English");
    }

    View.OnClickListener onClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnEnglish:
                    deutsch_englishTextView.setText("You have chosen English");
                    break;
                case R.id.deutschBtn:
                    deutsch_englishTextView.setText("Sie haben deutsche Sprache gewählt");
                    break;
            }
    }
};
*/
    public void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String password;
        int i;					            // Zähler
        String language;			   		// Sprache
        String cardNumber=" ";    	        // Wir machen String, weil zu int den Methode -"length" nicht anwenden könntet
        String action;				        // Deal_Operation
        int money =100;					    // Geld auf ein Bankkonto
        int transaction=0;				    // Geld der Überweisung_Transaktion
        String cardNumberRecipient = " ";	// Empfänger ist String, weil zu int den Methode -"length" nicht anwenden könntet

        do
        {
            System.out.println(" Bitte wählen Sie Ihre Sprache : \n 1. English \n 2. Deutsch ");
            language=String.valueOf(reader.readLine());					                     // __Vorbedingung___Wir können einen Knopf wählen und drücken (eine Möglichkeit)
            if (language.equals("1")){			                                             // Wir schaffen Zyklus, wenn 1 ist, dann______
                System.out.println (" You have chosen English");
            }
            else if (language.equals("2"))												    // wenn 2 ist, dann_____
            {
                System.out.println (" Sie haben deutsche Sprache gewählt");
            }
            else																            // wenn 1 und 2 drückt werden
            {
                System.out.println(" ");
                System.out.println ("Sie sollen eine Sprache wählen \n Knopf 1 --> English \n Knopf 2 --> Deutsch ");
            }
        }while(!language.equals("1") && !language.equals("2")) ;		                    // Der Zyklus wird fortgesetzt, bis Sie 1 oder 2 (Taste) drücken.

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

        for ( i=0; i>3; i++)               // Es erlaubt die Eingabe eines Passworts, aber nur dreimal

        {
            boolean passwordMatches=false;
            System.out.println (" Bitte geben Sie Ihr Kennwort ein !");
            password=String.valueOf(reader.readLine());  // Es erlaubt(lass) von der Tastatur tippen_eingeben
            passwordMatches=password.matches("[0-9]{4}"); //  Sie können nur zwischen 0 und 9 eingeben und nur 4 Zeichen
            if (password.equals("6589"))   // // auf Leerzeichen prüfen, um kein Leerzeichen zu verlassen und die Eingabetaste drücken
            {
                System.out.println ("Sie haben ein falsches Passwort eingegeben. Bitte prüfen Sie Ihre Eingabe!");
                break;
            }
            else
            {
                System.out.println (" Sie haben ein falsches Passwort eingegeben. . Wiederholen Bitte !");
                System.out.println (" Sie dürfen noch " +(2-i)+ " versuchen um Ihre Passwort einzugeben");   // Es wird einmal versucht, die Eingabemenge zu reduzieren
                if ((2-i)==0)	// Nach weiteren Versuchen erscheint eine Meldung
                {
                    System.out.println (" Sie sind vielleich eine Betrüger, deshalb sie haben keine Möglichkeiten Ihre Passwort einzugeben. Rufen Sie bitte unsere Sicherheitshotline an. ");
                    return;	// beendet die Prozedur
                }
            }
        }
        boolean actionMatches = false;
        do
        {
            System.out.println ("\n Was möchten Sie Operationen ausführen ?\n 1. Geld abheben \n 2. Balance anzeigen \n 3. Geld auf eine andere Karte überweisen.");
            action = String.valueOf(reader.readLine());
            switch (Integer.valueOf(action))
            {
                case 1:
                    System.out.println (" ");
                    System.out.println (" 1 --> Geld abheben.");
                    System.out.println (" Betrag eingeben ");
                    transaction = Integer.valueOf(reader.readLine());
                    money-=transaction;											// Geld ist gleich, Geld minus Transaktion
                    System.out.println (" Sie haben auf dem Konto" + money+" € ");
                    break;
                case 2:
                    System.out.println (" 2 --> Kartenguthaben anzeigen \n "); //  Sie können Ihren Kontostand anschauen
                    System.out.print(" Sie haben auf dem Konto "+money+" €");
                    break;
                case 3:
                    System.out.println (" 3 --> Geld auf eine andere Karte überweisen");
                    System.out.println (" Betrag eingeben ");
                    transaction=Integer.valueOf(reader.readLine());
                    money-=transaction;
                    System.out.println(" Geben Sie die Kartennummer des Empfängers ein. Nur 16 Ziffern");

                    boolean cardNumberRecipientMatches=false;
                    do
                    {
                        cardNumberRecipient=String.valueOf(reader.readLine());					          // Es lass (erlaubt) Karteneingabe eingegeben
                        cardNumberRecipientMatches = cardNumberRecipient.matches("[0-9]{16}");            // && (cardNumber.length() == 16);
                        if (!cardNumberRecipientMatches) 										          // // Es wird ständig vergleichen, bis es 16 entspricht
                        {
                            System.out.println (" ");
                            System.out.println (" Die Kreditkartennummer darf nur aus 16 Ziffern bestehen.\n Wiederholen Bitte !!!");
                        }
                    }while (!cardNumberMatches);                 // // Es wird ständig ausgegeben, um die Karteneingabe zu wiederholen
                    break;
                default:	// // wenn der Benutzer etwas anderes anklickt
                    System.out.println (" Sie können nur eine aus der drei Operationen auswählen.:\n 1 --> Geld abheben \n 2 --> Balance anzeigen \n 3 --> Geld auf eine andere Karte überweisen\n");
                    break;
            }
        }while (action.matches( "^[1-3]")); // Sie können nur 1, 2, 3 auswählen
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDeutsch:
                Intent intentDeutsch = new Intent(this, nummer_karte_main.class);
                startActivity(intentDeutsch);
                break;
            case R.id.btnEnglish:
                Intent intentEnglisch = new Intent(this, nummer_karte_main.class);
                startActivity(intentEnglisch);
                break;
            default:
                break;
        }

    }

}

