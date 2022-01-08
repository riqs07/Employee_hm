package PersistSchema;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Column(name = "sqft")
    private Integer sqft;

    @Column(name = "name", length = 45)
    private String name;


    public Location(){

    };

    public Location(String address, int sqft, String name){
        this.address = address;
        this.sqft = sqft;
        this.name = name;
    }

    public void showInfo(){
        System.out.println(this.getAddress() + " " + this.getSqft() +"sqft");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSqft() {
        return sqft;
    }

    public void setSqft(Integer sqft) {
        this.sqft = sqft;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}