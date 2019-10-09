package Encryption;

class Enigma
{
    Rotor rotor1;
    Rotor rotor2;
    Rotor rotor3;

    public Enigma(int rotor1, int rotor2, int rotor3)
    {
        this.rotor1 = new Rotor(rotor1, 0);
        this.rotor2 = new Rotor(rotor2, 0);
        this.rotor3 = new Rotor(rotor3, 0);
    }

    char encrypt(char input)
    {
        input %= 'a';

        int forwardOutput1 = rotor1.impulse((int)input, true);
        int forwardOutput2 = rotor2.impulse(forwardOutput1, true);
        int forwardOutput3 = rotor3.impulse(forwardOutput2, true);
        /*
        Dodac reflector i powrot przez rotory
         */

        //rotor3.tick() ? rotor2.tick() ? rotor1.tick()::;


    }
}