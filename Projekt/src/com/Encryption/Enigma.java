package com.Encryption;

public class Enigma
{
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Reflector reflector;

    public Enigma(int rotor1, int rotor2, int rotor3)
    {
        this.rotor1 = new Rotor(rotor1, 0);
        this.rotor2 = new Rotor(rotor2, 0);
        this.rotor3 = new Rotor(rotor3, 0);
        this.reflector = new Reflector();
    }


    public Rotor getRotor1() {
        return rotor1;
    }

    public Rotor getRotor2() {
        return rotor2;
    }

    public Rotor getRotor3() {
        return rotor3;
    }

    public char encrypt(char input)
    {
        input -= 'a';
        //System.out.println((int)input);
        int forwardOutput1 = rotor1.impulse(input, true);
        //System.out.println(forwardOutput1);
        int forwardOutput2 = rotor2.impulse(forwardOutput1, true);
        //System.out.println(forwardOutput2);
        int forwardOutput3 = rotor3.impulse(forwardOutput2, true);
        //System.out.println(forwardOutput3);
        int reflected = reflector.impulse(forwardOutput3);
        //System.out.println(reflected);
        int backwardOutput3 = rotor3.impulse(reflected, false);
        //System.out.println(backwardOutput3);
        int backwardOutput2 = rotor2.impulse(backwardOutput3, false);
        //System.out.println(backwardOutput2);
        int backwardOutput1 = rotor1.impulse(backwardOutput2, false);
        //System.out.println(backwardOutput1);

        return (char)(backwardOutput1 + (int)'a');
    }

    public void tickRotors()
    {
        if(rotor1.tick())
            if(rotor2.tick())
                rotor3.tick();
    }

    public void printRotors()
    {
        System.out.println(rotor3.getPosition() + " " + rotor2.getPosition() + " " + rotor1.getPosition());
    }
}