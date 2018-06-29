package com.iconicdev.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    A variable the user's score
    public int mScore = 0;

    private RadioGroup rgQuestion1;
    private RadioGroup rgQuestion3;
    private RadioGroup rgQuestion4;


    private CheckBox cbDwightYorke;
    private CheckBox cbSaf;
    private CheckBox cbBob;
    private CheckBox cbWillian;
    private CheckBox cbPoch;
    private CheckBox cbArseneWenger;
    private CheckBox cbDavidMoyes;

    public Boolean question1 = false;
    public Boolean question2 = false;
    public Boolean question3 = false;
    public Boolean question4 = false;
    public Boolean question5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setting all RadioGroups

        rgQuestion1 = (RadioGroup) findViewById(R.id.rg_question1);
        rgQuestion1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.rb_1887:
                          question1 = correctAnswer();
                          return;
                    default:
                        question1 = wrongAnswer();

                }

            }
        });
//        Initialize the Second Radio Group
        rgQuestion3 = (RadioGroup) findViewById(R.id.rg_question3);
//        Setting an oncheckedChangeListener to it
        rgQuestion3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_RedDevils:
                        question3 = correctAnswer();
                        return;
                    default:
                        question3 = wrongAnswer();
                }


            }
        });

        //        Initialize the Third Radio Group
       rgQuestion4 = (RadioGroup) findViewById(R.id.rg_question4);

       //         Setting an oncheckedChangeListener to it

        rgQuestion4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_oldTrafford:
                        question4 = correctAnswer();
                        return;
                    default:
                        question4 = wrongAnswer();

                }


            }
        });

//        // Setting CheckBoxes
        cbDwightYorke = (CheckBox) findViewById(R.id.cb_dwight_yorke);
        cbSaf = (CheckBox) findViewById(R.id.cb_saf);
        cbBob = (CheckBox) findViewById(R.id.cb_bob);
        cbWillian = (CheckBox) findViewById(R.id.cb_willian);
        cbArseneWenger = (CheckBox) findViewById(R.id.cb_arseneWenger);
        cbDavidMoyes = (CheckBox) findViewById(R.id.cb_davidMoyes);
        cbPoch = (CheckBox) findViewById(R.id.cb_poch);




    }



    public void onCheckQuestion2(View view){
        boolean cbSafIsChecked = cbSaf.isChecked();
        boolean cbPochIsChecked = cbPoch.isChecked();
        boolean cbDavidMoyesIsChecked = cbDavidMoyes.isChecked();
        boolean cbArseneWengerIsChecked = cbArseneWenger.isChecked();

        if (cbSafIsChecked && cbDavidMoyesIsChecked &&!cbPochIsChecked && !cbArseneWengerIsChecked){
            question2 = correctAnswer();
        }else{
            question2=wrongAnswer();
        }
    }

    public  void onCheckQuestion5(View view){
        boolean cbDwightYorkeIsChecked =  cbDwightYorke.isChecked();
        boolean cbWillianIsChecked = cbWillian.isChecked();
        boolean cbBobbyCharltonisChecked = cbBob.isChecked();

        if (cbDwightYorkeIsChecked && cbBobbyCharltonisChecked && !cbWillianIsChecked){
            question5 = correctAnswer();
        }else{
            question5 = wrongAnswer();
        }
    }

    public boolean wrongAnswer(){
        return  false;
    }

    public boolean correctAnswer(){
            return true;
    }

    public void showToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }


    public void submitAnswer(View v){

          boolean answers [];
          answers = new boolean[5];
          answers[0] = question1;
          answers[1] = question2;
          answers[2] = question3;
          answers[3] = question4;
          answers[4] = question5;

          for (int i = 0 ; i < answers.length; i++){
              if (answers[i]){
                  addScore();
              }

          }
          showToast("Your Score is " + mScore + "/5");
          mScore = reset();

    }

    public int reset(){
        return 0;
    }

    public void addScore(){
        mScore++;
    }


}
