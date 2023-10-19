package css.poquette.minecraft_encylopedia_poquette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView nameResult;
    TextView idResult;
    TextView digResult;
    Button returnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CIS 3334 Flooring", "moved to result activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // connect to UI elements
        nameResult = (TextView) findViewById(R.id.nameResult);
        idResult = (TextView) findViewById(R.id.idResult);
        digResult = (TextView) findViewById(R.id.digResult);

        Bundle extras = getIntent().getExtras(); // retrieve all passed variables
        // retrieve specific values
        String name = extras.getString("name");
        //Integer id = extras.getInt("id");
            // grab id, etc. info from json

        // hardcoded values for now
        Integer id = 1;
        Boolean diggable = true;

        Log.d("name", String.valueOf(name));
        Log.d("id", String.valueOf(id));

        // display values
        nameResult.setText(name);
        idResult.setText(id.toString());
        digResult.setText(diggable.toString());

        setUpButton(); // self-explanatory method
    }

    private void setUpButton() {
        returnHome = findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334 Flooring", "newCalculation clicked"); // debug tag
                finish(); // delete current activity and return to initial screen
                // beats the alternative of painting over the current activity amirite
            }
        });
    }
}