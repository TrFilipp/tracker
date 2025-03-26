package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ItemTest {
    @Test
    void itemAsc() {
        List<Item> items = Arrays.asList(
                new Item("Download documents"),
                new Item("Reload server"),
                new Item("Buy new computers"),
                new Item("Sell old PC")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Buy new computers"),
                new Item("Download documents"),
                new Item("Reload server"),
                new Item("Sell old PC")
        );
        assertThat(items.get(1).getName()).isEqualTo(expected.get(1).getName());
    }

    @Test
    void itemDesc() {
        List<Item> items = Arrays.asList(
                new Item("Download documents"),
                new Item("Reload server"),
                new Item("Buy new computers"),
                new Item("Sell old PC")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Sell old PC"),
                new Item("Reload server"),
                new Item("Download documents"),
                new Item("Buy new computers")
        );
        assertThat(items.get(1).getName()).isEqualTo(expected.get(1).getName());
    }
}
