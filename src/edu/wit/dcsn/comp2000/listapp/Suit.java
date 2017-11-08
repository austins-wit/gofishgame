/**
 * An enumeration of card suits. (Listing C-2 of Appendix C.)
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 * 
 * @author David M Rosenberg - Tu 3/16/2016:
 * - moved to package for Comp 2071 lab 4
 * - enhanced definition: added display name and graphic
 * - added test driver main()
 */
package edu.wit.dcsn.comp2000.listapp;

public enum Suit implements Comparable<Suit>
    {
//  Element         Display Name    Graphic     Color      Priority
    NONE        (   "",             "",         "",         0 ),
    CLUBS       (   "Clubs",        "♣",        "black",    1 ),
    DIAMONDS    (   "Diamonds",     "♦",        "red",      3 ),
    HEARTS      (   "Hearts",       "♥",        "red",      2 ),
    SPADES      (   "Spades",       "♠",        "black",    4 )
    ;


    private final String displayName;
    private final String graphic;
    private final String color;
    private final int priority;

    
    /**
     * 
     * @param suitDisplayName
     * @param suitGraphic
     * @param suitColor
     * @param suitPriority
     */
    private Suit( String suitDisplayName, String suitGraphic, String suitColor, int suitPriority )
        {
        displayName =   suitDisplayName;
        graphic =       suitGraphic;
        color =         suitColor;
        priority =      suitPriority;
        } // end constructor

    
    /**
     * 
     * @return
     */
    public String getDisplayName()
        {
        return displayName;
        } // end getDisplayName
    
    
    /**
     * 
     * @return
     */
    public String getGraphic()
        {
        return graphic;
        } // end getGraphic

 
    /**
     * 
     * @return
     */
    public String getColor()
        {
        return color;
        } // end getColor
    

    /**
     * 
     * @return
     */
    public int getPriority()
        {
        return priority;
        }   // end getPriority
    

    /**
     * 
     */
    @Override
    public String toString()
        {
        return graphic ;
        }
    
    
    // DMR - Tu 3/16/2016 - added test driver
    public static void main( String[] args )
        {
        // display column headers 
        System.out.printf( "%-5s %-15s %-8s %-15s %-15s %-10s %-10s%n", 
                            "#",
                            "Suit",
                            "Graphic",
                            "Name",
                            "Display Name",
                            "Color",
                            "Priority" );

        // display each element of the enumeration
        for ( Suit aSuit : Suit.values() )
            {
            System.out.printf( "%-5d %-15s %-8s %-15s %-15s %-10s %-10d%n", 
                                aSuit.ordinal(), 
                                aSuit,
                                aSuit.graphic,
                                aSuit.name(),
                                aSuit.displayName,
                                aSuit.color,
                                aSuit.getPriority() );
            }
        }

    } // end Suit