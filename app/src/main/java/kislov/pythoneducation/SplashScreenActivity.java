package kislov.pythoneducation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logoView = findViewById(R.id.logoView);
        logoView.setBackgroundResource(R.drawable.splash);
        AnimationDrawable animLogo = (AnimationDrawable) logoView.getBackground();
        animLogo.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}
