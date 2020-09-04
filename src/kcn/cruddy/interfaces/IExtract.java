package kcn.cruddy.interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public interface IExtract<T,R extends Reader>
{
    List<T> extractFromReader(R reader);
    R getReaderForFile(String fileLocation);
}
