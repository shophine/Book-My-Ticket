package uga.edu.bookmyticket.view.bean;

public class AnalyticsOutput {
    int age;
    int occurence;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }

    public AnalyticsOutput(int age, int occurence) {
        this.age = age;
        this.occurence = occurence;
    }

    public AnalyticsOutput() {
    }



}
