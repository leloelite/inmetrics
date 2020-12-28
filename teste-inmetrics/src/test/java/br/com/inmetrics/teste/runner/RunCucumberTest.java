package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "src\\test\\java\\br\\com\\inmetrics\\teste\\features"
,glue= "br.com.inmetrics.teste.glue"
)
public class RunCucumberTest {
	 
}