package dnd.Model;

import java.util.Random;

public class TestCalculation {

    /**
     *
     * @param diceSides
     * liczba scianek kostki
     * @return
     */
    private static TestCalculation instance;

    public static synchronized TestCalculation getInstance() {
        if (instance == null) {
            instance = new TestCalculation();
        }
        return instance;
    }

    public int castDice (int diceSides)
    {
        return new Random().nextInt(diceSides) + 1 ;
    }

    public int castDice (int diceSides, int diceQuantity)
    {
        int sum =0;
        for (int i =0;  i < diceQuantity; i++)
        {
            sum = sum + castDice(diceSides);
        }
        return sum;
    }



    public Boolean simpleTest(int difficulty, int modifiers)
    {
        if (modifiers > difficulty)
            return true;
        else
            return false;
    }


    public Boolean testWithDice( int difficulty, int modifiers, int dice){
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
    public Boolean testWithDice( int difficulty, int modifiers, int dice , boolean winOnTie ){
        if(winOnTie == true)
            difficulty--;
        return testWithDice(difficulty, modifiers, dice);
    }

    /**
     *
     * @param diceSides
     * Liczba scianek kostki
     * @param diceQuantity
     * Liczba kostek
     * @param attackModifiers
     * + ile do obrażen
     * @param resistance
     * odpornosc potwora
     * @return
     * Otrzymane obrażenia
     */

    public int damageCalculation (int diceSides, int diceQuantity, int attackModifiers, int ... resistance)
    {
        int efficientDamage =0;
        if (resistance.length > 0)
            efficientDamage -= resistance[0];

        efficientDamage += attackModifiers;
        efficientDamage += castDice(diceSides,  diceQuantity);

        if (efficientDamage < 0 )
            return 0;
        return efficientDamage;
    }

    public boolean savingThrow (int modifier)
    {
        if (castDice(20) + modifier > 10)
            return true;
        return false;
    }

}
