package tests.headless;

import java.io.File;

import org.junit.Test;

import crypto.HeadlessCryptoScanner;
import crypto.analysis.CrySLRulesetSelector.Ruleset;
import test.IDEALCrossingTestingFramework;

public class DummyHeadlessTest extends AbstractHeadlessTest {

//	@Test
//	public void testOne() {
//		String mavenProjectPath = new File("../CryptoAnalysisTargets/Dummy9").getAbsolutePath();
//		MavenProject mavenProject = createAndCompile(mavenProjectPath);
//		HeadlessCryptoScanner scanner = createScanner(mavenProject, Ruleset.JavaCryptographicArchitecture);
//		
//		scanner.exec();
//	  	assertErrors();
//	}

//	@Test
//	public void testTwo() {
//		String mavenProjectPath = new File("../CryptoAnalysisTargets/Dummy8").getAbsolutePath();
//		MavenProject mavenProject = createAndCompile(mavenProjectPath);
//		HeadlessCryptoScanner scanner = createScanner(mavenProject, Ruleset.JavaCryptographicArchitecture);
//		
//		scanner.exec();
//	  	assertErrors();
//	}
	
	@Test
	public void testThree() {
		String mavenProjectPath = new File("../CryptoAnalysisTargets/JPMSExample").getAbsolutePath();
		MavenProject mavenProject = createAndCompile(mavenProjectPath);
		HeadlessCryptoScanner scanner = createScanner(mavenProject, Ruleset.JavaCryptographicArchitecture);
		
		scanner.exec();
	  	assertErrors();
	}
}
