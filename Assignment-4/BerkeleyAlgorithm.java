public class BerkeleyAlgorithm {

    static void synchronizeClockTimes(int clockTimes[], int size) {
        int average,sum = 0;
        for(int times:clockTimes) {
            sum += times;
        }
        System.out.println("Sum is: " + sum);
        average = sum / size;
        System.out.println("Average is: " + average);

        int[] offsets = new int[size];
        for(int i = 0; i<size; i++) {
            offsets[i] = clockTimes[i] - average;
        }

        System.out.print("Offsets are : ");
        for(int offset:offsets) {
            System.out.print(offset + " ");
        }

        int[] correctedTimes = new int[size];
        for(int i=0; i<size; i++) {
            correctedTimes[i] = clockTimes[i] - offsets[i];
        }

        System.out.println("\nCorrected Times are : ");
        for(int time:correctedTimes) {
            System.out.print(time + " ");
        }

    }

    public static void main(String[] args) {
        int[] clockTimes = new int[100];
        clockTimes[0] = 1000;
        clockTimes[1] = 2000;
        clockTimes[2] = 3000;
        clockTimes[3] = 4000;
        clockTimes[4] = 5000;
        int size = 5;
        synchronizeClockTimes(clockTimes, size);
    }
}