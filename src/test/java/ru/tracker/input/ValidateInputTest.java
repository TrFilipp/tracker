package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"1", "3", "4"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedFirst = input.askInt("Enter menu:");
        assertThat(selectedFirst).isEqualTo(1);
        int selectedSecond = input.askInt("Enter menu:");
        assertThat(selectedSecond).isEqualTo(3);
        int selectedThird = input.askInt("Enter menu:");
        assertThat(selectedThird).isEqualTo(4);
    }

    @Test
    void whenNegativeInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}