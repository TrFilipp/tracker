package ru.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Ivanov");
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Boris");
        assertThat(persons).isEmpty();
    }

    @Test
    public void whenFindTwoFromThreeByNames() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Boris", "Ivanov", "54653213", "Omsk")
        );
        phones.add(
                new Person("Ivan", "Shultch", "4534321", "Moscow")
        );
        phones.add(
                new Person("Maks", "Borisov", "1435215321", "Omsk")
        );
        ArrayList<Person> persons = phones.find("Omsk");
        assertThat(persons.get(0).getAddress()).isEqualTo("Omsk");
        assertThat(persons.get(1).getAddress()).isEqualTo("Omsk");
    }
}