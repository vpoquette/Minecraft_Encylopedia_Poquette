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

import java.util.ArrayList;
import java.util.List;


public class ResultActivity extends AppCompatActivity {

    TextView nameResult;
    TextView idResult;
    TextView digResult;
    Button wikiButton, returnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CIS 3334 Minecraft", "moved to result activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras(); // retrieve all passed variables
        // retrieve specific values
        String name = extras.getString("name");
        // connect to UI elements
        nameResult = (TextView) findViewById(R.id.nameResult);
        idResult = (TextView) findViewById(R.id.idResult);
        digResult = (TextView) findViewById(R.id.digResult);

        Integer id = 1;
        Boolean diggable = true;

            String url = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.9/blocks.json"; // thanks GitHub user
            // Create a Volley web request to receive back a JSON object.
            // This requires two listeners for Async response, onResponse() and onErrorResponse()
            JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest (Request.Method.GET, url,null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                // Loop through the array elements
                                Log.d("CIS 3334", "In getBlockAPI -- Number of blocks retrieved = "+ response.length());
                                //textViewStatus.setText("Minecraft Blocks: \n");
                                for(int i=0;i<response.length();i++){
                                    Gson gson = new Gson();
                                    Block obj = gson.fromJson(response.getJSONObject(i).toString(), Block.class);
                                    //textViewStatus.append(obj.getDisplayName()+"\n ================== \n");

                                    Log.d("CIS 3334", name);
                                    Log.d("CIS 3334", obj.getDisplayName()); // it's getting all of them
                                        // maybe add to array and check if entered name is in array?
                                    if (obj.getDisplayName() == name){ // only checking last one!
                                        Log.d("CIS 3334", "Name Match");
                                        nameResult.setText(obj.getDisplayName()); // from json

                                        idResult.setText(id.toString()); // hardcoded values until we confirm that the JSON name works
                                        digResult.setText(diggable.toString()); // hardcoded values until we confirm that the JSON name works
                                        // etc.

                                        //nameResult.append(obj.getDisplayName()+"\n ================== \n");
                                    }
                                    else{
                                        nameResult.setText("No result found. Please try again.");
                                    }
                                }
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

                Uri webpage = Uri.parse("https://minecraft.fandom.com/wiki/" + nameResult.getText());
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
                // beats the alternative of painting over the current activity amirite
            }
        });
    }
}