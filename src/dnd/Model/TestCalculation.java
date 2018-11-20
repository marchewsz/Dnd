package dnd.Model;

import java.util.Random;

public class TestCalculation {

    /**
     *
     * @param diceSides
     * liczba scianek kostki
     * @return
     */
    int castDice (int diceSides)
    {
        return new Random().nextInt(diceSides) + 1 ;
    }



    Boolean simpleTest(int difficulty, int modifiers)
    {
        if (modifiers > difficulty)
            return true;
        else
            return false;
    }


    Boolean testWithDice( int difficulty, int modifiers, int dice){
        modifiers = modifiers + castDice(dice);
        return simpleTest(difficulty, modifiers);
    }
    /**
     *
     * @param difficulty
     * Poziom trudnosci testu
     * @param modifiers
     * Laczna suma modyfikatorow gracza
     * @param dice
     * Liczba scian kostki
     * @param winOnTie
     * Parametr opcjonalny
     * @return
     * Prawda jesli test sie uda
     */
    Boolean testWithDice( int difficulty, int modifiers, int dice , boolean winOnTie ){
        if(winOnTie == true)
            difficulty--;
        return testWithDice(difficulty, modifiers, dice);
    }
    /*
    int damageCalculation (int diceSides, int diceNumber, int attackModifiers, int ... resistance)
    {
        int efficientDamage =0;
        if (resistance.length > 0)
            efficientDamage -= resistance[0];
        efficientDamage += attackModifiers;
        efficientDamage += castDice(int diceSides, int dice)
        if (efficientDamage < 0 )
            return 0;
        return efficientDamage
    }
     */
}
