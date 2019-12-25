package mk.codeacademy.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterNameActivity extends AppCompatActivity {
    EditText player1name;
    EditText player2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        player1name = (EditText) findViewById(R.id.playeronename);
        player2name = (EditText) findViewById(R.id.playertwoname);

    }

    public void onPlayClickInNames(View view) {
        Intent i  = new Intent(this,GameActivity.class);
        i.putExtra("playeronename",player1name.getText().toString());
        i.putExtra("playertwoname",player2name.getText().toString());
        startActivity(i);
    }
}
