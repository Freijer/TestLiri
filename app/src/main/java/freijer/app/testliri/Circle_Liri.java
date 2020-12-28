package freijer.app.testliri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Circle_Liri extends AppCompatActivity {

    TextView viewText, meet, vegan;
    Button yes, no, start;

    Random ran;
    List<Integer> set_ofuseNumbers;
    List<Integer> LIST;
    List<Integer> answer_yes;
    List<Integer> answer_no;


    int yes_answer;
        public int getYes_answer() {
            return yes_answer;
        }
        public void setYes_answer(int yes_answer) {
            this.yes_answer = yes_answer;
        }
    int no_answer;
        public int getNo_answer() {
            return no_answer;
        }
        public void setNo_answer(int no_answer) {
            this.no_answer = no_answer;
        }



    private int count = 1;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    protected int randomNumber;
    public int getRandomNumber() {
        return randomNumber;
    }
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    DataHelper dbHelper = new DataHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle__liri);

        viewText = findViewById(R.id.viewText);
        start = findViewById(R.id.start);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        ran = new Random();
        LIST = new ArrayList<>();
        answer_yes = new ArrayList<>();
        answer_no = new ArrayList<>();

        answer_yes.removeAll(answer_yes);
        answer_no.removeAll(answer_no);
        Collections.addAll(LIST,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

                yes.setVisibility(View.GONE);
                no.setVisibility(View.GONE);

                dbHelper.DeleteDB(); //очистить БД
        dbHelper.insertWord(1,"Ты любишь рис?");
        dbHelper.insertWord(2,"Ты любишь курицу?");
        dbHelper.insertWord(3, "Ты любишь фасоль?");
        dbHelper.insertWord(4, "Ты любишь бекон?");
        dbHelper.insertWord(5, "Ты любишь стейки?");
        dbHelper.insertWord(6, "Ты любишь броколи?");
        dbHelper.insertWord(7, "Ты любишь сосиски?");
        dbHelper.insertWord(8, "Ты любишь соевый сыр?");
        dbHelper.insertWord(9, "Ты любишь колбасу?");
        dbHelper.insertWord(10, "Ты любишь еду без мяса?");
        dbHelper.insertWord(11, "Ты любишь бургеры?");
        dbHelper.insertWord(12, "Ты любишь рыбу?");

        setCount(12);
    }


    public void LetsPlay(View v){
        yes.setVisibility(View.VISIBLE);
        no.setVisibility(View.VISIBLE);
        start.setVisibility(View.GONE);
        AddToList();
        ReadDB_random(getRandomNumber());
//        ReadDB();
    }

    public void AddToList(){
        int sizeOfCollection = LIST.size();
        Random randomGenerator = new Random();
        int randomId = randomGenerator.nextInt(getCount());
            setRandomNumber(LIST.get(randomId));
            LIST.remove(randomId);
    }

    private void Next(){
        if (getCount() == 0 ){
            Toast.makeText(this, "Заполненно", Toast.LENGTH_SHORT).show();
            Results();
        } else {
            AddToList();
            Log.d("count", String.valueOf(getCount()));
            Log.d("seek", String.valueOf(set_ofuseNumbers)); //выводим в лог
            ReadDB_random(getRandomNumber()); // читать рандомную запись
        }
    }


    public void ReadDB_random(int come){
        dbHelper.ReadDB_numeric(come);
        viewText.setText(dbHelper.getValueQuest() + getRandomNumber());
    } // прочесть последнюю запись

    public void ReadDB(){
        dbHelper.ReadDB();
        viewText.setText(dbHelper.getValueQuest()+ getRandomNumber());
    } // прочесть последнюю запись

    public void Yes(View v){
        setCount(getCount()-1);
        switch (getRandomNumber()){
            case 2:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(2);
                break;
            case 4:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(4);
                break;
            case 5:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(5);
                break;
            case 7:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(7);
                break;
            case 9:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(9);
                break;
            case 11:
                setYes_answer(getYes_answer()+1);
                answer_yes.add(11);
                break;
        }
        Log.d("listersListYES",String.valueOf(answer_yes));
        Log.d("listersListYesSize",String.valueOf(answer_yes.size()));
        Next();
    }

    public void No(View v){
        setCount(getCount()-1);
        switch (getRandomNumber()){
            case 1:
                setNo_answer(getNo_answer()+1);
                answer_no.add(1);
                break;
            case 3:
                setNo_answer(getNo_answer()+1);
                answer_no.add(3);
                break;
            case 6:
                setNo_answer(getNo_answer()+1);
                answer_no.add(6);
                break;
            case 8:
                setNo_answer(getNo_answer()+1);
                answer_no.add(8);
                break;
            case 10:
                setNo_answer(getNo_answer()+1);
                answer_no.add(10);
                break;
            case 12:
                setNo_answer(getNo_answer()+1);
                answer_no.add(12);
                break;
        }
        Log.d("listersListNO",String.valueOf(answer_no));
        Log.d("listersListNOsize",String.valueOf(answer_no.size()));
        Next();
    }

    private void Results(){
        Toast.makeText(this, "Заполненно", Toast.LENGTH_SHORT).show();
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
        Intent intentResult = new Intent(this, Liri_ideal.class);

            String next = String.valueOf(answer_yes.size());
            intentResult.putExtra("real_meat", next);
            startActivity(intentResult);

            String next2 = String.valueOf(answer_no.size());
            intentResult.putExtra("real_vegan", next2);
            startActivity(intentResult);

        Log.d("listersYES",String.valueOf(getYes_answer()));
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

                        Intent intent = new Intent(Circle_Liri.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }).create().show();
    }
}


