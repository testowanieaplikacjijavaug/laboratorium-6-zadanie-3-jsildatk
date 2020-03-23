import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class FractionHamcrestTest {
    
    @Test
    public void shouldAddTwoFractionsToFull() {
        final Fraction result = Fraction.of(1, 2)
                .add(Fraction.of(1, 2));
        
        assertThat(result, is(Fraction.FULL));
    }
    
    @Test
    public void shouldAddTwoFractionsToThird() {
        final Fraction result = Fraction.of(0, 3)
                .add(Fraction.of(1, 3));
        
        assertThat(result, is(Fraction.of(3, 9)));
    }
    
    @Test
    public void shouldMultiplyToHalf() {
        final Fraction result = Fraction.of(1, 2)
                .multiply(Fraction.of(1, 1));
        
        assertThat(result, is(Fraction.HALF));
    }
    
    @Test
    public void shouldMultiplyDetermineToIndeterminate() {
        final Fraction result = Fraction.of(1, 1)
                .multiply(Fraction.of(0, 0));
        
        assertThat(result, is(Fraction.INDETERMINATE));
    }
    
    @Test
    public void shouldEqualToFull() {
        final Fraction result = Fraction.of(1, 1);
        
        assertThat(result, is(Fraction.FULL));
    }
    
    @Test
    public void shouldEqualToHalf() {
        final Fraction result = Fraction.of(1, 2);
        
        assertThat(result, is(Fraction.HALF));
    }
    
    @Test
    public void shouldEqualToOneThird() {
        final Fraction result = Fraction.of(1, 3);
        
        assertThat(result, is(Fraction.ONE_THIRD));
    }
    
    @Test
    public void shouldReturnDoubleValue() {
        final Fraction result = Fraction.of(1, 6);
        
        assertThat(result.doubleValue(), allOf(Matchers.greaterThanOrEqualTo(0.1611111), Matchers.lessThanOrEqualTo(0.16777777)));
    }
    
    @Test
    public void shouldThrowExceptionWithDenominatorEqualsToZero() throws Exception {
        assertThat(exceptionOf(() -> Fraction.of(3, 0)), instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldReturnToString() {
        final Fraction result = Fraction.of(3, 4);
        
        assertThat(result.toString(), allOf(startsWith("3"), containsString("/"), endsWith("4")));
    }
    
    private static Throwable exceptionOf(Callable<?> callable) throws Exception {
        try {
            callable.call();
            return null;
        } catch ( Throwable t ) {
            return t;
        }
    }
    
}