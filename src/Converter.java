public class Converter {
    int convertToKm(int steps){
        int centimetersOfSteps = steps * 75;
        return (int) (centimetersOfSteps / 100.0 / 1000.0);
    }

    int convertStepsToKilocalories(int steps){
       int caloriesOfSteps = steps * 50;
       return (int) (caloriesOfSteps / 1000.0);

    }
}
