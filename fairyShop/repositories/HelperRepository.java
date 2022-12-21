package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HelperRepository<T> implements Repository<Helper>{


    private List<Helper> helpers = new ArrayList<>();

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }

    @Override
    public void add(Helper model) {
        helpers.add(model);
    }

    @Override
    public boolean remove(Helper model) {
        if(!helpers.isEmpty()){
            helpers.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Helper findByName(String name) {
            return this.helpers.stream().filter(helper -> helper.getName().equals(name)).findFirst().orElse(null);

    }
}
