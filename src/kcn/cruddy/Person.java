package kcn.cruddy;

import kcn.cruddy.interfaces.IHaveID;

public class Person implements IHaveID<Person>
{
    private int id;
    private String name;
    private String mood;
    private boolean sexy;


    public Person(int id, String name, String mood, boolean sexy)
    {
        this.id = id;
        this.name = name;
        this.mood = mood;
        this.sexy = sexy;
    }

    public static Person fromString(String formattedString)
    {
        String[] splitString = formattedString.split(",");

        if(splitString.length != 4){return null;}

        return new Person(Integer.getInteger(splitString[0]), splitString[1], splitString[2],
                          splitString[3].equalsIgnoreCase("true"));
    }




    @Override
    public String toString()
    {
        return "Person{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", mood='" + mood + '\'' +
               ", sexy=" + sexy +
               '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMood()
    {
        return mood;
    }

    public void setMood(String mood)
    {
        this.mood = mood;
    }

    public boolean isSexy()
    {
        return sexy;
    }

    public void setSexy(boolean sexy)
    {
        this.sexy = sexy;
    }

    @Override
    public int getID()
    {
        return id;
    }
}
