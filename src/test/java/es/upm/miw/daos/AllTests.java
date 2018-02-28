package es.upm.miw.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({OrderDaoIT.class, CustomerDaoIT.class})

public class AllTests {
}
