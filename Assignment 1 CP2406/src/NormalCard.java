/**
 * Created by Ian on 9/2/2017.
 */
public class NormalCard extends Card {              //Class extend from the Card Class
    private float hardness;
    private float specificGravity;
    private String cleavage;
    private int cleavageValue;
    private String crustalAbundance;
    private int crustalAbundanceValue;
    private String ecoValue;
    private int ecoValueValue;              //Defining all the variable

    NormalCard(String nm, float hard, float speGra, String cleav, String cryAbu, String ecoV)
    {
        super(nm);
        hardness = hard;
        specificGravity = speGra;
        cleavage = cleav;
        crustalAbundance = cryAbu;
        ecoValue = ecoV;
        cleavageValue = convertCleavageValue();
        crustalAbundanceValue = convertAbuValue();
        ecoValueValue = convertEcoValue();                  //Constructor for all the variable
    }

    public int getCleavageValue() {
        return cleavageValue;
    }

    public int getCrustalAbundanceValue() {
        return crustalAbundanceValue;
    }

    public int getEcoValueValue() {
        return ecoValueValue;
    }

    public float getHardness() {
        return hardness;
    }

    public float getSpecificGravity() {
        return specificGravity;
    }

    public String getCleavage() {
        return cleavage;
    }

    public String getCrustalAbundance() {
        return crustalAbundance;
    }

    public String getEcoValue() {
        return ecoValue;
    }                           //All the get method for all the variable

    public int convertCleavageValue()                                           //Converting all the Cleavage into int number to be compared
    {
        int cleaValue = 0;
        String x = getCleavage();
        if(x.equals("None"))
        {cleaValue = 1;}
        else if(x.equals("Poor/None"))
        {cleaValue = 2;}
        else if(x.equals("1 Poor"))
        {cleaValue = 3;}
        else if(x.equals("2 Poor"))
        {cleaValue = 4;}
        else if(x.equals("1 Good"))
        {cleaValue = 5;}
        else if(x.equals("1 Good/1 Poor"))
        {cleaValue = 6;}
        else if(x.equals("2 Good"))
        {cleaValue = 7;}
        else if(x.equals("3 Good"))
        {cleaValue = 8;}
        else if(x.equals("1 Perfect"))
        {cleaValue = 9;}
        else if(x.equals("1 Perfect/1 Good"))
        {cleaValue = 10;}
        else if(x.equals("1 Perfect/2 Good"))
        {cleaValue = 11;}
        else if(x.equals("2 Perfect/1 Good"))
        {cleaValue = 12;}
        else if(x.equals("3 Perfect"))
        {cleaValue = 13;}
        else if(x.equals("4 Perfect"))
        {cleaValue = 14;}
        else if(x.equals("6 Perfect"))
        {cleaValue = 15;}
        return cleaValue;
    }
    public int convertAbuValue()                    //Converting all the Crustal Abundance into int to be compared
    {
        int aValue = 0;
        String x = getCrustalAbundance();
        if(x.equals("Ultra Trace"))
        {aValue=1;}
        else if(x.equals("Trace"))
        {aValue=2;}
        else if(x.equals("Low"))
        {aValue=3;}
        else if(x.equals("Moderate"))
        {aValue=4;}
        else if(x.equals("High"))
        {aValue=5;}
        else if(x.equals("Very High"))
        {aValue=6;}
        return aValue;
    }
    public int convertEcoValue()                //Converting the economic value into int to be compare
    {
        int eValue = 0;
        String x = getEcoValue();
        if(x.equals("Trivial"))
        {eValue=1;}
        else if(x.equals("Low"))
        {eValue=2;}
        else if(x.equals("Moderate"))
        {eValue=3;}
        else if(x.equals("High"))
        {eValue=4;}
        else if(x.equals("Very High"))
        {eValue=5;}
        else if(x.equals("I'm Rich Men"))
        {eValue=6;}
        return eValue;
    }
}
