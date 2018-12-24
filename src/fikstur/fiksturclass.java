/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fikstur;

/**
 *
 * @author Rdv
 */
public class fiksturclass {

    String[] currentWeek;
    int weekNumber;

    public fiksturclass(String[] currentWeek) {
        this.currentWeek = currentWeek;
        weekNumber = 1;
    }

    public void nextWeek() {

        String[] nextWeek = new String[currentWeek.length];
        if (weekNumber % 2 == 1) {

            nextWeek[0] = currentWeek[1];
            nextWeek[1] = currentWeek[currentWeek.length - 1];

        } else {
            nextWeek[1] = currentWeek[0];
            nextWeek[0] = currentWeek[currentWeek.length - 1];
        }

        String[] orderedWeek = shiftWeek();
        int newPoint = orderedWeek.length;

        for (int i = 0; i < orderedWeek.length; i++) {

            nextWeek[newPoint] = orderedWeek[i++];
            nextWeek[newPoint + 1] = orderedWeek[i];
            newPoint = newPoint - 2;

        }
        
        weekNumber++;
        currentWeek = nextWeek;

    }

    public String[] shiftWeek() {

        String[] orderedWeek = new String[currentWeek.length - 2];
        orderedWeek[0] = currentWeek[0];
        for (int i = 0; i < orderedWeek.length + 1; i++) {

            if (weekNumber % 2 == 1 && i > 1 || weekNumber % 2 == 0 && i > 0) {
                
                orderedWeek[i - 1] = currentWeek[i];
            }
        }
        
        return orderedWeek;
    }
    
    public String write(){
        String str = "";
        str += "Week " + weekNumber + "\n";
        for (int i = 0; i < currentWeek.length; i++) {
            str += currentWeek[i++] + " <=> " + currentWeek[i] + "\n";
        }
        return str;
    }
}
