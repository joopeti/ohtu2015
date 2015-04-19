package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private int hours;
    private int tehtyjatehtavia;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    private boolean[] lista = new boolean[21];
    
    public String getStudent_number() {
        return student_number;
    }
    
    public String getWeek(){
        return week;
    }
    
    public int getHours(){
        return hours;
    }
    
    public int getTehtyjaTehtavia(){
        luoTehtavaLista();
        tehtyjatehtavia = 0;
        for (int i = 0; i < 20; i++) {
            if(lista[i]){
                tehtyjatehtavia++;
            }
        }
        return tehtyjatehtavia;
    }
    
    public String getTehdyt(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if(lista[i]){
                sb.append((i + 1) + " ");
            }
        }
        return sb.toString();
    }
    
    public void luoTehtavaLista(){
        lista[0] = a1;
        lista[1] = a2;
        lista[2] = a3;
        lista[3] = a4;
        lista[4] = a5;
        lista[5] = a6;
        lista[6] = a7;
        lista[7] = a8;
        lista[8] = a9;
        lista[9] = a10;
        lista[10] = a11;
        lista[11] = a12;
        lista[12] = a13;
        lista[13] = a14;
        lista[14] = a15;
        lista[15] = a16;
        lista[16] = a17;
        lista[17] = a18;
        lista[18] = a19;
        lista[19] = a20;
        lista[20] = a21;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Viikko: " + getWeek() + ": ");
        sb.append("tehtyjä tehtäviä yhteensä: " + getTehtyjaTehtavia() + ", ");
        sb.append("aikaa kului: " + getHours() + " tuntia, ");
        sb.append("tehdyt tehtävät: " + getTehdyt());
        return sb.toString();
    }
    
}