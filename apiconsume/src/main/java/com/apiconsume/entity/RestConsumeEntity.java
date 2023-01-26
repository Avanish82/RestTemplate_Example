package com.apiconsume.entity;
 
import javax.persistence.*;

@Entity
@Table(name = "CURDSP")
public class RestConsumeEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(name = "name")
	    private String name;
	    @Column(name = "email")
	    private String email;
	    @Column(name = "address")
	    private String address;
	    @Column(name = "phone")
	    private String phone;
	    @Column(name = "uname")
	    private String uname;  
	    @Column(name = "uemail")
	    private String uemail;  
	    @Column(name = "uphone")
	    private String uphone;  

	    
		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getUemail() {
			return uemail;
		}

		public void setUemail(String uemail) {
			this.uemail = uemail;
		}

		public String getUphone() {
			return uphone;
		}

		public void setUphone(String uphone) {
			this.uphone = uphone;
		}

		public Long getId() {
	        return id;
	    }

		public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	}
