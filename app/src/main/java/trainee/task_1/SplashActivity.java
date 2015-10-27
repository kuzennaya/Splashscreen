package trainee.task_1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    int logoTimer = 0;
                    while(logoTimer < 2000)
                    {
                        sleep(100);
                        logoTimer = logoTimer + 100;
                    };
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        logoTimer.start();
    }
}
