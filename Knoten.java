/**
 * @author (Herbert Wenisch)
 * @version (08-18-23)
 */
public class Knoten {
    private String bezeichner;  // besser: id
    
    public Knoten(String Bezeichner){
        this.bezeichner = Bezeichner;
    }
    
    
    @Override
    public String toString(){
        return bezeichner;
    }
    
    // Returns a String of given length, but only the first n charactes 
    // of bezeichner, the rest is filled with Withespace (len <= 10).
    // Usefull, when drawing tables.
    public String toString(int n, int len){
        String whiteSpace10 = "          "; 
        return (bezeichner.substring(0,n) + whiteSpace10).substring(0,len);
    }
}
