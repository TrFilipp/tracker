package ru.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassport() {
        Citizen citizenOne = new Citizen("1aa2gf", "Nikolai Borisovich");
        Citizen citizenTwo = new Citizen("1aa2gf", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizenOne);
        office.add(citizenTwo);
        assertThat(office.add(citizenTwo)).isFalse();
    }
}