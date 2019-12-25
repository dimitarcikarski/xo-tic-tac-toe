package mk.codeacademy.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlayClick(View view) {
        Intent i = new Intent(this,EnterNameActivity.class);
        startActivity(i);
    }

    public void onStatisticsClick(View view) {
        Intent i = new Intent(this,StatisticsActivity.class);
        startActivity(i);
    }
}
