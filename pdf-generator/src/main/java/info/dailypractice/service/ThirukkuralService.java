
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

    public List<Thirukkural> getAllThirukkural() {
        return thirukkuralRepository.findAll();
    }

    public Thirukkural getThirukkuralById(Integer id) {
        return thirukkuralRepository.findById(id).orElse(null);
    }

    public Thirukkural saveThirukkural(Thirukkural thirukkural) {
        return thirukkuralRepository.save(thirukkural);
    }

    public void deleteThirukkural(Integer id) {
        thirukkuralRepository.deleteById(id);
    }
}
