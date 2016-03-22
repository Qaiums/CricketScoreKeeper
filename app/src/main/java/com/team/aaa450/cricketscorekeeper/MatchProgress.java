package com.team.aaa450.cricketscorekeeper;


import com.team.aaa450.cricketscorekeeper.contractClass;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.lang.Object.*;
import java.util.Date;

public class MatchProgress extends AppCompatActivity {

    EditText teamName;

    LinearLayout playerOneLayout;
    TextView playerOneTotalRun;
    TextView playerOneTotalBallsPlayed;
    Button playerOneSixButton;
    Button playerOneFourButton;
    Button playerOneThreeButton;
    Button playerOneTwoButton;
    Button playerOneOneButton;
    Button playerOneDotButton;
    Button playerOneWicketButton;

    TextView playerOneOnStike ;


    LinearLayout playerTwoLayout;
    TextView playerTwoTotalRun;
    TextView playerTwoTotalBallsPlayed;
    Button playerTwoSixButton;
    Button playerTwoFourButton;
    Button playerTwoThreeButton;
    Button playerTwoTwoButton;
    Button playerTwoOneButton;
    Button playerTwoDotButton;
    Button playerTwoWicketButton;
    TextView playerTwoOnStike ;

    LinearLayout playerThreeLayout;
    TextView playerThreeTotalRun;
    TextView playerThreeTotalBallsPlayed;
    Button playerThreeSixButton;
    Button playerThreeFourButton;
    Button playerThreeThreeButton;
    Button playerThreeTwoButton;
    Button playerThreeOneButton;
    Button playerThreeDotButton;
    Button playerThreeWicketButton;
    TextView playerThreeOnStike ;

    LinearLayout playerFourLayout;
    TextView playerFourTotalRun;
    TextView playerFourTotalBallsPlayed;
    Button playerFourSixButton;
    Button playerFourFourButton;
    Button playerFourThreeButton;
    Button playerFourTwoButton;
    Button playerFourOneButton;
    Button playerFourDotButton;
    Button playerFourWicketButton;
    TextView playerFourOnStike ;

    LinearLayout playerFiveLayout;
    TextView playerFiveTotalRun;
    TextView playerFiveTotalBallsPlayed;
    Button playerFiveSixButton;
    Button playerFiveFourButton;
    Button playerFiveThreeButton;
    Button playerFiveTwoButton;
    Button playerFiveOneButton;
    Button playerFiveDotButton;
    Button playerFiveWicketButton;
    TextView playerFiveOnStike ;

    LinearLayout playerSixLayout;
    TextView playerSixTotalRun;
    TextView playerSixTotalBallsPlayed;
    Button playerSixSixButton;
    Button playerSixFourButton;
    Button playerSixThreeButton;
    Button playerSixTwoButton;
    Button playerSixOneButton;
    Button playerSixDotButton;
    Button playerSixWicketButton;
    TextView playerSixOnStike ;

    LinearLayout playerSevenLayout;
    TextView playerSevenTotalRun;
    TextView playerSevenTotalBallsPlayed;
    Button playerSevenSixButton;
    Button playerSevenFourButton;
    Button playerSevenThreeButton;
    Button playerSevenTwoButton;
    Button playerSevenOneButton;
    Button playerSevenDotButton;
    Button playerSevenWicketButton;
    TextView playerSevenOnStike ;

    LinearLayout playerEightLayout;
    TextView playerEightTotalRun;
    TextView playerEightTotalBallsPlayed;
    Button playerEightSixButton;
    Button playerEightFourButton;
    Button playerEightThreeButton;
    Button playerEightTwoButton;
    Button playerEightOneButton;
    Button playerEightDotButton;
    Button playerEightWicketButton;
    TextView playerEightOnStike ;

    LinearLayout playerNineLayout;
    TextView playerNineTotalRun;
    TextView playerNineTotalBallsPlayed;
    Button playerNineSixButton;
    Button playerNineFourButton;
    Button playerNineThreeButton;
    Button playerNineTwoButton;
    Button playerNineOneButton;
    Button playerNineDotButton;
    Button playerNineWicketButton;
    TextView playerNineOnStike ;

    LinearLayout playerTenLayout;
    TextView playerTenTotalRun;
    TextView playerTenTotalBallsPlayed;
    Button playerTenSixButton;
    Button playerTenFourButton;
    Button playerTenThreeButton;
    Button playerTenTwoButton;
    Button playerTenOneButton;
    Button playerTenDotButton;
    Button playerTenWicketButton;
    TextView playerTenOnStike ;

    LinearLayout playerElevenLayout;
    TextView playerElevenTotalRun;
    TextView playerElevenTotalBallsPlayed;
    Button playerElevenSixButton;
    Button playerElevenFourButton;
    Button playerElevenThreeButton;
    Button playerElevenTwoButton;
    Button playerElevenOneButton;
    Button playerElevenDotButton;
    Button playerElevenWicketButton;
    TextView playerElevenOnStike ;

    TextView teamTotalRuns;
    TextView teamTotalExtraRuns;
    TextView currentScoreTotalRun;
    TextView currentScoreWicket;
    TextView currentScoreOver;
    TextView currentScoreBall;

    Button wideBowlButton ;
    Button NoBowlButton ;
    Button ByBowlButton ;
    Button doneButton;

    LinearLayout teamTargetLayout;
    TextView targetRun;

    Button undoButton;
    Button changeStrikerButton;

    public static int teamWicketsGone;
    public static int nextPlayerToDeploy;
    public static int teamLimit,overLimit;
    public static LinearLayout[] playerLayoutList;
    public static int wide,no,bye;
    public static boolean firstTeam ;
    public static BigInteger referenceId;
    public static int[] currentPlayerPair;
    public static boolean firstPlayerSelected = false;
    public static int lastPlayerDeployed;
    public static TextView[] playerOnStrikeList;
    public static TextView[][] playersAllButtonList;
    public static int firstTeamScore ;
    public static String firstTeamName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allLayoutsInitializeFunction();
        makeExtraLayoutsInvisible();
        setValuesToDefaultStatus();
        setButtonFunctionalities();

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        /*
        THIS
            METHOD
                IS
                    PRIMARILY
                        FOR
                            RESTORING
                                AFTER
                                    ORIENTATION
                                        CHANGE
         */



        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        allLayoutsInitializeFunction();
        makeExtraLayoutsInvisible();
        setValuesToDefaultStatus();
        setButtonFunctionalities();
        // Restore state members from saved instance
        boolean isFirstTeam = savedInstanceState.getBoolean("isFirstTeam");
        int targetRuns = savedInstanceState.getInt("target");
        int teamLimitCarryOver = savedInstanceState.getInt("teamLimitcarryOver");
        int overLimitCarryOver = savedInstanceState.getInt("overLimitcarryOver");
        firstTeamName=savedInstanceState.getString("firstTeamSavedName");

