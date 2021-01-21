package ru.kpfu.RationalFraction;

public class RationalFraction {
    private int numerator;
    private int denominator;

    public RationalFraction() {
        this(0, 1);
    }

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void reduce() {
        boolean isNumeratorNegative = this.numerator < 0;
        boolean isDenominatorNegative = this.denominator < 0;
        if (isNumeratorNegative) this.numerator *= -1;
        if (isDenominatorNegative) this.denominator *= -1;
        int commonDivisor = Math.min(this.numerator, this.denominator);
        while (commonDivisor > 1) {
            if (this.numerator % commonDivisor == 0 && this.denominator % commonDivisor == 0) {
                this.numerator /= commonDivisor;
                this.denominator /= commonDivisor;
                commonDivisor = Math.min(this.numerator, this.denominator);
                continue;
            }
            commonDivisor--;
        }
        if (isNumeratorNegative) this.numerator *= -1;
        if (isDenominatorNegative) this.denominator *= -1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public RationalFraction add(RationalFraction rf) {
        reduce();
        rf.reduce();
        int addedFractionNumerator = this.getNumerator() * rf.getDenominator()
                + rf.getNumerator() * this.getDenominator();
        int addedFractionDenominator = this.getDenominator() * rf.getDenominator();
        RationalFraction addedFraction = new RationalFraction(addedFractionNumerator,addedFractionDenominator);
        addedFraction.reduce();
        return addedFraction;
    }

    public void add2(RationalFraction rf) {
        RationalFraction addedFraction = add(rf);
        setNumerator(addedFraction.numerator);
        setDenominator(addedFraction.denominator);
    }

    public RationalFraction sub(RationalFraction rf) {
        reduce();
        rf.reduce();
        return add(new RationalFraction(rf.getNumerator()*-1,rf.getDenominator()));
    }

    public void sub2(RationalFraction rf) {
        reduce();
        rf.reduce();
        add2(new RationalFraction(rf.getNumerator()*-1,rf.getDenominator()));
    }

    public RationalFraction mult(RationalFraction rf) {
        RationalFraction newFraction = new RationalFraction(this.numerator*rf.getNumerator(),this.denominator*rf.getDenominator());
        newFraction.reduce();
        return newFraction;
    }

    public void mult2(RationalFraction rf) {
        RationalFraction newFraction = mult(rf);
        System.out.println(newFraction);
        setNumerator(newFraction.getNumerator());
        setDenominator(newFraction.getDenominator());
    }
    public RationalFraction div(RationalFraction rf) {
        return mult(rf.fractionInverse());
    }

    public void div2(RationalFraction rf) {
        mult2(rf.fractionInverse());
    }

    @Override
    public String toString() {
        //check if denominator == 0
        if(this.denominator==0){
            return this.numerator+"/"+this.denominator+" isNaN: division by zero";
        }
        if(this.denominator<0){
            setNumerator(this.numerator*-1);
            setDenominator(this.denominator*-1);
        }
        return this.numerator + "/" + this.denominator;
    }

    public double value() {
        try {
            return (double) this.numerator / this.denominator;
        }catch(ArithmeticException e){
            System.out.println(e.toString());
            return this.numerator>=0?Double.POSITIVE_INFINITY:Double.NEGATIVE_INFINITY;
        }
    }

    public boolean equals(RationalFraction rf) {
        return this.value()==rf.value();
    }

    public int numberPart() {
        return this.numerator / this.denominator;
    }


    //допонительные функции (помощники)
    public RationalFraction fractionInverse(){
        int denominator = getDenominator();
        int numerator = getNumerator();
        return new RationalFraction(denominator,numerator);
    }
}
