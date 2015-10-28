package trainee.task_1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class SplashActivity extends Activity {
    private boolean isInitial = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (savedInstanceState != null && savedInstanceState.containsKey("iniFlag")) {
            isInitial = savedInstanceState.getBoolean("iniFlag");
        }

        if (!isInitial) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    SplashActivity.this.finish();
                }
            }, 2000);
            isInitial = true;
        }
    }
    @Override
    public void onBackPressed() {
        isInitial = true;
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("iniFlag")) {
            isInitial = savedInstanceState.getBoolean("iniFlag");
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("iniFlag", isInitial);
    }
}
