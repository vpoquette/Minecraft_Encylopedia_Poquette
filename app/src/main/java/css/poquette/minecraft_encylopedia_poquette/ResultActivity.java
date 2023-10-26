package css.poquette.minecraft_encylopedia_poquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

public class ResultActivity extends AppCompatActivity {

    TextView idResult, nameResult, digResult, stackSize, transparent, emitLight, filterLight;
    Button wikiButton, returnHome;

    // create placeholder block with handy error message already included
    Block selectedBlock = new Block(0, "No result found. Please try again.", "_", 0, false, false, 0, 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CIS 3334 Minecraft", "moved to result activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras(); // retrieve all passed variables
        // retrieve specific value
        String name = extras.getString("name");
        // connect to UI elements
        nameResult = (TextView) findViewById(R.id.nameResult);
        idResult = (TextView) findViewById(R.id.idResult);
        digResult = (TextView) findViewById(R.id.digResult);
        stackSize = (TextView) findViewById(R.id.stackSize);
        transparent = (TextView) findViewById(R.id.transparent);
        emitLight = (TextView) findViewById(R.id.emitLight);
        filterLight = (TextView) findViewById(R.id.filterLight);
            String url = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.9/blocks.json"; // thanks GitHub user
            // Create a Volley web request to receive back a JSON object.
            // This requires two listeners for Async response, onResponse() and onErrorResponse()
            JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest (Request.Method.GET, url,null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                // Loop through .json file
                                Log.d("CIS 3334", "In getBlockAPI -- Number of blocks retrieved = "+ response.length());
                                for(int i=0;i<response.length();i++){
                                    Gson gson = new Gson();
                                    Block obj = gson.fromJson(response.getJSONObject(i).toString(), Block.class);
                                    if (obj.getDisplayName().equalsIgnoreCase(name)){ // since we're comparing strings, can't use ==
                                        selectedBlock=obj; // set selectedBlock to matching block
                                        break; // exit loop
                                    }
                                }
                                // set TextViews to selectedBlock values
                                    // if match found, will display values from .JSON
                                    // if match not found, will display default values, including error message
                                nameResult.setText(selectedBlock.getDisplayName());
                                idResult.setText(selectedBlock.getID().toString()); // if the returned datatype is not already string, set it to .toString() or the textView will crash the app
                                digResult.setText(selectedBlock.getDiggable().toString());
                                stackSize.setText(selectedBlock.getStackSize().toString());
                                transparent.setText(selectedBlock.getTransparent().toString());
                                emitLight.setText(selectedBlock.getEmitLight().toString());
                                filterLight.setText(selectedBlock.getFilterLight().toString());
                            } catch (JSONException e) {
                                Log.d("CIS 3334", "In getBlockAPI -- JSONException = "+e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("CIS 3334", "In getBlockAPI -- onErrorResponse = "+error);
                        }
                    });
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(jsonArrayRequest);

        setUpButton(); // sets up restart button
        setUpWeb(); // sets up wiki page button
    }

    private void setUpWeb() {
        wikiButton = findViewById(R.id.wikiButton);
        wikiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334 Minecraft", "wikiButton clicked"); // debug tag

                // string manipulation
                String linkName = nameResult.getText().toString();
                if (linkName.contains(" ")){
                    linkName.replace(" ", "_"); // minecraft wiki uses underscores where the data uses spaces
                }
                Uri webpage = Uri.parse("https://minecraft.fandom.com/wiki/" + linkName);
                // dynamic url using entered name
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
    }

    private void setUpButton() {
        returnHome = findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334 Minecraft", "returnHome clicked"); // debug tag
                finish(); // delete current activity and return to initial screen
            }
        });
    }
}