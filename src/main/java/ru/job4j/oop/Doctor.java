package ru.job4j.oop;

public class Doctor extends Profession{
    private int specialization;

   public Doctor(String name, String surname, String education, String birthday, int specialization){
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }
    public Diagnosis heal(Pacient pacient){
        Diagnosis diagnos = new Diagnosis();
        return diagnos;
    }
}
