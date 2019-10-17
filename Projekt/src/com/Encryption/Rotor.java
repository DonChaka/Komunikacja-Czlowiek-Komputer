package com.Encryption;

public class Rotor
{
    private int[] connections;
    private int position;

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) { this.position = position; }

    Rotor(int rotor_number, int position)
    {
        this.position = position;

        switch(rotor_number)
        {
            case 0: // To jest reflektor on zawsze ma pozycje 0 i nigdy sie nie obraca
                connections = new int [] {24,17,20,7,16,18,11,3,15,23,13,6,14,10,12,8,4,1,5,25,2,22,21,9,0,19};
                break;
            case 1:
                connections = new int[] {4,10,12,5,11,6,3,16,21,25,13,19,14,22,24,7,23,20,18,15,0,8,1,17,2,9};
                break;
            case 2:
                connections = new int[] {0,9,3,10,18,8,17,20,23,1,11,7,22,19,12,2,16,6,25,13,15,24,5,21,14,4};
                break;
            case 3:
                connections = new int[] {1,3,5,7,9,11,2,15,17,19,23,21,25,13,24,4,8,22,6,0,10,12,20,18,16,14};
                break;
            case 4:
                connections = new int[] {4,18,14,21,15,25,9,0,24,16,20,8,17,7,23,11,13,5,19,6,10,3,2,12,22,1};
                break;
            case 5:
                connections = new int[] {21,25,1,17,6,8,19,24,20,15,18,3,13,7,11,23,0,22,12,9,16,14,5,4,2,10};
                break;
        }
    }

    int impulse(int inputPin, boolean forward)
    {
        if(forward)
        {
            int pin = (position + inputPin) % 26;
            return connections[pin];
        }
        else
        {
            for (int i = 0; i< 26; i++)
            {
                if (inputPin == connections[i])
                {
                    int output = (i - position);
                    while (output < 0)
                    {
                        output = 26 + output;
                    }
                    output = output % 26;

                    return output;
                }
            }
        }
        return -1;
    }

    public boolean tick()
    {
        position += 1;
        if(position > 25)
        {
            position %= 26;
            return true;
        }
        return false;
    }
}
