/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin.ejb;

import java.util.List;
import javax.ejb.Remote;
import lychee.kulfi.admin.pojo.ProductPojo;
import lychee.kulfi.admin.pojo.PropertyPojo;

/**
 *
 * @author Sely
 */
@Remote
public interface ProductRegisterEJBRemote {
    List<ProductPojo> getAllProductsOrderByName();
    List<PropertyPojo> getAllPropertiesOrderByName();
}
