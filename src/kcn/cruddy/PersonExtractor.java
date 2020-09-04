package kcn.cruddy;

import kcn.cruddy.interfaces.IExtract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A PersonExtractor instance is able to open and parse a text file, given in the format:
 * [id-number],[name],[mood-descriptive-string],[truth of sexiness]
 * ex.
 * 1,Olga Seele,Bad,true
 * 2,Grorko Bandom,Feels beautiful,false
 * 3,Baldo Renkarnik,Blother,true
 * */
public class PersonExtractor implements IExtract<Person, BufferedReader>
{

    public List<Person> extractFromReader(BufferedReader reader)
    {
        var returnStrings = new ArrayList<String>();

        try
        {
            while(reader.ready())
            {
                returnStrings.add(reader.readLine());
            }

        } catch(IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<Person> persons = new ArrayList<>();

        for(String s : returnStrings)
        {
            String[] personString = s.split(",");
            if(personString.length != 4)
            {
                System.out.println("Error in file input, returning partial list.");
                return persons;
            }

            persons.add(
                    new Person(
                            Integer.parseInt(personString[0]),
                            personString[1],
                            personString[2],
                            personString[3].equalsIgnoreCase("true")));
        }

        return persons;
    }

    public BufferedReader getReaderForFile(String fileLocation)
    {
        try
        {
            return new BufferedReader(new FileReader(fileLocation));
        } catch(IOException e) { e.printStackTrace(); }

        /* if something went wrong, return null - so check*/
        return null;
    }
}
