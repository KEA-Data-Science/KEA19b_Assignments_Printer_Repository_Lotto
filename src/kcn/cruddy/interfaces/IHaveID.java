package kcn.cruddy.interfaces;

import java.io.BufferedReader;
import java.util.List;

/**
 * The IID interface describes an entity which is able to report a self-identifying integer value.
 * */
public interface IHaveID<T>
{
    int getID();
}
