
package info.dailypractice.service;

import info.dailypractice.dao.ThirukkuralRepository;
import info.dailypractice.entity.Thirukkural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirukkuralService {

    @Autowired
    private ThirukkuralRepository thirukkuralRepository;

    public List<Thirukkural> getAllUsers() {
        return thirukkuralRepository.findAll();
    }

    public Thirukkural getUserById(Integer id) {
        return thirukkuralRepository.findById(id).orElse(null);
    }

    public Thirukkural saveUser(Thirukkural user) {
        return thirukkuralRepository.save(user);
    }

    public void deleteUser(Integer id) {
        thirukkuralRepository.deleteById(id);
    }
}
