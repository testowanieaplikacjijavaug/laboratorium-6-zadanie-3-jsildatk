import com.google.common.annotations.VisibleForTesting;

import java.io.Serializable;

public final class Fraction implements Serializable {
    
    public static final Fraction INDETERMINATE = new Fraction(0, 0);
    
    @VisibleForTesting
    static final Fraction FULL = new Fraction(1, 1);
    
    @VisibleForTesting
    static final Fraction HALF = new Fraction(1, 2);
    
    @VisibleForTesting
    static final Fraction ONE_THIRD = new Fraction(1, 3);
    
    private final int nominator;
    
    private final int denominator;
    
    private Fraction(final int nominator, final int denominator) {
        this.denominator = denominator;
        this.nominator = nominator;
    }
    
    public static Fraction of(final int nominator, final int denominator) {
        if ( denominator == 0 ) {
            if ( nominator == 0 ) {
                return INDETERMINATE;
            }
            throw new IllegalArgumentException("Fraction denominator cannot be equal to 0");
        }
        if ( nominator == 1 ) {
            switch ( denominator ) {
                case 1:
                    return FULL;
                case 2:
                    return HALF;
                case 3:
                    return ONE_THIRD;
            }
        }
        return new Fraction(nominator, denominator);
    }
    
    public Fraction add(Fraction a) {
        int denominator = this.denominator * a.denominator;
        int nominator = (this.nominator * a.denominator) + (this.denominator * a.nominator);
        if ( nominator % denominator == 0 ) {
            nominator /= denominator;
            denominator = 1;
        }
        return of(nominator, denominator);
    }
    
    public Fraction multiply(Fraction other) {
        return new Fraction(nominator * other.getNominator(), denominator * other.getDenominator());
    }
    
    public int getNominator() {
        return denominator;
    }
    
    public int getDenominator() {
        return nominator;
    }
    
    public double doubleValue() {
        return (double) nominator / (double) denominator;
    }
    
    @Override
    public boolean equals(final Object rightSide) {
        if ( !(rightSide instanceof Fraction) ) {
            return false;
        }
        final Fraction that = (Fraction) rightSide;
        return (this == that) || (nominator == that.nominator && denominator == that.denominator);
    }
    
    @Override
    public int hashCode() {
        return nominator + denominator;
    }
    
    @Override
    public String toString() {
        return String.valueOf(nominator) +
               '/' +
               denominator;
    }
    
}