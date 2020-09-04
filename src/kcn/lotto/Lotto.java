package kcn.lotto;

import kcn.printy.interfaces.IPresent;

import java.util.HashSet;
import java.util.Scanner;

public class Lotto
{
    IPresent ui;
    HashSet<Integer> numberSet;
    NumberSetGenerator setGenerator;

    public Lotto(IPresent iPresent)
    {
        ui = iPresent;
        numberSet = new HashSet<>();
        setGenerator = new NumberSetGenerator();
    }

    public void PlayLotto()
    {
        HashSet<Integer> winningNumbers = setGenerator.returnRandomSubset(7, 36);
        HashSet<Integer> userNumbers = receiveUserInputNumbers();
        ui.present("Winning numbers are: " + winningNumbers);
        checkNumberOfMatches(userNumbers, winningNumbers);
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

        ui.present(
                userNumbers.size() > 3 ? "Congrats," : "Sorry, " + " you had " + userNumbers.size() + "right.");
        return userNumbers.size();
    }
}