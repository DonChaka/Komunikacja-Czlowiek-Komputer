package Encryption;

public class Rotor
{
    private int connections [][];
    private int position;

    public Rotor(int rotor_number, int position)
    {
        this.position = position;
        this.rotor_number = rotor_number;

        switch(rotor_number)
        {
            case 1:
                connections = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                break;
            case 2:
                connections = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                break;
            case 3:
                connections = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                break;
            case 4:
                connections = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                break;
            case 5:
                connections = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                break;
        }

        int impulse(int inputPin, boolean forward)
        {
            if(forward)
            {
                pin = (position + inputPin) % 26;
                return connections[pin];
            }
            else
            {
                for (int i = 0; i< 26; i++)
                {
                    if (input == connections[i])
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
        }

        boolean tick()
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
}
