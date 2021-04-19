package co.edu.javeriana.farmaceutica.client.message;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "client")
@Data
public class ClientResponse {
    @Attribute
    private String id;
    @Attribute
    private String documentType;
    @Attribute
    private String document;
    @Attribute
    private String name;
    @Attribute
    private String email;
}
