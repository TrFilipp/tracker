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

    @Test
    public void whenComparatorAscNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescPriorityAndAscName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscPriorityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescPriorityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescNameAndDescName() {
        Comparator<Job> cmpNameName = new JobDescByName().thenComparing(new JobDescByName());
        int rsl = cmpNameName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescNameAndAscName() {
        Comparator<Job> cmpNameName = new JobDescByName().thenComparing(new JobAscByName());
        int rsl = cmpNameName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscNameAndDescName() {
        Comparator<Job> cmpNameName = new JobAscByName().thenComparing(new JobDescByName());
        int rsl = cmpNameName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndAscName() {
        Comparator<Job> cmpNameName = new JobAscByName().thenComparing(new JobAscByName());
        int rsl = cmpNameName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescPriorityAndAscPriority() {
        Comparator<Job> cmpPriorityPriority = new JobDescByPriority().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscPriorityAndDescPriority() {
        Comparator<Job> cmpPriorityPriority = new JobAscByPriority().thenComparing(new JobDescByPriority());
        int rsl = cmpPriorityPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscPriorityAndAscPriority() {
        Comparator<Job> cmpPriorityPriority = new JobAscByPriority().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescPriorityAndDescPriority() {
        Comparator<Job> cmpPriorityPriority = new JobDescByPriority().thenComparing(new JobDescByPriority());
        int rsl = cmpPriorityPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndAscNameAndAscName() {
        Comparator<Job> cmpNameNameName = new JobAscByName().thenComparing(new JobAscByName()).thenComparing(new JobAscByName());
        int rsl = cmpNameNameName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndAscNameAndAscPriority() {
        Comparator<Job> cmpNameNamePriority = new JobAscByName().thenComparing(new JobAscByName()).thenComparing(new JobAscByPriority());
        int rsl = cmpNameNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndAscPriorityAndAscName() {
        Comparator<Job> cmpNamePriorityName = new JobAscByName().thenComparing(new JobAscByPriority()).thenComparing(new JobAscByName());
        int rsl = cmpNamePriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscNameAndAscPriorityAndAscPriority() {
        Comparator<Job> cmpNamePriorityPriority = new JobAscByName().thenComparing(new JobAscByPriority()).thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriorityPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}