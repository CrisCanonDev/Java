package Task5;

public class Country implements java.io.Serializable{
    private String name;
    private int population;
    private String continent;

    Country(){}
    Country(String name, int population, String continent){
        this.name = name;
        this.population = population;
        this.continent = continent;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

}
