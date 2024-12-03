package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateTest {
    @Test
    void whenInvalidInput() {
        Output output = new ru.tracker.output.Mock();
        Input in = new Mock(
                new String[] {"one", "1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new ru.tracker.output.Mock();
        Input in = new Mock(
                new String[] {"1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiValidInput() {
        Output output = new ru.tracker.output.Mock();
        Input in = new Mock(
                new String[] {"1", "3", "4"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
    }

    @Test
    void whenNegativeInput() {
        Output output = new ru.tracker.output.Mock();
        Input in = new Mock(
                new String[] {"-1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}