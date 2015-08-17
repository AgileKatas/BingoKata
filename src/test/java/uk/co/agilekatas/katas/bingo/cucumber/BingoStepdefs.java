package uk.co.agilekatas.katas.bingo.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.agilekatas.katas.bingo.BingoCard;
import uk.co.agilekatas.katas.bingo.BingoCard.Column;
import uk.co.agilekatas.katas.bingo.BingoCardGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoStepdefs {

    private BingoCardGenerator cardGenerator;
    private BingoCard card;

    @Given("^I have a Bingo card generator$")
    public void I_have_a_Bingo_card_generator() throws Throwable {
        cardGenerator = new BingoCardGenerator();
    }

    @When("^I generate a Bingo card$")
    public void I_generate_a_Bingo_card() throws Throwable {
        card = cardGenerator.generate();
    }

    @Then("^the generated card has (\\d+) unique spaces$")
    public void the_generated_card_has_unique_spaces(int spaces) throws Throwable {
        List<List<String>> columns = getColumns(card);
        List<String> everySpace = getFlattenedSpaces(columns);

        assertThat(everySpace).doesNotHaveDuplicates();
        assertThat(everySpace.size()).isEqualTo(spaces);
    }

    private List<String> getFlattenedSpaces(List<List<String>> columns) {
        List<String> spaces = new ArrayList<>();
        for (List<String> column : columns)
            for (String space : column)
                spaces.add(space);
        return spaces;
    }

    private List<List<String>> getColumns(BingoCard card) {
        List<List<String>> columns = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            columns.add(card.getColumn(Column.values()[i]));
        }
        return columns;
    }

    @And("^the generated card has a FREE space in the middle$")
    public void the_generated_card_has_FREE_space_in_the_middle() throws Throwable {
        List<String> column = card.getColumn(Column.N);
        assertThat(column.get(2)).isEqualTo("FREE");
    }

    @And("^column \"([^\"]*)\" only contains numbers between \"([^\"]*)\" and \"([^\"]*)\" inclusive$")
    public void column_only_contains_numbers_between_and_inclusive(String columnId, int lowerBound, int upperBound) throws Throwable {
        List<String> column = card.getColumn(Column.valueOf(columnId));

        List<Integer> numbers = getNumbers(column);

        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(lowerBound);
            assertThat(number).isLessThanOrEqualTo(upperBound);
        }
    }

    private List<Integer> getNumbers(List<String> column) {
        List<Integer> numbers = new ArrayList<>();
        for (String space : column)
            if (!space.equals("FREE"))
                numbers.add(Integer.valueOf(space));
        return numbers;
    }

}
