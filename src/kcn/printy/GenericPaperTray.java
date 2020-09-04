package kcn.printy;

import kcn.printy.interfaces.IPaperTray;

public class GenericPaperTray implements IPaperTray
{
    private final int maxCapacity;
    private int currentPages;

    public GenericPaperTray(int maxPages, int currentPages)
    {
        this.maxCapacity = maxPages;
        this.currentPages = currentPages;
    }

    public int getMaxCapacity(){ return maxCapacity; }

    @Override
    public int currentPages(){ return currentPages; }

    /**
     * Method subtracts the requested number of pages from currentPages.
     * If this would result in a number lower than 0, method
     * returns false; else returns true.
     */
    public boolean subtractPages(int numberToSubtract)
    {
        if(currentPages - numberToSubtract < 0){return false; }

        currentPages -= numberToSubtract;
        return true;
    }

    @Override
    public boolean feedNewPages(int numberToAddToTray)
    {
        if(numberToAddToTray+currentPages>maxCapacity){return false;}

        currentPages += numberToAddToTray;
        return true;
    }

    @Override
    public String toString()
    {
        return "GenericPaperTray{" +
               "maxCapacity=" + maxCapacity +
               ", currentPages=" + currentPages +
               '}';
    }
}
