package css.poquette.minecraft_encylopedia_poquette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Selected Features (must add up to 15 points)
    // Implement multiple activities (5 points)
    //Interface with other apps using intents (5 points each)
        // open browser to relevant page on the Minecraft wiki
        // review unit 6 intents assignment
        // C:\Users\vpoquette\AndroidStudioProjects\cis3334-unit6-intents-f23-vpoquette\app\src\main\java\css\cis3334unit6intents\MainActivity.java
// Handle images or videos or sound files in your app (5 points)
    // just Minecraft logo for now
    // would be great to make it dynamic
        // Need to figure out how to pull the image from the minecraft wiki, since the .json doesn't include images
        // Issue: Minecraft wiki and .json use different naming conventions

// Could we make these work?
    // Use new layout widgets besides TextView, EditText, and Button (5 points)
        // who knows what though
    // Implement custom menus, a navigation bar, or the floating action button (5 points) - Android developer docs on Menus
        // useful for later expansion after block search - item search, entity search, biome search

// https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.9/blocks.json
    // Oct 22+ content

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    Button button;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        setUpButton(); // separating the button creation + function into another method
    }

    private void setUpButton() {
        // simple variables
        button = findViewById(R.id.showResult);
        name = findViewById(R.id.nameInput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334 Minecraft", "showResult clicked");   // debug check
                Intent detailActIntent = new Intent(MainActivity.this, ResultActivity.class); // initialize the intent
                // pass data to result activity
                detailActIntent.putExtra("name", name.getText().toString()); // no longer simple variables
                startActivity(detailActIntent); // move to result activity
            }
        });
    }
}