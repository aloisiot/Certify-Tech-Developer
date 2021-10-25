package models;

public abstract class CheckQuality {
    protected CheckQuality nextCheckQuality;
    public abstract String checkQuality(Artigo artigo);

    public CheckQuality(CheckQuality nextCheckQuality) {
        this.nextCheckQuality = nextCheckQuality;
    }

    public CheckQuality getNextCheckQuality() {
        return nextCheckQuality;
    }
}
