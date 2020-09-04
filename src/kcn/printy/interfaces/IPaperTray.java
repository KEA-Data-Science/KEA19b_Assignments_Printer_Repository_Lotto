package kcn.printy.interfaces;

public interface IPaperTray
{
    int currentPages();
    /** Conceptually removes pages from paper tray */
    boolean subtractPages(int numberToRemove);
    /** Conceptually accepts pages into printer paper tray */
    boolean feedNewPages(int numberToAddToTray);
}
