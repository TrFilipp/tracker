package ru.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Download", 2),
                new Job("Reload", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Download", 2),
                new Job("Reload", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Download", 2),
                new Job("Reload", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Download", 2),
                new Job("Reload", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}