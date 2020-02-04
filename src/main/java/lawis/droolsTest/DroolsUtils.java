package lawis.droolsTest;

import lawis.droolsTest.banking.service.RuleRunner;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.Collection;

public class DroolsUtils {

    public static void PrintDRL(String path){
        //Leemos el archivo de reglas desde una planilla Excel
        SpreadsheetCompiler converter = new SpreadsheetCompiler();
        String drl = converter.compile(DroolsUtils.class.getClassLoader().getResourceAsStream(
                path), InputType.XLS);

        //Solo mostramos el DRL que se generó del Excel.
        System.out.println(drl);
    }

    public static KieSession prepareRules(String[] ruleFiles, Object[] facts){
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        for (String ruleFile : ruleFiles) {
            System.out.println("Loading file: " + ruleFile);

            DroolsUtils.PrintDRL(ruleFile);
            kbuilder.add(ResourceFactory.newClassPathResource(ruleFile,
                    RuleRunner.class),
                    ResourceType.DTABLE);
        }

        Collection pkgs = kbuilder.getKnowledgePackages();
        kbase.addPackages(pkgs);
        KieSession kieSession = kbase.newKieSession();

        for ( int i = 0; i < facts.length; i++ ) {
            Object fact = facts[i];
            System.out.println( "Inserting fact: " + fact );
            kieSession.insert( fact );
        }

        return kieSession;
    }
}
