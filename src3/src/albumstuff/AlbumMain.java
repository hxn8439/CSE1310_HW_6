/*
Hamilton Nguyen 1000538439 08/8/2018
 */
package albumstuff;
import albumstuff.AlbumCollection;
import java.util.*;

public class AlbumMain {
    
 public static void main(String[] args) {
        AlbumCollection a=new AlbumCollection();
        
        ArrayList<String> collection=a.printOutAlbum();
        AlbumCollection.fileOutput(collection);
    }    
}
