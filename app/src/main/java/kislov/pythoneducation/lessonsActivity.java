package kislov.pythoneducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class lessonsActivity extends Activity implements View.OnClickListener{

    int lesNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        TextView showText = findViewById(R.id.textView);

        Intent intent = getIntent();

        String lesText = intent.getStringExtra("lessonT");
        lesNum = intent.getIntExtra("lessonN", 0);

        showText.setText(lesText);

        Button startTestB = findViewById(R.id.startTestButton);
        startTestB.setOnClickListener(this);

        startTestB.startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));
    }

    @Override
    public void onClick (View v){
        if (v.getId() == R.id.startTestButton) {
            Intent intent = new Intent(lessonsActivity.this, testActivity.class);
            intent.putExtra("lessonN", lesNum);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(lessonsActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
