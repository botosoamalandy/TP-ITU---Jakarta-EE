package fr.grin.tpcustomerapplication.managedbeans;

import fr.grin.tpcustomerapplication.entities.Customer;
import fr.grin.tpcustomerapplication.entities.DiscountCode;
import fr.grin.tpcustomerapplication.session.CustomerManager;
import fr.grin.tpcustomerapplication.session.DiscountCodeManager;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable {
  private int idCustomer;
  private Customer customer;

  @EJB
    private DiscountCodeManager discountCodeManager;


  @EJB
  private CustomerManager customerManager;

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

    public Customer getDetails() {
      return customer;
    }

  public String update() {
    customer = customerManager.update(customer);
    return "CustomerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.getCustomer(idCustomer);
  }
  public List<DiscountCode> getDiscountCodes() {
        return discountCodeManager.getAllDiscountCodes();
  }
  public Converter<DiscountCode> getDiscountCodeConverter() {
      return new Converter<DiscountCode>() {

          @Override
          public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
              return discountCodeManager.findById(value);
          }
          @Override
          public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
              return value.getDiscountCode();
          }
      };
  }
}
