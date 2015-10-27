package trainee.task_1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

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
            Thread logoTimer = new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                        if (!isInitial) {
                            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                            isInitial = true;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        finish();
                    }
                }
            };
            logoTimer.start();
        }
    }
    @Override
    public void onBackPressed() {
        isInitial = true;
    }
   /* @Override
    public void onPause(){
        super.onPause();
        isInitial = true;
    }*/
    @Override
    public void onStop(){
        super.onStop();
       // isInitial = true;
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
