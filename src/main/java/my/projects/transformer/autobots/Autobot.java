package my.projects.transformer.autobots;

import my.projects.transformer.exception.MissionFailedException;

public abstract class Autobot {
    private Object result;

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean performMission() throws MissionFailedException;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
