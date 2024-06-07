package com.hei.CalculusRatiocinator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AffirmationTest {

    private final Affirmation verite1 = new Truth("Lou est beau");
    private final Affirmation mensonge1 = new Lie("Lou est pauvre");
    private final Affirmation affirmation1True = new SimpleAffirmation(true, "Lou est généreux");
    private final Affirmation affirmation1False = new SimpleAffirmation(false, "Lou est généreux");

    @Test
    public void testLouEstPauvreEtLouEstGenereux() {
        Affirmation test = new Et(mensonge1, affirmation1True);
        assertEquals(false, test.eval());
    }

    @Test
    public void testLouEstBeauDoncLouEstPauvre() {
        Affirmation test = new Donc(verite1, mensonge1);
        assertEquals(false, test.eval());
    }

    @Test
    public void testLouEstPauvreDoncLouEstGenereux() {
        Affirmation test = new Donc(mensonge1, affirmation1True);
        assertEquals(true, test.eval());
    }

    @Test
    public void testLouEstBeauOuLouEstGenereuxDoncLouEstPauvre() {
        Affirmation test = new Donc(new Ou(verite1, affirmation1True), mensonge1);
        assertEquals(false, test.eval());
    }

    @Test
    public void testComplexAffirmation() {
        Affirmation test = new Et(
                new Donc(new Ou(verite1, affirmation1True), mensonge1),
                new Ou(mensonge1, affirmation1True)
        );
        assertEquals(false, test.eval());
    }
}
