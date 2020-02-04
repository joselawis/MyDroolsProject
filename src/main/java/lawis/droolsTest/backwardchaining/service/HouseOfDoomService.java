package lawis.droolsTest.backwardchaining.service;


import lawis.droolsTest.DroolsUtils;
import lawis.droolsTest.backwardchaining.model.Location;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class HouseOfDoomService {
    private Location[] locations;
    private KieSession kieSession;

    public HouseOfDoomService() {
        this.locations = new Location[]{new Location("Office", "House"),
                new Location("Kitchen", "House"),
                new Location("Knife", "Kitchen"),
                new Location("Cheese", "Kitchen"),
                new Location("Desk", "Office"),
                new Location("Chair", "Office"),
                new Location("Computer", "Desk"),
                new Location("Drawer", "Desk")};
        this.kieSession = DroolsUtils.prepareRules(new String[]{"rules/droolsTest/backwardchaining/BC-Example.drl"}, ResourceType.DRL, this.locations);
    }

    public void play(){
        kieSession.insert( "go1" );
        kieSession.fireAllRules();
        System.out.println("---");

        kieSession.insert( "go2" );
        kieSession.fireAllRules();
        System.out.println("---");

        kieSession.insert( "go3" );
        kieSession.fireAllRules();
        System.out.println("---");

        kieSession.insert( new Location("Key", "Drawer") );
        kieSession.fireAllRules();
        System.out.println("---");

        kieSession.insert( "go4" );
        kieSession.fireAllRules();
        System.out.println("---");

        kieSession.insert( "go5" );
        kieSession.fireAllRules();
    }
}
