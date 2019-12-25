package mk.codeacademy.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    TextView xscore;
    TextView oscore;
    TextView tiescore;
    SharedPreferences sharedPreferences;
    TextView name1;
    TextView name2;
    TextView name3;
    TextView name4;
    TextView name5;
    TextView score1;
    TextView score2;
    TextView score3;
    TextView score4;
    TextView score5;
    int best1;
    int best2;
    int best3;
    int best4;
    int best5;
    String bestName1;
    String bestName2;
    String bestName3;
    String bestName4;
    String bestName5;
    int lastscore;
    String lastScoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        xscore = (TextView) findViewById(R.id.xscore);
        oscore = (TextView) findViewById(R.id.oscore);
        tiescore = (TextView) findViewById(R.id.tiescore);

        sharedPreferences = getSharedPreferences("MY_SHARED_PREF",MODE_PRIVATE);

        xscore.setText(sharedPreferences.getInt("xwon",0)+"");
        oscore.setText(sharedPreferences.getInt("owon",0)+"");
        tiescore.setText(sharedPreferences.getInt("tie",0)+"");

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);
        name5 = (TextView) findViewById(R.id.name5);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);

        lastscore = sharedPreferences.getInt("lastHiScore",0);
        lastScoreName = sharedPreferences.getString("lastScoreName",null);
        best1 = sharedPreferences.getInt("best1",0);
        best2 = sharedPreferences.getInt("best2",0);
        best3 = sharedPreferences.getInt("best3",0);
        best4 = sharedPreferences.getInt("best4",0);
        best5 = sharedPreferences.getInt("best5",0);
        bestName1 = sharedPreferences.getString("bestName1",null);
        bestName2 = sharedPreferences.getString("bestName2",null);
        bestName3 = sharedPreferences.getString("bestName3",null);
        bestName4 = sharedPreferences.getString("bestName4",null);
        bestName5 = sharedPreferences.getString("bestName5",null);

        if(lastscore > best5){
            best5 = lastscore;
            bestName5 = lastScoreName;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("best5",best5);
            editor.putString("bestName5",bestName5);
            editor.apply();
        }
        if(lastscore > best4){
            int temp = best4;
            best4 = lastscore;
            best5 = temp;
            String temps = bestName4;
            bestName4 = lastScoreName;
            bestName5 = temps;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("best5",best5);
            editor.putString("bestName5",bestName5);
            editor.putInt("best4",best4);
            editor.putString("bestName4",bestName4);
            editor.apply();
        }
        if(lastscore > best3){
            int temp = best3;
            best3 = lastscore;
            best4 = temp;
            String temps = bestName3;
            bestName3 = lastScoreName;
            bestName4 = temps;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("best4",best4);
            editor.putString("bestName4",bestName4);
            editor.putInt("best3",best3);
            editor.putString("bestName3",bestName3);
            editor.apply();
        }
        if(lastscore > best2){
            int temp = best2;
            best2 = lastscore;
            best3 = temp;
            String temps = bestName2;
            bestName2 = lastScoreName;
            bestName3 = temps;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("best3",best3);
            editor.putString("bestName3",bestName3);
            editor.putInt("best2",best2);
            editor.putString("bestName2",bestName2);
            editor.apply();
        }
        if(lastscore > best1){
            int temp = best1;
            best1 = lastscore;
            best2 = temp;
            String temps = bestName1;
            bestName1 = lastScoreName;
            bestName2 = temps;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("best2",best2);
            editor.putString("bestName2",bestName2);
            editor.putInt("best1",best1);
            editor.putString("bestName1",bestName1);
            editor.apply();
        }

        name1.setText(bestName1);
        name2.setText(bestName2);
        name3.setText(bestName3);
        name4.setText(bestName4);
        name5.setText(bestName5);

        score1.setText(best1+"");
        score2.setText(best2+"");
        score3.setText(best3+"");
        score4.setText(best4+"");
        score5.setText(best5+"");
    }

    public void onClearStatistics(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("lastHiScore");
        editor.remove("lastScoreName");
        editor.remove("best1");
        editor.remove("best2");
        editor.remove("best3");
        editor.remove("best4");
        editor.remove("best5");
        editor.remove("bestName1");
        editor.remove("bestName2");
        editor.remove("bestName3");
        editor.remove("bestName4");
        editor.remove("bestName5");
        editor.remove("xwon");
        editor.remove("owon");
        editor.remove("tie");
        editor.commit();

        name1.setText("");
        name2.setText("");
        name3.setText("");
        name4.setText("");
        name5.setText("");

        score1.setText("");
        score2.setText("");
        score3.setText("");
        score4.setText("");
        score5.setText("");

        xscore.setText("0");
        oscore.setText("0");
        tiescore.setText("0");
    }
}
