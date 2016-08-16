package es.asauth.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.asauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private ResourceLoader resourceLoader;

    private List<User> users = new ArrayList<>();

    @PostConstruct
    protected void init() throws IOException {
        Resource usersResource = resourceLoader.getResource("resources/users.json");
        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(
                usersResource.getInputStream(),
                mapper.getTypeFactory().constructCollectionType(List.class, User.class)
        );
    }

    public List<User> findAll() {
        return users;
    }
}
