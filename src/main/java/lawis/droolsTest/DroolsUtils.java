package lawis.droolsTest;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class DroolsUtils {

    public static void PrintDRL(ClassLoader cl, String path){
        //Leemos el archivo de reglas desde una planilla Excel
        SpreadsheetCompiler converter = new SpreadsheetCompiler();
        String drl = converter.compile(cl.getResourceAsStream(
                path), InputType.XLS);

        //Solo mostramos el DRL que se generó del Excel.
        System.out.println(drl);
    }
}
