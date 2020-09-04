package kislov.pythoneducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class resultActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra("res",0);

        TextView res = findViewById(R.id.result);
        res.setText(String.valueOf(result));

        TextView resText = findViewById(R.id.resultText);

        if (result < 60) resText.setText(R.string.result_0_text);
        if (result >= 60 && result < 80) resText.setText(R.string.result_60_text);
        if (result >= 80 && result <90) resText.setText(R.string.result_80_text);
        if (result >= 90) resText.setText(R.string.result_90_text);

        res.startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));
        resText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));

        TextView touch = findViewById(R.id.touch);
        touch.setOnClickListener(this);
    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(resultActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.touch) {
            Intent intent = new Intent(resultActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
