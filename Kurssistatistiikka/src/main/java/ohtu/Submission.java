package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public int getWeek() {
        return week;
    }
    

    @Override
    public String toString() {
        String words = "";
        for (int i = 0; i < exercises.length; i++) {
            words = words + exercises[i] + " ";
        }
        return "Viikko "+week + " tehtyjä tehtäviä yhteensä: " + exercises.length
                + ", aikaa kului " + hours + "tuntia, tehdyt tehtävät: " + words
                ;
    }
    
}