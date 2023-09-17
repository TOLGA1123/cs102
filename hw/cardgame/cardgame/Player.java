package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    // Creates a player object with an empty hand
    public Player( String name)
    {
        // ToDo +
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    // Adding a card to player's hand
    public void add( Card c)
    {
        // ToDo +
        hand.addTopCard(c);
    }
    // Playing a card and removing it from player's hand
    public Card playCard()
    {
        // ToDo +
        //return null;
        return hand.getTopCard();
    }
    
} // end class Player
