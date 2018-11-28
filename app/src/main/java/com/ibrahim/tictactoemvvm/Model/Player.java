package com.ibrahim.tictactoemvvm.Model;

public class Player
{
    int position ; // 1-->9
    String currentPlayer ;  // green or red

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
} // class of Player
