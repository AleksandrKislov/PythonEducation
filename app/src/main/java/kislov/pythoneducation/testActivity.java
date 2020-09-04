package kislov.pythoneducation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class testActivity extends Activity implements View.OnClickListener{

    TextView questionText;
    Button[] answerButtons = new Button[4];
    String[] questions;
    String[] answers;
    int[] rightAnswers;
    int helperQ = 0;
    int helperA = 0;
    int result = 0;
    SharedPreferences sPref;
    String bestResultConst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionText = findViewById(R.id.question);

        Button ans1 = findViewById(R.id.answer1);
        Button ans2 = findViewById(R.id.answer2);
        Button ans3 = findViewById(R.id.answer3);
        Button ans4 = findViewById(R.id.answer4);

        answerButtons[0] = ans1;
        answerButtons[1] = ans2;
        answerButtons[2] = ans3;
        answerButtons[3] = ans4;

        Intent intent = getIntent();
        int lesNum = intent.getIntExtra("lessonN", 0);
        switch (lesNum){
            case 1:
                bestResultConst = "1";
                questions = getResources().getStringArray(R.array.questions_1);
                answers = getResources().getStringArray(R.array.answers_1);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_1);
                filler(questions, answers);
                break;
            case 2:
                bestResultConst = "2";
                questions = getResources().getStringArray(R.array.questions_2);
                answers = getResources().getStringArray(R.array.answers_2);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_2);
                filler(questions, answers);
                break;
            case 3:
                bestResultConst = "3";
                questions = getResources().getStringArray(R.array.questions_3);
                answers = getResources().getStringArray(R.array.answers_3);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_3);
                filler(questions, answers);
                break;
            case 4:
                bestResultConst = "4";
                questions = getResources().getStringArray(R.array.questions_4);
                answers = getResources().getStringArray(R.array.answers_4);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_4);
                filler(questions, answers);
                break;
            case 5:
                bestResultConst = "5";
                questions = getResources().getStringArray(R.array.questions_5);
                answers = getResources().getStringArray(R.array.answers_5);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_5);
                filler(questions, answers);
                break;
            case 6:
                bestResultConst = "6";
                questions = getResources().getStringArray(R.array.questions_6);
                answers = getResources().getStringArray(R.array.answers_6);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_6);
                filler(questions, answers);
                break;
            case 7:
                bestResultConst = "7";
                questions = getResources().getStringArray(R.array.questions_7);
                answers = getResources().getStringArray(R.array.answers_7);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_7);
                filler(questions, answers);
                break;
            case 8:
                bestResultConst = "8";
                questions = getResources().getStringArray(R.array.questions_8);
                answers = getResources().getStringArray(R.array.answers_8);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_8);
                filler(questions, answers);
                break;
            case 9:
                bestResultConst = "9";
                questions = getResources().getStringArray(R.array.questions_9);
                answers = getResources().getStringArray(R.array.answers_9);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_9);
                filler(questions, answers);
                break;
            case 10:
                bestResultConst = "10";
                questions = getResources().getStringArray(R.array.questions_10);
                answers = getResources().getStringArray(R.array.answers_10);
                rightAnswers = getResources().getIntArray(R.array.rightAnswers_10);
                filler(questions, answers);
                break;
        }

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
    }

    private void resultChecker(int answer){

        if (answer == rightAnswers[helperQ-1]) {
            result += 10;
            answerButtons[answer-1].setBackgroundResource(R.drawable.button_green);
        }else{
            answerButtons[answer-1].setBackgroundResource(R.drawable.button_red);
            answerButtons[rightAnswers[helperQ-1]-1].setBackgroundResource(R.drawable.button_green);
        }

        if(helperQ == 10) {

            sPref = getSharedPreferences("Preferences",MODE_PRIVATE);
            String savedRes = sPref.getString(String.valueOf(bestResultConst),"");

            assert savedRes != null;
            if (!savedRes.equals("") && Integer.parseInt(savedRes) < result) {
                sPref = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString(bestResultConst, String.valueOf(result));
                ed.apply();
            }else if(savedRes.equals("")){
                sPref = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString(bestResultConst, String.valueOf(result));
                ed.apply();
            }

            final Intent intent = new Intent(testActivity.this, resultActivity.class);
            intent.putExtra("res", result);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i =0; i<4; i++) answerButtons[i].setEnabled(true);
                    answerButtons[0].setEnabled(true);
                    answerButtons[1].setEnabled(true);
                    answerButtons[2].setEnabled(true);
                    answerButtons[3].setEnabled(true);
                    filler(questions, answers);
                }
            }, 2000);
        }
    }

    private void filler(String[] questions, String[] answers) {
        questionText.setText(questions[helperQ]);
        for(int j = 0; j < 4; j++){
            answerButtons[j].setBackgroundResource(R.drawable.button);
            answerButtons[j].setText(answers[helperA]);
            answerButtons[j].startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));

            helperA++;
        }
        helperQ++;
    }

    @Override
    public void onClick (View v) {
        for (int i =0; i<4; i++) answerButtons[i].setEnabled(false);

        switch (v.getId()) {
            case R.id.answer1:
                resultChecker(1);
                break;
            case R.id.answer2:
                resultChecker(2);
                break;
            case R.id.answer3:
                resultChecker(3);
                break;
            case R.id.answer4:
                resultChecker(4);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(testActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
