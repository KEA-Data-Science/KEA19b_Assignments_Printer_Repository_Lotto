package kcn;

import kcn.cruddy.*;
import kcn.cruddy.interfaces.ICRUD;
import kcn.lotto.Lotto;
import kcn.lotto.NumberSetGenerator;
import kcn.printy.*;
import kcn.printy.interfaces.IMachine;
import kcn.printy.interfaces.IPresent;

import java.util.Arrays;

public class Main
{
    /** Solution is not finished, but only missing on the details and the database-part.*/
    public static void main(String[] args)
    {
        Assignments solutions = new Assignments();
        solutions.runAndPrintOutFromRepositoryExercise();
        solutions.runAndPrintOutPutFromMachineExercise();




        Lotto lotto = new Lotto(new Console());
        lotto.PlayLotto();
    }
}
