package ru.kpfu.RationalFraction;

public class Main {
    public static void main(String[] args) {
        RationalFraction frac0 = new RationalFraction();
        RationalFraction frac1 = new RationalFraction(-2,8);
        RationalFraction frac1_0 = new RationalFraction(-4,16);
        RationalFraction frac2 = new RationalFraction(30,9);
        System.out.println(frac0);
        System.out.println(frac1);
        System.out.println(frac2);
        frac0.reduce();
        frac1.reduce();
        frac2.reduce();
        System.out.printf("REDUCED FRACTIONS%nfrac0: %s, frac1: %s, frac2: %s%n",frac0,frac1,frac2);
        RationalFraction addedFraction = frac1.add(frac2);
        RationalFraction subtractedFraction = frac1.sub(frac2);
        RationalFraction multFraction = frac1.mult(frac2);
        RationalFraction divFraction = frac1.div(frac2);
        System.out.printf("frac1 + frac2 = %s%n",addedFraction);
        System.out.printf("frac1 - frac2 = %s%n",subtractedFraction);
        System.out.printf("frac1 * frac2 = %s%n",multFraction);
        System.out.printf("frac1 / frac2 = %s%n",divFraction);
        System.out.println("frac1 is "+(frac1.equals(frac1_0)?"":"NOT ")+"equal to frac2");
        System.out.println("Number part of "+frac2+" equals "+frac2.numberPart());
        frac1.add2(frac1_0);
        System.out.println("frac1_0 added to frac1 makes frac1 equal to "+frac1);
    }
}
