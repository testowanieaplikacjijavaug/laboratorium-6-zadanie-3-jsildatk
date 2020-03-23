import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FractionAssertJTest {
    
    @Test
    public void shouldAddTwoFractionsToFull() {
        final Fraction result = Fraction.of(1, 2)
                .add(Fraction.of(1, 2));
        
        assertThat(result).isEqualTo(Fraction.FULL);
    }
    
    @Test
    public void shouldAddTwoFractionsToThird() {
        final Fraction result = Fraction.of(0, 3)
                .add(Fraction.of(1, 3));
        
        assertThat(result).isEqualTo(Fraction.of(3, 9));
    }
    
    @Test
    public void shouldMultiplyToHalf() {
        final Fraction result = Fraction.of(1, 2)
                .multiply(Fraction.of(1, 1));
        
        assertThat(result).isEqualTo(Fraction.HALF);
    }
    
    @Test
    public void shouldMultiplyDetermineToIndeterminate() {
        final Fraction result = Fraction.of(1, 1)
                .multiply(Fraction.of(0, 0));
        
        assertThat(result).isEqualTo(Fraction.INDETERMINATE);
    }
    
    @Test
    public void shouldEqualToFull() {
        final Fraction result = Fraction.of(1, 1);
        
        assertThat(result).isEqualTo(Fraction.FULL);
    }
    
    @Test
    public void shouldEqualToHalf() {
        final Fraction result = Fraction.of(1, 2);
        
        assertThat(result).isEqualTo(Fraction.HALF);
    }
    
    @Test
    public void shouldEqualToOneThird() {
        final Fraction result = Fraction.of(1, 3);
        
        assertThat(result).isEqualTo(Fraction.ONE_THIRD);
    }
    
    @Test
    public void shouldReturnDoubleValue() {
        final Fraction result = Fraction.of(1, 6);
        
        assertThat(result.doubleValue()).isGreaterThanOrEqualTo(0.1611111)
                .isLessThanOrEqualTo(0.16777777);
    }
    
    @Test
    public void shouldThrowExceptionWithDenominatorEqualsToZero() {
        assertThatThrownBy(() -> Fraction.of(2, 0)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldReturnToString() {
        final Fraction result = Fraction.of(3, 4);
        
        assertThat(result.toString()).startsWith("3")
                .contains("/")
                .endsWith("4");
    }
    
}