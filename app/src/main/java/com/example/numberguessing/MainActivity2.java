package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView2);
        textView.setText("Total no of chances to guess the no are 5");
        int cnt = 0;
        Random rand = new Random();
        int num = rand.nextInt(100);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressButton(num,cnt);
            }
        });

    }

    public void pressButton(int num,int cnt){

        if(cnt<4) {
            int n = Integer.parseInt(editText.getText().toString());
            int chance = 4-cnt;
            if (n < num) {
                textView.setText("Guess heigher number\nNo of chances left are "+ chance);
            } else if (n > num) {
                textView.setText("Guess smaller number\nNo of chances left are "+chance);
            } else {
                textView.setText("You guessed correctly");
                button.setEnabled(false);
            }

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pressButton(num, cnt + 1);
                }
            });
        }
        else{
            button.setEnabled(false);
            textView.setText("You lost the game\nThe correct number was "+num);
        }
    }

}