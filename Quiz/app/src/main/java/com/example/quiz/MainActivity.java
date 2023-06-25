package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare the views
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton optionARadioButton;
    private RadioButton optionBRadioButton;
    private RadioButton optionCRadioButton;
    private RadioButton optionDRadioButton;
    private Button submitButton;

    // Declare the variables for the quiz logic
    private String[] questions; // An array of questions
    private String[][] options; // A two-dimensional array of options for each question
    private int[] answers; // An array of correct answers for each question
    private int currentQuestion; // The index of the current question
    private int score; // The score of the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        optionARadioButton = findViewById(R.id.optionARadioButton);
        optionBRadioButton = findViewById(R.id.optionBRadioButton);
        optionCRadioButton = findViewById(R.id.optionCRadioButton);
        optionDRadioButton = findViewById(R.id.optionDRadioButton);
        submitButton = findViewById(R.id.submitButton);

        // Initialize the quiz data
        questions = new String[] {
                "What is the capital of India?",
                "Who is the current president of the United States?",
                "Which of these is a programming language?",
                "What is the largest animal in the world?",
                "Which planet is the second from the sun?"
        };
        options = new String[][] {
                {"New Delhi", "Mumbai", "Kolkata", "Chennai"},
                {"Joe Biden", "Donald Trump", "Barack Obama", "George Bush"},
                {"Python", "Cobra", "Anaconda", "Viper"},
                {"Blue whale", "Elephant", "Giraffe", "Dinosaur"},
                {"Mercury", "Venus", "Earth", "Mars"}
        };
        answers = new int[] {0, 0, 0, 0, 1}; // The correct answer is the first option for each question
        currentQuestion = 0; // Start with the first question
        score = 0; // Start with zero score

        // Display the first question and options
        displayQuestion();

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected radio button from the radio group
                int selectedOption = optionsRadioGroup.getCheckedRadioButtonId();

                // If no option is selected, show a toast message
                if (selectedOption == -1) {
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if the selected option is correct and update the score accordingly
                if (selectedOption == optionsRadioGroup.getChildAt(answers[currentQuestion]).getId()) {
                    score++;
                    Toast.makeText(MainActivity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }

                // Clear the checked radio button from the radio group
                optionsRadioGroup.clearCheck();

                // Move to the next question or show the final score if all questions are answered
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    displayQuestion();
                } else {
                    Toast.makeText(MainActivity.this, "You have completed the quiz. Your score is: " + score + "/" + questions.length, Toast.LENGTH_LONG).show();
                    submitButton.setEnabled(false); // Disable the submit button
                }
            }
        });
    }

    // A helper method to display the current question and options on the screen
    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        optionARadioButton.setText(options[currentQuestion][0]);
        optionBRadioButton.setText(options[currentQuestion][1]);
        optionCRadioButton.setText(options[currentQuestion][2]);
        optionDRadioButton.setText(options[currentQuestion][3]);
    }
}
