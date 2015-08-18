package uk.co.agilekatas.katas.bingo.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.agilekatas.katas.bingo.BingoCaller;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoCallerStepdefs {

    private BingoCaller caller;
    private List<Integer> calledNumbers;

    @Given("^I have a Bingo caller$")
    public void I_have_a_Bingo_caller() throws Throwable {
        caller = new BingoCaller();
    }

    @When("^I call a number$")
    public void I_call_a_number() throws Throwable {
        calledNumbers = new ArrayList<>();
        int calledNumber = caller.call();
        calledNumbers.add(calledNumber);
    }

    @Then("^the number is between 1 and 75 inclusive$")
    public void the_number_is_between_and_inclusive() throws Throwable {
        int calledNumber = calledNumbers.get(0);
        assertThat(calledNumber).isBetween(1, 75);
    }

    @When("^I call a number 75 times$")
    public void I_call_a_number_times() throws Throwable {
        calledNumbers = new ArrayList<>();
        for (int i = 0; i < 75; i++)
            calledNumbers.add(caller.call());
    }

    @Then("^all numbers between 1 and 75 are present$")
    public void all_numbers_between_and_are_present() throws Throwable {
        for (int i = 1; i <= 75; i++)
            assertThat(calledNumbers).contains(i);
    }

    @And("^no number has been called more than once$")
    public void no_number_has_been_called_more_than_once() throws Throwable {
        assertThat(calledNumbers).doesNotHaveDuplicates();
    }
}
