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



    private final Affirmation verite2 = new Truth("Sullivan est intelligent");
    private final Affirmation mensonge2 = new Lie("Sullivan est paresseux");
    private final Affirmation affirmation2True = new SimpleAffirmation(true, "Sullivan est travailleur");
    private final Affirmation affirmation2False = new SimpleAffirmation(false, "Sullivan est travailleur");


    @Test
    public void testSullivanEstIntelligentEtSullivanEstTravailleur() {
        Affirmation test = new Ou(verite2, affirmation2False);
        assertEquals(true, test.eval());
    }

    @Test
    public void testSullivanEstParesseuxDoncSullivanEstTravailleur() {
        Affirmation test = new Donc(mensonge2, affirmation2True);
        assertEquals(true, test.eval());
    }

    @Test
    public void testSullivanEstIntelligentOuSullivanEstTravailleurDoncSullivanEstParesseux() {
        Affirmation test = new Donc(new Ou(verite2, affirmation2True), mensonge2);
        assertEquals(false, test.eval());
    }

    @Test
    public void testComplexAffirmationSullivan() {
        Affirmation test = new Et(
                new Donc(new Ou(verite2, affirmation2True), mensonge2),
                new Ou(mensonge2, affirmation2True)
        );
        assertEquals(false, test.eval());
    }
}
