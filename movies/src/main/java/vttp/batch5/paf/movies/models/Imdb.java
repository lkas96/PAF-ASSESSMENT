package vttp.batch5.paf.movies.models;

public class Imdb {

    private String title;
    private float vote_average;
    private int vote_count;
    private String release_date;
    private float revenue;
    private float budget;
    private int runtime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Imdb(String title, float vote_average, int vote_count, String release_date, float revenue, float budget,
            int runtime) {
        this.title = title;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.release_date = release_date;
        this.revenue = revenue;
        this.budget = budget;
        this.runtime = runtime;
    }

    public Imdb() {

    }

    public Imdb(String title, String vote_average, String vote_count, String release_date, String revenue,
            String budget,
            String runtime) {
        this.title = title;
        this.vote_average = Float.parseFloat(vote_average);
        this.vote_count = Integer.parseInt(vote_count);
        this.release_date = release_date;
        this.revenue = Float.parseFloat(revenue);
        this.budget = Float.parseFloat(budget);
        this.runtime = Integer.parseInt(runtime);
    }

    @Override
    public String toString() {
        return "Imdb [title=" + title + ", vote_average=" + vote_average + ", vote_count=" + vote_count
                + ", release_date=" + release_date + ", revenue=" + revenue + ", budget=" + budget + ", runtime="
                + runtime + "]";
    }

}
