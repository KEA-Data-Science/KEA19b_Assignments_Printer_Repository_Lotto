package kcn.printy;

import kcn.printy.interfaces.IMachine;
import kcn.printy.interfaces.IPaperTray;
import kcn.printy.interfaces.IPresent;

import java.util.Queue;

public abstract class Printer implements IMachine
{
    protected boolean isOn;
    protected IPaperTray paperTray;
    protected Queue<String> documentQueue;
    protected IPresent ui;


    public Printer(IPaperTray paperTray, IPresent ui)
    {
        this.ui = new Console();
        this.paperTray = paperTray;
        isOn = false;
    }

    public void power(){isOn = !isOn;}

    public boolean addDocumentToPrinterQueue(String document)
    {
        if(!presentPowerStatus(true)){ return false; }

        documentQueue.add(document);
        return true;
    }

    public boolean presentPowerStatus(boolean onlyReportProblems)
    {
        if(isOn())
        {
            if(!onlyReportProblems){ui.present("Printer :: Ready!");}
            return true;
        } else
        {
            ui.present("Printer :: Printer is off, turn on to use.");
            return false;
        }
    }

    @Override
    public boolean isOn(){ return isOn; }

    public IPaperTray getPaperTray(){ return paperTray; }

    public abstract void printFirstInQueue();

    public boolean checkIfPrinterQueueHasDocuments()
    {
        if(!presentPowerStatus(true)){return false;}

        if(documentQueue != null && documentQueue.isEmpty())
        {
            ui.present("LaserPrinter:: No documents waiting in queue:");
            return false;
        }
        return true;
    }

    /** Writes a nicely formatted and framed toString message to 'screen' */
    public void giveReport(){ui.present(toString());}

    @Override
    public String toString()
    {
        return "Printer{" +
               "isOn=" + isOn +
               ", paperTray=" + paperTray +
               '}';
    }
}
