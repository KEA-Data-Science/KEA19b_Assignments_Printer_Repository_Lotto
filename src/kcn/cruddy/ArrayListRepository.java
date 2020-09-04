package kcn.cruddy;

import kcn.cruddy.interfaces.ICRUD;
import kcn.cruddy.interfaces.IHaveID;

import java.util.ArrayList;

public class ArrayListRepository<T extends IHaveID<T>> implements ICRUD
{
    private ArrayList<T> arrayList;

    public ArrayListRepository()
    {
        this.arrayList = new ArrayList<>();
    }

    public ArrayList<T> getArrayList()
    {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> list){arrayList = list;}

    /** Includes objectT in collection, if not already in it.
    *@param assigned IID-object must also be a child-class T-object.
     * */
    @Override
    public boolean create(IHaveID objectT)
    {
        for(IHaveID obj : arrayList)
        {
            if(obj.getID() == objectT.getID()){return false;}
        }

        arrayList.add((T)objectT);
        return true;
    }

    @Override
    public IHaveID read(int id)
    {
        for(IHaveID obj : arrayList)
        {
            if(obj.getID() == id){return obj;}
        }

        /* in case of a bad id, return null*/
        return null;
    }

    @Override
    public IHaveID update(IHaveID object)
    {
        for(IHaveID obj : arrayList)
        {
            if(object.getID() == obj.getID())
            {
                obj = object;
                return obj;
            }
        }

        /* in case of a bad id, return null */
        return null;
    }

    @Override
    public boolean delete(int id)
    {
        for(int i = 0; i<arrayList.size(); i++)
        {
            if(id == arrayList.get(i).getID())
            {
                arrayList.remove(i);
                return true; // removal was a success
            }
        }
        return false;
    }
}
