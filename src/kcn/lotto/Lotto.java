package kcn.lotto;

import kcn.printy.interfaces.IPresent;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto
{
    IPresent ui;
    HashSet<Integer> numberSet;
    HashMap<Integer, Integer> prizeMap;

    public Lotto(IPresent iPresent)
    {
        ui = iPresent;
        numberSet = new HashSet<>();

        prizeMap = new HashMap<>();
        prizeMap.put(4, 125);
        prizeMap.put(5, 1500);
        prizeMap.put(6, 125000);
        prizeMap.put(7, 1000000);
    }

    public Lotto(IPresent iPresent, int prize4Correct, int prize5Correct, int prize6Correct, int prize7Correct)
    {
        ui = iPresent;
        numberSet = new HashSet<>();

        prizeMap = new HashMap<>();
        prizeMap.put(4, prize4Correct);
        prizeMap.put(5, prize5Correct);
        prizeMap.put(6, prize6Correct);
        prizeMap.put(7, prize7Correct);
    }

    public IPresent getUI(){ return ui; }

    /**
     * Method executes a single game of lotto, and returns number
     * of user successfully matched/guessed numbers.
     */
    public int PlayLotto()
    {
        /* Generate data */
        HashSet<Integer> winningNumbers = returnRandomSet(7, 36);
        HashSet<Integer> userNumbers = receiveUserInputNumbers();
        /* Present results */
        ui.present("Winning numbers are:");
        ui.present(winningNumbers.toString());
        ui.present("Use choose:");
        ui.present(userNumbers.toString());

        return checkNumberOfMatches(userNumbers, winningNumbers);
    }

    public HashSet<Integer> returnRandomSet(int sizeSet, int maxNumber)
    {
        HashSet<Integer> returnSet = new HashSet<>();

        while(returnSet.size() < sizeSet)
        {
            returnSet.add((int)(Math.random() * maxNumber));
        }

        return returnSet;
    }

    /**
     * Method queries user to input 7 numbers.
     *
     * @return
     */
    public HashSet<Integer> receiveUserInputNumbers()
    {

        HashSet<Integer> returnNumbers = new HashSet<>();

        ui.present("You can now input your 7 lucky numbers:");

        /* Getting input from scanner*/
        while(returnNumbers.size() != 7)
        {
            Scanner scanner = new Scanner(System.in);
            String receivedString = scanner.nextLine();
            String[] splits = receivedString.split(",");

            if(splits.length != 7)
            {
                ui.present("Please input 7 numbers, separated by comma.");
                continue;
            } else
            {
                try
                {
                    for(int i = 0; i < splits.length; i++)
                    {
                        returnNumbers.add(Integer.parseInt(splits[i]));
                    }
                } catch(Exception e)
                {
                    ui.present("You entered bad values; 7 integers comma separated, please");
                    returnNumbers = new HashSet<>();
                }
            }
        }

        return returnNumbers;
    }

    public int checkNumberOfMatches(HashSet<Integer> userNumbers, HashSet<Integer> winningNumbers)
    {
        userNumbers.retainAll(winningNumbers);

        String message = userNumbers.size() > 3 ? "Congrats, you have " : "Sorry, only got "
                                                                          + userNumbers.size() + " numbers right.";

        ui.present(message);

        return userNumbers.size();
    }
}