package kcn.cruddy;

import kcn.cruddy.interfaces.IExtract;
import kcn.cruddy.interfaces.IHaveID;

import java.io.*;
import java.util.List;

/**
 * FileRepository Relies Heavily on ArrayListRepository;
 * simply, the contents of file is read to arraylist in base class,
 * and base class handles outward interactions.
 * */
public class FileRepository<T extends IHaveID<T>,R extends Reader> extends ArrayListRepository<T>
{
    private String fileLocation;
    private IExtract<T,R> extractor;

    public FileRepository(String fileLocation, IExtract<T,R> extractor)
    {
        super(); // initializes arraylist
        this.fileLocation = fileLocation;
        this.extractor = extractor;
        List<T> keptItemsList = extractor.extractFromReader(extractor.getReaderForFile(fileLocation));
        getArrayList().addAll(keptItemsList);
    }
}
