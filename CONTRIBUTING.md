🎒 Codespace Usage - Client Creation
-
**Create the codespace**: Create a new codespace on this repo and then open the terminal.

**Install Java**: Type the following command in the terminal:
```bash
sdk install java 17.0.9-amzn
```
Type y when it asks you.

**Blocks**: To add blocks, update `item.java`, `RenderItem.java`, `Block.java`, `Blocks.java`, `en_US.lang` (Add to tile only) and add models in both items and block folders and edit with the appropiate file names. Make sure to add images to textures/blocks!

**Items**: To add items, update `item.java`, `RenderItem.java`, `Items.java` and `en_US.lang` under items. Add models for items with correct names and textures.
 
**Textures and Client Customizations**: Go to the textures tab in `resources/minecraft` in the desktopruntime folder.

**📦 Packaging and Playtesting**: Once you are finished adding to your client, go back to the terminal and direct to TeaVM.
```bash
cd target_teavm_javascript
```
Then run the `CompileJS.sh` file:
```bash
./CompileJS.sh
```
Once it is sucsessful, Run the `CompileEPK.sh` file:
```bash
./CompileEPK.sh
```
Finally run the `MakeOfflineDownload.sh` file.
```bash
./MakeOfflineDownload.sh
```
Now go to the javascript folder on the file explorer, download the html file by right click, and open on your computer to play!










