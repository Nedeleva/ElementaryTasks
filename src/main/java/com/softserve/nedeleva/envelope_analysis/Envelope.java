package com.softserve.nedeleva.envelope_analysis;

public class Envelope implements Comparable<Envelope> {
    public double firstSide;
    public double secondSide;

    public Envelope() {
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    @Override
    public int compareTo(Envelope envelope) {
        if (getFirstSide() > envelope.getFirstSide() && getSecondSide() > envelope.getSecondSide()) {
            return 1;
        } else if (getFirstSide() < envelope.getFirstSide() && getSecondSide() < envelope.getSecondSide()) {
            return -1;
        } else {
            return 0;
        }
    }
}