            // Restore value of members from saved state
            if (!isFirstTeam) {
                secondTeamLayoutPreparation();
                firstTeam = isFirstTeam;
                updateCell(targetRun, targetRuns);
                teamLimit = teamLimitCarryOver;
                overLimit = overLimitCarryOver;
                this.firstTeamScore=targetRuns;
            }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("isFirstTeam", firstTeam);
        savedInstanceState.putInt("target", getValue(teamTotalRuns));
        savedInstanceState.putInt("teamLimitcarryOver", teamLimit);
        savedInstanceState.putInt("overLimitcarryOver", overLimit);
        savedInstanceState.putString("firstTeamSavedName", teamName.getText().toString());
        // etc.
    }



    public void setInvisible(View newView) {
        newView.setVisibility(View.GONE);
    }

    public void runsScored(int runsAmountToUpdate, TextView playerTotalRunsVariable, TextView playerTotalBallsVariable,
                           TextView teamTotalRunsVariable, TextView currentScoreTotalRunVariable,
                           TextView currentScoreOverVariable, TextView currentScoreBallVariable) {
        updateCell(playerTotalRunsVariable, runsAmountToUpdate);
        updateCell(currentScoreTotalRunVariable, runsAmountToUpdate);
        updateCell(teamTotalRunsVariable, runsAmountToUpdate);
        incrementCell(playerTotalBallsVariable);
        overCounter(currentScoreBallVariable, currentScoreOverVariable);
        checkAndUpdateTargetRun(runsAmountToUpdate);
        lastRunChange.setPlayerChange(runsAmountToUpdate, currentScoreTotalRunVariable, currentScoreOverVariable,
                currentScoreBallVariable, playerTotalRunsVariable, playerTotalBallsVariable,
                teamTotalRunsVariable);
        undoButton.setEnabled(true);

        if(!firstPlayerSelected){
            selectFirstPlayerOnStrikeDescision();
        }

        if(runsAmountToUpdate==1 || runsAmountToUpdate==3) swapPlayers();
    }

    public void selectFirstPlayerOnStrikeDescision(){
        int p1Score = getValue(playerOneTotalRun);
        if(p1Score == 0) selectPlayerOnStrike(2);
        else selectPlayerOnStrike(1);
        firstPlayerSelected = true;
    }

    public void selectPlayerOnStrike(int playerNumber){
        if(currentPlayerPair[0] != playerNumber) swapPlayers();
        else implementSwap();
    }

    public static void swapPlayers(){
        int temp = currentPlayerPair[0];
        currentPlayerPair[0] = currentPlayerPair[1];
        currentPlayerPair[1] = temp;

        implementSwap();
    }

    public static void implementSwap(){
        playerOnStrikeList[currentPlayerPair[0]-1].setVisibility(View.VISIBLE);
        makeButtonsOfThisPlayerVisible(currentPlayerPair[0] - 1, true);
        playerOnStrikeList[currentPlayerPair[1]-1].setVisibility(View.INVISIBLE);
        makeButtonsOfThisPlayerVisible(currentPlayerPair[1]-1,false);
    }

    public static void makeButtonsOfThisPlayerVisible(int playerNumber,boolean action ){
            for(int j=0;j<7;j++){
                if(action) playersAllButtonList[playerNumber][j].setVisibility(View.VISIBLE);
                else playersAllButtonList[playerNumber][j].setVisibility(View.INVISIBLE);
            }
    }

    public void wicket(TextView currentScoreWicketVariable,TextView currentScoreBallVaribale,
                       TextView currentScoreOverVariable,
                       TextView playerTotalBallVariable, Button sixButton, Button fourButton,
                       Button threeButton,Button twoButton,Button oneButton,
                       Button dotButton,Button wicketButton){
        incrementCell(currentScoreWicketVariable);
        incrementCell(playerTotalBallVariable);
        overCounter(currentScoreBallVaribale, currentScoreOverVariable);

        sixButton.setVisibility(sixButton.INVISIBLE);
        fourButton.setVisibility(fourButton.INVISIBLE);
        threeButton.setVisibility(threeButton.INVISIBLE);
        twoButton.setVisibility(twoButton.INVISIBLE);
        oneButton.setVisibility(oneButton.INVISIBLE);
        dotButton.setVisibility(dotButton.INVISIBLE);
        wicketButton.setVisibility(wicketButton.INVISIBLE);

        nextPlayerDeployment();
        checkIfWicketLimitReached();

        playerOnStrikeList[currentPlayerPair[0]-1].setVisibility(View.INVISIBLE);

        lastRunChange.setWicketChange(currentScoreWicketVariable,currentScoreBallVaribale,currentScoreOverVariable,
                                        playerTotalBallVariable,sixButton,fourButton,threeButton,twoButton,oneButton,
                                        dotButton,wicketButton,currentPlayerPair[0]);

        lastPlayerDeployed++;
        currentPlayerPair[0] = lastPlayerDeployed;
        implementSwap();

    }

    public void checkIfWicketLimitReached(){
        teamWicketsGone++;
        if(teamWicketsGone >= teamLimit-1){
            if(firstTeam){
                doneButton.setVisibility(View.VISIBLE);
                makeExtraRunsButtonsInaccessible();
            }
            else if(!firstTeam){
                endMatch(1);
            }
        }
    }

    public void wideOrByeOrNo(String ball_type,TextView teamTotalRunsVariable,TextView currentScoreTotalRunVariable,TextView teamTotalExtraRunsVariable) {
        if (ball_type.equals("wide"))
            wide++;
        else if (ball_type.equals("No"))
            no++;
        else {
            bye++;
            swapPlayers();
        }
        incrementCell(teamTotalRunsVariable);
        incrementCell(currentScoreTotalRunVariable);
        incrementCell(teamTotalExtraRunsVariable);
        checkAndUpdateTargetRun(1);
        lastRunChange.setTeamChangeForExtraRun();
        undoButton.setEnabled(true);

    }



    public void overCounter(TextView currentScoreBallVariable, TextView currentScoreOverVariable) {
        int currentBall = Integer.parseInt(currentScoreBallVariable.getText().toString());
        if (currentBall <5) {
            incrementCell(currentScoreBallVariable);
        } else if (currentBall == 5) {
            resetNumberOfPlayedBalls(currentScoreBallVariable);
            incrementCell(currentScoreOverVariable);
            swapPlayers();
        }
        checkOverLimit(currentScoreOverVariable);
    }

    public void checkOverLimit(TextView currentScoreOverVariable){
        if(getValue(currentScoreOverVariable) >= overLimit){
            if(firstTeam){
                doneButton.setVisibility(View.VISIBLE);
                makeExtraRunsButtonsInaccessible();
            }
            else{
                endMatch(2);
            }
        }
    }

    public void checkAndUpdateTargetRun(int amount){
        if(getValue(targetRun) >= 0){
            updateCellSubtractValue(targetRun,amount);
            if(getValue(targetRun) < 0)
                endMatch(3);
        }
    }

    public static void nextPlayerDeployment(){
        if(nextPlayerToDeploy <= teamLimit){
            deploy(playerLayoutList[nextPlayerToDeploy-3]);
            nextPlayerToDeploy++;
        }
    }

    public static void deploy(LinearLayout nextPlayerLayout){nextPlayerLayout.setVisibility(View.VISIBLE);}


    public void updateCell(TextView cellToUpdate, int amountToBeAdded) {
        int val = Integer.parseInt( cellToUpdate.getText().toString());
        val+= amountToBeAdded ;

        cellToUpdate.setText(String.valueOf(val));
    }

    public void updateCellSubtractValue(TextView cellToUpdate, int amountToBeAdded) {
        int val = Integer.parseInt( cellToUpdate.getText().toString());
        val-= amountToBeAdded ;
        cellToUpdate.setText(String.valueOf(val));
    }

    public void incrementCell(TextView cellToIncrement) {
        int oldAmount = Integer.parseInt(cellToIncrement.getText().toString());
        oldAmount++;
        cellToIncrement.setText(String.valueOf(oldAmount));
    }

    public void resetNumberOfPlayedBalls(TextView numberOfPlayedBallsVariable) {numberOfPlayedBallsVariable.setText(String.valueOf(0));}

    public String getTextFromTextView(TextView tv){return tv.getText().toString();}

    public void setTextToTextView(TextView tv, String txt){tv.setText(txt);}

    public String getEditTextText(EditText et){
        return et.getText().toString();}

    public int getValue(TextView tv){
        return Integer.parseInt(tv.getText().toString());
    }

    public void setValueToTextView(TextView tv,int amount){tv.setText(String.valueOf(amount));}

    //public void setButtonText(Button bt){bt.setText("Finish");}

    public void doneButtonFunctionality() {
        if(firstTeam){
            Toast.makeText(MatchProgress.this, "firstTeam is true",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MatchProgress.this, "firstTeam is false",
                    Toast.LENGTH_LONG).show();
        }
        if (firstTeam) {
            /*
            referenceId = contractClass.specialReferenceNumberGenerator.referenceIdGenerator();
            firstTeam = false;
            dataStorage dt=new dataStorage(getApplicationContext());
            SQLiteDatabase db = dt.getWritableDatabase();
            db.execSQL(contractClass.sqlQueries.team_score_table_entry_query_construct(referenceId, getEditTextText(teamName),
                    getValue(teamTotalRuns), getValue(teamTotalExtraRuns), wide, no, bye));
             */
            /*if (android.os.Build.VERSION.SDK_INT >= 11){
                super.recreate();
            }else{
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
            */
            takeScreenShot();
            firstTeam = false;
            super.recreate();
        }
        else {doneButton.setVisibility(View.GONE);}
    }

    public void makeExtraRunsButtonsInaccessible(){
        wideBowlButton.setVisibility(View.GONE);
        NoBowlButton.setVisibility(View.GONE);
        ByBowlButton.setVisibility(View.GONE);
        makeEntirePlayerButtonsListInaccessible();
    }

    public void makeEntirePlayerButtonsListInaccessible(){
        for(int i=0;i<11;i++){
            for(int j=0;j<7;j++){
                playersAllButtonList[i][j].setVisibility(View.GONE);
            }
        }
    }

    public void secondTeamLayoutPreparation(){
        doneButton.setVisibility(View.GONE);
        teamTargetLayout.setVisibility(View.VISIBLE);
        incrementCell(targetRun);
        incrementCell(targetRun);
    }

    public void endMatch(int code){
        takeScreenShot();
        //Match ending funtionality to be added
        if(code == 1 || code==2){
            //Match ended because all players bowled out
            endMatchPopupWindow(1);
        }
        else{
            endMatchPopupWindow(2);
            //Match ended because target reached
        }

        System.out.println("End of the match");
    }

        public void takeScreenShot () {

        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "oldCSK.jpg";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 500;
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            //openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }

    }


    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
    }




    public void endMatchPopupWindow(int winningTeamNumber)
    {
        final Dialog dialog = new Dialog(this);
        String winMessage="";

        dialog.setContentView(R.layout.match_end_view);
        dialog.setTitle("Custom Alert Dialog");

        final TextView matchEndTextView = (TextView) dialog.findViewById(R.id.endMatchDialogTextView);
        Button exitButton        = (Button) dialog.findViewById(R.id.ExitButton);
        if(winningTeamNumber==1) {
            winMessage += firstTeamName+" wins the match by "+(firstTeamScore-getValue(teamTotalRuns))+ " runs" ;
        }
        else{
            winMessage += getEditTextText(teamName) + " wins the match by " + (teamLimit-teamWicketsGone) + " wickets";
        }
        setTextToTextView(matchEndTextView,winMessage);
        dialog.show();
    }

    public void allLayoutsInitializeFunction(){
        {
            teamName = (EditText) findViewById(R.id.teamName);

            playerOneLayout = (LinearLayout) findViewById(R.id.playerOneLayout);
            playerOneTotalRun = (TextView) findViewById(R.id.playerOneTotalRun);
            playerOneTotalBallsPlayed = (TextView) findViewById(R.id.playerOneTotalNumberOfBallsPlayed);
            playerOneSixButton = (Button) findViewById(R.id.playerOneSixButton);
            playerOneFourButton = (Button) findViewById(R.id.playerOneFourButton);
            playerOneThreeButton = (Button) findViewById(R.id.playerOneThreeButton);
            playerOneTwoButton = (Button) findViewById(R.id.playerOneTwoButton);
            playerOneOneButton = (Button) findViewById(R.id.playerOneOneButton);
            playerOneDotButton = (Button) findViewById(R.id.playerOneDotButton);
            playerOneWicketButton = (Button) findViewById(R.id.playerOneWicketButton);
            playerOneOnStike = (TextView) findViewById(R.id.playerOneOnStike);


            playerTwoLayout = (LinearLayout) findViewById(R.id.playerTwoLayout);
            playerTwoTotalRun = (TextView) findViewById(R.id.playerTwoTotalRun);
            playerTwoTotalBallsPlayed = (TextView) findViewById(R.id.playerTwoTotalNumberOfBallsPlayed);
            playerTwoSixButton = (Button) findViewById(R.id.playerTwoSixButton);
            playerTwoFourButton = (Button) findViewById(R.id.playerTwoFourButton);
            playerTwoThreeButton = (Button) findViewById(R.id.playerTwoThreeButton);
            playerTwoTwoButton = (Button) findViewById(R.id.playerTwoTwoButton);
            playerTwoOneButton = (Button) findViewById(R.id.playerTwoOneButton);
            playerTwoDotButton = (Button) findViewById(R.id.playerTwoDotButton);
            playerTwoWicketButton = (Button) findViewById(R.id.playerTwoWicketButton);
            playerTwoOnStike = (TextView) findViewById(R.id.playerTwoOnStike);

            playerThreeLayout = (LinearLayout) findViewById(R.id.playerThreeLayout);
            playerThreeTotalRun = (TextView) findViewById(R.id.playerThreeTotalRun);
            playerThreeTotalBallsPlayed = (TextView) findViewById(R.id.playerThreeTotalNumberOfBallsPlayed);
            playerThreeSixButton = (Button) findViewById(R.id.playerThreeSixButton);
            playerThreeFourButton = (Button) findViewById(R.id.playerThreeFourButton);
            playerThreeThreeButton = (Button) findViewById(R.id.playerThreeThreeButton);
            playerThreeTwoButton = (Button) findViewById(R.id.playerThreeTwoButton);
            playerThreeOneButton = (Button) findViewById(R.id.playerThreeOneButton);
            playerThreeDotButton = (Button) findViewById(R.id.playerThreeDotButton);
            playerThreeWicketButton = (Button) findViewById(R.id.playerThreeWicketButton);
            playerThreeOnStike= (TextView) findViewById(R.id.playerThreeOnStike);

            playerFourLayout = (LinearLayout) findViewById(R.id.playerFourLayout);
            playerFourTotalRun = (TextView) findViewById(R.id.playerFourTotalRun);
            playerFourTotalBallsPlayed = (TextView) findViewById(R.id.playerFourTotalNumberOfBallsPlayed);
            playerFourSixButton = (Button) findViewById(R.id.playerFourSixButton);
            playerFourFourButton = (Button) findViewById(R.id.playerFourFourButton);
            playerFourThreeButton = (Button) findViewById(R.id.playerFourThreeButton);
            playerFourTwoButton = (Button) findViewById(R.id.playerFourTwoButton);
            playerFourOneButton = (Button) findViewById(R.id.playerFourOneButton);
            playerFourDotButton = (Button) findViewById(R.id.playerFourDotButton);
            playerFourWicketButton = (Button) findViewById(R.id.playerFourWicketButton);
            playerFourOnStike= (TextView) findViewById(R.id.playerFourOnStike);

            playerFiveLayout = (LinearLayout) findViewById(R.id.playerFiveLayout);
            playerFiveTotalRun = (TextView) findViewById(R.id.playerFiveTotalRun);
            playerFiveTotalBallsPlayed = (TextView) findViewById(R.id.playerFiveTotalNumberOfBallsPlayed);
            playerFiveSixButton = (Button) findViewById(R.id.playerFiveSixButton);
            playerFiveFourButton = (Button) findViewById(R.id.playerFiveFourButton);
            playerFiveThreeButton = (Button) findViewById(R.id.playerFiveThreeButton);
            playerFiveTwoButton = (Button) findViewById(R.id.playerFiveTwoButton);
            playerFiveOneButton = (Button) findViewById(R.id.playerFiveOneButton);
            playerFiveDotButton = (Button) findViewById(R.id.playerFiveDotButton);
            playerFiveWicketButton = (Button) findViewById(R.id.playerFiveWicketButton);
            playerFiveOnStike =(TextView) findViewById(R.id.playerFiveOnStike);

            playerSixLayout = (LinearLayout) findViewById(R.id.playerSixLayout);
            playerSixTotalRun = (TextView) findViewById(R.id.playerSixTotalRun);
            playerSixTotalBallsPlayed = (TextView) findViewById(R.id.playerSixTotalNumberOfBallsPlayed);
            playerSixSixButton = (Button) findViewById(R.id.playerSixSixButton);
            playerSixFourButton = (Button) findViewById(R.id.playerSixFourButton);
            playerSixThreeButton = (Button) findViewById(R.id.playerSixThreeButton);
            playerSixTwoButton = (Button) findViewById(R.id.playerSixTwoButton);
            playerSixOneButton = (Button) findViewById(R.id.playerSixOneButton);
            playerSixDotButton = (Button) findViewById(R.id.playerSixDotButton);
            playerSixWicketButton = (Button) findViewById(R.id.playerSixWicketButton);
            playerSixOnStike =(TextView) findViewById(R.id.playerSixOnStike);

            playerSevenLayout = (LinearLayout) findViewById(R.id.playerSevenLayout);
            playerSevenTotalRun = (TextView) findViewById(R.id.playerSevenTotalRun);
            playerSevenTotalBallsPlayed = (TextView) findViewById(R.id.playerSevenTotalNumberOfBallsPlayed);
            playerSevenSixButton = (Button) findViewById(R.id.playerSevenSixButton);
            playerSevenFourButton = (Button) findViewById(R.id.playerSevenFourButton);
            playerSevenThreeButton = (Button) findViewById(R.id.playerSevenThreeButton);
            playerSevenTwoButton = (Button) findViewById(R.id.playerSevenTwoButton);
            playerSevenOneButton = (Button) findViewById(R.id.playerSevenOneButton);
            playerSevenDotButton = (Button) findViewById(R.id.playerSevenDotButton);
            playerSevenWicketButton = (Button) findViewById(R.id.playerSevenWicketButton);
            playerSevenOnStike =(TextView) findViewById(R.id.playerSevenOnStike);

            playerEightLayout = (LinearLayout) findViewById(R.id.playerEightLayout);
            playerEightTotalRun = (TextView) findViewById(R.id.playerEightTotalRun);
            playerEightTotalBallsPlayed = (TextView) findViewById(R.id.playerEightTotalNumberOfBallsPlayed);
            playerEightSixButton = (Button) findViewById(R.id.playerEightSixButton);
            playerEightFourButton = (Button) findViewById(R.id.playerEightFourButton);
            playerEightThreeButton = (Button) findViewById(R.id.playerEightThreeButton);
            playerEightTwoButton = (Button) findViewById(R.id.playerEightTwoButton);
            playerEightOneButton = (Button) findViewById(R.id.playerEightOneButton);
            playerEightDotButton = (Button) findViewById(R.id.playerEightDotButton);
            playerEightWicketButton = (Button) findViewById(R.id.playerEightWicketButton);
            playerEightOnStike =(TextView) findViewById(R.id.playerEightOnStike);

            playerNineLayout = (LinearLayout) findViewById(R.id.playerNineLayout);
            playerNineTotalRun = (TextView) findViewById(R.id.playerNineTotalRun);
            playerNineTotalBallsPlayed = (TextView) findViewById(R.id.playerNineTotalNumberOfBallsPlayed);
            playerNineSixButton = (Button) findViewById(R.id.playerNineSixButton);
            playerNineFourButton = (Button) findViewById(R.id.playerNineFourButton);
            playerNineThreeButton = (Button) findViewById(R.id.playerNineThreeButton);
            playerNineTwoButton = (Button) findViewById(R.id.playerNineTwoButton);
            playerNineOneButton = (Button) findViewById(R.id.playerNineOneButton);
            playerNineDotButton = (Button) findViewById(R.id.playerNineDotButton);
            playerNineWicketButton = (Button) findViewById(R.id.playerNineWicketButton);
            playerNineOnStike =(TextView) findViewById(R.id.playerNineOnStike);

            playerTenLayout = (LinearLayout) findViewById(R.id.playerTenLayout);
            playerTenTotalRun = (TextView) findViewById(R.id.playerTenTotalRun);
            playerTenTotalBallsPlayed = (TextView) findViewById(R.id.playerTenTotalNumberOfBallsPlayed);
            playerTenSixButton = (Button) findViewById(R.id.playerTenSixButton);
            playerTenFourButton = (Button) findViewById(R.id.playerTenFourButton);
            playerTenThreeButton = (Button) findViewById(R.id.playerTenThreeButton);
            playerTenTwoButton = (Button) findViewById(R.id.playerTenTwoButton);
            playerTenOneButton = (Button) findViewById(R.id.playerTenOneButton);
            playerTenDotButton = (Button) findViewById(R.id.playerTenDotButton);
            playerTenWicketButton = (Button) findViewById(R.id.playerTenWicketButton);
            playerTenOnStike =(TextView) findViewById(R.id.playerTenOnStike);

            playerElevenLayout = (LinearLayout) findViewById(R.id.playerElevenLayout);
            playerElevenTotalRun = (TextView) findViewById(R.id.playerElevenTotalRun);
            playerElevenTotalBallsPlayed = (TextView) findViewById(R.id.playerElevenTotalNumberOfBallsPlayed);
            playerElevenSixButton = (Button) findViewById(R.id.playerElevenSixButton);
            playerElevenFourButton = (Button) findViewById(R.id.playerElevenFourButton);
            playerElevenThreeButton = (Button) findViewById(R.id.playerElevenThreeButton);
            playerElevenTwoButton = (Button) findViewById(R.id.playerElevenTwoButton);
            playerElevenOneButton = (Button) findViewById(R.id.playerElevenOneButton);
            playerElevenDotButton = (Button) findViewById(R.id.playerElevenDotButton);
            playerElevenWicketButton = (Button) findViewById(R.id.playerElevenWicketButton);
            playerElevenOnStike =(TextView) findViewById(R.id.playerElevenOnStike);


            teamTotalRuns = (TextView) findViewById(R.id.teamTotalRun);
            teamTotalExtraRuns = (TextView) findViewById(R.id.teamTotalExtraRun);
            currentScoreTotalRun = (TextView) findViewById(R.id.currentScoreTotalRun);
            currentScoreWicket = (TextView) findViewById(R.id.currentScoreWicket);
            currentScoreOver = (TextView) findViewById(R.id.currentScoreOver);
            currentScoreBall = (TextView) findViewById(R.id.currentScoreBall);

            NoBowlButton = (Button) findViewById(R.id.NoBowlButton);
            wideBowlButton=(Button) findViewById(R.id.wideBowlButton);
            ByBowlButton= (Button) findViewById(R.id.ByBowlButton);
            doneButton = (Button) findViewById(R.id.doneButton);

            teamTargetLayout = (LinearLayout) findViewById(R.id.teamTargetLayout);
            targetRun = (TextView) findViewById(R.id.targetRun);

            undoButton = (Button) findViewById(R.id.undoButton);
            changeStrikerButton = (Button) findViewById(R.id.changeStrikerButton);
        }
    }

    public void makeExtraLayoutsInvisible(){
        {
            setInvisible(playerThreeLayout);
            setInvisible(playerFourLayout);
            setInvisible(playerFiveLayout);
            setInvisible(playerSixLayout);
            setInvisible(playerSevenLayout);
            setInvisible(playerEightLayout);
            setInvisible(playerNineLayout);
            setInvisible(playerTenLayout);
            setInvisible(playerElevenLayout);
            setInvisible(teamTargetLayout);
            doneButton.setVisibility(View.GONE);
        }
    }

    public void setValuesToDefaultStatus(){
        {
            playerOneTotalRun.setText(String.valueOf(0));
            playerOneTotalBallsPlayed.setText(String.valueOf(0));

            playerTwoTotalRun.setText(String.valueOf(0));
            playerTwoTotalBallsPlayed.setText(String.valueOf(0));

            playerThreeTotalRun.setText(String.valueOf(0));
            playerThreeTotalBallsPlayed.setText(String.valueOf(0));

            playerFourTotalRun.setText(String.valueOf(0));
            playerFourTotalBallsPlayed.setText(String.valueOf(0));

            playerFiveTotalRun.setText(String.valueOf(0));
            playerFiveTotalBallsPlayed.setText(String.valueOf(0));

            playerSixTotalRun.setText(String.valueOf(0));
            playerSixTotalBallsPlayed.setText(String.valueOf(0));

            playerSevenTotalRun.setText(String.valueOf(0));
            playerSevenTotalBallsPlayed.setText(String.valueOf(0));

            playerEightTotalRun.setText(String.valueOf(0));
            playerEightTotalBallsPlayed.setText(String.valueOf(0));

            playerNineTotalRun.setText(String.valueOf(0));
            playerNineTotalBallsPlayed.setText(String.valueOf(0));

            playerTenTotalRun.setText(String.valueOf(0));
            playerTenTotalBallsPlayed.setText(String.valueOf(0));

            playerElevenTotalRun.setText(String.valueOf(0));
            playerElevenTotalBallsPlayed.setText(String.valueOf(0));

            teamTotalRuns.setText(String.valueOf(0));
            teamTotalExtraRuns.setText(String.valueOf(0));
            currentScoreTotalRun.setText(String.valueOf(0));
            currentScoreWicket.setText(String.valueOf(0));
            currentScoreOver.setText(String.valueOf(0));
            currentScoreBall.setText(String.valueOf(0));

            targetRun.setText(String.valueOf(-1));

            teamWicketsGone=0;

            firstTeam = true;

            setPlayerDeployerDefaultValues();
        }
    }

    public void setPlayerDeployerDefaultValues(){
        nextPlayerToDeploy=3;
        playerLayoutList=new LinearLayout[9];
        playerLayoutList = new LinearLayout[]{playerThreeLayout, playerFourLayout, playerFiveLayout, playerSixLayout,
                playerSevenLayout, playerEightLayout, playerNineLayout, playerTenLayout, playerElevenLayout};

        currentPlayerPair = new int[2];
        currentPlayerPair[0] = 1;
        currentPlayerPair[1] = 2;

        lastPlayerDeployed = 2;

        playerOnStrikeList = new TextView[]{playerOneOnStike,playerTwoOnStike,playerThreeOnStike,playerFourOnStike,playerFiveOnStike,playerSixOnStike,
                                            playerSevenOnStike,playerEightOnStike,playerNineOnStike,playerTenOnStike,playerElevenOnStike};

        playersAllButtonList = new Button[11][7];
        playersAllButtonList = new Button[][]{{playerOneSixButton,playerOneFourButton,playerOneThreeButton,playerOneTwoButton,playerOneOneButton,
                                                        playerOneDotButton,playerOneWicketButton},
                                                {playerTwoSixButton,playerTwoFourButton,playerTwoThreeButton,playerTwoTwoButton,playerTwoOneButton,
                                                        playerTwoDotButton,playerTwoWicketButton},
                                                {playerThreeSixButton,playerThreeFourButton,playerThreeThreeButton,playerThreeTwoButton,playerThreeOneButton,
                                                        playerThreeDotButton,playerThreeWicketButton},
                                                {playerFourSixButton,playerFourFourButton,playerFourThreeButton,playerFourTwoButton,playerFourOneButton,
                                                        playerFourDotButton,playerFourWicketButton},
                                                {playerFiveSixButton,playerFiveFourButton,playerFiveThreeButton,playerFiveTwoButton,playerFiveOneButton ,
                                                        playerFiveDotButton,playerFiveWicketButton},
                                                {playerSixSixButton,playerSixFourButton,playerSixThreeButton,playerSixTwoButton,playerSixOneButton,
                                                        playerSixDotButton,playerSixWicketButton},
                                                {playerSevenSixButton,playerSevenFourButton,playerSevenThreeButton,playerSevenTwoButton,playerSevenOneButton,
                                                        playerSevenDotButton,playerSevenWicketButton},
                                                {playerEightSixButton,playerEightFourButton,playerEightThreeButton,playerEightTwoButton,playerEightOneButton,
                                                        playerEightDotButton,playerEightWicketButton},
                                                {playerNineSixButton,playerNineFourButton,playerNineThreeButton,playerNineTwoButton,playerNineOneButton,
                                                        playerNineDotButton,playerNineWicketButton},
                                                {playerTenSixButton,playerTenFourButton,playerTenThreeButton,playerTenTwoButton,playerTenOneButton ,
                                                        playerTenDotButton,playerTenWicketButton},
                                                {playerElevenSixButton,playerElevenFourButton,playerElevenThreeButton,playerElevenTwoButton,playerElevenOneButton,
                                                playerElevenDotButton,playerElevenWicketButton}};
    }

    public void setButtonFunctionalities(){
        playerOneSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6,playerOneTotalRun,playerOneTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerOneFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerOneTotalRun,playerOneTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerOneThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerOneTotalRun, playerOneTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.INVISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerOneTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerOneTotalRun,playerOneTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerOneOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerOneTotalRun, playerOneTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                setInvisible(playerOneOnStike);
               /* playerOneOnStike.setVisibility(playerOneOnStike.INVISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);
*/

            }
        });
        playerOneDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0, playerOneTotalRun, playerOneTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerOneWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerOneTotalBallsPlayed, playerOneSixButton, playerOneFourButton,
                        playerOneThreeButton, playerOneTwoButton, playerOneOneButton, playerOneDotButton, playerOneWicketButton);
                       setInvisible(playerOneOnStike);
                /*playerOneOnStike.setVisibility(playerOneOnStike.INVISIBLE);
                playerOneOnStike.setEnabled(false);*/
            }
        });


        playerTwoSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerTwoTotalRun, playerTwoTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerTwoFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerTwoTotalRun,playerTwoTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerTwoThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3,playerTwoTotalRun,playerTwoTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
                /*playerTwoOnStike.setVisibility(playerTwoOnStike.INVISIBLE);
                playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerTwoTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerTwoTotalRun,playerTwoTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerTwoOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerTwoTotalRun, playerTwoTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerTwoOnStike.setVisibility(playerTwoOnStike.INVISIBLE);
                playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/



            }
        });
        playerTwoDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0, playerTwoTotalRun, playerTwoTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerTwoWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerTwoTotalBallsPlayed, playerTwoSixButton, playerTwoFourButton,
                        playerTwoThreeButton, playerTwoTwoButton, playerTwoOneButton, playerTwoDotButton, playerTwoWicketButton);
                playerTwoOnStike.setVisibility(playerTwoOnStike.INVISIBLE);
                playerTwoOnStike.setEnabled(false);
            }
        });

        playerThreeSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerThreeTotalRun, playerThreeTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerThreeFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerThreeTotalRun,playerThreeTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerThreeThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3,playerThreeTotalRun,playerThreeTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.INVISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerThreeTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerThreeTotalRun,playerThreeTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerThreeOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerThreeTotalRun, playerThreeTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.INVISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/

            }
        });
        playerThreeDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0, playerThreeTotalRun, playerThreeTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerThreeWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerThreeTotalBallsPlayed, playerThreeSixButton, playerThreeFourButton,
                        playerThreeThreeButton, playerThreeTwoButton, playerThreeOneButton, playerThreeDotButton, playerThreeWicketButton);
                playerThreeOnStike.setVisibility(playerThreeOnStike.INVISIBLE);
                playerThreeOnStike.setEnabled(false);
            }
        });

        playerFourSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerFourTotalRun, playerFourTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerFourFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerFourTotalRun,playerFourTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerFourThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3,playerFourTotalRun,playerFourTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.INVISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerFourTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerFourTotalRun,playerFourTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerFourOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerFourTotalRun, playerFourTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.INVISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerFourDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0, playerFourTotalRun, playerFourTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerFourWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerFourTotalBallsPlayed, playerFourSixButton, playerFourFourButton,
                        playerFourThreeButton, playerFourTwoButton, playerFourOneButton, playerFourDotButton, playerFourWicketButton);
                playerFourOnStike.setEnabled(false);
            }
        });

        playerFiveSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerFiveTotalRun, playerFiveTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerFiveFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerFiveTotalRun,playerFiveTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerFiveThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerFiveTotalRun, playerFiveTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.INVISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerFiveTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerFiveTotalRun,playerFiveTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerFiveOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerFiveTotalRun, playerFiveTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
               /* playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.INVISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerFiveDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerFiveTotalRun,playerFiveTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerFiveWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerFiveTotalBallsPlayed, playerFiveSixButton, playerFiveFourButton,
                        playerFiveThreeButton, playerFiveTwoButton, playerFiveOneButton, playerFiveDotButton, playerFiveWicketButton);
                playerFiveOnStike.setEnabled(false);
            }
        });

        playerSixSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerSixTotalRun, playerSixTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerSixFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerSixTotalRun,playerSixTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSixThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerSixTotalRun, playerSixTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.INVISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerSixTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerSixTotalRun,playerSixTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSixOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerSixTotalRun, playerSixTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.INVISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerSixDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerSixTotalRun,playerSixTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSixWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerSixTotalBallsPlayed, playerSixSixButton, playerSixFourButton,
                        playerSixThreeButton, playerSixTwoButton, playerSixOneButton, playerSixDotButton, playerSixWicketButton);
                playerSixOnStike.setEnabled(false);
            }
        });

        playerSevenSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerSevenTotalRun, playerSevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerSevenFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerSevenTotalRun,playerSevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSevenThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerSevenTotalRun, playerSevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.INVISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerSevenTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerSevenTotalRun,playerSevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSevenOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerSevenTotalRun, playerSevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.INVISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerSevenDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerSevenTotalRun,playerSevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerSevenWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerSevenTotalBallsPlayed, playerSevenSixButton, playerSevenFourButton,
                        playerSevenThreeButton, playerSevenTwoButton, playerSevenOneButton, playerSevenDotButton, playerSevenWicketButton);
                playerSevenOnStike.setEnabled(false);
            }
        });

        playerEightSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerEightTotalRun, playerEightTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerEightFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerEightTotalRun,playerEightTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerEightThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerEightTotalRun, playerEightTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.INVISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerEightTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerEightTotalRun,playerEightTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerEightOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerEightTotalRun, playerEightTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.INVISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerEightDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerEightTotalRun,playerEightTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerEightWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerEightTotalBallsPlayed, playerEightSixButton, playerEightFourButton,
                        playerEightThreeButton, playerEightTwoButton, playerEightOneButton, playerEightDotButton, playerEightWicketButton);
                playerEightOnStike.setEnabled(false);
            }
        });

        playerNineSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerNineTotalRun, playerNineTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerNineFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerNineTotalRun,playerNineTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerNineThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerNineTotalRun, playerNineTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.INVISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerNineTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerNineTotalRun,playerNineTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerNineOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerNineTotalRun, playerNineTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.INVISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerNineDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerNineTotalRun,playerNineTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerNineWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerNineTotalBallsPlayed, playerNineSixButton, playerNineFourButton,
                        playerNineThreeButton, playerNineTwoButton, playerNineOneButton, playerNineDotButton, playerNineWicketButton);
                playerNineOnStike.setEnabled(false);
            }
        });


        playerTenSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerTenTotalRun, playerTenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerTenFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerTenTotalRun,playerTenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerTenThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerTenTotalRun, playerTenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.INVISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerTenTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerTenTotalRun,playerTenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerTenOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerTenTotalRun, playerTenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.INVISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.VISIBLE);*/
            }
        });
        playerTenDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerTenTotalRun,playerTenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerTenWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerTenTotalBallsPlayed, playerTenSixButton, playerTenFourButton,
                        playerTenThreeButton, playerTenTwoButton, playerTenOneButton, playerTenDotButton, playerTenWicketButton);
                playerTenOnStike.setEnabled(false);
            }
        });

        playerElevenSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(6, playerElevenTotalRun, playerElevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
            }
        });
        playerElevenFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(4,playerElevenTotalRun,playerElevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerElevenThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(3, playerElevenTotalRun, playerElevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver,currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.INVISIBLE);*/
            }
        });
        playerElevenTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(2,playerElevenTotalRun,playerElevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerElevenOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(1, playerElevenTotalRun, playerElevenTotalBallsPlayed, teamTotalRuns, currentScoreTotalRun, currentScoreOver, currentScoreBall);
                /*playerOneOnStike.setVisibility(playerOneOnStike.VISIBLE);
                playerTwoOnStike.setVisibility(playerTwoOnStike.VISIBLE);
                playerThreeOnStike.setVisibility(playerThreeOnStike.VISIBLE);
                playerFourOnStike.setVisibility(playerFourOnStike.VISIBLE);
                playerFiveOnStike.setVisibility(playerFiveOnStike.VISIBLE);
                playerSixOnStike.setVisibility(playerSixOnStike.VISIBLE);
                playerSevenOnStike.setVisibility(playerSevenOnStike.VISIBLE);
                playerEightOnStike.setVisibility(playerEightOnStike.VISIBLE);
                playerNineOnStike.setVisibility(playerNineOnStike.VISIBLE);
                playerTenOnStike.setVisibility(playerTenOnStike.VISIBLE);
                playerElevenOnStike.setVisibility(playerElevenOnStike.INVISIBLE);*/
            }
        });
        playerElevenDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runsScored(0,playerElevenTotalRun,playerElevenTotalBallsPlayed,teamTotalRuns,currentScoreTotalRun,currentScoreOver,currentScoreBall);
            }
        });
        playerElevenWicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket(currentScoreWicket, currentScoreBall, currentScoreOver, playerElevenTotalBallsPlayed, playerElevenSixButton, playerElevenFourButton,
                        playerElevenThreeButton, playerElevenTwoButton, playerElevenOneButton, playerElevenDotButton, playerElevenWicketButton);
                playerElevenOnStike.setEnabled(false);
            }
        });

        wideBowlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wideOrByeOrNo("wide", teamTotalRuns, currentScoreTotalRun, teamTotalExtraRuns);
            }
        });

        NoBowlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wideOrByeOrNo("no",teamTotalRuns,currentScoreTotalRun,teamTotalExtraRuns);
            }
        });

        ByBowlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wideOrByeOrNo("bye",teamTotalRuns,currentScoreTotalRun,teamTotalExtraRuns);
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneButtonFunctionality();
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastRunChange.rollbackLastChange();
                undoButton.setEnabled(false);
            }
        });

        changeStrikerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapPlayers();
            }
        });
    }
}



