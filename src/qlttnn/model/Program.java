package qlttnn.model;

import java.util.ArrayList;

public class Program {
    private int id;
    private String programName;
    private String description;
    private ArrayList<Level> levels;

    public Program(int id, String programName, String description) {
        this.id = id;
        this.programName = programName;
        this.description = description;
    }

    public Program(String programName, String description) {
        this.programName = programName;
        this.description = description;
    }

    public Program() {
    }

    @Override
    public String toString() {
        return this.programName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

}
