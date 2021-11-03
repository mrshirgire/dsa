public class RoboBoundedInCircle {

    public static void main(String[] args) {
        System.out.println(isRoboBoundedInCircle("RRGRRGLLLRLGGLGLLGRLRLGLRLRRGLGGLLRRRLRLRLLGRGLGRRRGRLG"));
    }

    public  static boolean isRoboBoundedInCircle(String instructions){

        int xCord = 0, yCord = 0;
        char facing = 'N';

        for(char instruction: instructions.toCharArray()){

            /* Update facing */
            if(facing == 'N' && instruction == 'L') facing = 'W';
            else if(facing == 'N' && instruction == 'R') facing = 'E';
            else if(facing == 'W' && instruction == 'L') facing = 'S';
            else if(facing == 'W' && instruction == 'R') facing = 'N';
            else if(facing == 'S' && instruction == 'L') facing = 'E';
            else if(facing == 'S' && instruction == 'R') facing = 'W';
            else if(facing == 'E' && instruction == 'L') facing = 'N';
            else if(facing == 'E' && instruction == 'R') facing = 'S';

            /* Update x and y co-ordinates*/
            if(facing == 'N' && instruction == 'G')  yCord++;
            else if(facing == 'W' && instruction == 'G') xCord--;
            else if(facing == 'S' && instruction == 'G') yCord--;
            else if(facing == 'E' && instruction == 'G') xCord++;


        }

        if((xCord == 0 && yCord == 0) || facing != 'N' ) return true;

        return false;


    }
}
