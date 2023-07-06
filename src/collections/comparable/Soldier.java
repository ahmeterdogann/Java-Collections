package collections.comparable;

public class Soldier implements  Comparable{
    private Rank rank;
    private String fullName;

    public Soldier(Rank rank, String fullName) {
        this.rank = rank;
        this.fullName = fullName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int compareTo(Object o) {
        Soldier s = (Soldier) o;

        return this.getRank().ordinal() - s.getRank().ordinal();
    }
}
