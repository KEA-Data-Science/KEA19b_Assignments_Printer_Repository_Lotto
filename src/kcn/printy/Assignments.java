package kcn.printy;

import kcn.cruddy.ArrayListRepository;
import kcn.cruddy.FileRepository;
import kcn.cruddy.Person;
import kcn.cruddy.PersonExtractor;
import kcn.cruddy.interfaces.ICRUD;
import kcn.printy.interfaces.IMachine;
import kcn.printy.interfaces.IPresent;

import java.io.BufferedReader;
import java.util.HashMap;

public class Assignments
{
    public void runAndPrintOutPutFromMachineExercise()
    {

        IPresent presenter = new Console();
        ((Console)presenter).setPrefix("||>>");
        ((Console)presenter).setPostfix("<<||Printer Assignment Output");

        presenter.present("Printer Assignment Output");


        // These transformations serve no functional purpose, I just wanted to show off the polymorphism
        IMachine machine = new LaserPrinter(new GenericPaperTray(500, 0), new Console());
        Printer printer = (Printer)machine;
        LaserPrinter lPrinter = (LaserPrinter)printer;

        printer.giveReport();

        printer.getPaperTray().feedNewPages(230);
        printer.addDocumentToPrinterQueue("Grunk was a warrior 1");

        if(!machine.isOn()){ machine.power(); }

        printer.giveReport();

        printer.addDocumentToPrinterQueue("Grunk was a warrior 2");
        printer.addDocumentToPrinterQueue("Grunk was a warrior 3");
        printer.addDocumentToPrinterQueue("Grunk was a warrior 4");
        printer.addDocumentToPrinterQueue("Grunk was a warrior 5");
        printer.addDocumentToPrinterQueue("Grunk was a warrior 6");
        printer.addDocumentToPrinterQueue("Grunk was a warrior 7");



        lPrinter.printWholeQueue();
        lPrinter.printWholeQueue();
    }

    public void runAndPrintOutFromRepositoryExercise()
    {
        IPresent presenter = new Console();
        ((Console)presenter).setPrefix("||>>");
        ((Console)presenter).setPostfix("<<|| CRUD Assignment output");
        presenter.present("");
        presenter.present("CRUD Assignment");
        presenter.present("File Repository turned out pretty nice");

        Person p1 = new Person(1, "Alfred Whitehead", "Brittle", true);
        Person p2 = new Person(2, "Bernard Whitehead", "Bastu", false);

        ICRUD<Person> repository = new ArrayListRepository<Person>();
        repository.create(p1);
        repository.create(p2);

        presenter.present(repository.read(1).toString());
        presenter.present(repository.read(2).toString());

        FileRepository<Person, BufferedReader> fileRepo =
                new FileRepository<>("D:/testy.txt", new PersonExtractor());
        presenter.present(fileRepo.read(1).toString());

        HashMap<Integer,Object> map;
    }

}
