package css.poquette.minecraft_encylopedia_poquette;

import java.util.List;

/***
 *  Details for a single block
 */
public class Block {

    private Integer id;
    private String displayName;
    private String name;
    private Integer stackSize;
    private Boolean diggable;
    List<BlockVariation> variations; //fishList = new ArrayList();
    List<BlockDrop> drops;
    private Boolean transparent;
    private Integer emitLight;
    private Integer filterLight;


    /***
     *  Constructor
     * @param id - unique identifier; Integer
     * @param displayName - name to display to user; String
     * @param name - name to use as variable; String
     * @param stackSize - how much of the block can be stored in one slot in player inventory; Integer
     * @param diggable - whether or not the block can be dug up with a shovel or other tool; Boolean
     * @param variations - metadata and displayname of very similar blocks, usually only differing in appearance; List of variation objects
     * @param drops - ids of what item(s) the block drops when the player harvests it; List of variation objects
     * @param transparent - whether or not the block is transparent; Boolean
     * @param emitLight - how much light the block emits; Integer
     * @param filterLight - how much light can pass through the block; Integer
     */
    public Block(Integer id, String displayName, String name, Integer stackSize, Boolean diggable, List<BlockVariation> variations, List<BlockDrop> drops, Boolean transparent, Integer emitLight, Integer filterLight) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
        this.stackSize = stackSize;
        this.diggable = diggable;
        this.variations = variations;
        this.drops = drops;
        this.transparent = transparent;
        this.emitLight = emitLight;
        this.filterLight = filterLight;
    }

    public Integer getID() {
        return id;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getName() {
        return name;
    }
    public Integer getStackSize() {
        return stackSize;
    }
    public Boolean getDiggable() {
        return diggable;
    }
    public List<BlockVariation> getVariations() {
        return variations;
    }
    public List<BlockDrop> getDrops() {
        return drops;
    }
    public Boolean getTransparent() {
        return transparent;
    }
    public Integer getEmitLight() {
        return emitLight;
    }
    public Integer getFilterLight() {
        return filterLight;
    }

    // see if we can pull a description from the wiki
    /*
    public String toString() {
        return description;
    }
    */

}

// identify what items to keep from the .json object
        /*
            "id": 3,
    "displayName": "Dirt",
    "name": "dirt",
    "stackSize": 64,
    "diggable": true,
    "variations": [
      {
        "metadata": 0,
        "displayName": "Dirt"
      },
      {
        "metadata": 1,
        "displayName": "Coarse Dirt"
      },
      {
        "metadata": 2,
        "displayName": "Podzol"
      }
    ],
    "drops": [ // if empty, drops nothing
      {
        "drop": 3 // id of item dropped in items.json (not blocks.json!)
            // items.json includes block information when stored in inventory
        // sometimes also includes minCount, metadata
      }
    ],
    "transparent": false,
    "emitLight": 0,
    "filterLight": 15, // 15 blocks, 2 lets diffused light in, 0 lets full light in
         */