package css.poquette.minecraft_encylopedia_poquette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* Selected Features (must add up to 15 points) */
    // Implement multiple activities (5 points)
    //Interface with other apps using intents (5 points each)
        // open browser to relevant page on the Minecraft wiki
    // Handle images or videos or sound files in your app (5 points)
        // just Minecraft logo for now
        // would be great to make it dynamic
            // Need to figure out how to pull the image from the minecraft wiki, since the .json doesn't include images
            // Issue: Minecraft wiki and .json use different naming conventions

/* Future Development */
    // add variation and drop information
        // currently unused BlockVariation and BlockDrop classes - attempted this during initial version but did not succeed
    // grab image from Minecraft wiki if result found
        // Issue: Minecraft wiki and .json use different naming conventions
    // add other searches
        // item search, entity search, biome search
        // use navigation bar - Android developer docs on Menus

public class MainActivity extends AppCompatActivity {

    Block mainViewModel;
    Button button;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(Block.class);

        setUpButton(); // separating the button creation + function into another method
    }

    private void setUpButton() {
        // connect to UI elements
        button = findViewById(R.id.showResult);
        name = findViewById(R.id.nameInput);

        button.setOnClickListener(new View.OnClickListener() { // when the button is clicked
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334 Minecraft", "showResult clicked");   // debug check
                Intent detailActIntent = new Intent(MainActivity.this, ResultActivity.class); // initialize the intent

                // pass data item to result activity
                detailActIntent.putExtra("name", name.getText().toString());
                startActivity(detailActIntent); // move to result activity
            }
        });
    }
}