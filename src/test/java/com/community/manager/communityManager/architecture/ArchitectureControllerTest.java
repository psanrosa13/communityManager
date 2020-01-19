package com.community.manager.communityManager.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.community.manager.communityManager")
public class ArchitectureControllerTest {

	  @ArchTest
	    static ArchRule controllers_should_have_name_controller =
	            classes().that()
	            	.resideInAPackage("..controller..")
	            	.should()
	            	.haveSimpleNameEndingWith("Controller");

	    @ArchTest
	    static ArchRule controllers_should_have_annotated =
	    		classes().that()
            	.resideInAPackage("..controller..")
            	.should().beAnnotatedWith(RestController.class);

	    @ArchTest
	    static ArchRule controllers_dependecy_service =
	    	classes().that()
	    	.resideInAPackage("..controller..")
	    	.should()
	    	.dependOnClassesThat()
	    	.resideInAPackage("..service..");
	    
	
}
