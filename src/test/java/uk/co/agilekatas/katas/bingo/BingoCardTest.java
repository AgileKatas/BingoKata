package uk.co.agilekatas.katas.bingo;

import org.junit.Test;
import uk.co.agilekatas.katas.bingo.BingoCard.Column;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoCardTest {

    private List<String> columnB = Arrays.asList("1", "8", "2", "15", "13");
    private List<String> columnI = Arrays.asList("18", "16", "30", "27", "22");
    private List<String> columnN = Arrays.asList("35", "40", "FREE", "31", "39");
    private List<String> columnG = Arrays.asList("50", "60", "55", "47", "46");
    private List<String> columnO = Arrays.asList("75", "61", "62", "70", "71");

    private List<List<String>> columns = Arrays.asList(columnB, columnI, columnN, columnG, columnO);

    @Test
    public void shouldReturnFirstColumnForColumnB() {
        BingoCard card = new BingoCard(columns);

        List<String> column = card.getColumn(Column.B);

        assertThat(column).isEqualTo(columnB);
    }

    @Test
    public void shouldReturnSecondColumnForColumnI() {
        BingoCard card = new BingoCard(columns);

        List<String> column = card.getColumn(Column.I);

        assertThat(column).isEqualTo(columnI);
    }

    @Test
    public void shouldReturnThirdColumnForColumnN() {
        BingoCard card = new BingoCard(columns);

        List<String> column = card.getColumn(Column.N);

        assertThat(column).isEqualTo(columnN);
    }

    @Test
    public void shouldReturnFourthColumnForColumnG() {
        BingoCard card = new BingoCard(columns);

        List<String> column = card.getColumn(Column.G);

        assertThat(column).isEqualTo(columnG);
    }

    @Test
    public void shouldReturnFifthColumnForColumnO() {
        BingoCard card = new BingoCard(columns);

        List<String> column = card.getColumn(Column.O);

        assertThat(column).isEqualTo(columnO);
    }
}
