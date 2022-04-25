package br.ce.javal.suit;

import br.ce.javal.core.DriveFactory;
import br.ce.javal.test.DataDrivem;
import br.ce.javal.test.SleepSyncro;
import br.ce.javal.test.TestePrime;
import br.ce.javal.test.TrainTest;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.sql.Driver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TrainTest.class,
        DataDrivem.class,
        TestePrime.class,
        SleepSyncro.class
})
public class suit_test {
    @AfterClass
    public static void finalizatudo(){
        DriveFactory.killDriver();
    }


}
