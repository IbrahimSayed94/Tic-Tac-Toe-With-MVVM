package com.ibrahim.tictactoemvvm.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.ibrahim.tictactoemvvm.Model.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayViewModel extends ViewModel
{
    Map<Integer,String> boardMap = new HashMap<>();

    MutableLiveData<String> whoWinner = new MutableLiveData<>();

    public void play(Player player)
    {
        boardMap.put(player.getPosition(),player.getCurrentPlayer());
    } // function of play

    public LiveData<String> checkWinner(String player)
    {

        if(boardMap.get(1).equals(boardMap.get(2)) && boardMap.get(1).equals(boardMap.get(3)) && boardMap.get(1) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(4).equals(boardMap.get(5)) && boardMap.get(4).equals(boardMap.get(6)) && boardMap.get(4) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(7).equals(boardMap.get(8)) && boardMap.get(7).equals(boardMap.get(9)) && boardMap.get(7) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(1).equals(boardMap.get(4)) && boardMap.get(1).equals(boardMap.get(7)) && boardMap.get(1) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(2).equals(boardMap.get(5)) && boardMap.get(2).equals(boardMap.get(8)) && boardMap.get(2) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(3).equals(boardMap.get(6)) && boardMap.get(3).equals(boardMap.get(9)) && boardMap.get(3) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(1).equals(boardMap.get(5)) && boardMap.get(1).equals(boardMap.get(9)) && boardMap.get(1) != "none")
            whoWinner.setValue(player);
        else if(boardMap.get(3).equals(boardMap.get(5)) && boardMap.get(3).equals(boardMap.get(7)) && boardMap.get(3) != "none")
            whoWinner.setValue(player);

        else
            whoWinner.setValue("none");

        Log.i("QR","winner : "+whoWinner.getValue());
        return whoWinner;
    } // function of checkWinner

    public void initBoard()
    {
        boardMap.put(1,"none");
        boardMap.put(2,"none");
        boardMap.put(3,"none");
        boardMap.put(4,"none");
        boardMap.put(5,"none");
        boardMap.put(6,"none");
        boardMap.put(7,"none");
        boardMap.put(8,"none");
        boardMap.put(9,"none");
    } // function of initBoard

} // class of ViewModel
