package com.e.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // 0: yellow, 1: red,
    // 2: empty


    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;

    boolean gameActive = true;

    public void dropIn(View view) {

        ImageView counter =
                (ImageView) view;

        int tag = Integer.parseInt(counter.getTag().toString());

        if (gameState[tag] == 2 && gameActive) {

            gameState[tag] =
                    activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.o);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.x);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition :
                    winningPositions) {


                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                            && gameState[winningPosition[0]] != 2) {

                    // Somone has won!

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "Yellow";

                    } else {

                        winner = "Red";

                    }


                    Button playAgain = (Button) findViewById(R.id.playAgain);
                    TextView winnerText = (TextView)findViewById(R.id.winnertext);
                    winnerText.setText(winner+"has won");
                    playAgain.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);


                    }


                }

            }
        }


public void playAgain(View view) {


    Button playAgain= (Button) findViewById(R.id.playAgain);
    TextView winnerText = (TextView) findViewById(R.id.winnertext);

    playAgain.setVisibility(View.INVISIBLE);
    winnerText.setVisibility(View.INVISIBLE);

    GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);

    for (int i = 0; i < gridLayout.getChildCount(); i++) {
        ImageView counter = (ImageView) gridLayout.getChildAt(i);
        counter.setImageDrawable(null);
    }


    for (int x=0; x < gameState.length; x++) {
         gameState[x]=2;
    }
    gameActive = true;

    activePlayer = 1;


}
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
