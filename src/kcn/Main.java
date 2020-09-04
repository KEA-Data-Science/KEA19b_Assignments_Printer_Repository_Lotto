package kcn;

import kcn.lotto.Lotto;
import kcn.printy.*;

public class Main
{
    /** Solution is not finished, but only missing on the details and the database-part.*/
    public static void main(String[] args)
    {

        Assignments solutions = new Assignments();

        solutions.runAndPrintOutFromRepositoryExercise(); // Repository exercise

        solutions.runAndPrintOutPutFromMachineExercise(); // Machine / Printer exercise

        solutions.runLottoGameAssignment(); // Lotto / Set exercise
    }
}
