package de.programmierenlernenhq.bankomat_2019_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Operation extends AppCompatActivity {

    Button btnGeld;
    Button btnBalanc;
    Button btnÜberweisung;
    TextView textViewOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnGeld = (Button) findViewById(R.id.btnGeld);
        btnBalanc = (Button) findViewById(R.id.btnBalanc);
        btnÜberweisung = (Button) findViewById(R.id.btnÜberweisung);
        textViewOperation = (TextView) findViewById(R.id.textViewOperation);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

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
}
