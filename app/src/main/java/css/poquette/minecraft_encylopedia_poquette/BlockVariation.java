package css.poquette.minecraft_encylopedia_poquette;

import java.util.List;

public class BlockVariation {
    private Integer metadata;
    private String displayName;

    /***
    *  Constructor
    * @param metadata - unique identifier; Integer
    * @param displayName - name to display to user; String
    */
    public BlockVariation(Integer metadata, String displayName) {
        this.metadata = metadata;
        this.displayName = displayName;
    }

    public Integer getMetadata(){return metadata;}

    public String getDisplayName(){return displayName;}
}