class lastRunChange{

    public static boolean wicketChange;

    public static boolean playerAsWellAsTeamChange;

    public static int amount;

    public static int playerNumber;

    public static TextView currentScoreTotalRun;
    public static TextView currentScoreOver;
    public static TextView currentScoreBall;
    public static TextView playerTotalRun;
    public static TextView playerTotalNumberOfBallsPlayed;
    public static TextView teamTotalRun;

    public static TextView currentScoreWicket;
    public static Button sixButton;
    public static Button fourButton;
    public static Button threeButton;
    public static Button twoButton;
    public static Button oneButton;
    public static Button dotButton;
    public static Button wicketButton;




    public static void setPlayerChange(int amt ,TextView currentScoreTotalRunVar, TextView currentScoreOverVar , TextView currentScoreBallVar,
                                       TextView playerTotalRunVar, TextView playerTotalNumberOfBallsPlayedVar,
                                       TextView teamTotalRunVar){

        amount =amt;
        wicketChange=false;
        playerAsWellAsTeamChange = true;
        currentScoreTotalRun = currentScoreTotalRunVar;
        currentScoreOver = currentScoreOverVar;
        currentScoreBall = currentScoreBallVar;
        playerTotalRun = playerTotalRunVar;
        playerTotalNumberOfBallsPlayed = playerTotalNumberOfBallsPlayedVar;
        teamTotalRun = teamTotalRunVar;

    }

