package trainee.task_1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class SplashActivity extends Activity {
    private Handler handler;
    private Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                SplashActivity.this.finish();
            }
        };
        handler.postDelayed(r, 2000);
    }
    @Override
    public void onStop(){
        super.onStop();
        handler.removeCallbacks(r);
    }
}
