package com.community.manager.communityManager.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.community.manager.communityManager")
public class ArchitectureRepository {

	    @ArchTest
	    static ArchRule should_accessed =
	    	noClasses().that()
	    	.areInterfaces()
	    	.should()
	    	.onlyBeAccessed().byClassesThat().haveSimpleName("*Service*");
}
