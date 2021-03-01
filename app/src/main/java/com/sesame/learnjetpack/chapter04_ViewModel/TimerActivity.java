package com.sesame.learnjetpack.chapter04_ViewModel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.sesame.learnjetpack.R;


public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        final TextView tvTimer = findViewById(R.id.tvTime);

//        TimerViewModel timerViewModel1 = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
//                .get(TimerViewModel.class);

        TimerViewModel timerViewModel1 = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(this.getApplication()))
                .get(TimerViewModel.class);

        timerViewModel1.setOnTimeChange(new TimerViewModel.OnTimeChange() {
            @Override
            public void timeChange(int second) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvTimer.setText("Time: " + second);
                    }
                });
            }
        });

        timerViewModel1.startTimer();
    }
}
