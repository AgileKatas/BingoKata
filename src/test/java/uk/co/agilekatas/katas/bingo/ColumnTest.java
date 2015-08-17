package uk.co.agilekatas.katas.bingo;

import org.junit.Test;
import uk.co.agilekatas.katas.bingo.BingoCard.Column;

import static org.assertj.core.api.Assertions.assertThat;

public class ColumnTest {

    @Test
    public void bColumnShouldBeIndexZero() {
        assertThat(Column.B.index).isEqualTo(0);
    }

    @Test
    public void iColumnShouldBeIndexOne() {
        assertThat(Column.I.index).isEqualTo(1);
    }

    @Test
    public void nColumnShouldBeIndexTwo() {
        assertThat(Column.N.index).isEqualTo(2);
    }

    @Test
    public void gColumnShouldBeIndexThree() {
        assertThat(Column.G.index).isEqualTo(3);
    }

    @Test
    public void oColumnShouldBeIndexFour() {
        assertThat(Column.O.index).isEqualTo(4);
    }

}
