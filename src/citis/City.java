package citis;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * City class
 */


@XmlType(propOrder = {"id", "name", "coordinates", "creationDate","area","population","metersAboveSeaLevel","telephoneCode","agglomeration","government","governor"})
@XmlSeeAlso({Human.class, Coordinates.class, Governmet.class})

public class City implements Serializable {
    /**
     * Field for unique ID of city
     */

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    /**
     * Field for name of city
     */
    private String name; //Поле не может быть null, Строка не может быть пустой

    /**
     * Field for coordinates
     */
    private Coordinates coordinates; //Поле не может быть null

    /**
     * Field for auto-generated value of creation date
     */
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    /**
     * Field for the city area.Сan not be null.
     */
    private Long area; //Значение поля должно быть больше 0, Поле не может быть null

    /**
     * Field for the city population.Field value must be greater than zero
     */
    private long population; //Значение поля должно быть больше 0

    /**
     * Field for the city metersAboveSeaLevel
     */
    private long metersAboveSeaLevel;

    /**
     * Field for the city metersAboveSeaLevel. Сan not be null.The maximum value is 100000
     */
    private Integer telephoneCode; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100000

    /**
     *
     * City agglomeration field
     */
    private int agglomeration;

    /**
     *
     * Field for government.Сan not be null.
     */
    private Governmet government; //Поле может быть null

    /**
     * Field for the age of the Governor.Сan not be null.
     */
    private Human governor; //Поле не может быть null

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setMetersAboveSeaLevel(long metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public void setTelephoneCode(Integer telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public void setAgglomeration(int agglomeration) {
        this.agglomeration = agglomeration;
    }

    public void setGovernment(Governmet government) {
        this.government = government;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public LocalDate getCreationDate() {
        return creationDate;
    }
    @XmlElement
    public Long getArea() {
        return area;
    }
    @XmlElement
    public Long getPopulation() {
        return population;
    }
    @XmlElement
    public Long getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }
    @XmlElement
    public Integer getTelephoneCode() {
        return telephoneCode;
    }
    @XmlElement
    public Integer getAgglomeration() {
        return agglomeration;
    }

    public Governmet getGovernment() {
        return government;
    }

    public Human getGovernor() {
        return governor;
    }

    @Override
    public String toString() {
        return "citis.City{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", coordinates= " + coordinates +
                ", creationDate= " + creationDate +
                ", area= " + area +
                ", population= " + population +
                ", metersAboveSeaLevel= " + metersAboveSeaLevel +
                ", telephoneCode= " + telephoneCode +
                ", agglomeration= " + agglomeration +
                ", government= " + government +
                ", governor= " + governor +
                '}';
    }

    public int compareTo(City C2) {
        return this.getName().compareTo(C2.getName());
    }



}


