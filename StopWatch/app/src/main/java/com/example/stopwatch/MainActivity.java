package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare the variables
    private TextView timeView;
    private Button startButton;
    private Button stopButton;
    private Button resetButton;

    private int seconds = 0; // The number of seconds passed
    private boolean running = false; // Whether the stopwatch is running or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the references of the views
        timeView = findViewById(R.id.time_view);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);
        resetButton = findViewById(R.id.reset_button);

        // Set the listeners for the buttons
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart(v);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStop(v);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickReset(v);
            }
        });

        // Run the timer
        runTimer();
    }

    // Start the stopwatch
    public void onClickStart(View view) {
        running = true;
    }

    // Stop the stopwatch
    public void onClickStop(View view) {
        running = false;
    }

    // Reset the stopwatch
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    // Update the time view every second
    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Format the seconds into hours, minutes and seconds
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                // Set the text view with the formatted time
                timeView.setText(time);

                // If the stopwatch is running, increment the seconds
                if (running) {
                    seconds++;
                }

                // Post the code again with a delay of one second
                handler.postDelayed(this, 1000);
            }
        });
    }
}
