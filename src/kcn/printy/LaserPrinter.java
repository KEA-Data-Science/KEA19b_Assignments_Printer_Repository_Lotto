package kcn.printy;

import kcn.printy.interfaces.IPaperTray;
import kcn.printy.interfaces.IPresent;

import java.util.LinkedList;

public class LaserPrinter extends Printer
{
    public LaserPrinter(IPaperTray paperTray, IPresent screen)
    {
        super(paperTray,screen);
        documentQueue = new LinkedList<>();
    }

    @Override
    public void printFirstInQueue()
    {
        ui.present("Laser printed document:" + documentQueue.poll());
    }

    public void printWholeQueue(){
        /* the 'above 0 check implies that a document is on page long, oh well */
        if(checkIfPrinterQueueHasDocuments() && paperTray.currentPages()>0){
            while(documentQueue.peek() != null){
                paperTray.subtractPages(1);
                ui.present(documentQueue.poll());
            }
        }
    }

    @Override
    public String toString()
    {
        return "LaserPrinter specifics: " + super.toString();
    }
}