    public static void setTeamChangeForExtraRun(){
        wicketChange=false;
        playerAsWellAsTeamChange = false;
    }

    public static void rollbackLastChange(){
        if(!wicketChange){
            if(playerAsWellAsTeamChange){reversePlayerChange();}
            else extraRunChangeRollback();
        }
        else rollBackWicketChange();
    }

    public static void extraRunChangeRollback(){
        cellMinusMinus(currentScoreTotalRun);
        cellMinusMinus(teamTotalRun);
        MatchProgress.swapPlayers();
    }

    public static void reversePlayerChange(){
        decreaseCellValue(currentScoreTotalRun, amount);
        overCounterMinusMinus(currentScoreBall, currentScoreOver);
        decreaseCellValue(playerTotalRun, amount);
        decreaseCellValue(teamTotalRun, amount);
        cellMinusMinus(playerTotalNumberOfBallsPlayed);
        if(amount==1 || amount==3) MatchProgress.swapPlayers();
    }

    public static void decreaseCellValue(TextView cellToUpdate, int amountToBeAdded) {
        int val = Integer.parseInt( cellToUpdate.getText().toString());
        val-= amountToBeAdded ;
        cellToUpdate.setText(String.valueOf(val));
    }


    public static void cellMinusMinus(TextView cellToIncrement) {
        int oldAmount = Integer.parseInt(cellToIncrement.getText().toString());
        oldAmount--;
        cellToIncrement.setText(String.valueOf(oldAmount));
    }

