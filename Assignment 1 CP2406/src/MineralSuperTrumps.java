import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*; //import necessary packages

/**
 * Created by Ian on 9/4/2017.
 */
public class MineralSuperTrumps {

    public static void main(String[] args)  //Main
    {
        Object[] options = {3,4,5};         // Choice
        int numberOfPlayer = JOptionPane.showOptionDialog(null,"Enter the number of players", "Players",JOptionPane.YES_NO_CANCEL_OPTION
                ,JOptionPane.QUESTION_MESSAGE,null,options,options[0]) + 3;         //Prompt asking for number of player
        ArrayList<Card> cardList = new ArrayList<Card>();
        String[] array;
        String string = "";              //Defining variable
        Path file =
                Paths.get("C:\\Users\\IAN\\IdeaProjects\\Assignment 1 CP2406\\src\\card.txt");     //Determining path for reading
        try
        {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            reader.readLine();                                                              //Reading the file
            while ((string = reader.readLine()) != null){
                array = string.split(",");
                cardList.add(new NormalCard(array[0],Float.valueOf(array[1]),Float.valueOf(array[2]),array[3],array[4],array[5])); //Making and adding of card
            }
            cardList.add(new SuperTrumpCard("The Mineralogist"));
            cardList.add(new SuperTrumpCard("The Geologist"));
            cardList.add(new SuperTrumpCard("The Geophysicist"));
            cardList.add(new SuperTrumpCard("The Petrologist"));
            cardList.add(new SuperTrumpCard("The Miner"));
            cardList.add(new SuperTrumpCard("The Gemmologist"));        //Making and adding all the supertrump card
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e.getMessage());           //To show error message
        }
        Deck gameDeck = new Deck(cardList);
        TableGame gameTable = new TableGame(numberOfPlayer,gameDeck);   //Starting the game with the number fo player and the deck
        int counter = 0;
        while (gameTable.getGameplayers().size()>1)                     //It is one of the loop continueously until one person left
        {
            int playerNo = counter%gameTable.getGameplayers().size();
            if(gameTable.getDeckCard().getDeckContent().size()==0)
            {
                gameTable.addBackCard();                                //If the card drawn, put back the used card into the deck
            }
            else{
                gameTable.getGameplayers().get(playerNo).getTurn(gameTable);    //Player using their turn
                counter+=1;
            }

        }
        JOptionPane.showMessageDialog(null,"The game is over, "+ gameTable.getGameplayers().get(0).getName() + " lost");
    }
}
