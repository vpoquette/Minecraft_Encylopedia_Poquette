package css.poquette.minecraft_encylopedia_poquette;

public class Transfer {

}

// class - Block?
/*
private void getBlockAPI() {
        String url = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.9/blocks.json";
        // Create a Volley web request to receive back a JSON object.
        // This requires two listeners for Async response, onResponse() and onErrorResponse()
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest (Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Loop through the array elements
                            Log.d("CIS 3334", "In getStudentAPI -- Number of blocks retrieved = "+ response.length());
                            textViewStatus.setText("Minecraft Blocks: \n");
                            for(int i=0;i<response.length();i++){
                                Gson gson = new Gson();
                                MinecraftBlock obj = gson.fromJson(response.getJSONObject(i).toString(), MinecraftBlock.class);
                                textViewStatus.append(obj.getDisplayName()+"\n ================== \n");
                            }
                        } catch (JSONException e) {
                            Log.d("CIS 3334", "In getStudentAPI -- JSONException = "+e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("CIS 3334", "In getStudentAPI -- onErrorResponse = "+error);
                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }
 */

// Main Activity
/*
private void setupButtonStudentAPI() {
        buttonStudentAPI = findViewById(R.id.buttonStudentAPI);
        buttonStudentAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "getStudentAPI onClick");
                getStudentAPI();
            }
        });
    }
 */

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */

// below code generated by https://json2csharp.com/code-converters/json-to-pojo
/*
public class Drop{
    public Object drop;
    public double minCount;
    public int maxCount;
}

public class HarvestTools{
    @JsonProperty("257")
    public boolean _257;
    @JsonProperty("270")
    public boolean _270;
    @JsonProperty("274")
    public boolean _274;
    @JsonProperty("278")
    public boolean _278;
    @JsonProperty("285")
    public boolean _285;
    @JsonProperty("267")
    public boolean _267;
    @JsonProperty("268")
    public boolean _268;
    @JsonProperty("272")
    public boolean _272;
    @JsonProperty("276")
    public boolean _276;
    @JsonProperty("283")
    public boolean _283;
    @JsonProperty("359")
    public boolean _359;
    @JsonProperty("256")
    public boolean _256;
    @JsonProperty("269")
    public boolean _269;
    @JsonProperty("273")
    public boolean _273;
    @JsonProperty("277")
    public boolean _277;
    @JsonProperty("284")
    public boolean _284;
}

public class Root{
    public int id;
    public String displayName;
    public String name;
    public double hardness;
    public int stackSize;
    public boolean diggable;
    public String boundingBox;
    public ArrayList<Drop> drops;
    public boolean transparent;
    public int emitLight;
    public int filterLight;
    public double resistance;
    public String material;
    public HarvestTools harvestTools;
    public ArrayList<Variation> variations;
}

public class Variation{
    public int metadata;
    public String displayName;
}

 */