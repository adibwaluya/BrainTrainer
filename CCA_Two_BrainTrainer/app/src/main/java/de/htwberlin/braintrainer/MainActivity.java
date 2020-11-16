package de.htwberlin.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView sumTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();      // Hold the potential answers
    int correctAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestion = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;

    public void chooseAnswer(View view) {
        if (Integer.toString(correctAnswer).equals(view.getTag().toString())) {
            // if the location of the correct answer equals as its tag
            // User got the correct answer
            resultTextView.setText("Correct!");
            score++;
        } else {
            resultTextView.setText("Wrong!");
        }
        numberOfQuestion++;

        // Score text contains score/numberOfQuestion
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        newQuestion();
    }
    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
    }

    public void newQuestion() {
        Random rand = new Random();

        // Picking 21 random different numbers
        // the lowest being 0, the highest being 20
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        correctAnswer = rand.nextInt(4);
        answers.clear();                                    // Clear the arrays beforehand
        for (int i = 0; i < 4; i++) {
            if (i == correctAnswer){
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }
                // Added random int between 0 to 40
                answers.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        newQuestion();
    }
}