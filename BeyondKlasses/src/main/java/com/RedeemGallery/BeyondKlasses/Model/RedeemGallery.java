package  com.RedeemGallery.BeyondKlasses.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="redeemgallery")
public class RedeemGallery {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String name;
    private String school;
    private String month;
    private String email;
    private int age;
    private String competition;
    private String sponsor;
    private String type;
    private String dynamicPage;
    private String city;
    private String profilePage;
    private int compyear;


}
