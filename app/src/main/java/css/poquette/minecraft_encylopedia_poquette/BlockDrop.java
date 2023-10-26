package css.poquette.minecraft_encylopedia_poquette;

// currently unused class - see comments in MainActivity.java
public class BlockDrop {
    private Integer drop;

    /***
     *  Constructor
     * @param drop - id of item dropped; Integer
     */
    public BlockDrop(Integer drop) {
        this.drop = drop;
    }

    public Integer getDrop(){
        return drop;
    }
}
