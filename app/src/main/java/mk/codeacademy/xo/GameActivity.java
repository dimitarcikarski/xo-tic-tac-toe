package mk.codeacademy.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView p1;
    TextView p2;
    TextView p3;
    TextView p4;
    TextView p5;
    TextView p6;
    TextView p7;
    TextView p8;
    TextView p9;
    TextView whowins;
    TextView score1;
    TextView score2;
    int turn=0; //0-Player 1   , 1-Player 2
    int scoreForX=0;
    int scoreForO=0;
    int scoreForTie=0;
    String playeronename;
    String playertwoname;
    TextView player1name;
    TextView player2name;
    TextView player1turn;
    TextView player2turn;
    int gameIsOver = 0 ; // 0 - still playing ; 1 - gameIsOver
    int counter = 0;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView) findViewById(R.id.p4);
        p5 = (TextView) findViewById(R.id.p5);
        p6 = (TextView) findViewById(R.id.p6);
        p7 = (TextView) findViewById(R.id.p7);
        p8 = (TextView) findViewById(R.id.p8);
        p9 = (TextView) findViewById(R.id.p9);
        whowins = (TextView) findViewById(R.id.whowins);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        player1name = (TextView) findViewById(R.id.playeronename);
        player2name = (TextView) findViewById(R.id.playertwoname);
        player1turn = (TextView) findViewById(R.id.playeroneturn);
        player2turn = (TextView) findViewById(R.id.playertwoturn);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("playeronename").equals("")){
            playeronename = getResources().getString(R.string.player1_ingame);
        }else{
            playeronename = extras.getString("playeronename");
        }

        if(extras.getString("playertwoname").equals("")){
            playertwoname = getResources().getString(R.string.player2ingame);
        }else{
            playertwoname = extras.getString("playertwoname");
        }

        player1name.setText(playeronename);
        player2name.setText(playertwoname);

        player1turn.setText(">");

        sharedPreferences = getSharedPreferences("MY_SHARED_PREF",MODE_PRIVATE);

    }

    public void onFieldClick(View view) {
        TextView textView = (TextView) view;
        if(turn == 0 && textView.getText().toString().equals("") && gameIsOver == 0){
            turn = 1;
            textView.setText("x");
            counter+=1;
            player2turn.setText(">");
            player1turn.setText("");
        }else if(turn == 1 && textView.getText().toString().equals("")&& gameIsOver == 0){
            turn = 0;
            textView.setText("o");
            counter+=1;
            player1turn.setText(">");
            player2turn.setText("");
        }

        if (hasWon("x")) {
            if(gameIsOver == 0) {
                scoreForX += 1;
                score1.setText("" + scoreForX);
            }
            whowins.setText(playeronename + " " + getResources().getString(R.string.wins));
            gameIsOver = 1;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            int x;
            x= sharedPreferences.getInt("xwon",0);
            x+=1;
            editor.putInt("xwon",x);
            editor.commit();

        } else if (hasWon("o")) {
            if(gameIsOver == 0) {
                scoreForO += 1;
                score2.setText("" + scoreForO);
            }
            whowins.setText(playertwoname+" "+ getResources().getString(R.string.wins));
            gameIsOver = 1;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            int x;
            x= sharedPreferences.getInt("owon",0);
            x+=1;
            editor.putInt("owon",x);
            editor.commit();
        } else if (counter == 9 && gameIsOver == 0){
            scoreForTie+=1;
            whowins.setText("Tie !");
            gameIsOver = 1;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            int x;
            x= sharedPreferences.getInt("tie",0);
            x+=1;
            editor.putInt("tie",x);
            editor.commit();
        }

        if(scoreForO>=scoreForX){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("lastScoreName",playertwoname);
            editor.putInt("lastHiScore",scoreForO);
            editor.apply();
        }else if(scoreForX>=scoreForX){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("lastScoreName",playeronename);
            editor.putInt("lastHiScore",scoreForX);
            editor.apply();
        }
    }

    public void onClearTableClick(View view) {
        p1.setText("");
        p2.setText("");
        p3.setText("");
        p4.setText("");
        p5.setText("");
        p6.setText("");
        p7.setText("");
        p8.setText("");
        p9.setText("");
        whowins.setText("");
        gameIsOver = 0;
        counter = 0;
    }

    public void onExitClick(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private boolean hasWon(String value){
        return ((p1.getText().toString().equals(value) && p2.getText().toString().equals(value) && p3.getText().toString().equals(value)) ||
                (p4.getText().toString().equals(value) && p5.getText().toString().equals(value) && p6.getText().toString().equals(value)) ||
                (p7.getText().toString().equals(value) && p8.getText().toString().equals(value) && p9.getText().toString().equals(value)) ||
                (p1.getText().toString().equals(value) && p4.getText().toString().equals(value) && p7.getText().toString().equals(value)) ||
                (p2.getText().toString().equals(value) && p5.getText().toString().equals(value) && p8.getText().toString().equals(value)) ||
                (p3.getText().toString().equals(value) && p6.getText().toString().equals(value) && p9.getText().toString().equals(value)) ||
                (p1.getText().toString().equals(value) && p5.getText().toString().equals(value) && p9.getText().toString().equals(value)) ||
                (p3.getText().toString().equals(value) && p5.getText().toString().equals(value) && p7.getText().toString().equals(value)));

    }
}