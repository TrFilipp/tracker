package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("one", "1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("1", "3", "4")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedFirst = input.askInt("Enter menu:");
        int selectedSecond = input.askInt("Enter menu:");
        int selectedThird = input.askInt("Enter menu:");
        assertThat(selectedFirst).isEqualTo(1);
        assertThat(selectedSecond).isEqualTo(3);
        assertThat(selectedThird).isEqualTo(4);
    }

    @Test
    void whenNegativeInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}