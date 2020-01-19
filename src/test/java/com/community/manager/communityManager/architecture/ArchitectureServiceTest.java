package com.community.manager.communityManager.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Service;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.community.manager.communityManager")
public class ArchitectureServiceTest {

	  @ArchTest
	    static ArchRule controllers_should_have_name_controller =
	            classes().that()
	            	.resideInAPackage("..service..")
	            	.should()
	            	.haveSimpleNameEndingWith("Service");

	    @ArchTest
	    static ArchRule controllers_should_have_annotated =
	    		classes().that()
            	.resideInAPackage("..service..")
            	.should().beAnnotatedWith(Service.class);

	    @ArchTest
	    static ArchRule controllers_dependecy_service =
	    	classes().that()
	    	.resideInAPackage("..service..")
	    	.should()
	    	.dependOnClassesThat()
	    	.resideInAPackage("..repository..");
	    
	    @ArchTest
	    static ArchRule controllers_should_accessed =
	    	classes().that()
	    	.haveNameMatching("Service")
	    	.should()
	    	.onlyBeAccessed().byClassesThat().haveSimpleName("*Controller*");
	
}
