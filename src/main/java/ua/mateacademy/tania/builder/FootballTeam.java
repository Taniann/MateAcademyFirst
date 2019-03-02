package ua.mateacademy.tania.builder;

public class FootballTeam implements Cloneable {
    private String goalkeeper;
    private String back;
    private String halfBack;
    private String forvard;
    private String fullBack;
    private String vinger;
    private String coach;

    public FootballTeam(BuildTeam buildTeam) {
        goalkeeper = buildTeam.goalkeeper;
        back = buildTeam.back;
        halfBack = buildTeam.halfBack;
        forvard = buildTeam.forvard;
        fullBack = buildTeam.fullBack;
        vinger = buildTeam.vinger;
        coach = buildTeam.coach;
    }

    public String getGoalkeeper() {
        return goalkeeper;
    }

    public String getBack() {
        return back;
    }

    public String getHalfBack() {
        return halfBack;
    }

    public String getForvard() {
        return forvard;
    }

    public String getFullBack() {
        return fullBack;
    }

    public String getVinger() {
        return vinger;
    }

    public String getCoach() {
        return coach;
    }

    public static BuildTeam builder() {
        return new BuildTeam();
    }

    public static class BuildTeam {
        private String goalkeeper;
        private String back;
        private String halfBack;
        private String forvard;
        private String fullBack;
        private String vinger;
        private String coach;

        public BuildTeam setGoalkeeper(String goalkeeper) {
            this.goalkeeper = goalkeeper;
            return this;
        }

        public BuildTeam setBack(String back) {
            this.back = back;
            return this;
        }

        public BuildTeam setHalfBack(String halfBack) {
            this.halfBack = halfBack;
            return this;
        }

        public BuildTeam setForvard(String forvard) {
            this.forvard = forvard;
            return this;
        }

        public BuildTeam setFullBack(String fullBack) {
            this.fullBack = fullBack;
            return this;
        }

        public BuildTeam setVinger(String vinger) {
            this.vinger = vinger;
            return this;
        }

        public BuildTeam setCoach(String coach) {
            this.coach = coach;
            return this;
        }

        private BuildTeam() {
        }

        public FootballTeam build() {
            return new FootballTeam(this);
        }
    }
}
