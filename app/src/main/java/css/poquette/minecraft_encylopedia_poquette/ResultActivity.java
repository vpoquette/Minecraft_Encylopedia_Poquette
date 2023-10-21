package css.poquette.minecraft_encylopedia_poquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    TextView nameResult;
    TextView idResult;
    TextView digResult;
    Button wikiButton, returnHome;
    List<Block> blockList = new ArrayList<Block>();

    // temporary variables
    List<BlockVariation> noVariations = new ArrayList<BlockVariation>();
    List<BlockVariation> stoneVariations = new ArrayList<BlockVariation>();
    List<BlockVariation> dirtVariations = new ArrayList<BlockVariation>();
    // it's healthy to keep them in separate declarations
    List<BlockDrop> noDrops = new ArrayList<BlockDrop>();
    List<BlockDrop> stoneDrops = new ArrayList<BlockDrop>();
    List<BlockDrop> grassDrops = new ArrayList<BlockDrop>();
    List<BlockDrop> dirtDrops = new ArrayList<BlockDrop>();
    BlockVariation noVariation = new BlockVariation(0, "");
    BlockVariation stoneVariation1 = new BlockVariation(0, "Stone");
    BlockVariation stoneVariation2 = new BlockVariation(1, "Granite");
    BlockVariation stoneVariation3 = new BlockVariation(2, "Polished Granite");
    BlockVariation stoneVariation4 = new BlockVariation(3, "Diorite");
    BlockVariation stoneVariation5 = new BlockVariation(4, "Polished Diorite");
    BlockVariation stoneVariation6 = new BlockVariation(5, "Andesite");
    BlockVariation stoneVariation7 = new BlockVariation(6, "Polished Andesite");
    BlockVariation dirtVariation1 = new BlockVariation(0, "Dirt");
    BlockVariation dirtVariation2 = new BlockVariation(1, "Coarse Dirt");
    BlockVariation dirtVariation3 = new BlockVariation(2, "Podzol");
    BlockDrop noDrop = new BlockDrop(0);
    BlockDrop stoneDrop = new BlockDrop(4);
    BlockDrop grassDrop = new BlockDrop(3);
    BlockDrop dirtDrop = new BlockDrop(3);

    Block airBlock = new Block(0, "Air", "air", 0, false, noVariations, noDrops, true, 0, 0);
    Block stoneBlock = new Block(1, "Stone", "stone", 64, true, stoneVariations, stoneDrops, false, 0, 15);
    Block grassBlock = new Block(2, "Grass Block", "grass", 64, true, noVariations, grassDrops, false, 0, 15);
    Block dirtBlock = new Block(3, "Dirt", "dirt", 64, true, dirtVariations, dirtDrops, false, 0, 15);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CIS 3334 Minecraft", "moved to result activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // connect to UI elements
        nameResult = (TextView) findViewById(R.id.nameResult);
        idResult = (TextView) findViewById(R.id.idResult);
        digResult = (TextView) findViewById(R.id.digResult);

        setUpVariations(); // set up variations
        setUpDrops(); // set up drops
        setUpBlocks(); // set up blocks

        Bundle extras = getIntent().getExtras(); // retrieve all passed variables
        // retrieve specific values
        String name = extras.getString("name");
        checkForExistence(name); // makes sure inputted name exists in block list
            // input validation; not sure if that falls under error handling but if so I'll take the points

        //Integer id = extras.getInt("id");
            // will grab id, etc. info from json
            // hardcoded values for now
        Integer id = 1;
        Boolean diggable = true;

        Log.d("name", String.valueOf(name));
        Log.d("id", String.valueOf(id));

        // display values
        nameResult.setText(name);
        idResult.setText(id.toString());
        digResult.setText(diggable.toString());

        setUpButton(); // sets up restart button
        setUpWeb(); // sets up wiki page button
    }

    // https://github.com/PrismarineJS/minecraft-data/blob/master/data/pc/1.9/blocks.json

    // actual method we'll update and use once we know how to use the .json file
    /*
    private List<Block> createBlockList (jsonFile json){
        blockList = new blockList();
        for (jsonFile json : json.getChildren()) {
            Block block = data.getValue(Block.class);
            blockList.add(block);
        }
        return blockList;
    }
    */

    // temporary method until we know how to use the .json file
    private void setUpVariations(){
        noVariations.add(noVariation);
        stoneVariations.add(stoneVariation1);
        stoneVariations.add(stoneVariation2);
        stoneVariations.add(stoneVariation3);
        stoneVariations.add(stoneVariation4);
        stoneVariations.add(stoneVariation5);
        stoneVariations.add(stoneVariation6);
        stoneVariations.add(stoneVariation7);

        dirtVariations.add(dirtVariation1);
        dirtVariations.add(dirtVariation2);
        dirtVariations.add(dirtVariation3);
    }
    // temporary method
    private void setUpDrops(){
        noDrops.add(noDrop);
        stoneDrops.add(stoneDrop);
        grassDrops.add(grassDrop);
        dirtDrops.add(dirtDrop);
    }
    // probably temmporary
    private void setUpBlocks() {
        blockList.add(airBlock);
        blockList.add(stoneBlock);
        blockList.add(grassBlock);
        blockList.add(dirtBlock);
    }

    private Boolean checkForExistence(String name){
        Boolean blockFound = false;
        for (Integer i = 0; i < blockList.size(); i++) {
            String blockName = blockList.get(i).getDisplayName();
            if (name == blockName){
                blockFound = true;
                break;
            }
        }
        if (blockFound == false){ // if entered name not match any in block list
            finish(); // delete current activity and return to initial screen
        }
        return blockFound;
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