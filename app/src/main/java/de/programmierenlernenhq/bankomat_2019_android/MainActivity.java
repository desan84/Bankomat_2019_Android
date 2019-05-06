package de.programmierenlernenhq.bankomat_2019_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView spracheTextView;
    Button btnEnglish;
    Button btnDeutsch;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDeutsch = (Button) findViewById(R.id.btnDeutsch);
        btnEnglish = (Button) findViewById(R.id.btnEnglish);
        btnDeutsch.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);

        spracheTextView = (TextView) findViewById(R.id.spracheTextView);

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDeutsch:
                Intent intentDeutsch = new Intent(this, NummerKarte.class);
                intentDeutsch.putExtra("language","DE");
                startActivity(intentDeutsch);
                break;
            case R.id.btnEnglish:
                Intent intentEnglisch = new Intent(this, NummerKarte.class);
                intentEnglisch.putExtra("language","EN");
                startActivity(intentEnglisch);
                break;
            default:
                break;
        }

    }



}

