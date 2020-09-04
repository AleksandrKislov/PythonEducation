package kislov.pythoneducation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends Activity implements View.OnClickListener{

    SharedPreferences sPref;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button[] buttons = new Button[10];

        Button les1b = findViewById(R.id.les1button);
        Button les2b = findViewById(R.id.les2button);
        Button les3b = findViewById(R.id.les3button);
        Button les4b = findViewById(R.id.les4button);
        Button les5b = findViewById(R.id.les5button);
        Button les6b = findViewById(R.id.les6button);
        Button les7b = findViewById(R.id.les7button);
        Button les8b = findViewById(R.id.les8button);
        Button les9b = findViewById(R.id.les9button);
        Button les10b = findViewById(R.id.les10button);

        buttons[0] = les1b;
        buttons[1] = les2b;
        buttons[2] = les3b;
        buttons[3] = les4b;
        buttons[4] = les5b;
        buttons[5] = les6b;
        buttons[6] = les7b;
        buttons[7] = les8b;
        buttons[8] = les9b;
        buttons[9] = les10b;

        TextView[] views =new TextView[10];

        TextView bestRes1 = findViewById(R.id.maxRes1);
        TextView bestRes2 = findViewById(R.id.maxRes2);
        TextView bestRes3 = findViewById(R.id.maxRes3);
        TextView bestRes4 = findViewById(R.id.maxRes4);
        TextView bestRes5 = findViewById(R.id.maxRes5);
        TextView bestRes6 = findViewById(R.id.maxRes6);
        TextView bestRes7 = findViewById(R.id.maxRes7);
        TextView bestRes8 = findViewById(R.id.maxRes8);
        TextView bestRes9 = findViewById(R.id.maxRes9);
        TextView bestRes10 = findViewById(R.id.maxRes10);

        views[0] = bestRes1;
        views[1] = bestRes2;
        views[2] = bestRes3;
        views[3] = bestRes4;
        views[4] = bestRes5;
        views[5] = bestRes6;
        views[6] = bestRes7;
        views[7] = bestRes8;
        views[8] = bestRes9;
        views[9] = bestRes10;

        for (int i = 0; i < 10; i++){
            buttons[i].startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));
            buttons[i].setOnClickListener(this);
            sPref = getSharedPreferences("Preferences",MODE_PRIVATE);
            String savedRes = sPref.getString(String.valueOf(i+1),"");
            views[i].setText(savedRes);

            assert savedRes != null;
            if (!savedRes.equals("") && Integer.parseInt(savedRes) < 60)
                buttons[i].setBackgroundResource(R.drawable.button_red);
            if (!savedRes.equals("") && Integer.parseInt(savedRes) >= 60 && Integer.parseInt(savedRes) < 80)
                buttons[i].setBackgroundResource(R.drawable.button_orange);
            if (!savedRes.equals("") && Integer.parseInt(savedRes) >= 80 && Integer.parseInt(savedRes) < 90)
                buttons[i].setBackgroundResource(R.drawable.button_yellow);
            if (!savedRes.equals("") && Integer.parseInt(savedRes) >= 90)
                buttons[i].setBackgroundResource(R.drawable.button_green);
            if (!savedRes.equals("") && Integer.parseInt(savedRes) >= 60 && buttons[i] != les10b){
                buttons[i+1].setEnabled(true);
                buttons[i+1].setCompoundDrawables(null,null,null,null);
            }
        }
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(MainMenuActivity.this, lessonsActivity.class);
        switch (v.getId()){
            case R.id.les1button:
                intent.putExtra("lessonT", getString(R.string.lesson1_text));
                intent.putExtra("lessonN", 1);
                startActivity(intent);
                finish();
                break;
            case R.id.les2button:
                intent.putExtra("lessonT", getString(R.string.lesson2_text));
                intent.putExtra("lessonN", 2);
                startActivity(intent);
                finish();
                break;
            case R.id.les3button:
                intent.putExtra("lessonT", getString(R.string.lesson3_text));
                intent.putExtra("lessonN", 3);
                startActivity(intent);
                finish();
                break;
            case R.id.les4button:
                intent.putExtra("lessonT", getString(R.string.lesson4_text));
                intent.putExtra("lessonN", 4);
                startActivity(intent);
                finish();
                break;
            case R.id.les5button:
                intent.putExtra("lessonT", getString(R.string.lesson5_text));
                intent.putExtra("lessonN", 5);
                startActivity(intent);
                finish();
                break;
            case R.id.les6button:
                intent.putExtra("lessonT", getString(R.string.lesson6_text));
                intent.putExtra("lessonN", 6);
                startActivity(intent);
                finish();
                break;
            case R.id.les7button:
                intent.putExtra("lessonT", getString(R.string.lesson7_text));
                intent.putExtra("lessonN", 7);
                startActivity(intent);
                finish();
                break;
            case R.id.les8button:
                intent.putExtra("lessonT", getString(R.string.lesson8_text));
                intent.putExtra("lessonN", 8);
                startActivity(intent);
                finish();
                break;
            case R.id.les9button:
                intent.putExtra("lessonT", getString(R.string.lesson9_text));
                intent.putExtra("lessonN", 9);
                startActivity(intent);
                finish();
                break;
            case R.id.les10button:
                intent.putExtra("lessonT", getString(R.string.lesson10_text));
                intent.putExtra("lessonN", 10);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
