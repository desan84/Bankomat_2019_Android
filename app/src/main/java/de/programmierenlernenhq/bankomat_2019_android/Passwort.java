package de.programmierenlernenhq.bankomat_2019_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Passwort extends AppCompatActivity {

    Button btnWeiterPasswort;
    EditText passwortEditText;
    TextView passwortTextView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        btnWeiterPasswort = (Button) findViewById(R.id.btnWeiterPasswort);
        passwortEditText = (EditText) findViewById(R.id.passwortEditText);
        passwortTextView = (TextView) findViewById(R.id.passwortTextView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwot);


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
    }
}
