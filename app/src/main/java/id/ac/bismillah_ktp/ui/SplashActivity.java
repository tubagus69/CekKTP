package id.ac.bismillah_ktp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import id.ac.bismillah_ktp.R;

    public class SplashActivity extends Activity {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            Thread thread = new Thread(){
                public void run(){
                    try {
                        sleep(4000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                }
            };
            thread.start();
        }
    }
