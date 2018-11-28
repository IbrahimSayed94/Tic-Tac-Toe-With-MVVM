package com.ibrahim.tictactoemvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ibrahim.tictactoemvvm.Model.Player;
import com.ibrahim.tictactoemvvm.R;
import com.ibrahim.tictactoemvvm.ViewModel.PlayViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {



    String nextPlayer = "green" , currentPlayer="green";

    PlayViewModel playViewModel ;
    boolean winner = false ;
    ImageView imageView;

    int [] ids = {R.id.im1,R.id.im2,R.id.im3,R.id.im4,R.id.im5,R.id.im6,R.id.im7,R.id.im8,R.id.im9};

    Player player ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViewModel();

    } // function of onCreate
    private void initViewModel()
    {
        playViewModel = ViewModelProviders.of(this).get(PlayViewModel.class);
        playViewModel.initBoard();

        player = new Player();
    } // function of initViewModel

    public void play(View view)
    {
        if(winner == false) {
             imageView = (ImageView) view;

            imageView.setTranslationY(-1500);


            if (nextPlayer.equals("green")) {
                imageView.setImageResource(R.drawable.circle_background_border);
                nextPlayer = "red";
            } // if
            else {
                imageView.setImageResource(R.drawable.circle_background_border1);
                nextPlayer = "green";
            } // else

            imageView.animate().translationYBy(1500).rotation(3600).setDuration(300);

            if (nextPlayer.equals("green")) currentPlayer = "red";
            else if (nextPlayer.equals("red")) currentPlayer = "green";

            player.setCurrentPlayer(currentPlayer);
            player.setPosition(Integer.parseInt(imageView.getTag().toString()));
            playViewModel.play(player);

            checkWin(currentPlayer);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
        }

    } // function of Button play

    private void checkWin(String currentPlayer)
    {
        playViewModel.checkWinner(currentPlayer).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i("QP","Winner : "+s);

                if(s.equals("red")) {
                    Toast.makeText(getApplicationContext(), "Red Is Winner", Toast.LENGTH_SHORT).show();
                    winner = true;
                }
                else if (s.equals("green")) {
                    Toast.makeText(getApplicationContext(), "Green Is Winner", Toast.LENGTH_SHORT).show();
                    winner = true ;
                }
            }
        });
    } // function of checkWinner


    public void reset(View view)
    {
        playViewModel.initBoard();
         nextPlayer = "green" ;
         currentPlayer="green";
        winner = false ;

        for(int i = 0;i<ids.length ; i++)
        {
            imageView = findViewById(ids[i]);
            imageView.setImageResource(R.drawable.circle_background_border2);
        } // for
    } // function of  reset Button
} // class of HomeActivity
