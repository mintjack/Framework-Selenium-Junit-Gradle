package testrunner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.TitleTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({TitleTests.class})

public class TestSuite {
}
