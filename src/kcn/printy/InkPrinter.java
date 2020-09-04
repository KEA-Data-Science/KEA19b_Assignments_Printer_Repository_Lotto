package kcn.printy;

import kcn.printy.interfaces.IPaperTray;
import kcn.printy.interfaces.IPresent;

import java.util.PriorityQueue;

public class InkPrinter extends Printer
{

    public InkPrinter(IPaperTray paperTray, IPresent screen)
    {
        super(paperTray,screen);
        documentQueue = new PriorityQueue<>();
    }

    @Override
    public void printFirstInQueue()
    {
        ui.present("Ink printer document: " + documentQueue.poll());
    }

    @Override
    public String toString()
    {
        return "InkPrinter specifics: " + super.toString();
    }
}
