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
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                        isInitial = true;
                        SplashActivity.this.finish();
                    }
                }, 2000);
                isInitial = true;
            }
            catch (Exception e) {
                isInitial = true;
                e.printStackTrace();
                SplashActivity.this.finish();
            }
        }
    }
    @Override
    public void onBackPressed() {
        isInitial = true;
        SplashActivity.this.finish();
        super.onBackPressed();
  }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey("iniFlag")) {
            isInitial = savedInstanceState.getBoolean("iniFlag");
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("iniFlag", isInitial);
        super.onSaveInstanceState(savedInstanceState);
    }
}
