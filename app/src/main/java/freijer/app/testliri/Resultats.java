package freijer.app.testliri;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;

public class Resultats extends AppCompatActivity {

    ProgressBar progressBar, progressBar2, progressBar3;
    ProgressBar progressBar_ideal_1, progressBar_ideal_2, progressBar_ideal_3;
    TextView score_1, score_2, score_3, text_1, text_2, text_3;
    TextView score_ideal_1, score_ideal_2, score_ideal_3, text_ideal_1, text_ideal_2, text_ideal_3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);

            score_1 = findViewById(R.id.score_1);
            score_2 = findViewById(R.id.score_2);
            score_3 = findViewById(R.id.score_3);

                text_1 = findViewById(R.id.text_1);
                text_2 = findViewById(R.id.text_2);
                text_3 = findViewById(R.id.text_3);

        progressBar_ideal_1 = findViewById(R.id.progressBar_ideal_1);
        progressBar_ideal_2 = findViewById(R.id.progressBar_ideal_2);
        progressBar_ideal_3 = findViewById(R.id.progressBar_ideal_3);

            score_ideal_1 = findViewById(R.id.score_ideal_1);
            score_ideal_2 = findViewById(R.id.score_ideal_2);
            score_ideal_3 = findViewById(R.id.score_ideal_3);

                text_ideal_1 = findViewById(R.id. text_ideal_1);
                text_ideal_2 = findViewById(R.id. text_ideal_2);
                text_ideal_2 = findViewById(R.id. text_ideal_3);

        progressBar.setMax(10);
        progressBar2.setMax(10);
            progressBar_ideal_1.setMax(10);
            progressBar_ideal_2.setMax(10);

        TextReal();
        TextIdeal();
        TextOnButtons();
    }

    public void TextReal() {
        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        String sizeMeet = (arguments.get("real_meat")).toString();
        int sizee = Integer.parseInt(sizeMeet);

            Bundle arguments2 = getIntent().getExtras();
            assert arguments2 != null;
            String sizeVegan = (arguments2.get("real_vegan")).toString();
            int sizee2 = Integer.parseInt(sizeVegan);

            progressBar.setProgress(sizee);
            score_1.setText(sizeMeet + " /10");
                progressBar2.setProgress(sizee2);
                score_1.setText(sizeVegan + " /10");
    }

    public void TextIdeal() {
        Bundle argumentsIdealmets = getIntent().getExtras();
        assert argumentsIdealmets != null;
            String sizeIdealMeat = (argumentsIdealmets.get("ideal_meat")).toString();
            int sizeIdealm = Integer.parseInt(sizeIdealMeat);

            Bundle argumentsIdealVegan = getIntent().getExtras();
            assert argumentsIdealVegan != null;
                String sizeVeganIdeal = (argumentsIdealVegan.get("ideal_vegan")).toString();
                int sizeIdealv = Integer.parseInt(sizeVeganIdeal);

                progressBar_ideal_1.setProgress(sizeIdealm);
                score_ideal_1.setText(sizeIdealMeat+ " /10");
                    progressBar_ideal_2.setProgress(sizeIdealv);
                    score_ideal_1.setText(sizeVeganIdeal+ " /10");


    }


    public void Open_1st_text(View v){
        androidx.appcompat.app.AlertDialog.Builder dialog = new androidx.appcompat.app.AlertDialog.Builder(this);
        dialog.setTitle("Первый параметр");
        dialog.setMessage(" Я видел любопытный сон.\n" +
                "    Ствол дерева был расщеплен.\n" +
                "    Такою складкой шла кора,\n" +
                "    Что мне понравилась дыра.\n" +
                "   \n" +
                "    Старуха\n" +
                "   \n" +
                "    Любезник с конскою ногой,\n" +
                "    Вы - волокита продувной.\n" +
                "    Готовьте подходящий кол,\n" +
                "    Чтоб залечить дуплистый ствол. ");

        LayoutInflater inflayter = LayoutInflater.from(this);
        View sign_window = inflayter.inflate(R.layout.first_paran, null);
        dialog.setView(sign_window);

        dialog.setNegativeButton("Ок", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();
    }

    public void TextOnButtons(){
        int a1 = 2;
        if (a1 > 1 && a1 < 6){
            text_1.setText(" Это проба ОДИН ТОПОЛЬ");
            text_2.setText(" Это проба ДВА ОВСА");
            text_3.setText(" Это проба ТРИ КОТА ");
        } else if(a1 > 7 && a1 < 10){
            text_1.setText(" Это проба ДВА ");
            text_2.setText(" Это проба ДВА ");
            text_3.setText(" Это проба ДВА ");
        } else {
            text_1.setText(" Это проба ТРИ ");
            text_2.setText(" Это проба ТРИ ");
            text_2.setText(" Это проба ТРИ ");
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения на главный жкран?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //SomeActivity - имя класса Activity для которой переопределяем onBackPressed();

                        Intent intent = new Intent(Resultats.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }).create().show();
    } //переназнчание кнопки назад

}


