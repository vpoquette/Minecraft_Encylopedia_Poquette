package css.poquette.minecraft_encylopedia_poquette;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    // reference pizza order

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
}
