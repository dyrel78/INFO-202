package domain;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * @author Mark George
 */
public class Customer {

	private Integer customerId;
        
        @NotNull(message = "Usernmae must be provided.")
         @NotBlank(message = "Username must be provided.")
         @Length(min = 5, message = "Username must contain at least five characters.")
         private String username;

         @NotNull(message = "First name must be provided.")
         @NotBlank(message = "First name must be provided.")
         @Length(min = 1, message = "First name must contain at least 1 character.")
         private String firstName;

         @NotNull(message = "Surname must be provided.")
         @NotBlank(message = "Surname must be provided.")
         @Length(min = 1, message = "Surname must contain at least 1 character.")
         private String surname;

         @NotNull(message = "Password must be provided.")
         @NotBlank(message = "Password must be provided.")
         @Length(min = 7, message = "Password must contain at least 7 characters.")
         private String password;

         @NotNull(message = "Email address must be provided.")
         @NotBlank(message = "Email address must be provided.")
         private String emailAddress;

         @NotNull(message = "Shipping address must be provided.")
         @NotBlank(message = "Shipping address must be provided.")
         private String shippingAddress;

	public Customer() {
	}

//	public Customer(Integer customerId, String username, String firstName, String surname, String shippingAddress, String emailAddress) {
//		this.customerId = customerId;
//		this.username = username;
//		this.firstName = firstName;
//		this.surname = surname;
//		this.shippingAddress = shippingAddress;
//		this.emailAddress = emailAddress;
//	}
        public Customer(String password, String username, String firstName, String surname, String shippingAddress, String emailAddress) {
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
		this.shippingAddress = shippingAddress;
		this.emailAddress = emailAddress;
                this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer personId) {
		this.customerId = personId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer{" + "customerId=" + customerId + ", username=" + username + ", firstName=" + firstName + ", surname=" + surname + ", password=" + password + ", emailAddress=" + emailAddress + ", shippingAddress=" + shippingAddress + '}';
	}

}
