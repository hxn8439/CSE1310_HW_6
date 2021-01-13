/*
Hamilton Nguyen 1000538439 08/8/2018
 */
package albumstuff;

public class Album {
    
 public String name;
    public String song;
    public String year;
    
    public Album(String[] s) {
        name=s[0].trim();
        song=s[1].trim();
        year=s[2].trim();
    }    
}
    