    public static void setValue(TextView tv, int amount){tv.setText(String.valueOf(amount));}

    public static void overCounterMinusMinus(TextView currentScoreBallVariable, TextView currentScoreOverVariable) {
        int currentBall = Integer.parseInt(currentScoreBallVariable.getText().toString());
        if (currentBall == 0) {
            cellMinusMinus(currentScoreOverVariable);
            setValue(currentScoreBallVariable, 5);
            MatchProgress.swapPlayers();
        }
        else if (currentBall > 0) {
            cellMinusMinus(currentScoreBallVariable);
        }
    }

    public static void setWicketChange(TextView currentScoreWicketVariable,TextView currentScoreBallVaribale,
                                       TextView currentScoreOverVariable,
                                       TextView playerTotalBallVariable, Button sixButtonVar, Button fourButtonVar,
                                       Button threeButtonVar,Button twoButtonVar,Button oneButtonVar,
                                       Button dotButtonVar,Button wicketButtonVar,
                                       int playerNumberVar){
        wicketChange=true;
        currentScoreWicket = currentScoreWicketVariable;
        currentScoreBall = currentScoreBallVaribale;
        currentScoreOver = currentScoreOverVariable;
        playerTotalNumberOfBallsPlayed = playerTotalBallVariable;
        sixButton = sixButtonVar;
        fourButton = fourButtonVar;
        threeButton = threeButtonVar;
        twoButton = twoButtonVar;
        oneButton = oneButtonVar;
        dotButton = dotButtonVar;
        wicketButton = wicketButtonVar;
        playerNumber = playerNumberVar;
    }

    public static void rollBackWicketChange(){
        overCounterMinusMinus(currentScoreBall, currentScoreOver);
        cellMinusMinus(playerTotalNumberOfBallsPlayed);
        cellMinusMinus(currentScoreWicket);
        makeButtonsVisible(sixButton, fourButton, threeButton, twoButton, oneButton, dotButton, wicketButton);
        MatchProgress.makeButtonsOfThisPlayerVisible(MatchProgress.currentPlayerPair[0] - 1, false);
        MatchProgress.playerOnStrikeList[MatchProgress.currentPlayerPair[0]-1].setVisibility(View.GONE);
        MatchProgress.currentPlayerPair[0] = playerNumber;
        MatchProgress.implementSwap();
    }

    public static void makeButtonsVisible(Button sixButtonVar, Button fourButtonVar,
                                   Button threeButtonVar,Button twoButtonVar,Button oneButtonVar,
                                   Button dotButtonVar,Button wicketButtonVar){
        makeVisible(sixButtonVar);
        makeVisible(fourButtonVar);
        makeVisible(threeButtonVar);
        makeVisible(twoButtonVar);
        makeVisible(oneButtonVar);
        makeVisible(dotButtonVar);
        makeVisible(wicketButtonVar);
    }

    public static void makeVisible(View newView){
        newView.setVisibility(View.VISIBLE);
    }
}




class lastWicketChange{
  /*
  Implement wicket rollback change here

   Based on ht changes made by Qaium
   */

}